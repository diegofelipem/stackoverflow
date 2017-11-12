package swing.examples6;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaFrame extends JFrame {

	   private JPanel contentPane;
	   
	   public static void main(String[] args) {
		   SwingUtilities.invokeLater(() -> new TelaFrame().setVisible(true));
	   }

	   public TelaFrame() {
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(100, 100, 450, 300);
	      contentPane = new JPanel();
	      contentPane.setLayout(null);
	      setContentPane(contentPane);

	      JDesktopPane desktopPane = new JDesktopPane();
	      desktopPane.setBounds(10, 11, 414, 239);
	      contentPane.add(desktopPane);

	            TelaInterna tf = new TelaInterna();
	            tf.setVisible(true);
	            desktopPane.add(tf);
	   }
	}

	 class TelaInterna extends JInternalFrame {
	   public TelaInterna() {
	      setBounds(100, 100, 289, 157);
	   }
	}
