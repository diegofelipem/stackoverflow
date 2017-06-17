package swing_examples2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class JTableEditorFormattedTest extends JFrame {

	public void createAndShowGUI() {

		Object rowData[][] = { { null, null, 0.0d } };
		Object columnNames[] = new String[] { "RA", "NOME", "NOTA" };
		JTable table = new JTable();

		DefaultTableModel modeloTabela = new DefaultTableModel(rowData, columnNames) {
			
			boolean[] canEdit = new boolean[] { false, false, true };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				
				return columnIndex == 2 ? Double.class : super.getColumnClass(columnIndex);
			}
		};
		
		table.setModel(modeloTabela);

		table.getColumnModel().getColumn(2).setCellEditor(new NumberCellEditor());
		
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[]) throws IllegalAccessException {

		EventQueue.invokeLater(() -> {
			new JTableEditorFormattedTest().createAndShowGUI();
		});
	}

	class NumberCellEditor extends DefaultCellEditor {
		
		Double previosValue = 0d;
		
		public NumberCellEditor() {
			super(new JFormattedTextField());
		}
		
		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return Double.valueOf((String) super.getCellEditorValue());
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			JFormattedTextField editor = (JFormattedTextField) super.getTableCellEditorComponent(table, value,
					isSelected, row, column);

			if (value != null) {
				
				Double valor = (Double) value;
			
				if(valor >= 0.0 && valor <= 10.0){
					try {
						MaskFormatter mask;
						mask = new MaskFormatter("##.#");
						editor.setFormatterFactory(new DefaultFormatterFactory(mask));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					previosValue = valor;
				}
			}
			editor.setHorizontalAlignment(SwingConstants.RIGHT);
			editor.setText(previosValue.toString());
			return editor;
		}
		
@Override
		public boolean stopCellEditing() {
			// TODO Auto-generated method stub
			return super.stopCellEditing();
		}
	}
}
