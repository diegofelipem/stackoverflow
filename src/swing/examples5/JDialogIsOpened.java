package swing.examples5;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JDialogIsOpened {

	JFrame frame = new JFrame();
	JDialog dialog = new JDialog();

	public void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setVisible(true);

		dialog = new JDialog(frame);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(300, 200);
		dialog.setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> {
			new JDialogIsOpened().createAndShowGUI();
			;
		});
	}
}
