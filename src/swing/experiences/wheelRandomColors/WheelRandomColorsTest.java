package swing.experiences.wheelRandomColors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class WheelRandomColorsTest extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(() -> new WheelRandomColorsTest().setVisible(true));
	}

	public WheelRandomColorsTest() {
		initComponents();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 300));
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Board board = new Board();

		contentPane.add(board, BorderLayout.CENTER);

		JPanel controlsPane = new JPanel(new GridLayout(0, 1, 0, 0));
		controlsPane.setBorder(new EmptyBorder(5, 1, 1, 1));

		JButton spinButton = new JButton("Spin!");
		spinButton.addActionListener(e -> board.spin());
		spinButton.setFocusable(false);

		controlsPane.add(spinButton);

		contentPane.add(controlsPane, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
}
