package swing.examples9;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class SpinnerTest extends JFrame {

JSpinner[] spinners = new JSpinner[10];
JButton[] botoes = new JButton[10];

JScrollPane scrollPane = new JScrollPane();
JPanel panel = new JPanel(new GridLayout(0, 2));

public SpinnerTest() throws HeadlessException {
    super("Produtos em Estoque");

    for (int i = 0; i < 10; i++) {
        JSpinner spinner = new JSpinner();
        JButton botao = new JButton();
        botao.setActionCommand(String.valueOf(i));
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
            	JButton btn =  (JButton) arg0.getSource();
                System.out.println(spinners[Integer.valueOf(btn.getActionCommand())].getValue());

            }
        });
        
        spinners[i] = spinner;
        botoes[i] = botao;

        panel.add(botao);
        panel.add(spinner);

    }

    add(panel);
    setVisible(true);
    setSize(1360, 720);


}




 public static void main(String[] args) {
            new SpinnerTest();
        }
    }
