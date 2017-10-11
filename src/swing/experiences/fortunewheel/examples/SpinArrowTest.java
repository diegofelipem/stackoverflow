package swing.experiences;

import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SpinArrowTest extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
    	
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
    	EventQueue.invokeLater(() -> new SpinArrowTest().setVisible(true));
    }

    public SpinArrowTest() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        Board board = new Board();

        contentPane.add(board, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel(new GridLayout(0, 1, 0, 0));
        controlsPane.setBorder(new EmptyBorder(5, 1, 1, 1));

        JButton rotateButton = new JButton("Rotate");
        rotateButton.addActionListener(e -> board.spin());
        
        controlsPane.add(rotateButton);

        contentPane.add(controlsPane, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

//painel principal onde ocorrerá a animação e desenho

class Board extends JPanel {

    private static final long serialVersionUID = 1L;
    private double angleDegrees; // Em graus.

    public Board() {
        angleDegrees = 90;
    }

    public void spin() {
        angleDegrees += 10;
        angleDegrees %= 360;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
    	
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

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
        Circle circle = new Circle(x, y, diameter, Color.red);
        circle.draw(g);

        LineArrow line = new LineArrow(x + diameter / 2, y + diameter / 2, angleDegrees, diameter / 2, Color.white, 3, 15);
        line.draw(g);
    }
}

//CLASSE QUE REPRESENTA O CIRCULO

class Circle {

    private final int x;
    private final int y;
    private final int diameter;
    private final Color color;

    public Circle(int x, int y, int diameter, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setPaint(new GradientPaint(x, y, color, x + diameter / 2, y + diameter / 2, color.darker()));
        g2.fillOval(x, y, diameter, diameter);
    }
}

//CLASSE QUE REPRESENTA A SETA QUE IRÁ GIRAR DENTRO DO CIRCULO

class LineArrow {

    private final int x;
    private final int y;
    private final int endX;
    private final int endY;
    private final double angleRadians;
    private final Color color;
    private final int thickness;
    private final double scale;

    private static final int TRIANGLE_LENGTH = 2;
    private static final Polygon ARROW_HEAD = new Polygon();

    static {
        ARROW_HEAD.addPoint(TRIANGLE_LENGTH, 0);
        ARROW_HEAD.addPoint(0, -TRIANGLE_LENGTH / 2);
        ARROW_HEAD.addPoint(0, TRIANGLE_LENGTH / 2);
    }

    public LineArrow(int x, int y, double angleDegrees, int length, Color color, int thickness, int headSize) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        this.thickness = thickness;

        // Converte o ângulo para radianos.
        this.angleRadians = Math.toRadians(angleDegrees);

        // Calcula a escala a ser aplicada ao desenhar a ponta.
        this.scale = headSize / TRIANGLE_LENGTH;

        // Calcula a posição final da linha de acordo com o ângulo e com o
        // comprimento. Corta do comprimento o tamanho da ponta.
        this.endX = (int) (x + (length - headSize) * Math.cos(angleRadians));
        this.endY = (int) (y + (length - headSize) * Math.sin(angleRadians));
    }

    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        // Define a cor e a espessura da linha.
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));

        // Desenha a linha.
        g2.drawLine(x, y, endX, endY);

        // Obtém o AffineTransform original.
        AffineTransform tx1 = g2.getTransform();

        // Cria uma cópia do AffineTransform.
        AffineTransform tx2 = (AffineTransform) tx1.clone();

        // Translada e rotaciona o novo AffineTransform.
        tx2.translate(endX, endY);
        tx2.scale(scale, scale);
        tx2.rotate(angleRadians);

        // Desenha a ponta com o AffineTransform transladado e rotacionado.
        g2.setTransform(tx2);
        g2.fill(ARROW_HEAD);

        // Restaura o AffineTransform original.
        g2.setTransform(tx1);
    }
}