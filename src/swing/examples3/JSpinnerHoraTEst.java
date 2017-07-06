package swing.examples3;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
 
public class JSpinnerHoraTEst extends JFrame {
 
    public static void main(String[] args) {
 
        SwingUtilities.invokeLater(() -> {
            JSpinnerHoraTEst t = new JSpinnerHoraTEst();
            t.setVisible(true);
        });
    }
    HoraSpinner campoHora = new HoraSpinner();
    JButton pegar = new JButton("Pegar");
 
    public JSpinnerHoraTEst() {
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        JPanel painel = new JPanel();
        painel.add(campoHora);
        campoHora.setPreferredSize(new Dimension(80, 22));
 
        painel.add(pegar);
        pegar.setPreferredSize(new Dimension(75, 22));
        acao();
 
        add(painel);
    }
 
    private void acao() {
        pegar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                campoHora.getValor();
                System.out.println(" " + campoHora.getValor());
            }
        });
    }
}
 
class HoraSpinner extends JPanel {
 
    JSpinner spinner = new JSpinner();
 
    public HoraSpinner() {
        spinner.setModel(new SpinnerDateModel());
        spinner.setEditor(new JSpinner.DateEditor(spinner, "HH:mm:ss"));
        add(spinner);
    }
 
    public Object getValor() {
        try {
            SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");
            return new java.sql.Timestamp(((Date)spinner.getModel().getValue()).getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter a Hora!");
            e.printStackTrace();
            return null;
        }
    }
}