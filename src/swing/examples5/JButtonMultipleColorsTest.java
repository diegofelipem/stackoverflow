package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;

public class JButtonMultipleColorsTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private MultiColorButton multiColorButton;
	private GradientButton gradientButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new JButtonMultipleColorsTest().setVisible(true);
		});
	}

	public JButtonMultipleColorsTest() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 200));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Random rand = new Random();

				Color[] colors = new Color[5];

				for (int i = 0; i < colors.length; i++)
					colors[i] = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

				((iColorsButton) e.getSource()).setColors(colors);

			}
		};

		Timer timer = new Timer(0, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				multiColorButton.doClick();
				gradientButton.doClick();
			}
		});

		timer.start();

		this.multiColorButton = new MultiColorButton();
		this.multiColorButton.addActionListener(action);

		this.multiColorButton.setText("multicolor btn");
		this.panel.add(this.multiColorButton);

		this.gradientButton = new GradientButton();
		this.gradientButton.addActionListener(action);
		this.gradientButton.setText("gradient btn");
		this.panel.add(this.gradientButton);
	}

	class MultiColorButton extends JButton implements iColorsButton {

		private static final long serialVersionUID = 1L;
		Color[] colors;

		public MultiColorButton() {
			this(new Color[] { new Color(63, 72, 204), new Color(181, 230, 29).darker(), new Color(237, 28, 36) });
		}

		public MultiColorButton(Color[] colors) {
			setContentAreaFilled(false);
			setFocusPainted(false);
			this.setColors(colors);
		}

		public void setColors(Color[] colors) {
			this.colors = colors;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {

			if (colors != null && colors.length > 0) {

				int colorsCount = colors.length;
				int fractionWitdh = getWidth() / colorsCount;

				for (int i = 0; i < colorsCount; i++) {
					g.setColor(colors[i]);
					g.fillRect(fractionWitdh * i, 0, fractionWitdh, getHeight());
				}
			}
			super.paintComponent(g);
		}
	}

	class GradientButton extends JButton implements iColorsButton {

		private static final long serialVersionUID = 1L;
		Color[] colors;

		public GradientButton() {
			this(new Color[] { new Color(63, 72, 204), new Color(181, 230, 29), new Color(237, 28, 36) });
		}

		public GradientButton(Color[] colors) {
			setContentAreaFilled(false);
			setFocusPainted(false);
			this.colors = colors;
		}
		
		@Override
		public void setColors(Color[] colors) {
			this.colors = colors;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {

			final Graphics2D g2d = (Graphics2D) g;
			float[] fractions = new float[colors.length];

			for (int i = 1; i <= fractions.length; i++) {
				float fraction = 1.0f / fractions.length;
				fractions[i - 1] = i * fraction;
			}

			g2d.setPaint(new LinearGradientPaint(0, 0, getWidth(), getHeight(), fractions, colors));
			g2d.fillRect(0, 0, getWidth(), getHeight());

			super.paintComponent(g);
		}
	}

	interface iColorsButton {

		void setColors(Color[] colors);
	}
}
