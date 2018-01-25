package swing.examples7;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

public class JSpinnerListenChangesTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() ->new JSpinnerListenChangesTest().setVisible(true));
	}


	public JSpinnerListenChangesTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("No changes");
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(e -> {
			label.setText("Spinner was changed to: " + spinner.getValue());
		});
		
		contentPane.add(spinner);
		contentPane.add(label);
		
		pack();
	}

}
