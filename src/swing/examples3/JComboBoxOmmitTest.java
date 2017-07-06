package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class JComboBoxOmmitTest extends JFrame {

    JComboBox combo = new JComboBox();

    public JComboBoxOmmitTest() {
        setTitle("Apenas um EXEMPLO");
        JPanel painelSuperior = new JPanel();
        painelSuperior.setBorder(BorderFactory.createTitledBorder(""));
        painelSuperior.add(combo);

        //preencher(new boolean[]{true, false, false});// parametros que deviar deixar ou n�o exibir
        preencher();
        add(painelSuperior, BorderLayout.NORTH);
        setResizable(false);
        setSize(400, 250);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void preencher() {
        combo.addItem("Op��o 01");
        combo.addItem("Op��o 02");
        combo.addItem("Op��o 03");

    }

    public static void main(String[] args) {
        JComboBoxOmmitTest tela = new JComboBoxOmmitTest();
    }
}