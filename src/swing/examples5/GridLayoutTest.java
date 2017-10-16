package swing.examples5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridLayoutTest extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridLayoutTest().setVisible(true));
    }

    public GridLayoutTest() {
        add(painel());
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel painel() {
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(300, 200));
        painel.setLayout(new GridLayout(4, 1));

        JPanel painel01 = new JPanel();
        painel01.add(new JLabel("Painel 01"));
        painel01.setBorder(BorderFactory.createLineBorder(Color.black));
        painel01.setPreferredSize(new Dimension(150, 50));

        JPanel painel02 = new JPanel();
        painel02.add(new JLabel("Painel 02"));
        painel02.setBorder(BorderFactory.createLineBorder(Color.black));
        painel02.setPreferredSize(new Dimension(150, 50));

        JPanel painel03 = new JPanel();
        painel03.add(new JLabel("Painel 03"));
        painel03.setBorder(BorderFactory.createLineBorder(Color.black));
        painel03.setPreferredSize(new Dimension(150, 50));

        JPanel painel04 = new JPanel();
        painel04.add(new JLabel("Painel 04"));
        painel04.setBorder(BorderFactory.createLineBorder(Color.black));
        painel04.setPreferredSize(new Dimension(150, 50));

        painel.add(painel01);
        painel.add(painel02);
        painel.add(painel03);
        painel.add(painel04);
        return painel;
    }
}