package swing.examples8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JLabelTimeTest extends JFrame {

	public JLabel label;
	public JPanel painel = new JPanel();

	public JLabelTimeTest() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Teste");

		label = new ClockLabel();

		painel.add(label);
		add(painel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(JLabelTimeTest::new);
	}
}

class ClockLabel extends JLabel {

	public ClockLabel() {
		Timer t = new Timer(1000, e -> setText(getDateTime()));
		t.setInitialDelay(0);
		t.start();
	}

	private String getDateTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
}