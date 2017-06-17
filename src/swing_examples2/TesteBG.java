package swing_examples2;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TesteBG extends JFrame {

	public TesteBG() {

		JLabel titulo1 = new JLabel("Testes de local1");

		JLabel titulo2 = new JLabel("Testes de local2");
		//
		BackgroundPanel bgPanel = new BackgroundPanel();
		//
		bgPanel.setLayout(new BorderLayout());

		bgPanel.add(titulo1, BorderLayout.NORTH);

		bgPanel.add(titulo2, BorderLayout.SOUTH);

		setContentPane(bgPanel);

		setSize(400, 400);

		setTitle("Teste");

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class BackgroundPanel extends JPanel {

		Image imagem;

		public BackgroundPanel() {

			try {

				imagem = ImageIO.read(getClass().getResource("/fotos/1.png"));

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Não foi possivel ler a imagem !");

			}
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(imagem, 0, 0, this);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new TesteBG();
		});
	}
}
