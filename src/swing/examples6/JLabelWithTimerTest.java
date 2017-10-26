package swing.examples6;

import java.awt.*;
import javax.swing.*;

public class JLabelWithTimerTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private CustomLabel label;
	private JButton btn;
	private JPanel pane;

	public JLabelWithTimerTest() {
		setTitle("JLabel with Timer");
		setPreferredSize(new Dimension(300, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = new JPanel(new GridBagLayout());
		setContentPane(pane);

		label = new CustomLabel("Texto inicial...");
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 1;
		gbc1.gridy = 0;
		gbc1.weightx = 1.0;
		gbc1.weighty = 1.0;
		pane.add(label, gbc1);

		btn = new JButton("disparar");
		btn.addActionListener(e -> label.setTransientText("texto temporario", 2000));

		GridBagConstraints gbc2 = (GridBagConstraints) gbc1.clone();
		gbc2.gridx = 1;
		gbc2.gridy = 3;
		pane.add(btn, gbc2);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class CustomLabel extends JLabel {

		private static final long serialVersionUID = 1L;
		private SwingWorker<Void, Void> worker;

		public CustomLabel() {
			super();
		}

		public CustomLabel(String text) {
			super.setText(text);
		}

		public void setTransientText(String text, long duration) {

			if (worker != null && !worker.isDone())
				return;

			final String originalText = getText();
			worker = new SwingWorker<Void, Void>() {

				@Override
				protected Void doInBackground() throws Exception {
					setText(text);
					Thread.sleep(duration);
					return null;
				}

				@Override
				protected void done() {
					setText(originalText);
				}
			};
			worker.execute();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(JLabelWithTimerTest::new);
	}
}
