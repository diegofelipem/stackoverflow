package swing.examples;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ExemploTela extends JFrame {
	
	JComponent comp;

    public ExemploTela() {
        add(monta());
        comp = montaAba();
        comp.setVisible(false);
        add(comp, BorderLayout.SOUTH);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JComponent monta() {
        JPanel painel = new JPanel();
        painel.setLayout(null);
        JTextField text = new JTextField();
        JLabel label = new JLabel();
        JCheckBox check = new JCheckBox("Exibe/Oculta");
        painel.add(label);
        label.setBounds(95, 90, 100, 25);
        label.setText("Exemplo:");
        painel.add(text);
        text.setBounds(155, 90, 200, 25);
        painel.add(check);
        check.setBounds(155, 150, 200, 25);
        painel.setBounds(1, 1, 500, 300);

        check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                    comp.setVisible(check.isSelected());
            }
        });
        return painel;
    }

    public JComponent montaAba() {
        JPanel aba = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        JLabel label = new JLabel("Testando aba");
        tabbedPane.setPreferredSize(new Dimension(300, 100));
        tabbedPane.add(label);
        aba.add(tabbedPane);
        return aba;
    }

    public static void main(String[] args) {
    	EventQueue.invokeLater(() ->{
    		ExemploTela x = new ExemploTela();	
    	});
        
    }
}