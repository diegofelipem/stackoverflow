package swing.examples5;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class JsliderTest extends JFrame{
    public static JPanel pn = new JPanel();
    public static final int VelMin = 0;
    public static final int VelMax = 20;
    public static final int VelInit = 10;

    public static JSlider jsVelocidade= new JSlider(JSlider.HORIZONTAL, VelMin, VelMax, VelInit);

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
    	   new JsliderTest();
       });
    }

    public JsliderTest(){
        super("Semáforo");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pn.setPreferredSize(new Dimension(800,500));
       // pn.setLayout(null);

        jsVelocidade.setMajorTickSpacing(10);
        jsVelocidade.setMinorTickSpacing(1);
        jsVelocidade.setPaintTicks(true);
        jsVelocidade.setPaintLabels(true);

        pn.add(jsVelocidade);

        add(pn);
        pack();

        setVisible(true);
        setLocationRelativeTo(null);
    }    
}