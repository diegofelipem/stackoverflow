package swing.examples6;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

public class JTableFilterDemo extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	private JTable table;
	private JTextField filterText;
	private JTextField statusText;
	private TableRowSorter<MyTableModel> sorter;

	public JTableFilterDemo() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Create a table with a sorter.
		MyTableModel model = new MyTableModel();
		sorter = new TableRowSorter<MyTableModel>(model);
		table = new JTable(model);
		table.setRowSorter(sorter);
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
		table.setFillsViewportHeight(true);

		// For the purposes of this example, better to have a single
		// selection.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// When selection changes, provide user with row numbers for
		// both view and model.
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				int viewRow = table.getSelectedRow();
				if (viewRow < 0) {
					// Selection got filtered away.
					statusText.setText("");
				} else {
					int modelRow = table.convertRowIndexToModel(viewRow);
					statusText.setText(String.format("Selected Row in view: %d. " + "Selected Row in model: %d.",
							viewRow, modelRow));
				}
			}
		});

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);

		// Create a separate form for filterText and statusText
		//JPanel form = new JPanel(new SpringLayout());
		JPanel form = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.weighty = 1.0;
		gbc1.insets = new Insets(0, 5, 0, 5);
		gbc1.fill = GridBagConstraints.HORIZONTAL;

		JLabel l1 = new JLabel("Filter Text:", SwingConstants.TRAILING);

		form.add(l1, gbc1);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.weightx = 1.0;
		gbc1.weighty = 1.0;
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridwidth = GridBagConstraints.REMAINDER;
		
		filterText = new JTextField();
		// Whenever filterText changes, invoke newFilter.
		filterText.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				newFilter();
			}

			public void insertUpdate(DocumentEvent e) {
				newFilter();
			}

			public void removeUpdate(DocumentEvent e) {
				newFilter();
			}
		});
		l1.setLabelFor(filterText);
		form.add(filterText, gbc2);
		
		GridBagConstraints gbc3 =  (GridBagConstraints) gbc1.clone();
		
		JLabel l2 = new JLabel("Status:", SwingConstants.TRAILING);
		form.add(l2, gbc3);
		
		GridBagConstraints gbc4 =  (GridBagConstraints) gbc2.clone();
		
		statusText = new JTextField();
		l2.setLabelFor(statusText);
		form.add(statusText, gbc4);
		add(form);
	}

	/**
	 * Update the row filter regular expression from the expression in the text box.
	 */
	private void newFilter() {
		RowFilter<MyTableModel, Object> rf = null;
		// If current expression doesn't parse, don't update.
		try {
			rf = RowFilter.regexFilter(filterText.getText(), 0);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		sorter.setRowFilter(rf);
	}

	class MyTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };
		private Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		/*
		 * JTable uses this method to determine the default renderer/ editor for each
		 * cell. If we didn't implement this method, then the last column would contain
		 * text ("true"/"false"), rather than a check box.
		 */
		public Class<?> getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's editable.
		 */
		public boolean isCellEditable(int row, int col) {
			// Note that the data/cell address is constant,
			// no matter where the cell appears onscreen.
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		/*
		 * Don't need to implement this method unless your table's data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			data[row][col] = value;
			fireTableCellUpdated(row, col);

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TableFilterDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JTableFilterDemo newContentPane = new JTableFilterDemo();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(JTableFilterDemo::createAndShowGUI);
	}
}