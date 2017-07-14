package swing.examples3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.FocusManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;

public class JTextFieldLineBorderTest extends JFrame {

	private JPanel contentPane;
	private FieldAnimatedBorder textField1;
	private FieldAnimatedBorder textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldLineBorderTest frame = new JTextFieldLineBorderTest();
					frame.setVisible(true);
					frame.requestFocusInWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTextFieldLineBorderTest() {
		initComponents();
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 200));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		
		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		painel.setPreferredSize(new Dimension(150, 60));
		
		this.textField1 = new FieldAnimatedBorder();
		this.textField1.setColumns(10);
		textField1.setBackground(getContentPane().getBackground());
		
		this.textField2 = new FieldAnimatedBorder();
		this.textField2.setColumns(10);
		textField2.setBackground(getContentPane().getBackground());
		
		painel.add(this.textField1);
		painel.add(Box.createVerticalGlue());
		painel.add(this.textField2);
		this.contentPane.add(painel);
		
		pack();
		setLocationRelativeTo(null);

	}
	
	class FieldAnimatedBorder extends JTextField{
		
		private Border focusBorder;
		private Border defaultBorder;
		
		public FieldAnimatedBorder() {
			
			defaultBorder = getBorder();
			focusBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE);
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 =  (Graphics2D) g;
			
			if (!(this.equals(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner()))) {
				setBorder(defaultBorder);
			} else {
				setBorder(focusBorder);
			}
		}
	}
}
