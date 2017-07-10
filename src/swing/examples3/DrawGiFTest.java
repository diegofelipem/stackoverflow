package swing.examples3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawGiFTest extends JComponent {

	public void createAndShowGUI() {
		
		JFrame window = new JFrame();
		
		window.getContentPane().add(new GifPanel(loadImage("http://introcs.cs.princeton.edu/java/15inout/duke.gif")));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(200, 200));
		
		window.pack();
		window.setVisible(true);
	}
	
	//Este método recebe uma string com a url da imagem e
	//cria um ImageIcon e retorna um tipo Image, com o 
	//gif já carregador corretamente
	private BufferedImage loadImage(String url){
		
		ImageIcon icon;
		
		try {
			icon = new ImageIcon(new URL(url));
			Image img = icon.getImage();
	        return img;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	class GifPanel extends JComponent{
		
		Image image;
		
		public GifPanel(Image image) {
			this.image = image;
		}
		
		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.drawImage(image, 10, 10, this);
		}
		
	}


	public static void main(String[] a) {

		SwingUtilities.invokeLater(() -> {
			new DrawGiFTest().createAndShowGUI();
		});
	}
}
