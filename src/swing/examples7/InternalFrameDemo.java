package swing.examples7;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class InternalFrameDemo extends JFrame {

	private JDesktopPane desktop;
	protected Dimension screenSize;

	public InternalFrameDemo() {
		super("InternalFrameDemo");

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		desktop = new JDesktopPane();
		MyInternalFrame internalFrame = new MyInternalFrame();
		internalFrame.setVisible(true);
		desktop.add(internalFrame);

		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Document");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(e -> dispose());
		menu.add(menuItem);
		setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(desktop);
		setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new InternalFrameDemo().setVisible(true));
	}

	class MyInternalFrame extends JInternalFrame {

		public MyInternalFrame() {
			super("My internalframe", true, // resizable
					true, // closable
					true, // maximizable
					true);// iconifiable

			setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			setSize(screenSize.width / 4, screenSize.height / 4);

			addInternalFrameListener(new InternalFrameAdapter() {

				@Override
				public void internalFrameClosing(InternalFrameEvent e) {

					int op = JOptionPane.showInternalConfirmDialog(getInstance(), "Quer mesmo fechar essa janela?", "Fechar Janela",
							JOptionPane.YES_NO_OPTION);

					if (op == JOptionPane.YES_OPTION) {
						dispose();
					}
				}
			});
		}
		
		private Component getInstance() {
			return this;
		}
	}
}
