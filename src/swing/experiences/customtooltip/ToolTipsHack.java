package swing.experiences.customtooltip;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ToolTipsHack {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			new ToolTipsHack().createAndShowGUI();
		});
	}

	public void createAndShowGUI() {
		JButton button;

		JFrame frame = new JFrame("Tool Tips Hack");
		BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.getContentPane().setLayout(layout);
		frame.setPreferredSize(new Dimension(200, 200));

		button = new CustomJButton();
		button.setText("Open");
		button.setToolTipText("Open an existing file");
		frame.getContentPane().add(button);

		button = new CustomJButton();
		button.setText("Save");
		button.setToolTipText("Save the currently open file");
		frame.getContentPane().add(button);

		frame.getContentPane().add(new JLabel("a label"));
		frame.getContentPane().add(new JLabel("a label"));
		frame.getContentPane().add(new JLabel("a label"));

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}