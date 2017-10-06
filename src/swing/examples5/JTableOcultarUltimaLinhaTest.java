package swing.examples5;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JTableOcultarUltimaLinhaTest extends JFrame {

	Object[][] rows = new Object[][] {

			{ "Jack", "19", "Masculino" }, { "Eddie", "56", "Masculino" }, { "Gina", "34", "Feminino" },
			{ "Klaus", "18", "Masculino" }, { "Erika", "20", "Feminino" }, { "Roberto", "29", "Masculino" },
			{ "Maria", "30", "Feminino" } };

	Object[] columns = new Object[] { "Nome:", "Idade:", "Sexo:" };

	public JTableOcultarUltimaLinhaTest() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultTableModel model = new DefaultTableModel(rows, columns);

		JTable table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		
		RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>(){
			
			@Override
			public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
		        int modelRow = entry.getIdentifier();
		        return modelRow < (table.getRowCount() - 1);
			}
		};
		
		((TableRowSorter<?>)table.getRowSorter()).setRowFilter(filter);
		
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		pack();
	}

	public static void main(String arg[]) {

		SwingUtilities.invokeLater(() -> {
			new JTableOcultarUltimaLinhaTest().setVisible(true);
		});
	}
}
