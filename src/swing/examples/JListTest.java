package swing.examples;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

public class JListTest extends JFrame {

	public void createAndShowGUI() {

		String[] selections = { "green", "red", "orange", "dark blue" };
		JList<String> list = new JList(selections);

		setLayout(new BorderLayout());
		add(new JScrollPane(list),BorderLayout.NORTH);
		
		JButton btn = new JButton("Salvar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SecondList frame = new SecondList();
				frame.createAndShowGUI(list.getModel());
				
			}
		});
		add(btn, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(100, 220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JListTest().createAndShowGUI();

			}
		});
	}
}

class SecondList extends JFrame{
	
	public void createAndShowGUI(ListModel model) {


		JList<String> list = new JList();
		list.setModel(model);

		setLayout(new FlowLayout());
		add(new JScrollPane(list));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(100, 200));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JListTest().createAndShowGUI();

			}
		});
	}
	
}