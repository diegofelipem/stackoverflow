package swing.experiences.wheelRandomColors;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle {
	
	int x;
	int y;
	int diameter;
	Color color;
	
	public Circle(int x, int y, int diameter, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = color;
	}
	
	public void draw(Graphics g){
	
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(color);
		g2.setPaint(new GradientPaint(x, y, color, x + diameter/2, y + diameter/2, color.darker()));
		g2.fillOval(x, y, diameter, diameter);
		g2.dispose();
	}
}
