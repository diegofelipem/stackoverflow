package swing.experiences.fortunewheel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.Random;

public class Wheel {

	private final int x;
	private final int y;
	private final int diameter;
	private static final Color[] colors = { new Color(128, 128, 128), new Color(128, 0, 0), new Color(128, 128, 0),
			new Color(0, 128, 0), new Color(128, 0, 128), new Color(0, 0, 128) };

	private Point[] points;
	private final Point circleCenter;
	// total de fatias na circunferencia
	private static final int TOTAL_SLICES = 6;
	private final double sliceAngleRadians;
	private final double sliceAngleDegree;

	public Wheel(int x, int y, int diameter) {
		super();
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.sliceAngleDegree = 360d / TOTAL_SLICES;
		// calcula o angulo base de uma fatia do circulo
		this.sliceAngleRadians = Math.toRadians(sliceAngleDegree);
		// calcula o ponto central do circulo
		this.circleCenter = new Point((x + diameter / 2), (y + diameter / 2));
		// array de pontos distribuidos na extremidade do circulo
		this.points = new Point[TOTAL_SLICES];
		// preenche o array com pontos distribuidos no comprimento da
		// circunferencia
		for (int i = 0; i < TOTAL_SLICES; i++)
			points[i] = new Point((int) (circleCenter.x + (diameter / 2) * Math.cos(sliceAngleRadians * (i + 1))),
					(int) (circleCenter.y + (diameter / 2) * Math.sin(sliceAngleRadians * (i + 1))));
	}

	public void draw(Graphics2D g2) {

		// desenha fatias dentro do circulo
		for (int i = 0; i < TOTAL_SLICES; i++) {
			g2.setColor(colors[i]);
			g2.fillArc(x, y, diameter, diameter, (int) sliceAngleDegree * i, (int) sliceAngleDegree);

		}
	}
}
