package swing_examples;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AlternarCorBotaoTest extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		
		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		UIManager.put("Button.disabled", null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlternarCorBotaoTest frame = new AlternarCorBotaoTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlternarCorBotaoTest() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = 	new JButton("New button");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if(lblNewLabel.getText().equals("Jogador 1")){
			    	btnNewButton.setBackground(Color.CYAN);
			        lblNewLabel.setText("Jogador 2");

			    }else{
			    	btnNewButton.setBackground(Color.GREEN);
			        lblNewLabel.setText("Jogador 1");
			    }
			    
				 
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(176, 117, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Jogador 2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 56, 89, 14);
		contentPane.add(lblNewLabel);
	}
}
