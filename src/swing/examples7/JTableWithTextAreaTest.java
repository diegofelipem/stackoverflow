package swing.examples7;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class JTableWithTextAreaTest extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JTableWithTextAreaTest().setVisible(true));
	}

	public JTableWithTextAreaTest() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		String[] columnNames = { "ComboColumn", "OtherColumn" };
		Object[][] data = { { null, null }, { null, null } };

		this.table = new JTable(data, columnNames);
		this.table.getColumnModel().getColumn(1).setCellRenderer(new TextAreaCellRenderer());
		this.table.getColumnModel().getColumn(1).setCellEditor(new MyTableCellEditor());

		this.scrollPane = new JScrollPane(table);
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);

	}

	class TextAreaCellRenderer extends JTextArea implements TableCellRenderer {
		public TextAreaCellRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
			setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
			setMargin(new java.awt.Insets(5, 5, 5, 5));
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// set color & border here
			// this.setText(value.toString());
			setText((value == null) ? "" : value.toString());
			setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
			if (table.getRowHeight(row) < getPreferredSize().height) {
				table.setRowHeight(row, getPreferredSize().height);
			}
			return this;
		}
	}

	class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {

		JTextArea textArea = new JTextArea();
		
		public MyTableCellEditor() {
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
			textArea.setMargin(new java.awt.Insets(5, 5, 5, 5));
			
			textArea.addKeyListener(new KeyAdapter() {
				
	            @Override
	            public void keyReleased(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                	e.consume();
	                    fireEditingStopped();
	                }
	                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                	e.consume();
	                    fireEditingCanceled();
	                }
	            }
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex,
				int colIndex) {

			JScrollPane scroll = new JScrollPane(textArea);
			
			String text =  value == null ? "" : value.toString();

			textArea.setText(text);

//			if(!text.isEmpty())
//				setTableCellHeight(table, rowIndex, colIndex);

			return textArea;
		}

		private void setTableCellHeight(JTable table, int rowIndex, int colIndex) {

			Component c = table.getCellRenderer(rowIndex, colIndex).getTableCellRendererComponent(table,
					table.getValueAt(rowIndex, colIndex), false, false, rowIndex, colIndex);
			Font f = c.getFont();
			FontMetrics fm = c.getFontMetrics(f);

			// this cast depends on the way your renderer is implemented !!!!
			int lineCount = ((JTextArea) c).getLineCount();

			int fheight = fm.getHeight();
			int rowHeight = lineCount * fheight;

			table.setRowHeight(rowIndex, rowHeight);
		}

		@Override
		public Object getCellEditorValue() {
			return textArea.getText();
		}

	}

}
