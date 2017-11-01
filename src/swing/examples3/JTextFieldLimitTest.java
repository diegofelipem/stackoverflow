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
import javax.swing.text.PlainDocument;

public class JTextFieldLimitTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(JTextFieldLimitTest::new);
	}

	public JTextFieldLimitTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.txtEmail = new JTextField();
		txtEmail.setColumns(15);
		 txtEmail.setDocument(new JTextFieldLimit(50));
		this.contentPane.add(this.txtEmail);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class JTextFieldLimit extends PlainDocument {

		private static final long serialVersionUID = 1L;
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

	            super.insertString(offset, str.replaceAll("\\D++", ""), attr);
	        }
	    }
	}
}
