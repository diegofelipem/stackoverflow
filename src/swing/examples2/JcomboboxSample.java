package swing.examples2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class JcomboboxSample extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBoxTwo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JcomboboxSample frame = new JcomboboxSample();
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
	public JcomboboxSample() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.comboBox = new JComboBox();

		for (int i = 0; i < 4; i++) {
			this.comboBox.addItem(new MyClass(i, "object " + i));
		}
		
		this.comboBox.addItemListener(e -> {
			if(e.getStateChange() == ItemEvent.SELECTED){
				comboBoxTwo.setSelectedItem(e.getItem());
			}
		});

		this.contentPane.add(this.comboBox, BorderLayout.NORTH);

		this.comboBoxTwo = new JComboBox();

		for (int i = 0; i < 4; i++) {
			this.comboBoxTwo.addItem(new MyClass(i, "object " + i));
		}

		this.contentPane.add(this.comboBoxTwo, BorderLayout.SOUTH);
	}
}

class MyClass {

	private int id;
	private String desc;

	public MyClass(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return this.id;
	}

	public String getDesc() {
		return this.desc;
	}

	@Override
	public boolean equals(Object obj) {
			return  obj instanceof MyClass && this.id == ((MyClass)obj).getId();
	}
}
