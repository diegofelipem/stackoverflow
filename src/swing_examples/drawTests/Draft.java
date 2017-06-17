package swing_examples.drawTests;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Draft extends JPanel {

	//usaremos para armazenar e desenhar novas imagens
	private BufferedImage bfImage;
	//usaremos para desenhar as linhas conforme movimentacao
	//do mouse na tela
	private Point oldPoint = null;
	private Point newPoint = null;
	
	private static final long serialVersionUID = 4886600019364448097L;

	public Draft() {

		//crio uma instancia de bufferedimage do mesmo tamanho do painel
		bfImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_ARGB);
		
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				//armazenamos o novo ponto arrastado
				//atualizamos a imagem na tela
				//invertemos os pontos, pois após tela desenhada
				//o ponto atual passa a ser antigo
				newPoint = e.getPoint();
				updateImage();
				oldPoint = newPoint;
			}

		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//ao liberar o mouse, armazenamos o ponto atual para finalizar
				//o desenho da atual linha e "limpamos" as duas referencias de pontos					
				newPoint = e.getPoint();
				updateImage();
				newPoint = null;
				oldPoint = null;
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//ao pressionar o mouse, verificamos se o ponto antigo existe
				//pois ele é o ponto de partida para desenhar o primeiro segmento
				//da nova linha
				if (oldPoint == null) {
					oldPoint = e.getPoint();
				}
			}

		});
	}
	
	//sobrescrevi o método getSize para que o tamanho do painel possa
	//ser informado corretamente ao bufferedImage
	@Override
	public Dimension getSize() {
		return new Dimension(500, 350);
	}

	private void updateImage() {
		//se o ponto atual não for nulo, criamos um grafico no buffer e desenhamos o
		//segmento da linha atual, forçando o redesenho da tela com repaint()
		if (newPoint != null) {

			Graphics2D g2 = bfImage.createGraphics();
			g2.setColor(Color.BLACK);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
			g2.dispose();
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//apenas passamos o buffer para o paintcomponent desenhar
		//o que está nele.
		g.drawImage(bfImage, 0, 0, null);
	}
}