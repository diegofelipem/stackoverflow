/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.examples;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author diego.felipe
 */
public class SystemTrayBalloonClick {

//    static Image image;
//
//    static TrayIcon trayIcon;
//
//    public static void main(String[] a) throws Exception {
//        
//        image = ImageIO.read(new URL("http://www.freeiconspng.com/uploads/tick-icon-2.png"));
//        trayIcon = new TrayIcon(image, "Tester2");
//        
//        if (SystemTray.isSupported()) {
//            SystemTray tray = SystemTray.getSystemTray();
//
//            trayIcon.setImageAutoSize(true);
//            trayIcon.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("In here");
//                    trayIcon.displayMessage("Tester!", "Some action performed", TrayIcon.MessageType.WARNING);
//                }
//            });
//
//            try {
//                tray.add(trayIcon);
//            } catch (AWTException e) {
//                System.err.println("TrayIcon could not be added.");
//            }
//        }
//    }
    private void initialize() throws IOException {
        Image trayImage = ImageIO.read(new URL("http://www.freeiconspng.com/uploads/tick-icon-2.png"));
        TrayIcon tray = new TrayIcon(trayImage, "Tray Icon Example");
        SystemTray sysTray = SystemTray.getSystemTray();
        tray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "clicou");
            }
        });
        try {
            sysTray.add(tray);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        tray.displayMessage("Atenção!", "Clique aqui para abrir mais detalhes.", TrayIcon.MessageType.WARNING);
    }

    public static void main(String[] args) throws IOException {
        new SystemTrayBalloonClick().initialize();
    }
}
