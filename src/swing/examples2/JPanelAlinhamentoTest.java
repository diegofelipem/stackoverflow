package swing.examples2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanelAlinhamentoTest extends JFrame {

    private JButton btn;
    private JPanel painel;
    private JScrollPane scroll;
    private JTextArea tArea;

    public JPanelAlinhamentoTest() {

        btn = new JButton("Sair");
        btn.setPreferredSize(new Dimension(72, 35));
        btn.addActionListener(e -> System.exit(0));

        painel = new JPanel();
        FlowLayout layout = (FlowLayout) painel.getLayout();
        layout.setAlignment(FlowLayout.LEFT);
        ((FlowLayout)painel.getLayout()).setAlignment(FlowLayout.LEFT);
        painel.add(btn); //nao funciona

        JScrollPane scroll = new JScrollPane(tArea = new JTextArea());
        scroll.setPreferredSize(new Dimension(400, 300));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Container cp = getContentPane();
        cp.add(painel, "North");
        cp.add(scroll, "Center");

        //getRootPane().setDefaultButton(btn);

        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelAlinhamentoTest().setVisible(true);
    }

}