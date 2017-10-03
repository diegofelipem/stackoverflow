package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Maquina3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelNorth;
	private JTextField textField;
	private JPanel panelSouth;
	private JButton btnFormatar;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new Maquina3().setVisible(true);
		});
	}

	public Maquina3() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 250));
		this.contentPane = new JPanel(new BorderLayout(0, 0));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);

		this.panelNorth = new JPanel();
		this.contentPane.add(this.panelNorth, BorderLayout.NORTH);

		this.panelSouth = new JPanel();
		this.contentPane.add(this.panelSouth, BorderLayout.SOUTH);

		this.textField = new JTextField();
		this.textField.setColumns(15);
		this.panelNorth.add(this.textField);

		this.btnFormatar = new JButton("Formatar");
		btnFormatar.addActionListener(e -> {

			String text = textField.getText();

			if (text == null | text.length() == 0)
				return;

			String regex = "([Qq]{1}(0[1-9]|10))";
			StringBuilder builder =  new StringBuilder();

			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(text);

			while (m.find()) {
				
				builder.append(builder.length() == 0 ? "" : ",");
				builder.append(m.group());
			}
			builder.insert(0, "{");
			builder.append("}");

			textField.setText(builder.toString().toLowerCase());
		});

		this.panelSouth.add(this.btnFormatar);
	}
}
