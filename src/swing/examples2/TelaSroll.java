package swing.examples2;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TelaSroll extends JFrame {

    private final JTextField vazio = new JTextField();
    private JButton bt = new JButton("Exemplo");

    public static void main(String[] args) {
        TelaSroll tela = new TelaSroll();
    }

    public TelaSroll() {
        setSize(450, 345);
        add(telaPainel());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JComponent telaPainel() {
        JPanel painel = new JPanel();// Painel principal, nele eu adiciono outros paines que organizam a tela

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        //p.setPreferredSize(new Dimension(200, 200));
        p.add(vazio);
        vazio.setPreferredSize(new Dimension(100, 50));

        JScrollPane srcPainel = new JScrollPane(p);
        srcPainel.setPreferredSize(new Dimension(200, 200));
        painel.add(srcPainel);
        p.add(bt);
        for(int i = 1; i <= 10; i++){
        	p.add(new JButton("botao-teste " + i));
        }
        return painel;
    }
}