package swing.experiences.wheelRandomColors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class WheelRandomColorsTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Board board;
	private JPanel controlsPane;
	private JButton spinButton;

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
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 300));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.board = new Board();

		this.contentPane.add(this.board, BorderLayout.CENTER);

		this.controlsPane = new JPanel(new GridLayout(0, 1, 0, 0));
		this.controlsPane.setBorder(new EmptyBorder(5, 1, 1, 1));

		this.spinButton = new JButton("Spin!");
		this.spinButton.addActionListener(e -> {
			
			Random r = new Random();
			int laps = r.nextInt(9);
			
			for(int i = 0; i < laps; i++){
				board.spin();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		this.spinButton.setFocusable(false);

		this.controlsPane.add(this.spinButton);

		this.contentPane.add(this.controlsPane, BorderLayout.SOUTH);

	}
}
