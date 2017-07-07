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

public class JTextFieldTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldTest frame = new JTextFieldTest();
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
	public JTextFieldTest() {
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
		txtEmail.addActionListener(e ->{
			
//			String email = txtEmail.getText();
//			
//			String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";
//
//					Pattern pattern = Pattern.compile(EMAIL_PATTERN);
//					Matcher matcher = pattern.matcher(email);
//
//					    if (!matcher.matches()) {
//					    	System.out.println("E-mail inválido.");
//					    } else {
//					    	System.out.println("E-mail válido.");
//					    }
			
//			if ((txtEmail.getText().contains("@"))
//	                && (txtEmail.getText().contains("."))
//	                && (!txtEmail.getText().contains(" "))) {
//
//	        String usuario = new String(txtEmail.getText().substring(0,
//	                txtEmail.getText().lastIndexOf('@')));
//
//	        String dominio = new String(txtEmail.getText().substring(txtEmail.getText().lastIndexOf('@') + 1, txtEmail.getText().length()));
//
//	        if ((usuario.length() >= 1) && (!usuario.contains("@"))
//	                && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".")
//	                >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {
//
//	        } else {
//
//	            System.out.println("E-mail inválido!");
//	            txtEmail.requestFocus();
//
//	        }
//
//	    } else {
//
//	    	System.out.println("E-mail inválido");
//	        txtEmail.requestFocus();
//
//			}
			
		});
		txtEmail.setColumns(15);
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
	        	String regex = "^([^FT])$";
	        	
	            super.insertString(offset, str.replaceAll(regex, ""), attr);
	        }
	    }
	}

}
