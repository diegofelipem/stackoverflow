package swing.examples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DesenhoTeste extends JFrame {

	private JPanel contentPane;
	private JPanel drawPanel;
	private JPanel superiorPanel;
	private JButton btnNewButton;
	
	private Point point;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesenhoTeste frame = new DesenhoTeste();
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
	public DesenhoTeste() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		drawPanel = new JPanel();
		contentPane.add(drawPanel, BorderLayout.CENTER);
		
		superiorPanel = new JPanel();
		contentPane.add(superiorPanel, BorderLayout.NORTH);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						point = e.getPoint();
						Graphics2D g2 = (Graphics2D) drawPanel.getGraphics();
						Rectangle rect = new Rectangle(point.x, point.y, 100, 100);
						g2.setColor(Color.red);
						g2.draw(rect);
						drawPanel.repaint();
					}
				});
			}
		});
		superiorPanel.add(btnNewButton);
	}

}
