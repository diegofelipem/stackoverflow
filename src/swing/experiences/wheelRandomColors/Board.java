package swing.experiences.wheelRandomColors;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	private Circle circle;
	private LineArrow line;

	public void spin() {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

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

		circle = (circle == null) ? new Circle(x, y, diameter, new Color(255, 77, 77)) : circle;
		line = (line == null) ? new LineArrow(x + diameter / 2, y + diameter / 2, x + diameter / 2, y + diameter,
				new Color(177, 203, 187), 5) : line;

		circle.draw(g);
		line.draw(g);
	}
}
