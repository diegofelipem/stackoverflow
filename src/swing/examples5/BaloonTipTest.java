package swing.examples5;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.java.balloontip.BalloonTip;

public class BaloonTipTest extends JFrame {

    private JTextField jTextField = new JTextField();

    public static void main(String[] args) {
        EventQueue.invokeLater(()
                -> {            
            BaloonTipTest tp = new BaloonTipTest();
            tp.setVisible(true);
        }
        );        
    }

    public BaloonTipTest() {

        BalloonTip ballon = new BalloonTip(jTextField, "teste");
        JPanel p = new JPanel();
        p.add(jTextField);
        add(p);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
