package swing.examples5;

import java.awt.*;
import javax.swing.*;

public class GridBagLayoutTesting extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		EventQueue.invokeLater(() -> new GridBagLayoutTesting().setVisible(true));
	}

	public GridBagLayoutTesting() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 200));
		((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		GridBagLayout gbl = new GridBagLayout();
		this.panel = new JPanel(gbl);
		getContentPane().add(this.panel, BorderLayout.CENTER);

		JButton lb01 = new JButton("Noroeste");
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.NORTHWEST;
		gbc1.weightx = 1.0;
		gbc1.weighty = 1.0;
		this.panel.add(lb01, gbc1);

		JButton lb02 = new JButton("Norte");
		GridBagConstraints gbc2 = (GridBagConstraints) gbc1.clone();
		gbc2.anchor = GridBagConstraints.NORTH;
		this.panel.add(lb02, gbc2);

		JButton lb03 = new JButton("Nordeste");
		GridBagConstraints gbc3 = (GridBagConstraints) gbc1.clone();
		gbc3.anchor = GridBagConstraints.NORTHEAST;
		gbc3.gridwidth = GridBagConstraints.REMAINDER;
		this.panel.add(lb03, gbc3);

		JButton lb04 = new JButton("Oeste");
		GridBagConstraints gbc4 = (GridBagConstraints) gbc1.clone();
		gbc4.anchor = GridBagConstraints.WEST;
		this.panel.add(lb04, gbc4);

		JButton lb05 = new JButton("Centro");
		GridBagConstraints gbc5 = (GridBagConstraints) gbc1.clone();
		gbc5.anchor = GridBagConstraints.CENTER;
		gbc5.fill = GridBagConstraints.BOTH;
		this.panel.add(lb05, gbc5);

		JButton lb06 = new JButton("Leste");
		GridBagConstraints gbc6 = (GridBagConstraints) gbc1.clone();
		gbc6.anchor = GridBagConstraints.EAST;
		gbc6.gridwidth = GridBagConstraints.REMAINDER;
		this.panel.add(lb06, gbc6);

		JButton lb07 = new JButton("Sudoeste");
		GridBagConstraints gbc7 = (GridBagConstraints) gbc1.clone();
		gbc7.anchor = GridBagConstraints.SOUTHWEST;
		this.panel.add(lb07, gbc7);

		JButton lb08 = new JButton("Sul");
		GridBagConstraints gbc8 = (GridBagConstraints) gbc1.clone();
		gbc8.anchor = GridBagConstraints.SOUTH;
		this.panel.add(lb08, gbc8);

		JButton lb09 = new JButton("Sudeste");
		GridBagConstraints gbc9 = (GridBagConstraints) gbc1.clone();
		gbc9.anchor = GridBagConstraints.SOUTHEAST;
		gbc9.gridwidth = GridBagConstraints.REMAINDER;
		this.panel.add(lb09, gbc9);

	}
}
