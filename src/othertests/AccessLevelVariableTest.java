package othertests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class AccessLevelVariableTest {

    private String oneVariable = "oneVariable";


    public void myMethod() {

        String localVariable = "localVariable";

        JButton btn = new JButton();

        btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt){

                oneVariable = localVariable; //isso é permitido
                System.out.println(localVariable); //isso é permitido
                //localVariable = oneVariable; // isso ocorre erro de sinxate

            }
        });
    }
}