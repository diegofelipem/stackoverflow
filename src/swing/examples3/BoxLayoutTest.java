package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class BoxLayoutTest extends JFrame
{
    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(() ->{
            BoxLayoutTest teste = new BoxLayoutTest();
            teste.setVisible(true);
    	});                
    }

    private PainelX painel = new PainelX();

    public BoxLayoutTest()
    {
    	setSize(600, 400);
        getContentPane().add(painel, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
}

class PainelX extends JPanel
{       
    public PainelX() 
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));        
        setBackground(Color.red);
        add(painel02());
        add(Box.createHorizontalStrut(50));
        add(painel03());
    }

    private JComponent painel02()
    {
        JPanel painel = new JPanel();
        JLabel teste = new JLabel("Painel 02");
        painel.add(teste);
        painel.setBorder(new LineBorder(Color.black));
        return painel;
    }

    private JComponent painel03()
    {
        JPanel painel = new JPanel();
        JLabel teste = new JLabel("Painel 03");
        painel.add(teste);
        painel.setBorder(new LineBorder(Color.black));
        return painel;
    }    
}