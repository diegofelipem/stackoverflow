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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.table.TableCellRenderer;

public class JTableCellEditorTextAreaTest extends JFrame {

	private JTable tabela;
	private JScrollPane scrollPainel;

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

				// inicia a edicao na celula da tabela
				// e quando o editor for o scrollpane, transfere
				// o foco para a textarea dentro dela
				if (editCellAt(rowIndex, columnIndex)) {
					Component editor = getEditorComponent();

					if (editor instanceof JScrollPane)
						((JScrollPane) editor).getViewport().getView().requestFocusInWindow();
				}
				super.changeSelection(rowIndex, columnIndex, toggle, extend);
			}
		};

		this.scrollPainel = new JScrollPane(tabela);
		tabela.getColumnModel().getColumn(0).setCellEditor(new TextAreaEditor());
		tabela.getColumnModel().getColumn(0).setCellRenderer(new TextAreaCellRenderer());
		tabela.setRowHeight(50);

		this.add(scrollPainel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		textArea.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "transferFocus");

		scroll = new JScrollPane(textArea);

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

class TextAreaCellRenderer extends JTextArea implements TableCellRenderer {

	public TextAreaCellRenderer() {
		setLineWrap(true);
		setWrapStyleWord(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		
		setText((value == null) ? "" : value.toString());
		
		// ajusta o tamanho da celular conforme o texto digitado
		setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
		//ajusta o tamanho da linha da celula, conforme o texto digitado
		//para evitar que o texto seja cortado pela altura da linha
		if (table.getRowHeight(row) < getPreferredSize().height) {
			table.setRowHeight(row, getPreferredSize().height);
		}
		return this;
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
