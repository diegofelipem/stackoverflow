package swing_examples.drawTests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class ExperimentalClass {
    // as much as possible, don't use the water in the tank when they're off
    // because it can cause air locks. You'll get no water anyway if the tank is
    // empty
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Draw a red line");
        f.setSize(300, 300);
        f.setLocation(300, 300);
        f.setResizable(false);
 
        JPanel p = new JPanel() {
            Point pointStart = null;
            Point pointEnd = null;
            {
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        pointStart = e.getPoint();
 
                    }
 
                    public void mouseReleased(MouseEvent e) {
                        pointStart = null;
 
                    }
                });
                addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent e) {
                        pointEnd = e.getPoint();
                    }
 
                    public void mouseDragged(MouseEvent e) {
                        pointEnd = e.getPoint();
                        repaint();
                    }
                });
            }
 
            public void paint(Graphics g) {
                super.paint(g);
                if (pointStart != null) {
                    g.setColor(Color.red);
                    g.drawLine(pointStart.x, pointStart.y, pointEnd.x,
                            pointEnd.y);
 
                }
            }
        };
        f.add(p);
        f.setVisible(true);
 
    }
}