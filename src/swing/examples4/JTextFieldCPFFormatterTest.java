package swing.examples4;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class JTextFieldCPFFormatterTest extends JFrame {

	private JPanel contentPane;
	private CPFTextField textField;
	private JButton button;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {

			JTextFieldCPFFormatterTest frame = new JTextFieldCPFFormatterTest();
			frame.setVisible(true);
		});
	}

	public JTextFieldCPFFormatterTest() {
		initComponents();
		pack();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		this.contentPane = new JPanel();
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.textField = new CPFTextField();
		this.textField.setColumns(10);
		this.contentPane.add(textField);
		
		this.button =  new JButton("validar");
		button.addActionListener(e -> {
			String text = textField.getText();
			if(text == null || text.trim().length() < 14){
				JOptionPane.showMessageDialog(null, "CPF preenchido incorretamente");
				textField.requestFocus();
			} else {
				JOptionPane.showMessageDialog(null, "CPF preenchido");
			}
		});
		this.contentPane.add(button);
		pack();
		setLocationRelativeTo(null);
	}
	
	class CPFTextField extends JTextField{
		
		boolean hasSeparatorAdded = false;
		
		public CPFTextField() {
			
			setDocument(new PlainDocument() {

			    @Override
			    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			    	
			        if (str == null || !Character.isDigit(str.charAt(0))) {
			            return;
			        }
	        		
	        		
			        if ((getLength() + str.length()) <= 14) {

			        	if(offset > 0 && offset < 9 && (offset+1)%4==0){
			        		hasSeparatorAdded = true;
			        		str = "." + str;
			        	} else if(offset > 0 && (offset+1)%12==0){
			        		hasSeparatorAdded = true;
			        		str = "-" + str;
			        	}
			     
			            super.insertString(offset, str, attr);
			        }
			    }
			});		
		}	
	}
}
