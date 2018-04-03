package swing.examples7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaRelativaTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new TelaRelativaTest().setVisible(true));
	}


	public TelaRelativaTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPreferredSize(getRelativeDimension());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(8);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		Object[][] data = {{null, null, null},{null, null, null},{null, null, null},{null, null, null}};
		Object[] columns =  { "Column One", "Column Two", "Column Three"};
		
		table = new JTable(data, columns);

		JScrollPane scrollPane  = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
	
	}
	
	private Dimension getRelativeDimension() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  

		int width = screenSize.width;  
		int height = screenSize.height;  
		
		// valor que definira a proporcao do JFrame em
		// relacao ao tamanho da tela do usuario
		//valores maximos de 0 a 1 onde 1 é semelhante a fullscreen
		float ratio = 0.5f;
		
		return new Dimension(Math.round(width*ratio), Math.round(height*ratio));
	}
	
}
