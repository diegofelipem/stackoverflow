package swing.examples4;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class JDateChooserBackgroundTest extends JFrame {

    JDateChooser data = new JDateChooser();
    JPanel painel = new JPanel();

    public JDateChooserBackgroundTest() {
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField lb = new JTextField("teste");
        
        painel.add(lb);
        
        painel.add(data);
        
        JTextFieldDateEditor dateChooserEditor = ((JTextFieldDateEditor)data.getDateEditor());


        dateChooserEditor.addFocusListener(new FocusListener() {
        	
        	Color defaultBG = dateChooserEditor.getBackground();
        	
            @Override
            public void focusGained(FocusEvent e) {

            	dateChooserEditor.setBackground(Color.CYAN);
            }

            @Override
            public void focusLost(FocusEvent e) {
            	
            	dateChooserEditor.setBackground(defaultBG);
            }
        });

        add(painel);
    }

    public static void main(String[] args) {
        JDateChooserBackgroundTest bg = new JDateChooserBackgroundTest();
        bg.setVisible(true);
    }
}