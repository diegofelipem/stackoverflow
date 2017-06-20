package swing.examples2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JIFrameDemo extends JFrame {

	MBoxFrame mboxFrame;
	JDesktopPane dtp;

	public void createAndShowGUI() {
		setTitle("JIFrameDemo Main Window");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenSize.width -= 200;
		screenSize.height -= 200;
		setSize(screenSize);
		setLocation(20, 20);

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		JMenu fm = new JMenu("File");
		mb.add(fm);
		JMenuItem mi;
		fm.add(mi = new JMenuItem("Open"));
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mboxFrame == null ){
					mboxFrame = new MBoxFrame("Mail Reader", true, true, true, true);
				}
				
				if(!mboxFrame.isVisible()){
					dtp.add(mboxFrame);
					mboxFrame.setVisible(true);
				}
				mboxFrame.toFront();
			}
		});

		dtp = new JDesktopPane();
		setContentPane(dtp);
		
		JInternalFrame iframe = new JInternalFrame();
		iframe.setSize(200, 150);
		dtp.add(iframe);
		iframe.setVisible(true);

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
	

	/* Main View */
	public static void main(String[] a) {
		EventQueue.invokeLater(() -> {
			new JIFrameDemo().createAndShowGUI();;
		});
	}

	class MBoxFrame extends JInternalFrame {

		public MBoxFrame(String arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4) {
			
			super(arg0, arg1, arg2, arg3, arg4);

			JLabel reader = new JLabel("Mail Reader Would Be Here");
			setContentPane(reader);
			setSize(400, 300);
			setLocation(50, 50);
			
		}
	}
}