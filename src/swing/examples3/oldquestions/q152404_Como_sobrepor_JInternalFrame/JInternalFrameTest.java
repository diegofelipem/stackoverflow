package swing.examples3.oldquestions.q152404_Como_sobrepor_JInternalFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author diego.felipe
 */
public class JInternalFrameTest  {
    
    JFrame frame = new JFrame();

    public void createAndShowGUI() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Frame principal");
        frame.setSize(600, 500);

        JDesktopPane desk = new JDesktopPane();
        frame.setContentPane(desk);

        JInternalFrame mboxFrame = new JInternalFrame();
        JButton botao = new JButton("Chamar outra tela");
        botao.setSize(104, 104);

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyInternalFrame tela = new MyInternalFrame();
                desk.add(tela);
                tela.setVisible(true);
            }
        });

        mboxFrame.setContentPane(botao);
        mboxFrame.setSize(300, 200);
        mboxFrame.setLocation(50, 50);
        mboxFrame.setVisible(true);
        desk.add(mboxFrame);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    class MyInternalFrame extends JInternalFrame {

        public MyInternalFrame() {
            createGUI();
        }

        private void createGUI() {

            BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
            setLayout(boxLayout);
            setPreferredSize(new Dimension(300, 200));

            JLabel label = new JLabel("Label1");

            JTextField campo = new JTextField("campo de texto");
            add(label);
            add(campo);
            pack();
        }
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JInternalFrameTest test = new JInternalFrameTest();
                test.createAndShowGUI();
            }
        });
    }
}
