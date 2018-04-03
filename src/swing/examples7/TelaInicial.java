package swing.examples7;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaInicial extends javax.swing.JFrame {

	ArrayList<Pessoa> p;
	Pessoa pessoa;
	int contador = 0, controlador = 0;

	@Override
	public String toString() {
		return "\nNOME" + campoNome.getText() + "\nIDADE : " + campoIdade.getText();
	}

	public TelaInicial() {
		p = new ArrayList<Pessoa>();
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		campoNome = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		campoIdade = new javax.swing.JTextField();
		botaoCadastrar = new javax.swing.JButton();
		botaoExibir = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("CADASTRO PESSOAS ");

		jLabel2.setText("NOME : ");

		jLabel3.setText("IDADE : ");

		botaoCadastrar.setText("CADASTRAR");
		botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoCadastrarActionPerformed(evt);
			}
		});

		botaoExibir.setText("EXIBIR");
		botaoExibir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoExibirActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(96, 96, 96).addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE,
														111, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(botaoExibir,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(campoIdade))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(41, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(25, 25, 25)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(27, 27, 27)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(botaoCadastrar).addComponent(botaoExibir))
						.addContainerGap(69, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		int idade = Integer.parseInt(campoIdade.getText());
		pessoa = new Pessoa(campoNome.getText(), idade);
		p.add(pessoa);
		JOptionPane.showMessageDialog(this, " DADO CADASTRADO COM SUCESSO ");
		contador = contador + 1;

	}

	private void botaoExibirActionPerformed(java.awt.event.ActionEvent evt) {
		ExibeFrame exibe = new ExibeFrame();
		exibe.setVisible(true);

		exibe.MostraTudo(p, pessoa);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaInicial().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton botaoCadastrar;
	private javax.swing.JButton botaoExibir;
	private javax.swing.JTextField campoIdade;
	private javax.swing.JTextField campoNome;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	// End of variables declaration
}

// ========================================================================================
// //

class ExibeFrame extends javax.swing.JFrame {
	public ExibeFrame() {
		initComponents();
	}

	public void MostraTudo(ArrayList p, Pessoa pessoa) {

		for (int i = 0; i < p.size(); i++) {
			areaDados.setText(p.get(i).toString());
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		areaDados = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("DADOS PESSOAS");

		areaDados.setColumns(20);
		areaDados.setRows(5);
		jScrollPane1.setViewportView(areaDados);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(146, 146, 146).addComponent(jLabel1)
						.addContainerGap(171, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ExibeFrame().setVisible(true);
			}
		});
	}
	
	// Variables declaration - do not modify
	private javax.swing.JTextArea areaDados;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration
}

// =============================================================================//

class Pessoa {
	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String exibeDados() {
		return "\nNOME : " + this.getNome() + "\nIDADE : " + this.getIdade();
	}
}