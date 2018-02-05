package swing.examples7;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClipboardTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new ClipboardTest().setVisible(true));
	}

	public ClipboardTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField = new JTextField();
		textField.setColumns(20);

		JButton btnClipboard = new JButton("Copy to Clipboard");

		btnClipboard.addActionListener(e -> {
			
			StringSelection stringSelection = new StringSelection(textField.getText());
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents(stringSelection, null);

			JOptionPane.showMessageDialog(this, "campo de texto copiado para o clipboard");
		});

		contentPane.add(textField);
		contentPane.add(btnClipboard);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(""), null);
	}

}
