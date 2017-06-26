package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RandomSquares {

	NovoPainel painel;
	JFrame frame;

	public static void main(String[] args) {
		//aplicações swing devem iniciar SEMPRE desta forma
		SwingUtilities.invokeLater(() -> {
			RandomSquares rs = new RandomSquares();
			rs.construirGUI();
		});

	}

	public void construirGUI() {

		frame = new JFrame("Squares");

		painel = new NovoPainel();

		JButton botao = new JButton("CRIAR");
		
		//sempre que clicado, vai chamar o método que
		//desenhará quadrados aleatórios no painel
		botao.addActionListener(e -> {
			painel.criarRetangulos();
		});
		
		frame.getContentPane().add(painel, BorderLayout.CENTER);
		frame.getContentPane().add(botao, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public class NovoPainel extends JPanel {

		BufferedImage image;

		public NovoPainel() {
			setLayout(null);
		}

		public void criarRetangulos() {
			
			//cria uma instancia de BufferedImage, se ela nao existir
			if(image == null)
				image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);			

			
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);

			int posicaoX = (int) (Math.random() * this.getWidth());
			int posicaoY = (int) (Math.random() * this.getHeight());
			int largura = (int) (Math.random() * this.getWidth() + 1);
			int altura = (int) (Math.random() * this.getHeight() + 1);	
			
			//cria graficos da imagem para que possamos "desenhar" nela
			Graphics2D g2 = image.createGraphics();
			g2.setColor(new Color(red, green, blue));
			g2.fillRect(posicaoX, posicaoY, largura, altura);
			//dispensa os graficos, uma vez que já concluimos o desenho
			g2.dispose();
			//redesenha a tela com um novo quadrado pintado
			repaint();
		}

		public void paintComponent(Graphics g) {
			//esta chamada SEMPRE deve ser invocada
			//antes de tudo ao reescrever o método paintComponent
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
		}

	}
}