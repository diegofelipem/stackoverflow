package swing.examples4;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class StartCaretPosition extends JFrame {

    private final JTextField campo = new JTextField();
    private JButton botao = new JButton("Clique");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            StartCaretPosition tela = new StartCaretPosition();
            tela.setVisible(true);
        });

    }

    public StartCaretPosition() {
        add(colocaCampo());
        setSize(500, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent colocaCampo() {

        JPanel painel = new JPanel();
        JLabel label = new JLabel("TextField");

        campo.setPreferredSize(new Dimension(120, 22));
        campo.addFocusListener(new CaretPosition());
        painel.add(label);
        painel.add(campo);
        campo.setEditable(false);

        painel.add(botao);
        botao.addActionListener((ActionEvent e) -> {
            campo.setText("Texto longo, realmente grande esse texto !");
            campo.setCaretPosition(0);
        });
        botao.setPreferredSize(new Dimension(90, 22));
        return painel;
    }

    class CaretPosition extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {

            JTextComponent comp = (JTextComponent) e.getSource();
//            comp.setCaretPosition(0);
        }
    }
}