package swing.examples8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JTableAddColunasseparadosPorVirgulaTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JTableAddColunasseparadosPorVirgulaTest().setVisible(true));
	}

	public JTableAddColunasseparadosPorVirgulaTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelField = new JPanel();
		contentPane.add(panelField, BorderLayout.NORTH);

		textField = new JTextField();
		panelField.add(textField);
		textField.setColumns(20);

		String[] columnNames = new String[] { "classes", "Xi", "Fi", "Fac" };

		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		contentPane.add(scroll, BorderLayout.CENTER);

		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);

		JButton jbutton = new JButton("Adicionar");
		panelBtn.add(jbutton);

		jbutton.addActionListener(e -> {

			String text = textField.getText().trim();

			if (!text.isEmpty()) {

				String[] values = text.split(",");

				for (int i = 0; i < values.length; i++) {
					model.addRow(new Object[] { null, values[i], null, null });
				}
			}
		});
		pack();
	}
}
