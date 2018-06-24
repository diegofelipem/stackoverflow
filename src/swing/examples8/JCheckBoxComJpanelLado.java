package swing.examples8;

import javax.swing.*;
import java.awt.*;

public class JCheckBoxComJpanelLado extends JFrame {
	
    private JDesktopPane desktopPane = new JDesktopPane();

    public JCheckBoxComJpanelLado() {
        setTitle("Teste");
        setPreferredSize(new Dimension(700, 450));
        getContentPane().add(desktopPane);
        getContentPane().add("South", new Info(comp()));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private JComponent comp() {
        JPanel painel = new JPanel();
        painel.add(new JLabel("Informações ... "));
        painel.setVisible(false);
        painel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        return painel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new JCheckBoxComJpanelLado());
    }
}

class Info extends JPanel {
	
    private JCheckBox checkBox = new JCheckBox("Click");

    public Info(JComponent component) {
    	
    	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    	setPreferredSize(new Dimension(700, 30));
    	
    	setBorder(BorderFactory.createLineBorder(Color.red));
    	
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
            	component.setVisible(true);
            } else {
            	component.setVisible(false);
            }
        });

        add(checkBox);
        add(component);
    }
}

