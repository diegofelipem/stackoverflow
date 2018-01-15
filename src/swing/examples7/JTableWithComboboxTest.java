package swing.examples7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class JTableWithComboboxTest extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JTableWithComboboxTest().setVisible(true));
	}

	public JTableWithComboboxTest() {
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

		JComboBox<String> comboBox = new JComboBox<>(new MeuComboModel());

		String[] columnNames = { "ComboColumn", "OtherColumn" };
		Object[][] data = { { null, null }, { null, null } };

		this.table = new JTable(data, columnNames);
		this.table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox));

		this.scrollPane = new JScrollPane(table);
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);

	}

	class MeuComboModel extends DefaultComboBoxModel {

		private ArrayList<String> itens;
		private Object itemSelected;

		public MeuComboModel() {
			this.itens = new ArrayList<>();
			this.itens.add("Option 1");
			this.itens.add("Option 2");
			this.itens.add("Option 3");
			this.itens.add("Option 4");
		}

		@Override
		public int getSize() {
			return itens.size();
		}

		@Override
		public Object getElementAt(int index) {
			return itens.get(index);
		}

		@Override
		public void setSelectedItem(Object anItem) {
			this.itemSelected = anItem;

		}

		@Override
		public Object getSelectedItem() {
			return this.itemSelected;
		}
	}

}
