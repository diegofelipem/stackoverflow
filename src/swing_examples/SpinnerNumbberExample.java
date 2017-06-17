package swing_examples;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

public class SpinnerNumbberExample {
	
	public void createAndShowGUI(){
		JFrame f = new JFrame();
		
		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		
		JSpinner spinner = new JSpinner();
		
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(50, 20));
		JButton btn = new JButton("OK");
		
		btn.addActionListener(e -> {
			int n = (int)spinner.getValue();
			
			label.setText(n + "");
			f.repaint();
		});
		
		f.add(label);
		f.add(spinner);
		f.add(btn);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SpinnerNumbberExample().createAndShowGUI();;
		});

	}

}
