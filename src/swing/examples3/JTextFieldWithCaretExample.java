package swing.examples3;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class JTextFieldWithCaretExample extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private boolean hasOpenParentese = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			JTextFieldWithCaretExample frame = new JTextFieldWithCaretExample();
			frame.setVisible(true);
		});
	}

	public JTextFieldWithCaretExample() {
		initComponents();
		pack();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		this.contentPane = new JPanel();
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.textField = new JTextField();
		this.contentPane.add(this.textField);
		this.textField.setColumns(10);

		textField.setDocument(new PlainDocument() {

			@Override
			public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
				if (str == null) {
					return;
				}

				if (str.equals("(")) {
					hasOpenParentese = true;
					str += ")";
				}
				super.insertString(offset, str, attr);
			}
		});

		textField.addCaretListener(e -> {
			if (hasOpenParentese) {
				hasOpenParentese = false;
				JTextComponent comp = (JTextComponent) e.getSource();
				comp.setCaretPosition(e.getDot() - 1);
			}
		});
	}
}
