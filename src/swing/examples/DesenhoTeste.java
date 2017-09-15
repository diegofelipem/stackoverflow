package swing.examples;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DesenhoTeste extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DesenhoTeste frame = new DesenhoTeste();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DesenhoTeste() {
        setTitle("Desenho Teste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel areaDeEdicao = new AlteraGrafico();
        contentPane.add(areaDeEdicao, BorderLayout.CENTER);
        areaDeEdicao.setLayout(null);
    }

    public class AlteraGrafico extends JPanel implements MouseMotionListener {

        protected int xi;
        protected int xf;
        protected int yi;
        protected int yf;
        //estas variaveis guardam as coordenadas atuais quando o 
        // mouse mover por sobre este componente
        private int mX, mY;
        private static final long serialVersionUID = 1L;

        public AlteraGrafico() {
            xi = 150;
            xf = 250;
            yi = 150;
            yf = 250;
            addMouseMotionListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);
            Graphics2D g1 = (Graphics2D) g;
            g1.drawRect(150, 150, 100, 100);

            if ((xi <= mX && mX <= xf) && (yi <= mY && mY <= yf)) {
                g1.setColor(Color.red);
                g1.fillRect(150, 150, 100, 100);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

            mX = e.getX();
            mY = e.getY();
           repaint();
        }
    }
}