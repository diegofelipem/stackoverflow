package swing.examples6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TimerTaskSwingTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private int count = 0;

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		EventQueue.invokeLater(() -> new TimerTaskSwingTest().setVisible(true));
	}

	public TimerTaskSwingTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 200));
		((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl = new GridBagLayout();
		this.panel = new JPanel(gbl);
		getContentPane().add(this.panel, BorderLayout.CENTER);

		JTextField field = new JTextField(10);
		field.setEditable(false);
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.anchor = GridBagConstraints.NORTH;
		gbc1.weightx = 1.0;
		gbc1.weighty = 1.0;
		gbc1.insets = new Insets(2, 2, 2, 2);
		this.panel.add(field, gbc1);

		int delay = 3000; 
		int interval = 3000;
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				SwingUtilities.invokeLater(() -> field.setText(String.valueOf(count)));
				count++;
			}

		}, delay, interval);

		pack();
		setLocationRelativeTo(null);
	}
}
