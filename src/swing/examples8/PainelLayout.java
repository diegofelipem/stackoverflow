package swing.examples8;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class PainelLayout extends JPanel {
	
	private static final int LINES = 8;
	
	private JTextField textField;
	private JTextField textField_1;
	private JButton[] buttons = new JButton[LINES];
	private JTextField[] fields = new JTextField[LINES];
	private JLabel[] labels = new JLabel[LINES];
	



	public PainelLayout() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel painelSuperior = new JPanel();
		painelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(painelSuperior, BorderLayout.NORTH);
		painelSuperior.setLayout(new BoxLayout(painelSuperior, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		painelSuperior.add(textField);
		textField.setColumns(5);
		
		painelSuperior.add(Box.createHorizontalGlue());
		
		textField_1 = new JTextField();
		painelSuperior.add(textField_1);
		textField_1.setColumns(5);
		
		JPanel painelMeio = new JPanel();
		add(painelMeio, BorderLayout.CENTER);
		painelMeio.setLayout(new GridLayout(0, 3, 5, 5));
		
		for(int i = 0; i < LINES; i++) {
			fields[i] = new JTextField(10);
			labels[i] = new JLabel();
			buttons[i] = new JButton("File");
			
			painelMeio.add(fields[i]);
			painelMeio.add(labels[i]);
			painelMeio.add(buttons[i]);
		}
		
		JPanel painelInferior = new JPanel();
		painelInferior.setBorder(new EmptyBorder(5, 5, 5, 0));
		add(painelInferior, BorderLayout.SOUTH);
		painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Contagem Total: ");
		painelInferior.add(lblNewLabel);
		
		painelInferior.add(Box.createHorizontalGlue());
		
		JButton btnNewButton = new JButton("Contar");
		painelInferior.add(btnNewButton);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame =  new JFrame();
			frame.add(new PainelLayout());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		});
	}

}

