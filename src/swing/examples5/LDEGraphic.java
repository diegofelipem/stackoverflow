package swing.examples5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.*;

public class LDEGraphic extends JFrame {
	
	
	JButton jb = new JButton("Adicionar");
	JButton jb2 = new JButton("Remover");
	JPanel painel;

	public LDEGraphic() {
		setTitle("Lista Duplamente encadeada");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		painel = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);	
				g.setColor(Color.BLACK);
				g.drawRect(100, 300, 60, 25);
				g.fillRect(100, 300, 60, 25);

			}
		};
		
		painel.setLayout(null);
		jb.setBounds(10, 10, 100, 60);
		painel.add(jb);
		jb2.setBounds(10, 70, 120, 60);
		painel.add(jb2);
		getContentPane().add(painel);
		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new LDEGraphic());
	}

}