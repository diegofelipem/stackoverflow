package swing_examples2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainCombo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private final String logradouros[] = { "<Selecione>", "Avenida", "Rua", "Estrada" };

	private JComboBox<String> cmb = new JComboBox<String>();
	private JTextField tf = new JTextField();
	JPanel painel = new JPanel();
	JPanel painelBotao = new JPanel();
	private final JButton incluir = new JButton("OK");
	private final JButton consultar = new JButton("CONSULTAR");
	private String salvaBD = "";
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();

	public MainCombo() {
		setTitle("Combo + Text");
		setSize(550, 150);
		setResizable(false);

		cmb = new JComboBox<String>(logradouros);
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(110, 25));
		painel.add(cmb);
		painel.add(tf);
		getContentPane().add("South", painelBotao);
		painelBotao.setLayout(new GridLayout(1, 2));
		adicionaBotao(incluir);
		adicionaBotao(consultar);
		painel.add(label);
		painel.add(label2);
		add(painel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void acao() {
		cmb.getSelectedItem();
		tf.getText();
		salvaBD = (cmb.getSelectedItem() + " " + tf.getText());
		label.setText(salvaBD);
		cmb.setSelectedIndex(0);
		tf.setText("");
	}

	public void consultar() {
		String retorno = JOptionPane.showInputDialog("Consulta");
		separa(retorno);
	}

	public void separa(String retorno) {

		if (retorno != null) {
			retorno = retorno.trim();
			String logTipo = retorno.split(" ")[0];
			for (String log : logradouros) {
				if (log.equalsIgnoreCase(logTipo)) {
					cmb.setSelectedItem(log);
					break;
				}
			}
			label2.setText(retorno.substring(retorno.indexOf(" "), retorno.length()));
			cmb.setEnabled(false);

		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == incluir) {
			acao();
		}

		if (ae.getSource() == consultar) {
			consultar();
		}
	}

	private void adicionaBotao(JButton botao) {
		painelBotao.add(botao);
		botao.addActionListener(this);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			MainCombo combo = new MainCombo();
			combo.setVisible(true);
		});
	}

	class textF extends JTextField {
		public void setValor(Object valor) {
			setText("" + valor);
		}
	}
}