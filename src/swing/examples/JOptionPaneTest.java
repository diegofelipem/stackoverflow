/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.examples;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author diego.felipe
 */
public class JOptionPaneTest {

    public static void main(String[] args) {
//        JTextField txfName = new JTextField();
//        // By passing a list of option strings (and a default of null), the focus goes in your custom component
//        String[] options = {"OK", "Cancel"};
//        int result = JOptionPane.showOptionDialog(null, txfName, "Enter a name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Digite a senha para iniciar o auxilio:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = {"OK", "Cancelar maestro"};
        int option = JOptionPane.showOptionDialog(null, panel, "Inicio de auxilio",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.NO_OPTION,
                null, options, null);
        if (option == 0) {
            
        }
    }
}
