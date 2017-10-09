package swing.experiences.drawTests;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel  extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Point> points = new ArrayList<>();

	public DrawPanel() {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// adiciona uma coordenada nula para ignorarmos
				// no paintComponent
				points.add(e.getPoint());
				points.add(new Point(-1, -1));
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

				points.add(e.getPoint());
				repaint();
			}

		});
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