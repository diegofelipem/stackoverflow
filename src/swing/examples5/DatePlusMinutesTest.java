package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

public class DatePlusMinutesTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JSpinner spinner01;
	private JTextField textField;
	private JButton btnPlusMin;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			DatePlusMinutesTest frame = new DatePlusMinutesTest();
			frame.setVisible(true);
		});
	}

	public DatePlusMinutesTest() {
		initComponents();
		pack();
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		this.contentPane = new JPanel(new BorderLayout(0, 0));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.NORTH);

		this.spinner01 = new JSpinner(new SpinnerDateModel());
		this.spinner01.setEditor(new JSpinner.DateEditor(this.spinner01, "HH:mm"));
		this.spinner01.setValue(new Date());
		this.panel.add(this.spinner01);

		this.btnPlusMin = new JButton("+3");
		btnPlusMin.addActionListener(e -> {
			if (spinner01.getValue() != null) {

				Date spDate = (Date) spinner01.getModel().getValue();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				textField.setText(sdf.format(new Date(spDate.getTime() + (3 * 60 * 1000))));
			}
		});
		this.panel.add(this.btnPlusMin);

		this.textField = new JTextField(10);
		this.textField.setEditable(false);
		this.panel.add(this.textField);
	}
}
