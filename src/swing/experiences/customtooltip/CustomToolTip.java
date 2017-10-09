package swing.experiences.customtooltip;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToolTip;

public class CustomToolTip extends JToolTip {

	public CustomToolTip() {
		super();
		// make the tool tip not fill in its background
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		System.out.println();
	}

	public Dimension getPreferredSize() {
		Dimension dim = super.getPreferredSize();
		return new Dimension((int) dim.getWidth() + 20, (int) dim.getHeight() + 20);
	}

	public void paintComponent(Graphics g) {

		// set the parent to not be opaque
		Component parent = this.getParent();
		if (parent != null) {
			if (parent instanceof JComponent) {
				JComponent jparent = (JComponent) parent;
				if (jparent.isOpaque()) {
					jparent.setOpaque(false);
				}
			}
		}

		// create a round rectangle
		Shape round = new RoundRectangle2D.Float(4, 4, this.getWidth() - 1 - 8, this.getHeight() - 1 - 8, 15, 15);

		// draw the white background
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.white);
		g2.fill(round);

		// draw the gray border
		g2.setColor(Color.gray);
		g2.setStroke(new BasicStroke(3));
		g2.draw(round);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);

		// draw the text
		String text = this.getComponent().getToolTipText();
		if (text != null) {
			FontMetrics fm = g2.getFontMetrics();
			int h = fm.getAscent();
			g2.setColor(Color.black);
			g2.drawString(text, 10, (this.getHeight() + h) / 2);
		}
	}
}
