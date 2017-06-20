package swing.examples.drawTests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class FreehandExample extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
     private int counter = 0;
     private int draw = 0;
     private int red[] = {58,71,231,243,255};
     private int green[] = {54,224,235,109,40};
     private int blue[] = {241,95,61,52,40};
     private Point start, end;
     private Graphics gd; 

     public FreehandExample()
     {
        //setUndecorated(true);
        setBackground(new Color(255,0,0));
        setSize(new Dimension(300,200));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        //setOpacity(0.55f);
        setVisible(true);
     }

    public void mousePressed(MouseEvent e) {
        start = new Point(e.getX(), e.getY()); 
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) draw = 1;
        if(e.getButton() == MouseEvent.BUTTON3) draw = 0;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e)  {}

    public void mouseMoved(MouseEvent e) {
       gd = this.getGraphics();

       if(draw==1){
          end = new Point(e.getX(), e.getY());
          gd.setColor(new Color( red[counter],green[counter],blue[counter]));
          gd.drawLine(start.x, start.y, end.x, end.y);
          start = end;
       }
    }

    public static void main(String []args){
         new FreehandExample();
    }

    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            counter++;
            if(counter>4) counter=0;
         }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
