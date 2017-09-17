package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChessBoardTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			ChessBoardTest frame = new ChessBoardTest();
			frame.setVisible(true);
		});
	}

	public ChessBoardTest() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));
		setResizable(false);

		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.contentPane.add(new GridPane(10, 10));
	}

	class GridPane extends JPanel {

		private static final long serialVersionUID = 1L;
		private int rows;
		private int column;

		private JLabel[][] squares;

		public GridPane(int rows, int column) {
			this.rows = rows;
			this.column = column;
			this.setLayout(new GridLayout(rows, column));
			this.squares = new JLabel[this.rows][this.column];

			for (int r = 0; r < this.rows; r++) {
				for (int c = 0; c < this.column; c++) {
					SquareLabel square = new SquareLabel();
					this.squares[r][c] = square;
					this.add(square);
				}
			}
		}
	}

	class ClickChangeColor extends MouseAdapter {

		boolean clicked = false;

		@Override
		public void mouseClicked(MouseEvent e) {

			clicked = !clicked;
			JLabel square = (JLabel) e.getSource();
			Color color = clicked ? Color.black : square.getParent().getBackground();
			square.setBackground(color);
		}
	}

	class SquareLabel extends JLabel {

		private static final long serialVersionUID = 1L;

		public SquareLabel() {
			setOpaque(true);
			setBorder(BorderFactory.createLineBorder(Color.black, 1));
			addMouseListener(new ClickChangeColor());
		}
	}
}
