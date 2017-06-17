package questions;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Tela extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();

    public Tela() {
        setTitle("Apenas um EXEMPLO");
        tabbedPane.addTab("Página 1", painel1());
        tabbedPane.addTab("Página 2", painel2());
        tabbedPane.setPreferredSize(new Dimension(getWidth(), 300));
        
        /* -- exemplificacao de como adicionar o painel superior -- */
        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JButton("teste"));
        add(painelSuperior, BorderLayout.NORTH);
        
        add(tabbedPane, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Tela tela  = new Tela();
    }

    public JComponent painel1() {
        JPanel painel1 = new JPanel();       
        JLabel label1;     
        label1 = new JLabel("Página 1");
        painel1.add(label1);
        return painel1; // retorna painel.
    }

    public JComponent painel2() {
        JPanel painel2 = new JPanel();       
        JLabel label2;
        label2 = new JLabel("Página 2");
        painel2.add(label2);
        return painel2;
    }
}