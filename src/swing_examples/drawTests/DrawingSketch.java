package swing_examples.drawTests;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//Essa classe tem o objetivo de imitar o recurso de desenhar linhas do softwere paint, da Microsoft.

public class DrawingSketch extends JFrame {

	private static final long serialVersionUID = 5661286812709693531L;
	private JPanel contentPane;
	private JPanel draft;

	private ArrayList<Point> points = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingSketch frame = new DrawingSketch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingSketch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		draft = new Draft();
		draft.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

				points.add(e.getPoint());
				draft.repaint();
			}

		});
		draft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// adiciona uma coordenada nula para ignorarmos
				// no paintComponent
				points.add(e.getPoint());
				points.add(new Point(-1, -1));
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		contentPane.add(draft, BorderLayout.CENTER);
		draft.setLayout(null);
	}

	public class Draft extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 4886600019364448097L;

		public Draft() {

		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			int i = 0;
			while (i < points.size() - 1) {
				Point p1 = points.get(i);
				Point p2 = points.get(i + 1);

				if (p2.x != -1 && p2.y != -1) {
					Graphics2D g1 = (Graphics2D) g;
					RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					g1.setRenderingHints(rh);
					g1.drawLine(p1.x, p1.y, p2.x, p2.y);
					i++;

				} else {
					// quando as coordenadas do ponto seguinte forem (-1, -1),
					// pulamos essa iteração para evitar que a linha anterior
					// seja ligada a nova linha que está sendo desenhada
					i += 2;
				}
			}
		}
	}

}