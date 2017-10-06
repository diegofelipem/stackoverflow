package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import java.awt.FlowLayout;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JButton;

public class JTextComponentValidatorTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel labelOne;
	private JTextField textFieldOne;
	private JLabel labelTwo;
	private JTextField textFieldTwo;
	private JButton btnNewButton;

	public static void main(String[] args) {
		
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
                break;
            }
        }
        
		EventQueue.invokeLater(() -> {
			new JTextComponentValidatorTest().setVisible(true);
		});
	}

	public JTextComponentValidatorTest() {
		initComponents();
		pack();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = new JPanel(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.contentPane.add(this.panel, BorderLayout.CENTER);

		this.labelOne = new JLabel("Field 1");
		this.panel.add(this.labelOne);

		this.textFieldOne = new JTextField();
		this.labelOne.setLabelFor(this.textFieldOne);
		this.textFieldOne.setColumns(15);
		this.textFieldOne.setInputVerifier(new TextFieldInputVerifier(Pattern.compile("[A-Za-z0-9]+")));
		this.panel.add(this.textFieldOne);

		this.labelTwo = new JLabel("Field 2");
		this.panel.add(this.labelTwo);

		this.textFieldTwo = new JTextField();
		this.labelTwo.setLabelFor(this.textFieldTwo);
		this.textFieldTwo.setColumns(15);
		this.textFieldTwo.setInputVerifier(new TextFieldInputVerifier(Pattern.compile("[A-Za-z0-9]+")));
		this.panel.add(this.textFieldTwo);
		
		this.btnNewButton = new JButton("OK");
		this.panel.add(this.btnNewButton);
		this.btnNewButton.addActionListener(e -> {
			System.out.println("Submetido!");
		});
	}

	class TextFieldInputVerifier extends InputVerifier {

		Pattern pattern;
		Border originalBorder;

		public TextFieldInputVerifier(Pattern pattern) {
			this.pattern = pattern;
		}

		@Override
		public boolean verify(JComponent input) {

			JTextField comp = (JTextField) input;
			boolean isValid = !comp.getText().isEmpty() && pattern.matcher(comp.getText()).matches();
			comp.setText(isValid ? comp.getText() : "");
			return isValid;
		}

		@Override
		public boolean shouldYieldFocus(JComponent input) {

			boolean isValid = verify(input);

			if (!isValid) {
				originalBorder = originalBorder == null ? input.getBorder() : originalBorder;
				input.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			} else {
				if(originalBorder != null) {
					input.setBorder(originalBorder);
					originalBorder = null;
				}
			}

			return isValid;
		}
	}
}
