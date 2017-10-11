package swing.experiences.fortunewheel.examples;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class SpinArrowTest extends JFrame {

    private static final long serialVersionUID = 1L;

    private final JButton rotateButton;
    private final Board board;

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(SpinArrowTest::new);
    }

    public SpinArrowTest() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        board = new Board();

        contentPane.add(board, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel(new GridLayout(0, 1, 0, 0));
        controlsPane.setBorder(new EmptyBorder(5, 1, 1, 1));

        rotateButton = new JButton("Rotate");
        rotateButton.addActionListener(e -> girar());

        controlsPane.add(rotateButton);

        contentPane.add(controlsPane, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Medidas em graus por segundo.
    private static final double VELOCIDADE_ANGULAR_INICIAL_MINIMA = 180;
    private static final double VELOCIDADE_ANGULAR_INICIAL_MAXIMA = 720;

    // Unidade de aceleração, medido em graus por segundo a cada segundo.
    private static final double ATRITO = -40;

    // Tempo entre ticks, em MICROsegundos.
    // Quanto menor for, mais preciso fica, porém mais custoso será.
    private static final int MICRO_DELTA_T = 10_000;

    // Tempo entre ticks, em segundos.
    private static final double DELTA_T = MICRO_DELTA_T / 1_000_000.0;

    private void girar() {
        rotateButton.setEnabled(false);

        SwingWorker<Void, Double> worker = new SwingWorker<Void, Double>() {
            @Override
            protected Void doInBackground() {

                ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

                // Sorteia a velocidade inicial da roleta em graus por segundo.
                double velocidadeInicial =
                        Math.random() * (VELOCIDADE_ANGULAR_INICIAL_MAXIMA - VELOCIDADE_ANGULAR_INICIAL_MINIMA)
                        + VELOCIDADE_ANGULAR_INICIAL_MINIMA;

                // Armazena a velocidade angular atual em graus por segundo.
                AtomicReference<Double> vref = new AtomicReference<>(velocidadeInicial);

                Runnable run = () -> {
                    // Obtém a velocidade angular atual.
                    double velocidadeAngular = vref.get();

                    // Publica no SwingWorker a distância angular percorrida.
                    // Obs: Velocidade * tempo = distância (deg/s * s = deg)
                    publish(velocidadeAngular * DELTA_T);

                    // Aplica o atrito para reduzir a velocidade.
                    // Obs: Aceleração * tempo = velocidade (deg/s² * s = deg/s)
                    double velocidadeAngularNova = velocidadeAngular + ATRITO * DELTA_T;
                    vref.set(velocidadeAngularNova);

                    // Se parou, termina.
                    if (isCancelled() || velocidadeAngularNova <= 0.0) ses.shutdown();
                };

                ses.scheduleAtFixedRate(run, 0, MICRO_DELTA_T, TimeUnit.MICROSECONDS);
                try {
                    ses.awaitTermination(99999, TimeUnit.DAYS);
                } catch (InterruptedException e) {
                    // Ignora a exceção e deixa o SwingWorker terminar graciosamente.
                }
                return null;
            }

            @Override
            protected void process(List<Double> doubles) {
                double distanciaAngular = doubles.stream().reduce(Double::sum).orElse(0.0);
                board.spin(distanciaAngular);
            }

            @Override
            protected void done() {
                rotateButton.setEnabled(true);
            }
        };
        worker.execute();
    }
}

//painel principal onde ocorrerá a animação e desenho

class Board extends JPanel {

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
        Circle circle = new Circle(x, y, diameter, Color.red);
        circle.draw(g2);
        //calcular o tamanho da seta um pouco menor que o raio
        int arrowlength = Math.round(diameter/2 * 0.9f);
        LineArrow line = new LineArrow(x + diameter / 2, y + diameter / 2, angleDegrees, arrowlength, new Color(177, 203, 187), 3, 15);
        line.draw(g2);
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

    public void draw(Graphics2D g2) {

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