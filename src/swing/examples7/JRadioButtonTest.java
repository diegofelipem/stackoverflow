package swing.examples7;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JRadioButtonTest {

    public JPanel painel = new JPanel();
    private JFrame formulario = new JFrame();
    
    
    public JRadioButtonTest() {
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setTitle("dd");
        formulario.setSize(500, 270);
        // Formulário no centro da tela.
        formulario.setLocationRelativeTo(null);
        // --[ DESLIGANDO O GERENCIADOR DE LAYOUT ]--\\
        painel.setLayout(null);
        formulario.add(painel);

        // Labels
        JLabel codigoInicial = new JLabel("Código inicial:");
        JLabel codigoFinal = new JLabel("Código final:");
        JLabel ignorarEntregues = new JLabel("Ignorar os já entregues:");

        // JTexts
        JTextField jL1 = new JTextField();
        JTextField jL2 = new JTextField();

        JRadioButton jbY = new JRadioButton("Sim", false);
        JRadioButton jbN = new JRadioButton("Não", true);
        
        // Adicionando os componentes
        adiciona(codigoInicial, 10, 10, 100, 25);
        adiciona(jL1, 190, 10, 190, 25);

        adiciona(codigoFinal, 10, 50, 100, 25);
        adiciona(jL2, 190, 50, 190, 25);

        adiciona(ignorarEntregues, 10, 90, 180, 25);

        adiciona(jbY, 190, 90, 80, 25);
        adiciona(jbN, 270, 90, 80, 25);

        formulario.setVisible(true);

	}

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new JRadioButtonTest() );
    }

    private void adiciona(Component componente, int nColuna, int nLinha, int nLargura, int nAltura) {
        painel.add(componente);
        componente.setBounds(nColuna, nLinha, nLargura, nAltura);
    }
}