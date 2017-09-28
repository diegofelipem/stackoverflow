package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;

public class JDateChooserActionDayTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JCalendar cal;
	private JPanel contentpane;

	public JDateChooserActionDayTest() {
		contentpane = new JPanel(new BorderLayout());
		
		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(contentpane.getWidth(), 20));
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setHorizontalAlignment(SwingConstants.CENTER);;
		contentpane.add(label, BorderLayout.SOUTH);

		cal = new JCalendar();
		cal.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				label.setText("Clicou na data: "+ new SimpleDateFormat("dd/MM/yyyy").format(cal.getDate()));
			}
		});
		
		contentpane.add(cal, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(contentpane);
		pack();
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			JDateChooserActionDayTest bg = new JDateChooserActionDayTest();
			bg.setLocationRelativeTo(null);
			bg.setVisible(true);
		});
	}
}
