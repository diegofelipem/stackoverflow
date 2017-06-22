package swing.examples3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;


public class InternalFrameDemo extends JFrame {

	JDesktopPane desktop;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			new InternalFrameDemo().createAndShowGUI();
		});
	}

	private void createAndShowGUI() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		desktop = new JDesktopPane();

		MyInternalFrame iframe = new MyInternalFrame();

		desktop.add(iframe);
		iframe.setVisible(true);

		setContentPane(desktop);
		setTitle("InternalFrameDemo");
		setSize(screenSize.width - 50, screenSize.height - 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class MyInternalFrame extends JInternalFrame {

	static final int xOffset = 30, yOffset = 30;

	public MyInternalFrame() {
		super("MyInternalFrame", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable

		setSize(300, 300);

		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Click to open other frame");

		btn.addActionListener(e -> {
			OtherInternalFrame otherFrame = new OtherInternalFrame();
			getParent().add(otherFrame);
			otherFrame.setVisible(true);
		});

		add(new Label("MyInternalFrame"));
		add(btn);
		System.out.println(getLayout());
		setLocation(xOffset, yOffset);
	}
}

class OtherInternalFrame extends JInternalFrame {

	static final int xOffset = 350, yOffset = 70;

	public OtherInternalFrame() {
		super("OtherInternalFrame", true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable

		setSize(300, 300);

		setLocation(xOffset, yOffset);
	}
}