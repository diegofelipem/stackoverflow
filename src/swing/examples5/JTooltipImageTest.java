package swing.examples5;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTooltipImageTest extends JFrame {

    private JTextField jTextField = new JTextField();

    public JTooltipImageTest() {
        add(tela());
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent tela() {
        JPanel painel = new JPanel();
        painel.add(jTextField);
        jTextField.setPreferredSize(new Dimension(150, 20));
        jTextField.setToolTipText(personalizaToolTip("Teste: "));
        return painel;
    }

    private String personalizaToolTip(String text) {


       return "<html><body>" + text + "<img src='" + getClass().getResource("/res/icon.png") + "' /></body></html>";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->  new JTooltipImageTest());
    }
}