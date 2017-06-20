package swing.examples2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class OrdemEventosTest extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdemEventosTest frame = new OrdemEventosTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrdemEventosTest() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(450, 300));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panel = new JPanel();
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldFocusLost(e);
			}
		});;
		panel.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(contentPane.getPreferredSize().width/2, contentPane.getPreferredSize().height));
		contentPane.add(scrollPane);
		
		String[] columns = {"col-1","col-2","col-3","col-4"};
		
		String[][] data = {{"cell-1","cell-2","cell-3","cell-4"},{"cell-5","cell-6","cell-7","cell-8"}};
		
		DefaultTableModel model = new DefaultTableModel(data, columns);
		
		table = new JTable(model);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					int row = table.getSelectedRow();
					textField.setText((String) table.getValueAt(row, 0));
					System.out.println("Seleção de linha alterada!");
				}
			}
		});
		scrollPane.setViewportView(table);
		pack();
	}

	protected void textFieldFocusLost(ActionEvent e) {
		JTextComponent c = (JTextComponent) e.getSource();
		String text = c.getText();
		int selectedRow = table.getSelectedRow();
		if(text != null && !text.isEmpty() && selectedRow != -1){
			table.setValueAt(text, selectedRow, 0);
		}
		System.out.println("Campo perdeu foco!");
	}

}
