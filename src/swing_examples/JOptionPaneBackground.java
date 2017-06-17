package swing_examples;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JOptionPaneBackground {
	public static void main(String[] args) throws Exception {

		BufferedImage image = ImageIO.read(JOptionPaneBackground.class.getResource("background.jpg"));

		JOptionBackgroundPane pane = new JOptionBackgroundPane(image, "Teste");
		pane.setVisible(true);
	}
}

class JOptionBackgroundPane extends JDialog {

	BufferedImage imgBackground;
	JLabel label;

	public JOptionBackgroundPane(BufferedImage imgBackgound, String message) {
		this.imgBackground = imgBackgound;
		makeUI(message);
	}

	private void makeUI(String message) {

		JPanel backgroundPane = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {

				super.paintComponents(g);
				//desenha a imagem no componente como fundo
				g.drawImage(imgBackground, 0, 0, this);
			}
		};

		label = new JLabel(message);
		
		//mude para cor de primeiro plano que quiser
		label.setForeground(Color.BLACK);
		//mude para o formato de fonte que quiser
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		label.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton btn = new JButton("OK");

		btn.setAlignmentX(Component.CENTER_ALIGNMENT);

		btn.addActionListener(e -> {
			dispose();
		});

		backgroundPane.setLayout(new BoxLayout(backgroundPane, BoxLayout.Y_AXIS));
		//workaround para evitar que o label fique colado no topo
		backgroundPane.add(Box.createRigidArea(new Dimension(0, Math.round(getPreferredSize().height*0.1f))));
		backgroundPane.add(label);
		backgroundPane.add(Box.createVerticalGlue());
		backgroundPane.add(btn);
		//workaround para evitar que o label fique colado na parte de baixo
		backgroundPane.add(Box.createRigidArea(new Dimension(0, Math.round(getPreferredSize().height*0.1f))));

		setModal(true);
		setResizable(false);
		setContentPane(backgroundPane);
		pack();
		setLocationRelativeTo(null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		//força o container a ter sempre o mesmo tamanho da imagem
		return new Dimension(imgBackground.getWidth(), imgBackground.getHeight());
	}
}
