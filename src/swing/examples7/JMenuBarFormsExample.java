package swing.examples7;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class JMenuBarFormsExample {
	
	public JMenuBarFormsExample() {
		
	    JFrame frame = new JFrame("JMenu example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();

	    JMenu fileMenu = new JMenu("File");
	    menuBar.add(fileMenu);

	    JMenuItem newMenuItem = new JMenuItem("New");
	    fileMenu.add(newMenuItem);

	    frame.getContentPane().add(menuBar, BorderLayout.NORTH);
	    frame.setPreferredSize(new Dimension(350, 250));
	    frame.pack();
	    frame.setVisible(true);
	}

  public static void main(final String args[]) {
	  SwingUtilities.invokeLater(JMenuBarFormsExample::new);
  }
}
