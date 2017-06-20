package swing.examples;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FrameComImageIcone {

    public void start() throws IOException {
        final JFrame frame = new JFrame();
        frame.setTitle("Frame Teste");
        frame.setSize(300, 200);

        URL path = getClass().getResource("address_book.png");

        Image icone = ImageIO.read(path);
        frame.setIconImage(icone);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrameComImageIcone().start();
                } catch (IOException ex) {
                    Logger.getLogger(FrameComImageIcone.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
