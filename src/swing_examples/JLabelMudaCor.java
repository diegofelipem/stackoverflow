package swing_examples;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class JLabelMudaCor extends JFrame implements ActionListener
{


    public JPanel jpBotoes = new JPanel();
    JTextField tx1 = new JTextField();
    JTextField tx2 = new JTextField();
    
    JLabel label;

    private JButton botao01 = new JButton("Habilita");
    private JButton botao02 = new JButton("Desabilita");

    private String conteudo = "Teste de cor";

    public JLabelMudaCor()
    {
        setTitle("Tela de teste");
        setSize(400, 300);      
        add(posicaoComponentes());        
        habilitaComp(false);             
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }        

    public JComponent posicaoComponentes()
    {
        JPanel painel = new JPanel();
        painel.setLayout(null);
        label = new JLabel("Teste de cor");        
        painel.add(label);
        label.setBounds(170, 150, 32, 32);        
        painel.add(tx1);
        tx1.setBounds(130, 30, 150, 22);                            
        painel.add(tx2);       
        tx2.setBounds(130, 70, 150, 22);

        getContentPane().add("South", jpBotoes);        
        jpBotoes.setLayout(new GridLayout(1, 2));      
        adicionaBotao(botao01);
        adicionaBotao(botao02);

        return painel;        
    }

    private void adicionaBotao(JButton botao) 
    {
        jpBotoes.add(botao);
        botao.addActionListener(this);
    }

    public void habilitaComp(boolean status)
    {

        tx1.setEnabled(status);
        tx2.setEnabled(status);
        
        try {
			URL OnIcon = new URL("https://cdn4.iconfinder.com/data/icons/CornerStone/PNG/arrow-up.png");
	        URL OffIcon = new URL("http://www.kronoservice.com/it/img/down_arrow.png");
			label.setIcon(new ImageIcon(status ? OnIcon : OffIcon));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if (ae.getSource() == botao01) 
        {            
            habilitaComp(true);
        } 

        else if (ae.getSource() == botao02) 
        {
            habilitaComp(false);
        } 
    }

    public static void main(String[] args) 
    {
        JLabelMudaCor cor = new JLabelMudaCor();
        cor.setVisible(true);
    }     
}