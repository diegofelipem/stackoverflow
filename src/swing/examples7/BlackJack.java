package swing.examples7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class BlackJack {

//    private static Intro intro = new Intro();
    private static Title title = new Title();

    public static void main(String[] args) {
        Display window = new Display();
        window.getContentPane().setBackground(Color.white);
//        window.add(intro);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        intro.setVisible(false);
//        window.remove(intro);
        window.add(title);
    }
}

class Display extends JFrame {

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Display(){
        setTitle("BlackJack");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
        setLayout(new GridLayout(1,1,0,0));
    }

}


class Title  extends JPanel implements ActionListener{

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
}
    