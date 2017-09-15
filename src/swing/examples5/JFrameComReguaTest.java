package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

public class JFrameComReguaTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameComReguaTest frame = new JFrameComReguaTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameComReguaTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 70));
		
		this.contentPane = new JPanel(){
			
			@Override
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				

			    int height = getSize().height;
			    int width = getSize().width;

			    // draw vertical rule at left side (bottom to top)
			    for (int y=height; y > 0; y--) {
			        int pos = (y-height);

			        if (pos % 50 == 0) {          // 20 pixel tick every 50 pixels
			            g.drawLine(0, y, 20, y);
			        }
			        else if (pos % 10 == 0) {     // 10 pixel tick every 10 pixels
			            g.drawLine(0, y, 10, y);
			        }
			        else if (pos % 2 == 0) {      // 5 pixel tick every 2 pixels
			            g.drawLine(0, y, 5, y);
			        }
			    }

			    
			    //draw horizontal rule at bottom (left to right)
			    for (int x = 0; x < width; x++) {
			        if (x % 50 == 0) {
			            g.drawLine(x, height - 20, x, height);
			        }
			        else if (x % 10 == 0) {
			            g.drawLine(x, height - 10, x, height);
			        }
			        else if (x % 2 == 0) {
			            g.drawLine(x, height - 5, x, height);
			        }			        
			    }
			}
		};
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		pack();
		setLocationRelativeTo(null);
	}

}
