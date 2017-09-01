package swing.examples4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class KeyListenerActionPerformTest extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JPanel panel2;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			KeyListenerActionPerformTest frame = new KeyListenerActionPerformTest();
			frame.setVisible(true);
		});
	}

	public KeyListenerActionPerformTest() {
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = (JPanel) getContentPane();

		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder("Campo c/ Action e KeyListener"));
		this.contentPane.add(this.panel, BorderLayout.CENTER);

		this.textField = new JTextField(10);
		
		this.textField.addActionListener(e -> {
			textArea.append("Action triggered.\n");
		});

		this.textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textArea.append("KeyEvent triggered.\n");
			}
		});

		this.panel.add(this.textField);

		this.panel2 = new JPanel();
		getContentPane().add(this.panel2, BorderLayout.SOUTH);

		this.textArea = new JTextArea(5, 15);
		this.textArea.setLineWrap(true);
		this.scrollPane = new JScrollPane(textArea);
		this.panel2.add(this.scrollPane);

		pack();
		setLocationRelativeTo(null);
	}
}
