package swing.examples9;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdTest extends JFrame {
    private JTextField diretorio = new JTextField();
    private JTextArea log = new JTextArea();
    private JButton jButton = new JButton("Executar");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new CmdTest();
        });
    }

    public CmdTest() {
        setTitle("Teste CMD");
        add(painel());
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        diretorio.setText("c:\\temp");
    }

    private JPanel painel() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.add(diretorio, BorderLayout.NORTH);
        painel.add(log, BorderLayout.CENTER);
        painel.add(jButton, BorderLayout.SOUTH);
        diretorio.setPreferredSize(new Dimension(400, 20));
        log.setPreferredSize(new Dimension(400, 90));
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        action();
        return painel;
    }

    private void action() {
        jButton.addActionListener(e -> {
            performBackup();
        });
    }

    private void performBackup() {
    	
        String[] cmds = {
                "cd " + diretorio.getText(),
                "dir"
            };
    	
    	
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", String.join("& ", cmds));
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
            System.out.println(line);
            log.append(line.replaceAll("\n", "\r\n"));
        }
    }
}