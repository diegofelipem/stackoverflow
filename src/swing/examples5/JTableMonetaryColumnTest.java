package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableMonetaryColumnTest extends JFrame {

	public void createAndShowGUI() {

		Object[][] rowData = {new Object[]{}};
		Object[] columnNames = { "Column One", "Column Two", "Column Three" };
		
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames){
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 0 ? Double.class : super.getColumnClass(columnIndex);
			}
		};
		
		JTable table = new JTable(model);
		
		table.getColumnModel().getColumn(0).setCellRenderer(new CurrencyTableCellRenderer());

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[]) throws IllegalAccessException {

		EventQueue.invokeLater(() -> {

			new JTableMonetaryColumnTest().createAndShowGUI();
		});
	}
	
	class CurrencyTableCellRenderer extends DefaultTableCellRenderer {

	    private final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();

	    @Override
	    public final Component getTableCellRendererComponent(JTable table, Object value,
	            boolean isSelected, boolean hasFocus, int row, int column) {
	        final Component result = super.getTableCellRendererComponent(table, value,
	                isSelected, hasFocus, row, column);
	        if (value instanceof Number) {
	            setHorizontalAlignment(JLabel.RIGHT);
	            setText(FORMAT.format(value));
	        } else {
	            setText("");
	        }
	        return result;
	    }
	}
	
}
