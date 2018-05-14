package swing.examples8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TPrincipal extends JFrame {

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TPrincipal().setVisible(true);
			}
		});
	}

	private TPrincipal getInstance() {
		return this;
	}

	public TPrincipal() {
		setTitle("Frame principal");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnFrame = new JButton("Mudar Usuário");
		btnFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// passando a instancia do Frame para referencia do modal
				new TLogin(getInstance()).start();
			}

		});
		setLayout(new BorderLayout());
		add(new JLabel("Este é o frame principal"), BorderLayout.CENTER);
		add(btnFrame, BorderLayout.PAGE_END);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class TLogin extends JDialog {

		public TLogin(TPrincipal owner) {
			super(owner, "Dialog 02", true);
			
			addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowClosing(WindowEvent e) {
					System.out.println("fechou");
					System.exit(0);
				}
			});
		}

		public void start() {
			add(new JLabel("Esta é a segunda janela modal"));
			JButton btnFrame = new JButton("LOGIN REALIZADO - Fechar apenas modal");
			btnFrame.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
						
				}
			});
			setSize(300, 300);
			add(btnFrame, BorderLayout.PAGE_END);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(getParent());
			setVisible(true);
		}
	}
}
