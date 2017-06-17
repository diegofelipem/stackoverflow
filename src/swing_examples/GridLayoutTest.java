package swing_examples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class GridLayoutTest extends JFrame{

	JPanel painel01;
	final int PLAYER_ONE = 1;
	final int PLAYER_TWO = 2;	
	
	
	public GridLayoutTest() {
		initComponents();
	}

	public void initComponents() {

		painel01 = new JPanel();
		painel01.setPreferredSize(new Dimension(200, 200));
		GridLayout grid = new GridLayout(3, 3);
		painel01.setLayout(grid);
		
		for(int i = 0; i  < 9; i++){

			int down = i/3 <= 1 ? 1 : 0;
			
			int side = i == 1 || i == 4 || i == 7 ? 1 : 0;

			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createMatteBorder(0, side, down, side, Color.black));
			painel01.add(label);
		}
		
		setContentPane(painel01);
		pack();
	}
	
	class ActionListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel lb = (JLabel)e.getSource();
			
		}
	}
	
	public static void main(String[] args){

		SwingUtilities.invokeLater(() ->{
			GridLayoutTest f = new GridLayoutTest();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		});
	}
}
