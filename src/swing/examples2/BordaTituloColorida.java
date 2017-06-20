package swing.examples2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import swing.examples.AlternateMaskFormattedTextField;

public class BordaTituloColorida extends JDialog {

    public BordaTituloColorida() {
        setTitle("Teste Dialog");
        add(criaBorda());
        setSize(500, 320);        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JComponent criaBorda() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridBagLayout());

        JPanel painelBorda = new JPanel();
        painelBorda.setLayout(new GridBagLayout());
        

        Border lineBorder = BorderFactory.createLineBorder(Color.green);
        TitledBorder title = BorderFactory.createTitledBorder(lineBorder, "Teste");
        painelBorda.setBorder(title);

        painelBorda.setPreferredSize(new Dimension(350, 70));         
        painelPrincipal.add(painelBorda);
        return painelPrincipal;
    }

    public static void main(String[] args) {
    	
        
        SwingUtilities.invokeLater(()->{
        	
        	BordaTituloColorida t = new BordaTituloColorida();
            t.setVisible(true);
        });
    }
}