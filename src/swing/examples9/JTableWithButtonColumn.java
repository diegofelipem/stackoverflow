package swing.examples9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class JTableWithButtonColumn extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JTableWithButtonColumn().setVisible(true));
	}

	public JTableWithButtonColumn() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table = new JTable(new ExampleTableModel());

		// acqui você implementa a acao do botao, neste exemplo, 
		//implementei exibir o status da linha atual
		
		Action showStatus =  new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table  = (JTable) e.getSource(); //recupera a tabela
				int modelRow = Integer.valueOf(e.getActionCommand());
				JOptionPane.showMessageDialog(null, ((ExampleTableModel)table.getModel()).getRowData(modelRow));
				
			}
		};
		
		ButtonColumn buttonColumn = new ButtonColumn(table, showStatus, 2);

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * classe de exemplo de um model, apenas pra equiparar ao teu codigo
	 * 
	 * @author diego.felipe
	 *
	 */
	class ExampleTableModel extends AbstractTableModel {

		private String[] col = { "cod", "text" , ""};
		private ArrayList<ExampleModel> data;

		public ExampleTableModel() {
			data = new ArrayList<>();
			boolean status = true;
			for (int i = 0; i < 6; i++)
				data.add(new ExampleModel((i + 1), ("obj " + (i + 1)), !status));
		}
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public String getColumnName(int column) {
			return col[column];
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			return col.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return data.get(rowIndex).getCod();
			case 1:
				return data.get(rowIndex).getText();
			}
			return null;
		}
		
		public Object getRowData(int rowIndex) {
			return data.get(rowIndex);
		}
	}
	


	/**
	 * classe Model de exemplo
	 * 
	 * @author diego.felipe
	 *
	 */

	class ExampleModel {

		private int cod;
		private String text;
		private boolean status;

		public ExampleModel(int cod, String text, boolean status) {

			this.cod = cod;
			this.text = text;
			this.status = status;
		}

		public int getCod() {
			return cod;
		}

		public void setCod(int cod) {
			this.cod = cod;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}
		
		@Override
		public String toString() {	
			return "[" + cod + "," + "text" + "," + status + "]";
		}
	}
}

class ButtonColumn extends AbstractCellEditor
		implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {
	private JTable table;
	private Action action;
	private int mnemonic;
	private Border originalBorder;
	private Border focusBorder;

	private JButton renderButton;
	private JButton editButton;
	private Object editorValue;
	private boolean isButtonColumnEditor;

	/**
	 * Create the ButtonColumn to be used as a renderer and editor. The renderer and
	 * editor will automatically be installed on the TableColumn of the specified
	 * column.
	 *
	 * @param table
	 *            the table containing the button renderer/editor
	 * @param action
	 *            the Action to be invoked when the button is invoked
	 * @param column
	 *            the column to which the button renderer/editor is added
	 */
	public ButtonColumn(JTable table, Action action, int column) {
		this.table = table;
		this.action = action;

		renderButton = new JButton();
		editButton = new JButton();
		editButton.setFocusPainted(false);
		editButton.addActionListener(this);
		originalBorder = editButton.getBorder();
		setFocusBorder(new LineBorder(Color.BLUE));

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer(this);
		columnModel.getColumn(column).setCellEditor(this);
		table.addMouseListener(this);
	}

	/**
	 * Get foreground color of the button when the cell has focus
	 *
	 * @return the foreground color
	 */
	public Border getFocusBorder() {
		return focusBorder;
	}

	/**
	 * The foreground color of the button when the cell has focus
	 *
	 * @param focusBorder
	 *            the foreground color
	 */
	public void setFocusBorder(Border focusBorder) {
		this.focusBorder = focusBorder;
		editButton.setBorder(focusBorder);
	}

	public int getMnemonic() {
		return mnemonic;
	}

	/**
	 * The mnemonic to activate the button when the cell has focus
	 *
	 * @param mnemonic
	 *            the mnemonic
	 */
	public void setMnemonic(int mnemonic) {
		this.mnemonic = mnemonic;
		renderButton.setMnemonic(mnemonic);
		editButton.setMnemonic(mnemonic);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value == null) {
			editButton.setText("");
			editButton.setIcon(null);
		} else if (value instanceof Icon) {
			editButton.setText("");
			editButton.setIcon((Icon) value);
		} else {
			editButton.setText(value.toString());
			editButton.setIcon(null);
		}

		this.editorValue = value;
		return editButton;
	}

	@Override
	public Object getCellEditorValue() {
		return editorValue;
	}

	//
	// Implement TableCellRenderer interface
	//
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (isSelected) {
			renderButton.setForeground(table.getSelectionForeground());
			renderButton.setBackground(table.getSelectionBackground());
		} else {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}

		if (hasFocus) {
			renderButton.setBorder(focusBorder);
		} else {
			renderButton.setBorder(originalBorder);
		}

		// renderButton.setText( (value == null) ? "" : value.toString() );
		if (value == null) {
			renderButton.setText("");
			renderButton.setIcon(null);
		} else if (value instanceof Icon) {
			renderButton.setText("");
			renderButton.setIcon((Icon) value);
		} else {
			renderButton.setText(value.toString());
			renderButton.setIcon(null);
		}

		return renderButton;
	}

	//
	// Implement ActionListener interface
	//
	/*
	 * The button has been pressed. Stop editing and invoke the custom Action
	 */
	public void actionPerformed(ActionEvent e) {
		int row = table.convertRowIndexToModel(table.getEditingRow());
		fireEditingStopped();

		// Invoke the Action

		ActionEvent event = new ActionEvent(table, ActionEvent.ACTION_PERFORMED, "" + row);
		action.actionPerformed(event);
	}

	//
	// Implement MouseListener interface
	//
	/*
	 * When the mouse is pressed the editor is invoked. If you then then drag the
	 * mouse to another cell before releasing it, the editor is still active. Make
	 * sure editing is stopped when the mouse is released.
	 */
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this)
			isButtonColumnEditor = true;
	}

	public void mouseReleased(MouseEvent e) {
		if (isButtonColumnEditor && table.isEditing())
			table.getCellEditor().stopCellEditing();

		isButtonColumnEditor = false;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
