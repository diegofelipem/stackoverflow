package swing.examples3;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class TecladoEvento extends javax.swing.JFrame {

	public TecladoEvento() {
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Jogo do Monstro");
		setPreferredSize(new java.awt.Dimension(550, 700));
		getContentPane().setLayout(null);

		addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
					JOptionPane.showMessageDialog(null, "esquerda");
				} else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
					JOptionPane.showMessageDialog(null, "direita");
				} else if (evt.getKeyCode() == KeyEvent.VK_UP) {
					JOptionPane.showMessageDialog(null, "cima");
				} else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
					JOptionPane.showMessageDialog(null, "baixo");
				}
			}
		});
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TecladoEvento().setVisible(true);
			}
		});

	}
}
