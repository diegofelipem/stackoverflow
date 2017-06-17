package swing_examples2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BreakoutTest2 {
	Board boardGame;
	JFrame frame;

	public void initGui() {
		frame = new JFrame("Breakout Game");

		this.boardGame = new Board();
		frame.setContentPane(boardGame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			new BreakoutTest2().initGui();
		});
	}
	
	class Board extends JPanel {

		private static final long serialVersionUID = 1L;
		public final int WIDTH = 400;
		public final int HEIGHT = 300;
		private final int UPDATE_INTERVAL = 20;
		
		private Timer timer;

		public Board() {

			setBorder(BorderFactory.createLineBorder(Color.red));

			ActionListener action = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateBoard();
					repaint();
				}
			};

			timer = new Timer(UPDATE_INTERVAL, action);

			setFocusable(true);

		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}

		private void updateBoard() {
			repaint();
		}

		public void gameOver() {
			JOptionPane.showMessageDialog(this, "Game Over");
			newGame();
		}

		public void starGame() {
			timer.start();
		}

		public void stop() {
			timer.stop();
		}

		public void newGame() {
			stop();
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//draw the rectangle just to give an example
			g2.fillRect(0, 0, 400, 10);
			
		}
	}
	
}