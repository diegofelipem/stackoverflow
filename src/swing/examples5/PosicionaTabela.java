package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PosicionaTabela extends JFrame {
	
    private JScrollPane jsp = new JScrollPane();

    private JTable tabela = new JTable();

    private JButton botao1 = new JButton("1");
    private JButton botao2 = new JButton("2");
    private JButton botao3 = new JButton("3");

    public PosicionaTabela() {
    	
    	getContentPane().add(getButtonsPanel(), BorderLayout.NORTH);
    	getContentPane().add(getTabelaPanel(), BorderLayout.CENTER);
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private JScrollPane getTabelaPanel() {
        JPanel painel = new JPanel();
        jsp.setViewportView(tabela);
        jsp.setPreferredSize(new Dimension(400, 200));
        painel.add(jsp);
        return jsp;
    }
    
    private JPanel getButtonsPanel(){    	
        JPanel painel = new JPanel();
        painel.add(botao1);
        painel.add(botao2);
        painel.add(botao3);
        return painel;
    }

    public static void main(String[] args) {
        new PosicionaTabela().setVisible(true);
    }
}

