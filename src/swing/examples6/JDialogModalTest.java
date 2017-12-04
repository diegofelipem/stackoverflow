package swing.examples6;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.*;
import javax.swing.*;

public class JDialogModalTest extends JFrame {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> new JDialogModalTest().start());
	}

	private JFrame getInstance() {
		return this;
	}

	// start frames
	private void start() {
		setTitle("Frame principal");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnFrame = new JButton("Abrir Dialog");
		btnFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// passando a instancia do Frame para referencia do modal
				new Dialog01(getInstance()).start();
			}
		});
		setLayout(new BorderLayout());
		add(new JLabel("Este é o frame principal"), BorderLayout.CENTER);
		add(btnFrame, BorderLayout.PAGE_END);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}

class Dialog01 extends JDialog {

	// precisa passar a janela mae como parametro para servir
	// de referencia ao modal
	public Dialog01(JFrame owner) {
		// recebe a janela mae, o titulo(opcional) e se é modal
		super(owner, "Dialog 01", true);
	}

	private JDialog getInstance() {
		return this;
	}

	public void start() {
		JButton btn2 = new JButton("Abrir outro dialog");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// aqui está sendo passada a instancia do Dialog01
				// como referencia do modal da dialog02
				new Dialog02(getInstance()).start();
			}
		});
		setLayout(new BorderLayout());
		add(new JLabel("Esta é a primeira janela modal"), BorderLayout.CENTER);
		add(btn2, BorderLayout.PAGE_END);
		setSize(200, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(getParent());
		setVisible(true);
	}

}

class Dialog02 extends JDialog {

	// repare que o Jdialog pode receber um JFrame ou
	// outro JDialog como argumento
	public Dialog02(Dialog owner) {
		// recebe a janela mae, o titulo e se é modal
		super(owner, "Dialog 02", true);
	}

	public void start() {

		add(new JLabel("Esta é a segunda janela modal"));
		setSize(200, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(getParent());
		setVisible(true);
	}
}