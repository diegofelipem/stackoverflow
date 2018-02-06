package swing.examples7;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

public class JTableCellEditorTextAreaTest extends JFrame {

	private JTable tabela;
	private JScrollPane scrollPainel;

	public JTableCellEditorTextAreaTest() {
		renderizarTela();
	}

	private void renderizarTela() {

		Funcionario f1 = new Funcionario("", 0, 0);
		Funcionario f2 = new Funcionario("", 0, 0);
		Funcionario f3 = new Funcionario("", 0, 0);
		Funcionario f4 = new Funcionario("", 0, 0);

		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		funcionarios.add(f1);
		funcionarios.add(f2);
		funcionarios.add(f3);
		funcionarios.add(f4);

		FuncionarioTableModel model = new FuncionarioTableModel(funcionarios);

		this.tabela = new JTable(model) {
			
			@Override
			public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {

				super.changeSelection(rowIndex, columnIndex, toggle, extend);
				
				if(editCellAt(rowIndex, columnIndex)) {
					Component editor = getEditorComponent();
					editor.requestFocusInWindow();
				}
			}
		};
		this.scrollPainel = new JScrollPane(tabela);
		tabela.getColumnModel().getColumn(0).setCellEditor(new TextAreaEditor());
		tabela.setRowHeight(50);
		
		this.add(scrollPainel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				JTableCellEditorTextAreaTest tb = new JTableCellEditorTextAreaTest();
				tb.setLocationRelativeTo(null);
				tb.setVisible(true);
			}
		});
	}
}

class FuncionarioTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String colunas[] = { "nome" };
	private ArrayList<Funcionario> funcionarios;
	private final int COLUNA_NOME = 0;

	public FuncionarioTableModel(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public int getRowCount() {
		return funcionarios.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int indice) {
		return colunas[indice];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COLUNA_NOME:
			return String.class;
		default:
			return String.class;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Funcionario funcionario = this.funcionarios.get(rowIndex);

		switch (columnIndex) {
		case COLUNA_NOME:
			return funcionario.getNome();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Funcionario funcionario = this.funcionarios.get(rowIndex);
		switch (columnIndex) {
		case COLUNA_NOME:
			funcionario.setNome(String.valueOf(aValue));
			break;
		}
		fireTableDataChanged();
	}
}

// celleditor
class TextAreaEditor extends DefaultCellEditor {

	protected JScrollPane scrollpane;
	protected JTextArea textarea;

	public TextAreaEditor() {
		super(new JCheckBox());
		scrollpane = new JScrollPane();
		textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		// textarea.setBorder(new TitledBorder("This is a JTextArea"));
		scrollpane.getViewport().add(textarea);

		// colocar para editar em 2 click
		//setClickCountToStart(2);
		//
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		textarea.setText((String) value);

		return scrollpane;
	}

	public Object getCellEditorValue() {
		return textarea.getText();

	}
}

class Funcionario {

	private String nome;

	public Funcionario(String nome, int idade, int matricula) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
