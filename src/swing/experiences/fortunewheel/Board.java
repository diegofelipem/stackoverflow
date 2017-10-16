package swing.experiences.fortunewheel;

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

    public void spin(double degrees) {
        angleDegrees += degrees;
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
		Wheel circle = new Wheel(x, y, diameter);
		circle.draw(g2);
		//calcular o tamanho da seta um pouco menor que o raio
        int arrowlength = Math.round(diameter/2 * 0.9f);
		LineArrow line = new LineArrow(x + diameter / 2, y + diameter / 2, angleDegrees, arrowlength, Color.white, 4,
				15);
		line.draw(g2);
	}
}
