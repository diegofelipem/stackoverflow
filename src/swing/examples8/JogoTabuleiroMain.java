package swing.examples8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JogoTabuleiroMain {

	public static void main(String[] args) {
		Tabuleiro cenario = new Tabuleiro();
		cenario.criarTela();
	}

}

class Tabuleiro extends JFrame implements ActionListener {
	
	private JButton tabela[][], andar, cura, sair, debug, percepcao, vida;
	private GridLayout layoutTabuleiro;
	Humano jogador1;

	public Tabuleiro() {
		super("Zumbicídio");
		setSize(800, 600);
		setResizable(false);
		layoutTabuleiro = new GridLayout(14, 14);
		setSize(800, 600);
		jogador1 = new Humano();
		setVisible(true);
	}

	public void criarTela() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ADICIONANDO ELEMENTOS
		this.visualizarTabuleiro();
		// MOSTRANDO A JANELA
		this.setVisible(true);
	}

	// No método abaixo eu adiciono tudo no tabuleiro, por isso ficou grande, mas
	// boa parte pode ser ignorada. Acho que o que importa mesmo é ter adicionado os
	// ActionListener, o que fiz logo no início. Adicionei printf's de teste nos
	// locais que não funcionam no meu código original (isso tá lá embaixo, perto do
	// método do ActionListener)
	public void visualizarTabuleiro() {
		final JPanel telaTabuleiro = new JPanel();
		int i, j;

		telaTabuleiro.setLayout(layoutTabuleiro);
		telaTabuleiro.setPreferredSize(new Dimension(600, 550));

		// ADICIONANDO ACTION LISTENER
		tabela = new JButton[10][10];
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				this.tabela[i][j] = new JButton(new ImageIcon("res/images/desconhecido.png/"));
				this.tabela[i][j].addActionListener(this);
			}
		}

		// ADICIONANDO ELEMENTOS

		// 1 LINHA
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 2 LINHA (PRIMEIRA DO TABULEIRO) **************

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[0][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 3 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[1][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 4 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[2][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 5 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[3][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 6 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[4][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 7 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[5][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 8 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[6][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 9 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[7][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 10 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[8][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 11 LINHA

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		for (j = 0; j < 10; j++) {
			telaTabuleiro.add(tabela[9][j]);
		}
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 12 LINHA
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 13 LINHA
		telaTabuleiro.add(new Label(" "));
		vida = new JButton("hp");
		telaTabuleiro.add(vida);
		percepcao = new JButton("percep");

		telaTabuleiro.add(percepcao);

		telaTabuleiro.add(new Label(" "));
		andar = new JButton("andar");
		andar.addActionListener(this);
		telaTabuleiro.add(andar);

		telaTabuleiro.add(new Label(" "));
		cura = new JButton("cura");
		cura.addActionListener(this);
		telaTabuleiro.add(cura);

		telaTabuleiro.add(new Label(" "));
		debug = new JButton("debug");
		debug.addActionListener(this);
		telaTabuleiro.add(debug);
		telaTabuleiro.add(new Label(" "));

		telaTabuleiro.add(new Label(" "));
		sair = new JButton("sair");
		sair.addActionListener(this);
		telaTabuleiro.add(sair);
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// 14 LINHA
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label("    Vida "));
		telaTabuleiro.add(new Label("  Percep. "));

		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label("   Andar"));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label("   Cura"));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label("   Debug"));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label("     Sair"));
		telaTabuleiro.add(new Label(" "));
		telaTabuleiro.add(new Label(" "));

		// ADICIONANDO NO CONTENTPANE
		this.getContentPane().add(telaTabuleiro, BorderLayout.NORTH);
	}

	public void moverHumano(JButton escolha) {
		if (escolha == tabela[0][0]) {
			System.out.println("Selecionou a primeira posição!"); // O QUE DESEJO TESTAR E NÃO ESTÁ FUNCIONANDO
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton escolha = (JButton) ae.getSource();
		if (escolha == andar) {
			System.out.println("Escolheu andar");
			moverHumano(escolha);
		}
	}

}

class Humano {
	
	private int saude, percep;

	Humano() {
		this.saude = 5;
		this.percep = 3;
	}

	public int getSaude() {
		return this.saude;
	}

	public int getPercepcao() {
		return this.percep;
	}

}