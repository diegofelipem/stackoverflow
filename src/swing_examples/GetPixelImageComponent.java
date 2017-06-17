package swing_examples;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.*;

public class GetPixelImageComponent {

	public void showAndCreateGUI() throws MalformedURLException, AWTException {

		JFrame frame;
		Robot robot;
		JLayeredPane layeredPane;
		MouseMotionListener ml;

		robot = new Robot();
		frame = new JFrame("Pc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(300, 310));
		layeredPane.setBorder(BorderFactory.createTitledBorder("capture color under the label"));
		


		/** ESTAS DUAS LINHAS SÃO APENAS PARA DEMONSTRAÇÃO **/
		URL url = new URL("http://wimages.vr-zone.net/2013/06/10-15-2012-2-22-52-PM-300x300.png");
		CustomLabel label = new CustomLabel(new ImageIcon(url));
		
		//CustomLabel label = new JLabel(new ImageIcon("folder/matiz.jpg"));		
		label.setBounds(15, 15, 300, 300);
		label.setOpaque(true);
		label.setBackground(Color.black);

		JLabel label1 = new JLabel();
		label1.setBounds(60, 60, 300, 300);
		label1.setOpaque(true);
		label1.setBackground(new Color(255, 255, 255));

		layeredPane.add(label, 0, 0);
		layeredPane.add(label1, 1, 0);

		frame.setSize(660, 400);

		frame.getContentPane().setBackground(Color.red);
		frame.setGlassPane(layeredPane);
		layeredPane.setVisible(true);
		frame.setVisible(true);

	}

	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(() -> {
			try {
				new GetPixelImageComponent().showAndCreateGUI();
			} catch (MalformedURLException | AWTException e) {
				e.printStackTrace();
			}
		});
	}

	class CustomLabel extends JLabel implements MouseMotionListener {

		private ImageIcon image;

		public CustomLabel(ImageIcon image) {
			this.image = image;
			setIcon(image);
			this.addMouseMotionListener(this);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseMoved(MouseEvent e) {

			int x = (int) e.getX();
			int y = (int) e.getY();

			BufferedImage bufImage = new BufferedImage(image.getIconWidth(), image.getIconHeight(),
					BufferedImage.TYPE_INT_RGB);
			
			Graphics g = bufImage.createGraphics();
			
			g.drawImage(image.getImage(), 0, 0, null);

			if(x < image.getIconWidth() && y < image.getIconHeight()){
				int rgb = bufImage.getRGB(x, y);
				System.out.println(new Color(rgb));
			}

		}
	}
}
