package swing.examples;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import swing.examples.exception_handler_test.DialogUnhandledException;

public class FrameComImageIcone {

    public void start() throws IOException {
        final JFrame frame = new JFrame();
        frame.setTitle("Frame Teste");
        frame.setSize(300, 200);

        URL path = getClass().getResource("/res/address_book.png");

        Image icone = ImageIO.read(path);
        frame.setIconImage(icone);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {   	

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new FrameComImageIcone().start();
                } catch (Exception ex) {
        			StringWriter strStackTrace = new StringWriter();
        			ex.printStackTrace(new PrintWriter(strStackTrace));
                    DialogUnhandledException.showException(ex.getClass() + " " + ex.getMessage(), strStackTrace.toString());
                }
            }
        });
    }
}
