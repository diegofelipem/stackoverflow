package swing.examples9;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JTextFieldDisabled extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(JTextFieldDisabled::new);
	}

	public JTextFieldDisabled() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		
		textField = new JTextField();
		textField.setEditable(false);

		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(e -> {
			String text = JOptionPane.showInputDialog("Digite algo:");
			textField.setText(text);
		});
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
