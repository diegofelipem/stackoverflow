package swing.examples3;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class JTextFieldFilterTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldFilterTest frame = new JTextFieldFilterTest();
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
	public JTextFieldFilterTest() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.txtEmail = new JTextField();
		txtEmail.setColumns(15);
//		((AbstractDocument) txtEmail.getDocument()).setDocumentFilter(new TextFieldFilter());
		 txtEmail.setDocument(new JTextFieldLimit(50));
		this.contentPane.add(this.txtEmail);
		pack();
	}

	class JTextFieldLimit extends PlainDocument {

		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		@Override
		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null) {
				return;
			}

			if ((getLength() + str.length()) <= limit) {
				String regex = "([^FT])";

				super.insertString(offset, str.replaceAll(regex, ""), attr);
			}
		}
	}

	class TextFieldFilter extends DocumentFilter {

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
				throws BadLocationException {
			
			String a = filterString(text);
			super.replace(fb, offset, length, a, attrs);
		}

		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			super.insertString(fb, offset, filterString(string), attr);
		}

		private String filterString(String text) {
			return text.replaceAll("([^FT])", "");
		}
	}
}
