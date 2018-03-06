package swing.examples7;

import java.awt.FlowLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JButtonAlinhaTextIconTest {

	public void genericMethod() {

		JFrame frame = new JFrame("JFrame Example");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		
		button1.setText("button1");
		button2.setText("button2");
		
		try {
			button1.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/res/arrow-right-black.png"))));
			button2.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/res/arrow-right-black.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//button.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);          
		//button.setHorizontalAlignment(SwingConstants.RIGHT);                
		button1.setHorizontalTextPosition(SwingConstants.LEFT);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		frame.setSize(300, 300);

		frame.setVisible(true);
	}

	public static void main(String s[]) {

		SwingUtilities.invokeLater(() -> new JButtonAlinhaTextIconTest().genericMethod());
	}
}
