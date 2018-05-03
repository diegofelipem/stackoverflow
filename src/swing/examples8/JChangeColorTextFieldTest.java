package swing.examples8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class JChangeColorTextFieldTest extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new JChangeColorTextFieldTest().setVisible(true));
	}

	public JChangeColorTextFieldTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(10);
		
        MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("##/##/####");
	        dateMask.install(formattedTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		formattedTextField.setInputVerifier(new InputVerifier() {

		    Color originalBackground;

		    @Override
		    public boolean verify(JComponent input) {

		        JFormattedTextField comp = (JFormattedTextField) input;
		        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		        
		        
		        try {
		        	LocalDate datafield = sdf.parse(comp.getText()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		        	
					return LocalDate.now().equals(datafield);
				} catch (ParseException e) {
					return false;
				}        
		    }

		    @Override
		    public boolean shouldYieldFocus(JComponent input) {

		        boolean isValid = verify(input);
		        JFormattedTextField comp = (JFormattedTextField) input;

		        if (!isValid) {
		        	originalBackground = originalBackground == null ? comp.getBackground(): originalBackground;
		        	comp.setBackground(Color.red);
		        } else {
		            if(originalBackground != null) {
		                input.setBackground(originalBackground);
		                originalBackground = null;
		            }
		        }
		        return isValid;
		    }
		});
		
		panel.add(formattedTextField);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	}

}
