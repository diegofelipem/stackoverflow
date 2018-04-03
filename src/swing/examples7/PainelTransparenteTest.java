package swing.examples7;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class PainelTransparenteTest {

    public PainelTransparenteTest() {
        JFrame jWindow = new JFrame();
        jWindow.setBackground(new Color(0, 0, 0, 0));
        jWindow.setContentPane(new Pane());
        jWindow.pack();
        jWindow.setVisible(true);
        jWindow.setLocationRelativeTo(null);
    }

    class Pane extends JPanel {

        private BufferedImage leaf;

        public Pane() {
            //setLayout(new BorderLayout());

            JPanel borderPainel = new JPanel();
            borderPainel.setLayout(new BorderLayout());
            JPanel gridPainel = new JPanel();
            gridPainel.setLayout(new GridLayout(2, 1));

            gridPainel.add(new JLabel("Label 01"));
            gridPainel.add(new JLabel("Label 02"));

            borderPainel.add(gridPainel, BorderLayout.SOUTH);
            add(borderPainel);

            try {
                //leaf = ImageIO.read(getClass().getResource("/imagens/icon.png"));
            	leaf = ImageIO.read(new URL("https://i.stack.imgur.com/i5lmv.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            gridPainel.setOpaque(false);
            borderPainel.setOpaque(false);
            setOpaque(false);

        }

        @Override
        public Dimension getPreferredSize() {
            return leaf == null ? new Dimension(200, 200) : new Dimension(leaf.getWidth(), leaf.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (leaf != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(leaf, 0, 0, this);
                g2d.dispose();
            }
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
       SwingUtilities.invokeLater(() ->  new PainelTransparenteTest());
    }
}
