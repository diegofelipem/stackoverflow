package swing.examples6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class JTableCheckboxTest extends JFrame{
	
	public void createAndShowGUI() {

		Object[][] rowData = {null, null, null};
		Object[] columnNames = { "Column One", "Column Two",};
		
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames){
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
			}
		};
		
		JTable table = new JTable(model);		

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		setPreferredSize(new Dimension(300, 150));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) throws IllegalAccessException {
		EventQueue.invokeLater(() -> new JTableCheckboxTest().createAndShowGUI());
	}
}
