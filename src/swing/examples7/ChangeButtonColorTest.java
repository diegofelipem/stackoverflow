package swing.examples7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;

public class ChangeButtonColorTest extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new ChangeButtonColorTest().setVisible(true));
	}

	public ChangeButtonColorTest() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.btnNewButton = new JButton("New button");
		this.btnNewButton.setContentAreaFilled(false);
		this.btnNewButton.setOpaque(true);
		this.btnNewButton.setBackground(Color.RED);
		this.contentPane.add(this.btnNewButton);
	}

}
