package swing.examples4;

import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pesquisa extends JFrame {

    JTextField pesquisa = new JTextField();
    JLabel resultado = new JLabel();

    public Pesquisa() {
        setTitle("Teste !");
        add(tela());
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent tela() {
        JPanel painel = new JPanel();
        painel.add(pesquisa);
        painel.add(resultado);
        pesquisa.setPreferredSize(new Dimension(80, 22));
        
        pesquisa.addKeyListener(new KeyAdapter() {
        	
        	@Override
        	public void keyReleased(KeyEvent e) {
        		
        		if(e.getKeyCode() == KeyEvent.VK_ENTER){
        			 String conteudo = pesquisa.getText();
                     if (!(conteudo.isEmpty())) {
                         resultado.setText("Resultado: " + conteudo);
                     } else {
                         JOptionPane.showMessageDialog(null, "Digite um número !");
                     }
        		} else {
        			
        		}
        	}
        	
		});
        
//        pesquisa.addActionListener((ActionEvent e)
//                -> {
//            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e1)
//                    -> {
//                if (e1.getID() == KeyEvent.KEY_RELEASED && e1.getKeyCode() == KeyEvent.VK_ENTER) {
//                    String conteudo = pesquisa.getText();
//                    if (!(conteudo.isEmpty())) {
//                        resultado.setText("Resultado: " + conteudo);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Digite um número !");
//                    }
//                } else {
//
//                }
//                return false;
//            });
//        });

        return painel;
    }

    public static void main(String[] args) {
        Pesquisa teste = new Pesquisa();
        teste.setVisible(true);
    }
}