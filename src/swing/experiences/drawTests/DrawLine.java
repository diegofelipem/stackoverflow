package swing.experiences.drawTests;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawLine extends JFrame implements MouseMotionListener {
    int x1,y1,x,y;
    private boolean first = true;
     public DrawLine() {
         super("Top Level Demo");
         setSize(300, 250);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         setBackground(Color.white);
         addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x =x1; y = y1;
        x1 = e.getX();
        y1 = e.getY();
        if(first){
            x = x1;
            y = y1;
            first  = false;
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paint(Graphics graphics){
        graphics.drawLine(x, y, x1, y1);
    }

    public static void main(String[] args) {
        new DrawLine();
    }
}