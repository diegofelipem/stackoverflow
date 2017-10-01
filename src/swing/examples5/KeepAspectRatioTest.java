package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class KeepAspectRatioTest extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 350;
	private static final int HEIGHT = 500;
	private static final float RATIO = 0.7f;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			KeepAspectRatioTest screen = new KeepAspectRatioTest();
			screen.setVisible(true);
		});
	}

	public KeepAspectRatioTest() {

		initUI();
	}

	private void initUI() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setTitle("Keep Aspect Ratio");

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				 proportionalDimension((JFrame) e.getSource());
			}
		});

		JPanel board = new JPanel();
		board.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.setPreferredSize(new Dimension(WIDTH / 6, HEIGHT));

		add(board, BorderLayout.CENTER);
		add(sidePanel, BorderLayout.EAST);

		pack();
		setLocationRelativeTo(null);

	}

	public void proportionalDimension(JFrame frame) {
		double w = frame.getWidth();
		double h = frame.getHeight();

		int newWidth, newHeight;

		if (w / h < RATIO) {
			newWidth = (int) (h * RATIO);
			newHeight = (int) h;
		} else {
			newWidth = (int) w;
			newHeight = (int) (w / RATIO);
		}

		 frame.setSize(newWidth, newHeight);
		 frame.repaint();
	}
}
