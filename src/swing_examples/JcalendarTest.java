package swing_examples;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JcalendarTest extends JFrame  implements ActionListener
{
    private final JDateChooser data = new JDateChooser();   
    private final JButton botao01 = new JButton("Salvar");
    public JPanel jpBotoes = new JPanel();

    public JcalendarTest()
    {         
        setSize(500, 300);
        add(posicaoComponentes());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }

    public JComponent posicaoComponentes()
    {
        JPanel jp = new JPanel();         
        jp.add(data);     
        data.setPreferredSize(new Dimension(100, 20));
        getContentPane().add("North", data);
        getContentPane().add("South", jpBotoes);        
        jpBotoes.setLayout(new GridLayout(1, 1));      
        adicionaBotao(botao01);           
        return jp;        
    }

    private void adicionaBotao(JButton botao) 
    {
        jpBotoes.add(botao);
        botao.addActionListener(this);
    }

    public boolean vazio() 
    {        
        if(data.getDate() == null)
        {
            return true;
        }

        else
        {
            return false;
        }        
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {   
        if (ae.getSource() == botao01) 
        {      
            if( vazio() == true)
            {
                JOptionPane.showMessageDialog(null, "Inválido !");
            } 

            else
            {
                JOptionPane.showMessageDialog(null, "Salvo !");
            }                
        }
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        { 
        	JcalendarTest c = new JcalendarTest();
            c.setVisible(true);
        });
    }        
}