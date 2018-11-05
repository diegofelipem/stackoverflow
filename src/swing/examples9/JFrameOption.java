package swing.examples9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JFrameOption {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			
			int response = JOptionPane.showConfirmDialog(null, "Clique OK para abrir o frame!");
			
			if(response == JOptionPane.OK_OPTION) {
				JFrame f = new JFrame();
				f.setSize(150,100);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
				
			
			
		});
	}
}
