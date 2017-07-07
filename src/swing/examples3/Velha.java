package swing.examples3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Velha extends JFrame implements ActionListener, MouseListener {

    private JPanel painel;
    private final int LARGURA = 480;
    private final int ALTURA = 320;
    private Rectangle rect[];
    private boolean colidiu = false;
    int vez = 0;
     

    private int posX, posY;
    private Timer timer;

    private int contador;

    public Velha() {

        //Cria uma nova instancia da classe Rectangle;
        rect = new Rectangle[9];

        timer = new Timer(6, this);
        timer.start();
        contador = 0;

        painel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenhar(g);
            }

            public void desenhar(Graphics g) {

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.WHITE);
                for(int linha = 0; linha < 3; linha++) {
                    for(int coluna = 0; coluna < 3; coluna++) {
                        int xWidth = (LARGURA / 3);
                        int yHeigth = (ALTURA / 3);
                        g2d.drawRect(xWidth * linha, yHeigth * coluna, xWidth, yHeigth);

                        rect[linha * 3 + coluna] = new Rectangle(xWidth * linha, yHeigth * coluna, xWidth, yHeigth);
                    }
                }
            }
        };

        painel.addMouseListener(this);
        painel.setBackground(Color.BLACK);
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA));
        getContentPane().add(painel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(colidiu) {

            Graphics grapichs = getGraphics();
            Graphics2D g2d = (Graphics2D) grapichs;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.RED);

            if(contador % 2 == 0) {
                g2d.drawLine(posX - 10, posY - 15, posX + 40, posY + 60);
                g2d.drawLine(posX - 10, posY + 60, posX + 40, posY - 10);
            } else {
                g2d.drawOval(posX - 30, posY, 60, 60);
            }

            //Incrementa quantidade de jogadas;
            contador++;
            colidiu = false;
        }
    }
    public static void main(String[] args) {
        new Velha().setVisible(true);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

        for(int i=0; i<9; i++) {
            Rectangle eClick = new Rectangle(e.getX(), e.getY(), (LARGURA / 3), (ALTURA / 3));
            if(rect[i].getBounds().intersects(eClick)) {
                System.out.println("Retangulo: " + (i + 1));
                colidiu = true; 
                posX = (int) rect[i].getCenterX();
                posY = (int) rect[i].getCenterY();
                break; 
            }
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}
}