package swing.examples7;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

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

		this.tabela = new JTable(model);
		this.tabela.setSurrendersFocusOnKeystroke(true);
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

class TextAreaEditor extends AbstractCellEditor implements TableCellEditor {

	JTextArea textArea = new JTextArea();
	JScrollPane scroll;

	public TextAreaEditor() {

		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(new TitledBorder("This is a JTextArea"));

		// altera o comportamento padrao do TAB para que transfira o foco
		// neste caso, vai transferir para a celular seguinte
		textArea.getInputMap(JTextArea.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("TAB"), "transferFocus");

		scroll = new JScrollPane(textArea);
	}

	@Override
	public boolean isCellEditable(EventObject e) {
		super.isCellEditable(e);
		// habilita edicao para o mouse apenas quando
		// for clicado 2 vezes
		if (e instanceof MouseEvent) {
			MouseEvent evt = (MouseEvent) e;
			return evt.getClickCount() >= 2;
		}		

		return true;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex,
			int colIndex) {
		
		String text = value == null ? "" : value.toString();
		textArea.setText(text);

		return scroll;
	}

	@Override
	public Object getCellEditorValue() {
		return textArea.getText();
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
