package swing.examples6;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class ColorirRegioesGraficas {

	String cor; // É determinada ao clicar em um dos jButtons coloridos
	String tipo; // É determinado ao clicar em um dos jButtons com ferramentas
	private Container pnlPixels;
	private Map<String, Color> colorMap;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(ColorirRegioesGraficas::new);
	}

	public ColorirRegioesGraficas() {
		JButton[] button = new JButton[100];

		for (int i = 0; i < 100; i++) {
			button[i] = new JButton();
			pnlPixels.add(button[i]);
			button[i].addActionListener(new AcaoBotaoColoridoListener());
		}

	}

	class AcaoBotaoColoridoListener implements ActionListener {

		private Map<String, Color> colorMap;

		public AcaoBotaoColoridoListener() {

			colorMap = new HashMap<>();
			colorMap.put("cinza", new Color(101, 101, 101));
			colorMap.put("branco", new Color(255, 255, 255));
			colorMap.put("preto", new Color(0, 0, 0));
			colorMap.put("azulE", new Color(0, 0, 255));
			colorMap.put("vermelho", new Color(255, 0, 0));
			colorMap.put("verde", new Color(0, 204, 0));
			colorMap.put("amarelho", new Color(255, 255, 0));
			colorMap.put("laranja", new Color(255, 204, 0));
			colorMap.put("rosa", new Color(255, 153, 153));
			colorMap.put("azulC", new Color(0, 204, 204));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if ("lapis".equals(tipo) && colorMap.containsKey(cor)) {
				button.setBackground(colorMap.get(cor));
			}
		}
	}
}
