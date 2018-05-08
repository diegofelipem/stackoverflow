package swing.examples8;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jogo1 extends JFrame { // Herda para usar JFrame

	String n = "0";
	JLabel labelFlappy = new JLabel(n);

	int posPrincX = 300;
	int posPrincY = 300;

	public Jogo1() {
		editarComponentes();
		editarJanela();
		addMovimento();
	}

	public void addMovimento() {
		addKeyListener(new KeyListener() { // Teclado
			public void keyPressed(KeyEvent e) {
				//System.out.println(e.getKeyCode()); // Exibe código da tecla pressionada
				if (e.getKeyCode() == 38) {
					posPrincY -= 20;
				}
				if (e.getKeyCode() == 40) {
					posPrincY += 20;
				}
				if (e.getKeyCode() == 37) {
					posPrincX -= 20;
				}
				if (e.getKeyCode() == 39) {
					posPrincX += 20;
				}

				if (!excedeuAreaDaTela(posPrincX, posPrincY)) {
					labelFlappy.setBounds(posPrincX, posPrincY, 180, 90); // Atualiza posição
					System.out.println(posPrincY);
				}
					
			}

			public void keyReleased(KeyEvent e) {

			}

			public void keyTyped(KeyEvent e) {

			}
		});
		addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) { // Ao clicar no objeto em questão
				posPrincX = (int) (Math.random() * 650);
				posPrincY = (int) (Math.random() * 700);

				if (!excedeuAreaDaTela(posPrincX, posPrincY))
					labelFlappy.setBounds(posPrincX, posPrincY, 180, 90);
			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}
		});
	}

	private boolean excedeuAreaDaTela(int posX, int posY) {
		return posX < 0 || posX + 180 > 750 || posY < 0 || posY + 90 > 700;
	}

	public void editarComponentes() {
		labelFlappy.setBounds(posPrincX, posPrincY, 180, 90);
	}

	public void editarJanela() {
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Encerra ao fechar
		setSize(750, 700); // Tamanho
		setLocationRelativeTo(null); // Centraliza
		setVisible(true); // Torna visível
		setLayout(null); // Permite redimensionamento de cada componente
		setResizable(false); // Impossibilita o redimensionamento pelo usuário
		setTitle("Magisterix"); // Título

		add(labelFlappy);
	}

	public static void main(String[] args) {
		new Jogo1();
	}
}