package swing.examples6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class JTableModelTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private SimpleTableModel model;
	private JButton btn;

	public JTableModelTest() {

		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person("person1", 25, true));
		persons.add(new Person("person2", 17, false));
		persons.add(new Person("person3", 28, true));
		persons.add(new Person("person5", 22, true));
		persons.add(new Person("person5", 55, false));

		model = new SimpleTableModel(persons);
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		btn = new JButton("New...");
		btn.addActionListener(e -> {
			model.add(new Person());
		});
		getContentPane().add(btn, BorderLayout.PAGE_END);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		SwingUtilities.invokeLater(JTableModelTest::new);
	}

	class SimpleTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private String[] columns = { "Name", "Age", "Active" };
		private Class<?>[] columns_type = { String.class, Integer.class, Boolean.class };
		private ArrayList<Person> dataList;

		public SimpleTableModel(ArrayList<Person> dataList) {
			this.dataList = dataList;
		}

		@Override
		public int getColumnCount() {
			return columns.length;
		}

		@Override
		public int getRowCount() {
			return dataList.size();
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
		}

		@Override
		public void setValueAt(Object value, int row, int col) {
			Person p = (Person) (dataList.get(row));

			switch (col) {
			case 0:
				p.setName((String) value);
				break;
			case 1:
				p.setAge((Integer) value);
				break;
			case 2:
				p.setActive((Boolean) value);
			}
			fireTableDataChanged();
		}

		@Override
		public String getColumnName(int col) {
			return columns[col];
		}

		@Override
		public Class<?> getColumnClass(int col) {
			return columns_type[col];
		}

		@Override
		public Object getValueAt(int row, int col) {
			Person p = (Person) (dataList.get(row));

			switch (col) {
			case 0:
				return p.getName();
			case 1:
				return p.getAge();
			case 2:
				return p.isActive();
			default:
				return null;
			}
		}

		public void add(Person p) {
			this.dataList.add(p);
			this.fireTableRowsInserted(dataList.indexOf(p), dataList.indexOf(p));
		}
	}

	class Person {

		private String name;
		private int age;
		private boolean isActive;

		public Person() {
		}

		public Person(String name, int age, boolean isActive) {
			this.name = name;
			this.age = age;
			this.isActive = isActive;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
	}
}
