package swing.examples8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventTexFieldJOptionPaneTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(KeyEventTexFieldJOptionPaneTest::new);
	}

	private Component getInstance() {
		return this;
	}

	public KeyEventTexFieldJOptionPaneTest() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		contentPane = new JPanel(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		textField = new JTextField(10);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
					System.out.println("enter pressionado e liberado");
					JOptionPane.showMessageDialog(getInstance(), "teste");
				}
			}
		});
		panel.add(textField);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
