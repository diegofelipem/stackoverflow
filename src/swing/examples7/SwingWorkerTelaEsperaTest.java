package swing.examples7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SwingWorkerTelaEsperaTest {
	
	  public void genericMethod(){
	      JFrame frame = new JFrame("JFrame Example");
	      JPanel panel = new JPanel();
	      panel.setLayout(new FlowLayout());
	      JButton button =
	      button= new JButton(new AbstractAction("Botao") {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                WaitSplash wait;
	                wait = new WaitSplash();
	                wait.setVisible(true);
	                wait.requestFocus();
	                metodoQualquer();
	                wait.dispose();
	            }
	        });
	      panel.add(button);
	      frame.add(panel);
	      frame.setSize(300, 300);
	      frame.setVisible(true);
	    }

	  public void metodoQualquer(){
	      try {
	      Thread.sleep(10000);
	     } catch (Exception e) {}

	  }
	    public static void main(String s[]) {
	     new SwingWorkerTelaEsperaTest().genericMethod();
	    }
	}

class WaitSplash extends JFrame{
    public void showComponente() {
        JFrame frame =this;        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel jLabel = new JLabel();
        //jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/aguarde.gif")));
        panel.add(jLabel);
        panel.setBackground(new  Color( 221, 236, 239 ));
        frame.add(panel);
        frame.setSize(350, 121);
        frame.setUndecorated(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        centralizarComponente(frame);
    }
    public WaitSplash() throws HeadlessException {
        showComponente();
    }
    public void centralizarComponente(JFrame frame) {
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = frame.getSize();
        frame.setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }
    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}

