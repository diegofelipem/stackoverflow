package questions.q162299_Menu_ocultavel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class TelaSistema extends JFrame implements ActionListener {

	public JDesktopPane jdp = new JDesktopPane();
	public JMenuBar jmb = new JMenuBar();
	public JMenu jmCadastros = new JMenu("Cadastros");
	public JMenuItem jmiEstado = new JMenuItem("Estado");
	JToolBar toolBar = new JToolBar();



	public TelaSistema() {

		Container contentPane = this.getContentPane();
		// contentPane.add(toolBar, BorderLayout.EAST);
		JLabel label = new JLabel("Configurações");

		toolBar.setFloatable(false);// não deixa ToolBar mudar de lugar.
		toolBar.add(label);
		toolBar.setBackground(new Color(230, 230, 230));
		
		JPanel barPanel = new ToolBarPanel(toolBar);

		contentPane.add(barPanel, BorderLayout.EAST);

		// setSize(800, 600);	
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Sistema");
		getContentPane().add(jdp);
		setJMenuBar(jmb);
		jmb.add(jmCadastros);
		adicionaJMenuItem(jmCadastros, jmiEstado);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void adicionaJMenuItem(JMenu menu, JMenuItem item) {
		menu.add(item);
		item.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

	}

	public static void main(String[] args) {
		TelaSistema tela = new TelaSistema();
	}

}