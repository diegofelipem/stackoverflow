package swing_examples;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class CircleExample {

    private static final int GAP = 5;

    private JPanel drawingBoard;    

    private void displayGUI() {
        JFrame frame = new JFrame("Circle Drawing Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(GAP, GAP));
        contentPane.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        drawingBoard = new DrawingBoard();
        contentPane.add(drawingBoard);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new CircleExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class DrawingBoard extends JPanel {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 350;

    private List<MyCircle> circles;
    private Random random;

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            System.out.println("Mouse Clicked");
            int x = me.getX();
            int y = me.getY();
            circles.add(new MyCircle(x, y, getRandomColour()));
            DrawingBoard.this.repaint();
        }
    };

    public DrawingBoard() {
        super();
        circles = new ArrayList<MyCircle> ();
        random = new Random();
        setOpaque(true);
        addMouseListener(mouseAdapter);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MyCircle circle : circles) {
            circle.drawCircle(g);
        }
    }

    private Color getRandomColour() {
        return new Color(random.nextFloat(), random.nextFloat(),
                            random.nextFloat(), random.nextFloat());
    }
}

class MyCircle {

    private int x;
    private int y;
    private Color backgroundColour;

    private static final int RADIUS = 20;

    public MyCircle(int x, int y, Color backgroundColour) {
        this.x = x;
        this.y = y;
        this.backgroundColour = backgroundColour;
    }

    public void drawCircle(Graphics g) {
        g.setColor(backgroundColour);
        g.fillOval(x, y, RADIUS, RADIUS);
    }
}