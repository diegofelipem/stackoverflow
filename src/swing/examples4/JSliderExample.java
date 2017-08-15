package swing.examples4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class JSliderExample extends JPanel {

	public JSliderExample() {

		JFrame frame = new JFrame("Slider Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);

		slider.setMajorTickSpacing(2);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);

		frame.getContentPane().add(slider, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JSliderExample();
		});
	}
}
