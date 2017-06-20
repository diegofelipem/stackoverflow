package swing.examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class FrameSystemTrayTest {

    public void start() throws IOException {
        final JFrame frame = new JFrame();
        frame.setTitle("Frame principal");
        frame.setSize(300, 200);

        JTextField field = new JTextField(10);
        frame.setLayout(new FlowLayout());
        frame.add(field);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //checa se o sistema tem suporte a iconTray
        if (SystemTray.isSupported()) {
            //pega uma instancia da bandeija do sistema
            final SystemTray tray = SystemTray.getSystemTray();
            //apenas para demonstração, altere para a imagem da
            //sua aplicação
            Image icon = ImageIO.read(new URL("http://www.freeiconspng.com/uploads/tick-icon-2.png"));
            //frame.setIconImage(icon);
            //cria um icone de bandeira, recebendo uma imagem 
            final TrayIcon trayIcon = new TrayIcon(icon);
            //IMPORTANTE! Deixa a propria API
            //decidir o tamanho, se remover essa linha
            //não aceitará imagem de qualquer tamanho
            trayIcon.setImageAutoSize(true);
            trayIcon.displayMessage("Atenção!", "Clique aqui para abrir mais detalhes.", TrayIcon.MessageType.WARNING);
            trayIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("clicou");
                }
            });

//            trayIcon.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    if (e.getClickCount() == 1) {
//                        //a ação que você
//                        //quer que ocorra quando for clicado
//                        JOptionPane.showMessageDialog(null, "passou");
//                    }
//                }
//
//            });

            //adiciona uma ação ao frame, para monitorar alterações de status
            //da janela
            frame.addWindowStateListener(new WindowAdapter() {
                @Override
                public void windowStateChanged(WindowEvent e) {
                    //checa se a janela foi minimizada
                    if (e.getNewState() == JFrame.ICONIFIED) {
                        //listener para que a janela se abra com
                        //o clique do mouse
                        trayIcon.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                frame.setVisible(true);
                                frame.toFront();
                                //remove o icone da bandeira
                                //quando a janela for reaberta
                                tray.remove(trayIcon);
                            }
                        });
                        try {
                            tray.add(trayIcon);
                        } catch (AWTException ex) {
                            ex.printStackTrace();
                        }
                        frame.setVisible(false);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameSystemTrayTest f = new FrameSystemTrayTest();
                try {
                    f.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
