package swing.examples5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;

public class JRadioButtonTest {
	
	public JRadioButtonTest() {

        /*cria o layout e a janela */
        JFrame frame = new JFrame("Prototipo10");
        JPanel panel = new JPanel(new GridBagLayout());


        /*Cria os Radio Butons*/
        GridBagConstraints gbc9 = new GridBagConstraints();
        gbc9.anchor = GridBagConstraints.WEST;
        gbc9.gridx = 1;
        gbc9.gridy = 7;
        JRadioButton radMasc = new JRadioButton("Radio1");
        radMasc.setForeground(Color.BLUE);

        GridBagConstraints gbc10 = new GridBagConstraints();
        gbc10.anchor = GridBagConstraints.WEST;
        gbc10.gridx = 1;
        gbc10.gridy = 8;
        JRadioButton radFem = new JRadioButton("Radio2");
        radFem.setForeground(Color.BLUE);

        ButtonGroup grubut = new ButtonGroup();
        grubut.add(radMasc);
        grubut.add(radFem);
        panel.add(radMasc, gbc9);
        panel.add(radFem, gbc10);
        
        radFem.addActionListener(new RadioButtonListener());
        radMasc.addActionListener(new RadioButtonListener());
        


        /*Configurações da janela*/
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(250, 250);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new JRadioButtonTest());
    }
    
    class RadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton radio = (JRadioButton) e.getSource();
			System.out.println(radio.getActionCommand());
			
		}
    	
    }
}