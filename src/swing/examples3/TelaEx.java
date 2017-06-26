package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class TelaEx extends JFrame implements ActionListener {

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(() -> {
			TelaEx cl = new TelaEx();
			cl.setVisible(true);
		});
	}

	private JLabel label = new JLabel("Componente:");
	private MeuComponenteJP compe = new MeuComponenteJP();
	private JLabel label2 = new JLabel("JTextField:");
	private JTextField jt = new JTextField();
	private JButton jbHabilitar = new JButton("Habilitar");
	private JButton jbDesabilitar = new JButton("Desabilitar");
	public List<Cp> componentes = new ArrayList();

	public TelaEx() {
		setSize(500, 500);

		JPanel painelSuperior = new JPanel();
		painelSuperior.setBorder(BorderFactory.createTitledBorder(""));
		painelSuperior.add(jbHabilitar);
		jbHabilitar.addActionListener(this);
		painelSuperior.add(jbDesabilitar);
		jbDesabilitar.addActionListener(this);
		add(painelSuperior, BorderLayout.NORTH);

		JPanel painelInferior = new JPanel();
		painelInferior.setBorder(BorderFactory.createTitledBorder(""));
		painelInferior.add(label);
		painelInferior.add(compe);
		painelInferior.add(label2);
		painelInferior.add(jt);
		jt.setPreferredSize(new Dimension(100, 20));
		add(painelInferior, BorderLayout.SOUTH);
		setFocusInComponents(painelInferior);

		botaoHabilita();
		botaoDesabilita();
		habilita(false);
		customizaCampos(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void botaoHabilita() {
		jbHabilitar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				habilita(true);
			}
		});
	}

	public void botaoDesabilita() {
		jbDesabilitar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				habilita(false);
			}
		});
	}

	public void habilita(boolean status) {
		compe.setEnabled(status);
		jt.setEnabled(status);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void setFocusInComponents(Container container) {
		Component[] components = container.getComponents();

		for (Component comp : components) {
			if (comp instanceof Container) {
				setFocusInComponents((Container) comp);
			}

			comp.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					JComponent comp = (JComponent) e.getSource();
					comp.setBorder(new LineBorder(new Color(27, 145, 255)));
					comp.setBackground(new Color(255, 255, 255));
				}

				@Override
				public void focusGained(FocusEvent e) {
					JComponent comp = (JComponent) e.getSource();
					comp.setBorder(new LineBorder(new Color(2, 58, 255)));
					comp.setBackground(new Color(147, 200, 255));
				}
			});
		}
	}

	public void customizaCampos(boolean status) {
		for (int i = 0; i < componentes.size(); i++) {
			// Customizar campos.
			if (componentes.get(i).customiza() == true) {
				if (status == true) // Campo HABILITADO.
				{
					/*
					 * JComponent comp = null ; comp.setBorder(new
					 * LineBorder(new Color(2, 58, 255)));
					 * comp.setBackground(new Color(147, 200, 255));
					 */
					((JComponent) componentes.get(i)).setBorder(new LineBorder(new Color(27, 145, 255)));// 125,
																											// 191,
																											// 244
					((JComponent) componentes.get(i)).setBackground(new Color(255, 255, 255));
				} else // Campo DESABILITADO.
				{
					/*
					 * JComponent comp = null ; comp.setBorder(new
					 * LineBorder(new Color(192, 192, 192)));
					 * comp.setBackground(new Color(239, 239, 239));
					 */
					((JComponent) componentes.get(i)).setBorder(new LineBorder(new Color(192, 192, 192)));
					((JComponent) componentes.get(i)).setBackground(new Color(239, 239, 239));
					((JComponent) componentes.get(i)).setToolTipText("Campo desabilitado..");
				}
			} // Não customizar campos.
			else {
				((JComponent) componentes.get(i)).setBorder(new LineBorder(new Color(239, 239, 239)));
			}
		}
	}

}

class MeuComponenteJP extends JPanel implements Cp {

	public JTextField jt01 = new JTextField();
	public JTextField jt02 = new JTextField();

	public MeuComponenteJP() {
		setLayout(new FlowLayout());
		add(jt01);
		jt01.setPreferredSize(new Dimension(70, 20));
		add(jt02);
		jt02.setPreferredSize(new Dimension(70, 20));
	}

	@Override
	public boolean customiza() {
		return false;
	}

}

interface Cp {
	public boolean customiza();
}