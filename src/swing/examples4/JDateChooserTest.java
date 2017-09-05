package swing.examples4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class JDateChooserTest extends JFrame {

    JDC data = new JDC();
    JPanel painel = new JPanel();

    public JDateChooserTest() {
        setSize(450, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        painel.add(data);
        data.setPreferredSize(new Dimension(120, 20));

        JTextField f = new JTextField();
        painel.add(f);
        f.setEditable(false);
        f.setPreferredSize(new Dimension(200, 20));

        JButton btSetar = new JButton("Clique");
        painel.add(btSetar);
        btSetar.setPreferredSize(new Dimension(70, 20));

        btSetar.addActionListener((ActionEvent e) -> {

            f.setText(data.getData());
        });
        add(painel);	
    }

    public static void main(String[] args) {
        JDateChooserTest bg = new JDateChooserTest();
        bg.setVisible(true);
    }
}

class JDC extends JDateChooser {

    public JDC() {

    }

    public void setData(Object valor) {
        setDate(((Date) valor));
    }

    public String getData() {
        Date dt = this.getDate();
        return dt != null ? new SimpleDateFormat("dd/MM/yyyy").format(dt) : ""; 
    }
}		
