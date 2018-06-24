package swing.examples8;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Yuri Sanford 
 */
public class Jogo extends JFrame{

//ImageIcon iconHomem = new ImageIcon(getClass().getResource("HomemAndando.gif"));
//ImageIcon iconCenario = new ImageIcon(getClass().getResource("2d3.png")); 


JLabel lHomem = new JLabel("homem");
JLabel lCenario = new JLabel("cenario");

//JLabel lHomem = new JLabel(iconHomem);
//JLabel lCenario = new JLabel(iconCenario);
int posHomemX = -150;
int posHomemY = 275;


public Jogo(){
    super("Projeto JogoRepassando");
    editaJanela();
    editarComponentes();
    addMovimento();
}
public void addMovimento(){
    addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyReleased(KeyEvent e) {
         posHomemY = 275;   
        }
        @Override

        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == 38) {
                posHomemY -= 100;
                if (posHomemY < 175) {
                    posHomemY = 275;
                }

            }
            if (e.getKeyCode() == 37) {
                posHomemX -= 20;
                if (posHomemX < -150) {
                    posHomemX = -150;
                }
            }
            if (e.getKeyCode() == 39) {
                posHomemX += 20;
                if(posHomemX > 860){
                    posHomemX = 860;
                }
            }


            lHomem.setBounds(posHomemX, posHomemY, 400, 400);

        }

    });

}
public void editarComponentes() {
    lHomem.setBounds(posHomemX, posHomemY, 400, 400);
    lCenario.setBounds(0, 0, 1200, 800);
}
public void editaJanela(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(1210, 700 );
    setLocationRelativeTo(null);
    setLayout(null);
    add(lHomem);
    add(lCenario);
}

public static void main(String[] args) {
    new Jogo();
}

}