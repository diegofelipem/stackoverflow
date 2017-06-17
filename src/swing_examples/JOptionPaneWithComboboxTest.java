/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_examples;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author diego.felipe
 */
public class JOptionPaneWithComboboxTest {

    public static void main(String[] args) {

        JComboBox jcb = new JComboBox();

        for (int i = 0; i < 6; i++) {
            jcb.addItem("motivo 0" + (i + 1));
        }

        JOptionPane.showMessageDialog(null, jcb, "Selecione o motivo", JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(null, jcb.getSelectedItem(), "Opção selecionada", JOptionPane.INFORMATION_MESSAGE);
    }
    
    class Motivo{
    
        
    }
}
