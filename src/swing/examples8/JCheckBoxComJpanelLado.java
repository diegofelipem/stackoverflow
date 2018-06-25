package swing.examples8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class JCheckBoxComJpanelLado extends JFrame {

	private JDesktopPane desktopPane = new JDesktopPane();
	private Info infoPanel =  new Info();

	public JCheckBoxComJpanelLado() {
		
		setTitle("Teste");
		setPreferredSize(new Dimension(700, 450));

		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel auxPanel = new JPanel(new BorderLayout());
		auxPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30));
		auxPanel.setBackground(desktopPane.getBackground());
		
		JCheckBox checkBox = new JCheckBox("Click");
		
		checkBox.addItemListener(e -> infoPanel.setVisible(e.getStateChange() == ItemEvent.SELECTED));
		
		auxPanel.add(checkBox, BorderLayout.WEST);
		auxPanel.add(infoPanel, BorderLayout.CENTER);
		
		getContentPane().add(auxPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JCheckBoxComJpanelLado());
	}
}

class Info extends JPanel {

	public Info() {

		add(new JLabel("Informações ... "));
		setVisible(false);
	}
}
