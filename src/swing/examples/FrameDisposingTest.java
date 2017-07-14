package swing.examples;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameDisposingTest extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			System.out.println("creating frame...");
			FrameDisposingTest frame = new FrameDisposingTest();
			System.out.println("setting visibility...");
			frame.setVisible(true);
		});
	}

	public FrameDisposingTest() {
		initComponents();
		System.out.println("disposing...");
		this.dispose();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		pack();
	}
}
