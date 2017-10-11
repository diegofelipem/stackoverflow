package swing.experiences.wheelRandomColors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	private double angleDegrees;

	public Board() {
		angleDegrees = 90;
	}

	public void spin() {
		angleDegrees += 1;
		angleDegrees %= 360;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		super.paintComponent(g2);
		
		int widthRectangle = getWidth();
		int heightReclangle = getHeight();

		int x, y, diameter;

		if (widthRectangle <= heightReclangle) {
			diameter = widthRectangle;
			y = heightReclangle / 2 - diameter / 2;
			x = 0;
		} else {
			diameter = heightReclangle;
			x = widthRectangle / 2 - diameter / 2;
			y = 0;
		}
		Circle circle = new Circle(x, y, diameter, Color.red);
		circle.draw(g2);

		LineArrow line = new LineArrow(x + diameter / 2, y + diameter / 2, angleDegrees, diameter / 2, Color.white, 3,
				20);
		line.draw(g2);
	}
}
