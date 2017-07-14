package swing.examples3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MouseListenerLambdaTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MouseListenerLambdaTest();
		});
	}

	public MouseListenerLambdaTest() {
		initComponents();
	}

	private void initComponents() {

		JFrame f = new JFrame();
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(200, 120));

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel();
		contentPane.add(label);

		contentPane.addMouseListener((MouseListenerHelper) (e) -> label.setText("Clicked"));

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		label.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	interface MouseListenerHelper extends MouseListener {

		@Override
		public default void mouseEntered(MouseEvent e) {
		}

		@Override
		public default void mouseExited(MouseEvent e) {
		}

		@Override
		public default void mousePressed(MouseEvent e) {
		}

		@Override
		public default void mouseReleased(MouseEvent e) {
		}

	}
}
