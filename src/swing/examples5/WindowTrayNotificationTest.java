package swing.examples5;

import java.awt.AWTException;   
import java.awt.Image;    
import java.awt.SystemTray;  
import java.awt.Toolkit;  
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class WindowTrayNotificationTest {

    WindowTrayNotificationTest() {
        initialize();
    }

    private void initialize() {
    	
        Image trayImage = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/res/icon.png"));
        TrayIcon tray = new TrayIcon(trayImage, "Tray Icon Example");
        SystemTray sysTray = SystemTray.getSystemTray();
        tray.setImageAutoSize(true);
        tray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "clicou");
                sysTray.remove(tray);
                System.exit(0);	
            }
        });
        
        tray.addMouseListener(new MouseAdapter() {
        	
        	@Override
        	public void mouseClicked(MouseEvent e) {
            	if (e.getClickCount() == 1){
                    JOptionPane.showMessageDialog(null, "clicou");
                    sysTray.remove(tray);
                    System.exit(0);	
            	}
        	}
		});
        try {
            sysTray.add(tray);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        tray.displayMessage("Atenção!", "Notificação funfou!", TrayIcon.MessageType.WARNING);
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(()->{
            new WindowTrayNotificationTest();
    	});
    }
}