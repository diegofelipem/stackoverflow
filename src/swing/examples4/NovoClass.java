package swing.examples4;

import java.awt.Cursor;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NovoClass extends JFrame {

    private JPanel painel = new JPanel();

    public NovoClass() {
        setSize(200, 150);
//        ImageIcon image = new ImageIcon(getClass().getResource("/imagens/botãoExcluir.png"));
        JLabel imagelabel = new JLabel("TESTE");
        JCheckBox check = new JCheckBox("Enable/Disable");

        imagelabel.addMouseListener(getMouseListener());
        imagelabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        painel.add(imagelabel);
        imagelabel.setEnabled(false);
        add(painel);
        painel.add(check);

        check.addItemListener((ItemEvent e) -> {
            if (check.isSelected() == true) {
                imagelabel.setEnabled(true);
            } else {
                imagelabel.setEnabled(false);
                //retirar evento.
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public MouseListener getMouseListener() {

        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	JComponent comp = (JComponent) e.getSource();
            	
            	if(comp.isEnabled()){
                    JOptionPane.showMessageDialog(null, "Clicou aqui !");
            	}
            }
        };
    }

    public static void main(String[] args) {
        NovoClass novo = new NovoClass();
    }
}
