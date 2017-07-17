package swing.examples4;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class GridLayoutButtonsTest extends JFrame {

	private JPanel contentPane;
	private int qtButton = 0; 
	
	public static void main(String[] args) 
	{
		GridLayoutButtonsTest frame = new GridLayoutButtonsTest();
		frame.setVisible(true);
	}
	
	public GridLayoutButtonsTest() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(464, 439));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		for(int i = 0; i < 15; i++)
		{
			panel.add(gerarButton());
		}
		scroll.setViewportView(panel);
		contentPane.add(scroll);
		
		pack();
	}
	
	public JButton gerarButton() {
		
		qtButton++;
		JButton NewButton = new JButton(String.valueOf(qtButton));
		return NewButton;
	}
}