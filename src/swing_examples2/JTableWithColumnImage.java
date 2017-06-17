package swing_examples2;

import java.awt.Component;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableWithColumnImage extends JFrame {

	private static final long serialVersionUID = 1L;

	public void createAndShowGUI() {

		ImageIcon icon = null, icon2 = null;

		try {
			icon = new ImageIcon(ImageIO.read(new URL(
					"http://searchengineland.com/figz/wp-content/themes/searchengineland/img/icons/black-google-play-badge.png")));
			icon2 = new ImageIcon(ImageIO.read(new URL(
					"http://searchengineland.com/figz/wp-content/themes/searchengineland/img/icons/black-badge-appstore.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object columnNames[] = { "Column One", "Column Two" };
		Object[][] rowData = { { "Row1-Column1", icon }, { "Row2-Column1", icon2 } };

		DefaultTableModel model = new DefaultTableModel(rowData, columnNames){
			@Override
			public Class<?> getColumnClass(int columnIndex) {

				return columnIndex == 1 ? ImageIcon.class : super.getColumnClass(columnIndex);
			}
		};

		JTable table = new JTable(model);

		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				if (value instanceof ImageIcon) {
					ImageIcon icon = (ImageIcon) value;
					table.setRowHeight(row, icon.getIconHeight());
				}
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		});

		table.setRowHeight(icon.getIconHeight());
		
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String args[]) throws IllegalAccessException {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JTableWithColumnImage().createAndShowGUI();
			}
		});
	}
}
