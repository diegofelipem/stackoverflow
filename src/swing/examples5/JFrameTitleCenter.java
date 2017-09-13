package swing.examples5;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class JFrameTitleCenter {

	public void createAndShowGUI() {

		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300));
		frame.setTitle("Hello Center");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titleAlign(frame);
			}

		});
		
		JPanel p = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				

			    int height = getSize().height;
			    int width = frame.getSize().width - 14;

//			    // draw vertical rule at left side (bottom to top)
//			    for (int y=height; y > 0; y--) {
//			        int pos = (y-height);
//
//			        if (pos % 50 == 0) {          // 20 pixel tick every 50 pixels
//			            g.drawLine(0, y, 20, y);
//			        }
//			        else if (pos % 10 == 0) {     // 10 pixel tick every 10 pixels
//			            g.drawLine(0, y, 10, y);
//			        }
//			        else if (pos % 2 == 0) {      // 5 pixel tick every 2 pixels
//			            g.drawLine(0, y, 5, y);
//			        }
//			    }
			    // draw horizontal rule at bottom (left to right)
			    
			    
			    for (int x=0; x < width; x++) {
//			        if (x % 50 == 0) {
//			            g.drawLine(x, 20, x, 0);
//			        }
//			        else if (x % 10 == 0) {
//			            g.drawLine(x, 10, x, 0);
//			        }
//			        else if (x % 2 == 0) {
//			            g.drawLine(x, 5, x, 0);
//			        }			        
			        if(x == width/2){
			        	g.drawLine(x, 100, x, 0);
			        }
			    }
			}
		};
		frame.setContentPane(p);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	private void titleAlign(JFrame frame) {

		Font font = frame.getFont();
		
		String currentTitle = frame.getTitle().trim();
		FontMetrics fm = frame.getFontMetrics(font);
		int frameWidth = frame.getWidth();
		int titleWidth = fm.stringWidth(currentTitle);
		int spaceWidth = fm.stringWidth(" ");
		int centerPos = (frameWidth / 2) - (titleWidth / 2);
		int spaceCount = centerPos / spaceWidth;
		String pad = "";
		// for (int i=0; i!=w; i++) pad +=" ";
		pad = String.format("%" + (spaceCount - 14) + "s", pad);
		frame.setTitle(pad + currentTitle);
		System.out.println("pad width: " + fm.stringWidth(pad));
		System.out.println("title width: " + fm.stringWidth(currentTitle));
		System.out.println("center pos: " + centerPos);
		System.out.println("frame width: " + frameWidth);
		System.out.println();

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			new JFrameTitleCenter().createAndShowGUI();
		});
	}
}