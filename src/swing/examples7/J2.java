package swing.examples7;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class J2 extends JFrame {
	
	private JPanel contentPane;
	private JLabel[] equipas = new JLabel[4];
	
	
	public void func() {

		int Porto = 1;
		int Benfica = 2;
		int Sporting = 3;
		int SCVitoria = 4;

		Integer[] arr = { 1, 2, 3, 4 };
		
		
		Collections.shuffle(Arrays.asList(arr));

		for (int i = 0; i < arr.length; i++) {
		    equipas[i].setText(String.valueOf(arr[i]));
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new J2().setVisible(true));
	}


	public J2() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJornada = new JLabel("Jornada 1");
		lblJornada.setBounds(61, 11, 80, 14);
		contentPane.add(lblJornada);

		JButton btnNewButton = new JButton("Gerar Jornada");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				func();
			}
		});
		btnNewButton.setBounds(125, 139, 139, 23);
		contentPane.add(btnNewButton);
		
		JPanel equipaPanel = new JPanel(new GridLayout(2,2));
		
		for(int i = 0; i < equipas.length; i++) {
			equipas[i] =  new JLabel();
			equipas[i].setHorizontalAlignment(SwingConstants.CENTER);
			equipaPanel.add(equipas[i]);
		}
		
		equipaPanel.setBounds(20, 36, 149, 50);
		contentPane.add(equipaPanel);

	}
}