package swing.examples5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalarioFrame extends JFrame {

	private JPanel painelTopo;
	private JPanel painelCentro;
	private JPanel painelFundo;
	private JLabel lblSalarioBruto;
	private JTextField txtSalarioBruto;
	private JButton btnCalcular;
	private JCheckBox chkFormatar;
	private JLabel lblBaseInss;
	private JLabel lblDescInss;
	private JLabel lblBaseIrpf;
	private JLabel lblDescIrpf;
	private JTextField txtBaseInss;
	private JTextField txtDescInss;
	private JTextField txtBaseIrpf;
	private JTextField txtDescIrpf;
	private JLabel lblSalarioLiq;
	private JTextField txtSalarioLiq;

	public static void main(String[] args) {
		new SalarioFrame().setVisible(true);
	}

	public SalarioFrame() {
		iniciarElementos();
		configurarFrame();
		criarEvento();
		montarFrame();
	}

	/*
	 * Criando eventos
	 */
	private void criarEvento() {
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtSalarioBruto.getText().length() < 1) {
						JOptionPane.showMessageDialog(null, "Por favor preencher o campo Salário Bruto.");
						return;
					}
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Por favor preencher o campo Salário Bruto.");
					return;
				}

				double salarioBruto = 0.0;

				try {
					salarioBruto = Double.parseDouble(txtSalarioBruto.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor preencher o campo Salário Bruto com Número.");
					return;
				}

				double[] valoresCalculados = SalarioClasse.ValorCalculo(salarioBruto);
				txtBaseInss.setText(String.valueOf(valoresCalculados[0]));
				txtDescInss.setText(String.valueOf(valoresCalculados[1]));
				txtBaseIrpf.setText(String.valueOf(valoresCalculados[2]));
				txtDescIrpf.setText(String.valueOf(valoresCalculados[3]));
				txtSalarioLiq.setText(String.valueOf(valoresCalculados[4]));
				painelCentro.revalidate();
			}
		});

		chkFormatar.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				String salarioBruto = txtSalarioBruto.getText();

				if (salarioBruto == null || salarioBruto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Antes de formatar, por favor informar um Salário Bruto e clicar no botão [Calcular]");
					return;
				}

				String salarioBrutoFormatado = "", salarioLiquido = "", descontoInss = "", descontoIrpf = "",
						baseInss = "", baseIrpf = "";

				if (chkFormatar.isSelected()) {

					NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();

					try {
						salarioBrutoFormatado = formatoMoeda.format(Double.parseDouble(salarioBruto));

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,
								"Antes de formatar, por favor informar um Salário Bruto válido e clicar no botão [Calcular]");
						return;
					}

					salarioLiquido = formatoMoeda.format(Double.parseDouble(txtSalarioLiq.getText()));
					descontoInss = formatoMoeda.format(Double.parseDouble(txtDescInss.getText()));
					descontoIrpf = formatoMoeda.format(Double.parseDouble(txtDescIrpf.getText()));
					baseInss = formatoMoeda.format(Double.parseDouble(txtBaseInss.getText()));
					baseIrpf = formatoMoeda.format(Double.parseDouble(txtBaseIrpf.getText()));

					txtSalarioBruto.setText(salarioBrutoFormatado);
					txtSalarioLiq.setText(salarioLiquido);
					txtDescInss.setText(descontoInss);
					txtDescIrpf.setText(descontoIrpf);
					txtBaseInss.setText(baseInss);
					txtBaseIrpf.setText(baseIrpf);

				} else {
					
					salarioBrutoFormatado = txtSalarioBruto.getText();
					salarioLiquido = txtSalarioLiq.getText();
					descontoInss = txtDescInss.getText();
					descontoIrpf = txtDescIrpf.getText();
					baseInss = txtBaseInss.getText();
					baseIrpf = txtBaseIrpf.getText();

					txtSalarioBruto.setText(salarioBrutoFormatado);
					txtSalarioLiq.setText(salarioLiquido);
					txtDescInss.setText(descontoInss);
					txtDescIrpf.setText(descontoIrpf);
					txtBaseInss.setText(baseInss);
					txtBaseIrpf.setText(baseIrpf);
				}
				painelCentro.revalidate();
			}
		});
	}

	/*
	 * Montando Frame
	 */
	private void montarFrame() {
		painelTopo.add(lblSalarioBruto);
		painelTopo.add(txtSalarioBruto);
		painelTopo.add(btnCalcular);
		painelTopo.add(chkFormatar);
		painelCentro.add(lblBaseInss);
		painelCentro.add(txtBaseInss);
		painelCentro.add(lblDescInss);
		painelCentro.add(txtDescInss);
		painelCentro.add(lblBaseIrpf);
		painelCentro.add(txtBaseIrpf);
		painelCentro.add(lblDescIrpf);
		painelCentro.add(txtDescIrpf);
		painelFundo.add(lblSalarioLiq);
		painelFundo.add(txtSalarioLiq);
	}

	/**
	 * Iniciar Elementos
	 */
	private void iniciarElementos() {
		painelTopo = new JPanel(new FlowLayout());
		lblSalarioBruto = new JLabel("Salário Bruto:");
		txtSalarioBruto = new JTextField(10);
		btnCalcular = new JButton("Calcular");
		chkFormatar = new JCheckBox("Formatar");
		painelCentro = new JPanel(new GridLayout(4, 1));
		painelCentro = new JPanel(new GridLayout(4, 1));
		lblBaseInss = new JLabel("Base INSS");
		txtBaseInss = new JTextField();
		txtBaseInss.setEnabled(false);
		lblDescInss = new JLabel("Desconto INSS");
		txtDescInss = new JTextField(10);
		txtDescInss.setEnabled(false);
		lblBaseIrpf = new JLabel("Base IRPF");
		txtBaseIrpf = new JTextField(10);
		txtBaseIrpf.setEnabled(false);
		lblDescIrpf = new JLabel("Desconto IRPF");
		txtDescIrpf = new JTextField(10);
		txtDescIrpf.setEnabled(false);
		painelFundo = new JPanel(new FlowLayout());
		lblSalarioLiq = new JLabel("Salário Liquido:");
		txtSalarioLiq = new JTextField(10);
		txtSalarioLiq.setEnabled(false);
	}

	/*
	 * Configurando Frame
	 */
	private void configurarFrame() {
		this.setTitle("Calculador de salário");
		this.setSize(400, 180);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout(5, 5));

		this.add(painelTopo, BorderLayout.PAGE_START);
		this.add(painelCentro, BorderLayout.CENTER);
		this.add(painelFundo, BorderLayout.PAGE_END);
	}
}

class SalarioClasse {

	public static double[] ValorCalculo(double salarioBruto) {

		double[] valorCalculo = new double[5];
		valorCalculo[0] = salarioBruto;

		// calculo INSS
		if (salarioBruto <= 1659.38)
			valorCalculo[1] = salarioBruto * 0.8;

		if (salarioBruto >= 1659.39 && salarioBruto <= 2765.66)
			valorCalculo[1] = salarioBruto * 0.9;

		if (salarioBruto >= 2765.67 && salarioBruto <= 5531.31)
			valorCalculo[1] = salarioBruto * 0.11;

		if (valorCalculo[1] > 608.45)
			valorCalculo[1] = 608.45;

		// salario liquido
		valorCalculo[2] = salarioBruto - valorCalculo[1];

		// calculo IRPF
		if (valorCalculo[2] <= 1903.98)
			valorCalculo[3] = 0.0;

		if (valorCalculo[2] >= 1903.99 && valorCalculo[2] <= 2826.65)
			valorCalculo[3] = ((valorCalculo[2] * 7.5) / 100) - 142.80;

		if (valorCalculo[2] >= 2826.66 && valorCalculo[2] <= 3751.05)
			valorCalculo[3] = ((valorCalculo[2] * 15) / 100) - 354.80;

		if (valorCalculo[2] >= 3751.06 && valorCalculo[2] <= 4664.68)
			valorCalculo[3] = ((valorCalculo[2] * 22.5) / 100) - 636.13;

		if (valorCalculo[2] > 4664.68)
			valorCalculo[3] = ((valorCalculo[2] * 27.5) / 100) - 869.36;

		valorCalculo[4] = salarioBruto - valorCalculo[1] - valorCalculo[3];

		return valorCalculo;
	}
}