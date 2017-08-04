package swing.examples3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class JTableCellSelectingTest extends JFrame {

	public void createAndShowGUI() {

		Object columnNames[] = { "Any type Column", "Only Float Column", "Other Column"};

		DefaultTableModel model = new DefaultTableModel(null, columnNames) {

			@Override
			public Class<?> getColumnClass(int columnIndex) {

					return columnIndex == 1 ? Float.class : super.getColumnClass(columnIndex); 
			}
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return column == 1;
			}
			
		};

		model.addRow(new Object[]{});
		model.addRow(new Object[]{});
		model.addRow(new Object[]{});
		model.addRow(new Object[]{});
		model.addRow(new Object[]{});
		
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		
		DefaultListSelectionModel selectionModel = new DefaultListSelectionModel() {
			
			
		    private boolean isSelectable(int index0, int index1) {
		        return  index0 >= 1 && index1 <= 2;
		    }

		    @Override
		    public void setSelectionInterval(int index0, int index1) {
		    	int tempIndex0 = index0, tempIndex1 = index1;
		        if(!isSelectable(tempIndex0, tempIndex1)) {
		            tempIndex0++;
		            tempIndex1++;
		        }
		        super.addSelectionInterval(tempIndex0, tempIndex1);
		    }

		    @Override
		    public void addSelectionInterval(int index0, int index1) {
		    	int tempIndex0 = index0, tempIndex1 = index1;
		        if(!isSelectable(tempIndex0, tempIndex1)) {
		            tempIndex0++;
		            tempIndex1++;
		        }
		        super.addSelectionInterval(tempIndex0, tempIndex1);
		    }
		};
		table.getColumnModel().setSelectionModel(selectionModel);

		this.add(scrollPane, BorderLayout.CENTER);

		pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[])  {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JTableCellSelectingTest().createAndShowGUI();

			}
		});
	}
}
