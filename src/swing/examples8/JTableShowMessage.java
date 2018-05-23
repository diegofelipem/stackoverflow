package swing.examples8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class JTableShowMessage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JTableShowMessage().setVisible(true));
	}


	public JTableShowMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		contentPane = new JPanel(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		table = new JTable(5,5);
		
//		table.addPropertyChangeListener(e -> {
//			
//			if("tableCellEditor".equals(e.getPropertyName())) {
//				if(!table.isEditing())
//					JOptionPane.showMessageDialog(this,"fim da edição em alguma celula");
//			}
//		});
		
		table.getColumnModel().getColumn(1).setCellEditor(new ShowMessageCellEditor(new JTextField()));

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
	}
	
	class ShowMessageCellEditor extends DefaultCellEditor{

		public ShowMessageCellEditor(JTextField textField) {
			super(textField);
		}
		
		@Override
		public boolean stopCellEditing() {
			JOptionPane.showMessageDialog(null, "celula modificada");
			return super.stopCellEditing();
		}
	}	
}
