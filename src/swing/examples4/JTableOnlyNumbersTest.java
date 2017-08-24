package swing.examples4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class JTableOnlyNumbersTest extends JFrame {

	public void createAndShowGUI() {

		Object columnNames[] = { "Any type Column", "Only Integer Column" };

		DefaultTableModel model = new DefaultTableModel(null, columnNames) {

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return columnIndex == 1 ? Integer.class : super.getColumnClass(columnIndex);
			}

		};

		model.addRow(new Object[] {});
		model.addRow(new Object[] {});
		model.addRow(new Object[] {});
		model.addRow(new Object[] {});
		model.addRow(new Object[] {});

		JTable table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);

		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);

		this.add(scrollPane, BorderLayout.CENTER);

		pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JTableOnlyNumbersTest().createAndShowGUI();

			}
		});
	}
}