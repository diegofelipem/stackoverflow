package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JScrollPaneTest extends JFrame {

    JScrollPane jsp = new JScrollPane();

    public JScrollPaneTest() {
        add(addComp());
        setPreferredSize(new Dimension(500, 500));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent addComp() {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Borda"));
        
        //neste painel é que adicionaremos os chekboxes
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0, 4));
        
        int controle = 30;

        for (int i = 0; i < controle; i++) {
            String nome = "Check " + i;
            JCheckBox box = new JCheckBox(nome);
            p.add(box);
        }
        //defini um tamanho preferido pro scrollpane
        jsp.setPreferredSize(new Dimension(340, 150));
        //defini o painel de checkboxes como viewport do scrollpane
        jsp.setViewportView(p);
        painel.add(jsp);
        return painel;
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            JScrollPaneTest a = new JScrollPaneTest();
    	});
    }
}
