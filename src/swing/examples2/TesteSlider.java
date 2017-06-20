package swing.examples2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

//import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

public class TesteSlider extends JFrame {

	private float imc = 0;
	JTextField campo = new JTextField();
	MeuSlider slider = new MeuSlider(imc);

	public TesteSlider() {
		setSize(525, 300);
		add(monta());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JComponent monta() {
		JPanel jp = new JPanel();
		jp.add(campo);
		campo.setPreferredSize(new Dimension(100, 20));

		campo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
					@Override
					public boolean dispatchKeyEvent(KeyEvent e) {
						if (e.getID() == KeyEvent.KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_ENTER) {

							imc = Float.valueOf(campo.getText());
							slider.definePonteiro(imc);
						} else {

						}
						return false;
					}
				});
			}
		});
		jp.add(slider);
		slider.setPreferredSize(new Dimension(375, 60));
		return jp;
	}

	public static void main(String[] args) {

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
                break;
            }
        }

		TesteSlider teste = new TesteSlider();
		teste.setVisible(true);
	}
}

class MeuSlider extends JPanel {
	public static final Color[] COLORS = { /* Azul */new Color(28, 93, 181), /* Verde */ new Color(100, 199, 51),
			/* Amarelo */ new Color(216, 203, 53), /* Laranja */ new Color(234, 132, 57),
			/* Vermelho */ new Color(208, 53, 49) };
	public static final String[] NUMEROS = { "18.5", "25", "30", "35", "40" };
	private static final int COMPRIMENTO = 70;
	private static final int ALTURA = 17;
	private JSlider slider = new JSlider(0, 100, 0);

	public MeuSlider(float resultadoIMC) {
		int majorSpacing = slider.getMaximum() / (COLORS.length - 1);
		Dictionary<Integer, JLabel> dictionary = new Hashtable<>();
		slider.setMajorTickSpacing(majorSpacing);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		for (int i = 0; i < COLORS.length; i++) {
			ImageIcon icon = createColorIcon(COLORS[i]);
			JLabel label = new JLabel(icon);
			// adicionar o valor corresponder a cor de mesmo indice
			label.setText(NUMEROS[i]);
			label.setForeground(Color.white);// altere a cor dos numeros como
												// quiser aqui
			label.setHorizontalTextPosition(JLabel.CENTER);// centraliza o texto
			int key = i * majorSpacing;
			dictionary.put(key, label);
		}
		slider.setLabelTable(dictionary);

		setLayout(new BorderLayout());
		add(slider, BorderLayout.CENTER);
		definePonteiro(resultadoIMC);
		System.out.println("Resultado IMC: " + resultadoIMC);
	}

	private ImageIcon createColorIcon(Color color) {
		BufferedImage img = new BufferedImage(COMPRIMENTO, ALTURA, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(color);
		g.fillRect(0, 0, COMPRIMENTO, ALTURA);
		g.dispose();
		return new ImageIcon(img);
	}

	public void definePonteiro(float valor) {
		System.out.println("variavel valor: " + valor);
		// variavel que armazenará a posicao do knob
		int sliderPos = 0;

		if (valor <= 18.5) {
			sliderPos = 0;
		}

		else if (valor <= 25) {
			sliderPos = 25;
		}

		else if (valor <= 30) {
			sliderPos = 30;
		}

		else if (valor <= 35) {
			sliderPos = 35;
		}

		else if (valor <= 40) {
			sliderPos = 100;
		}
		// 18.5", "25", "30", "35", "40"
		slider.setValue(sliderPos);
		System.out.println("Posição: " + sliderPos);
	}
}