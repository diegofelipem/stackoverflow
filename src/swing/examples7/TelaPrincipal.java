package swing.examples7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class TelaPrincipal extends JFrame {

    public static void main(String[] args) {
        Runnable startApp = () -> {
            TelaPrincipal fc = new TelaPrincipal();
            fc.setVisible(true);
        };

        SwingUtilities.invokeLater(startApp);
    }

    private JTabbedPane jTabbedPane = new JTabbedPane();
    private JButton button = new JButton("Click");
    private JDesktopPane jdp = new JDesktopPane();

    public TelaPrincipal() {
        add(montaTela());
        setSize(700, 400);
        action();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel montaTela() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        jTabbedPane.add("Aba 01", new JLabel("→ Aba 01"));
        jTabbedPane.add("Aba 02", new JLabel("→ Aba 02"));
        jTabbedPane.setPreferredSize(new Dimension(500, 150));

        painel.add(jTabbedPane, BorderLayout.NORTH);
        painel.add(jdp, BorderLayout.CENTER);
        painel.add(button, BorderLayout.SOUTH);
        return painel;
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    private void action() {
        button.addActionListener(e -> {
            Tela tela = new Tela();
            jdp.add(tela);
            tela.setVisible(true);
        });
    }
    
    
    class Tela extends JInternalFrame {

        private JButton close = new JButton("Close");

        public Tela() {
            setTitle("Tela interna");
            add(montaTela());
            setSize(300, 100);
            actionClose();
            setVisible(true);
            setLocationRelativeTo(null);
        }

        private JPanel montaTela() {
            JPanel painel = new JPanel();
            painel.setLayout(new BorderLayout());
            painel.add(new JLabel("Apenas para demonstrar .."), BorderLayout.NORTH);
            painel.add(close, BorderLayout.CENTER);
            return painel;
        }

        private void actionClose() {
            close.addActionListener(e -> {
                dispose();
//                getjTabbedPane().getTabComponentAt(1).requestFocus();
                getjTabbedPane().setSelectedIndex(1);
            });
        }
    }
}
