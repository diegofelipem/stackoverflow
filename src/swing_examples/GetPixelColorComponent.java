package swing_examples;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GetPixelColorComponent extends JFrame {

	public static void main(String[] args) throws AWTException {
		JFrame frame;
		Robot robot;
		JLayeredPane layeredPane;
		MouseMotionListener ml;

		robot = new Robot();
		frame = new JFrame("Pc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(300, 310));
		layeredPane.setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move Duke"));
		JLabel label = new JLabel();
		label.setBounds(15, 15, 300, 300);
		label.setOpaque(true);
		label.setBackground(Color.white);

		JLabel label1 = new JLabel();
		label1.setBounds(60, 60, 300, 300);
		label1.setOpaque(true);
		label1.setBackground(new Color(0, 0, 0, 125));

		layeredPane.add(label, 0, 0);
		layeredPane.add(label1, 1, 0);

		frame.setSize(660, 400);

		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setGlassPane(layeredPane);
		layeredPane.setVisible(true);
		frame.setVisible(true);

		ml = new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent evt) {

				JComponent comp = (JComponent) evt.getSource();
				Point point = comp.getLocationOnScreen();

				Color color = robot.getPixelColor((int) point.getX(), (int) point.getY());
				System.out.println(color);
			}
		};
		label.addMouseMotionListener(ml);
	}
}