package swing.examples4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CustomToolTipTest {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			new CustomToolTipTest().createAndShowGUI();
			
		});
	}
	
	public void createAndShowGUI(){
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(500, 500));

		JPanel glassPane = new JPanel();
		glassPane.setOpaque(false);
		glassPane.setLayout(null);

		frame.setGlassPane(glassPane);
		frame.getGlassPane().setVisible(true);

		final MyInfoBubble mib = new MyInfoBubble();
		mib.setBounds(10, 30, 100, 50);
		((JPanel) frame.getGlassPane()).add(mib);

		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseMoved(MouseEvent me) {
				mib.setBounds(me.getPoint().x, me.getPoint().y, 100, 50);
			}
		});

		((JPanel) frame.getGlassPane()).validate();
		((JPanel) frame.getGlassPane()).repaint();

		frame.setVisible(true);
	}

	class MyInfoBubble extends JPanel {
		
		public MyInfoBubble() {
			setVisible(true);
			setBackground(new Color(200, 200, 200, 100));
		}

//		public void paintComponent(Graphics g) {
//			Graphics2D g2d = (Graphics2D) g;
//			g2d.setColor(Color.BLUE);
//			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//			g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
//		}

	}

}
