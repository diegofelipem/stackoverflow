package swing.examples7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainTelas {

	public static void main(String[] args) {
		new ControleTelaInicialUm(new TelaInicialUm());
	}
}

class TelaInicialUm extends JFrame {

	private JPanel contentPane;
	private JButton btnOutraTela;

	public TelaInicialUm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnOutraTela = new JButton("outra tela");
		btnOutraTela.setBounds(135, 67, 148, 93);
		contentPane.add(btnOutraTela);
		setLocationRelativeTo(null);
	}

	public JButton getBtnOutraTela() {
		return btnOutraTela;
	}

}

class ControleTelaInicialUm implements ActionListener {

	private TelaInicialUm tiu;

	public ControleTelaInicialUm(TelaInicialUm tiu) {

		this.tiu = tiu;
		this.tiu.getBtnOutraTela().addActionListener(this);

		tiu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tiu.getBtnOutraTela()) {
			this.tiu.dispose();
			new ControleTelaDois(new TelaDois());
		}
	}
}

class ControleTelaDois {

	private TelaDois td;

	public ControleTelaDois(TelaDois td) {
		this.td = td;

		td.setVisible(true);
	}
}

class TelaDois extends JFrame {

	private JPanel contentPane;
	private JButton btnTelaTres;

	public TelaDois() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnTelaTres = new JButton("Tela tres");
		btnTelaTres.setBounds(200, 136, 89, 23);
		contentPane.add(btnTelaTres);
		setLocationRelativeTo(null);
	}

	public JButton getBtnTelaTres() {
		return btnTelaTres;
	}
}