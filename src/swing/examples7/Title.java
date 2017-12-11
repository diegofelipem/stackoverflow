package swing.examples7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Title extends JPanel implements ActionListener{

    JLabel press_enter = new JLabel("Pressione ENTER para começar", JLabel.CENTER);
    Font font = new Font("arial", Font.BOLD, 32);

    public Title(){

//        setVisible(true);
//        setLocation (0,0);
        setSize( 800, 600 );
        setBackground(Color.WHITE);
        Timer t = new Timer(20, this);
        //t.start();
        press_enter.setAlignmentX(0);
        press_enter.setAlignmentY(0);
        //press_enter.setFont(font);
        press_enter.setBounds(130, 280, 200, 60);
        press_enter.setVisible(true);
        press_enter.setForeground(Color.BLACK);
        add(press_enter);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JFrame frame = new JFrame();
			Title title = new Title();
			frame.setSize(title.getSize());
			frame.add(title);
			frame.setVisible(true);
			
		});
	}
}
    