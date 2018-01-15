package swing.examples7.teste;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TelaPainel extends JFrame {

	private JPanel contentPane;
	private JButton btVerResultado;
	private JButton btFecharResultado;
	private JButton btSalvarRespostas;
	private ButtonGroup grupo;
	private JRadioButton radioDois;
	private JRadioButton radioUm;

	public TelaPainel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		btVerResultado = new JButton("ver resultado");
		btVerResultado.setBounds(236, 156, 121, 23);
		contentPane.add(btVerResultado);

		btFecharResultado = new JButton("fechar resultado");
		btFecharResultado.setBounds(236, 156, 121, 23);
		btFecharResultado.setVisible(false);
		contentPane.add(btFecharResultado);

		btSalvarRespostas = new JButton("Salvar respostas");
		btSalvarRespostas.setBounds(22, 156, 131, 23);
		contentPane.add(btSalvarRespostas);

		JLabel lblQueAnimal = new JLabel("Que animal \u00E9 esse?");
		lblQueAnimal.setBounds(22, 45, 113, 14);
		contentPane.add(lblQueAnimal);

		radioUm = new JRadioButton("Cachorro");
		radioUm.setBounds(26, 75, 109, 23);
		contentPane.add(radioUm);

		radioDois = new JRadioButton("Gato");
		radioDois.setBounds(26, 113, 109, 23);
		contentPane.add(radioDois);

		grupo = new ButtonGroup();
		grupo.add(radioUm);
		grupo.add(radioDois);
		setVisible(true);
	}

	public JButton getBtVerResultado() {
		return btVerResultado;
	}

	public void setBtVerResultado(JButton brVerResultado) {
		this.btVerResultado = brVerResultado;
	}

	public JButton getBtFecharResultado() {
		return btFecharResultado;
	}

	public void setBtFecharResultado(JButton btFecharResultado) {
		this.btFecharResultado = btFecharResultado;
	}

	public JButton getBtSalvarRespostas() {
		return btSalvarRespostas;
	}

	public JRadioButton getRadioDois() {
		return radioDois;
	}

	public void setRadioDois(JRadioButton radioDois) {
		this.radioDois = radioDois;
	}

	public JRadioButton getRadioUm() {
		return radioUm;
	}

	public void setRadioUm(JRadioButton radioUm) {
		this.radioUm = radioUm;
	}

	public void setBtSalvarRespostas(JButton btSalvarRespostas) {
		this.btSalvarRespostas = btSalvarRespostas;
	}
}
