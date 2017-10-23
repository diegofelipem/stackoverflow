package swing.examples5;

import java.awt.*;
import javax.swing.*;

public class PosicaoDeCompTest {

	public static void main(String args[]) {

		EventQueue.invokeLater(() -> {

			JFrame frame = new JFrame();
			JPanel panel = new JPanel(new GridBagLayout());

			GridBagConstraints gbc1 = new GridBagConstraints();
			gbc1.gridx = 0;
			gbc1.gridy = 0;
			JTextField texto = new JTextField();
			texto.setColumns(10);
			panel.add(texto, gbc1);

			JComboBox combo = new JComboBox();
			combo.setBackground(Color.WHITE);
			combo.addItem("opção1");
			combo.addItem("opção2");
			combo.addItem("opção3");
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridx = 0;
			gbc2.gridy = 1;
			panel.add(combo, gbc2);


			frame.setSize(500, 500);
			frame.getContentPane().add(panel);

			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}