package swing_examples2;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class JFrameSuaveResizing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			try {
				JFrameSuaveResizing frame = new JFrameSuaveResizing();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.resizingFrame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	private void resizingFrame(){
		Dimension dimOld = getSize();
		
		for(int i = 0; i < 300; i++){
			setSize(dimOld.width, dimOld.height + i);
			revalidate();
			repaint();
		}
		
		System.out.println(dimOld);
	}

	public JFrameSuaveResizing() {
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
