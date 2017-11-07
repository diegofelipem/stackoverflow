package swing.examples6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class JMenuBarDisableHoverTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu FileMenu;
	private JMenu EditMenu;
	private JMenuItem mi_open;
	private JMenuItem mi_save;
	private JMenuItem mi_cut;
	private JMenuItem mi_copy;
	private JPanel panel;
	private JButton btn;

	public static void main(String args[]) {	

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if (info.getName().equalsIgnoreCase("Nimbus")) {
				try {

					UIManager.put("MenuItem.selectionBackground", UIManager.getColor("MenuItem.background"));
					UIManager.put("MenuItem.selectionForeground", UIManager.getColor("MenuItem.foreground"));
//					UIManager.put("MenuItem.borderPainted", false);
//					System.out.println(UIManager.getLookAndFeel());

					UIManager.setLookAndFeel(info.getClassName());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}


		EventQueue.invokeLater(() -> new JMenuBarDisableHoverTest().setVisible(true));
	}

	public JMenuBarDisableHoverTest() {

		initComponents();
		pack();
		setLocationRelativeTo(null);
		
		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.NORTH);
		
		this.btn = new JButton("New button");
		this.btn.setRolloverEnabled(false);
		this.panel.add(this.btn);
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));

		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);

		this.FileMenu = new JMenu("File");
		this.menuBar.add(this.FileMenu);

		this.mi_open = new JMenuItem("Open...");
		this.FileMenu.add(this.mi_open);

		this.mi_save = new JMenuItem("Save");
		this.FileMenu.add(this.mi_save);

		this.EditMenu = new JMenu("Edit");
		this.menuBar.add(this.EditMenu);

		this.mi_copy = new JMenuItem("Copy");
		this.EditMenu.add(this.mi_copy);

		this.mi_cut = new JMenuItem("Cut");
		this.EditMenu.add(this.mi_cut);
	}
}