package swing.examples7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValidarCamposComLabelTest extends JFrame {

	private List<MeuJTextField> fields = new ArrayList<>();
	private List<JLabel> labels = new ArrayList<>();
	private JButton jButton = new JButton("Validar");

	private Font fonte = new Font("Arial", Font.PLAIN, 10);

	public static void main(String[] args) {
		EventQueue.invokeLater(ValidarCamposComLabelTest::new);
	}

	public ValidarCamposComLabelTest() {

		JPanel painelPrincipal = new JPanel();

		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());

		fields.add(new MeuJTextField(true, "Campo 01"));
		fields.add(new MeuJTextField(true, "Campo 02"));
		fields.add(new MeuJTextField(true, "Campo 03"));

		int linhaAtual = 1;

		for (int i = 0; i < fields.size(); i++, linhaAtual++) {
			adicionaComponente(linhaAtual, 1, 1, 1, new JLabel(fields.get(i).getName()), painel);
			adicionaComponente(linhaAtual, 2, 1, 2, fields.get(i), painel);

			if (fields.get(i).eObrigatorio()) {

				JLabel label = new JLabel("");
				label.setFont(fonte);
				label.setForeground(new Color(255, 21, 8));
				adicionaComponente(++linhaAtual, 2, 1, 1, label, painel);
				labels.add(label);
			}
		}

		adicionaComponente(++linhaAtual, 1, 1, 1, jButton, painel);
		jButton.addActionListener(e -> validaComponentes());

		painelPrincipal.add(painel);
		add(painelPrincipal);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private boolean validaComponentes() {
		boolean retorno = true;

		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).isEmpty()) {
				labels.get(i).setText(fields.get(i).getName() + " não pode ser vazio !");
				retorno = false;
			} else {
				labels.get(i).setText("");
			}
		}
		pack();
		return retorno;
	}

	private void adicionaComponente(int linha, int coluna, int linhas, int colunas, JComponent componente,
			JPanel painel) {

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = linha;
		gbc.gridx = coluna;
		gbc.gridheight = linhas;
		gbc.gridwidth = colunas;
		gbc.insets = new Insets(5, 5, 5, 5);
		painel.add(componente, gbc);

	}

	class MeuJTextField extends JTextField {

		private boolean eObrigatorio;

		public MeuJTextField(boolean eObrigatorio, String nome) {
			this.eObrigatorio = eObrigatorio;
			setName(nome);
			setPreferredSize(new Dimension(200, 25));

		}

		public boolean isEmpty() {
			return getText().trim().isEmpty();
		}

		public boolean eObrigatorio() {
			return eObrigatorio;
		}
	}
}
