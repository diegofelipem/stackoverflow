package swing.experiences.wheelRandomColors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WheelRandomColorsTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel wheelPane;
	private JPanel controlsPane;
	private JButton rotateButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new WheelRandomColorsTest().setVisible(true);
		});
	}

	public WheelRandomColorsTest() {
		initComponents();
		pack();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 300));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.wheelPane = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				int widthRectangle = getWidth();
				int heightReclangle = getHeight();

				int x, y, diameter;

				if (widthRectangle <= heightReclangle) {
					diameter = widthRectangle;
					y = heightReclangle / 2 - diameter / 2;
					x = 0;
				} else {
					diameter = heightReclangle;
					x = widthRectangle / 2 - diameter / 2;
					y = 0;

				}
				Circle circle = new Circle(x, y, diameter, Color.red);
				circle.draw(g);
				
				LineArrow line = new LineArrow(x + diameter/2, y + diameter/2, x + diameter/2, y + diameter, Color.white, 3);
				line.draw(g);
			}
		};

		this.contentPane.add(this.wheelPane, BorderLayout.CENTER);

		this.controlsPane = new JPanel(new GridLayout(0, 1, 0, 0));
		this.controlsPane.setBorder(new EmptyBorder(5, 1, 1, 1));

		this.rotateButton = new JButton("Rotate");
		this.rotateButton.addActionListener(e -> {
			
		});
		this.controlsPane.add(this.rotateButton);

		this.contentPane.add(this.controlsPane, BorderLayout.SOUTH);

	}
}
