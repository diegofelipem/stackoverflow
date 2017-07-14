package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class JTextFieldTimeTest extends JFrame {

	private JPanel contentPane;
	private Timer timer;
	private JLabel lbTimer;
	private Instant currentTime;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldTimeTest frame = new JTextFieldTimeTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTextFieldTimeTest() {
		initComponents();
	}
	
	private void initComponents() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(200, 120));
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.lbTimer = new JLabel("00:00:00.00");
		
		timer = new Timer(0, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentTime == null){
					currentTime = Instant.MIN;
				}
				lbTimer.setText(getTimeCurrent());
			}
		});
		
		timer.start();
		
		
		this.contentPane.add(this.lbTimer);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	private String getTimeCurrent(){
		return DateTimeFormatter.ofPattern("HH:mm:ss.SS").format(currentTime);
	}

}
