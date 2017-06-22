package swing.examples3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class TelaPrincipal extends JFrame {

	private JLabel label = new JLabel("Componente:");
	private MeuComponente comp = new MeuComponente();
	private JLabel label2 = new JLabel("JTextField:");
	JTextField jt = new JTextField();
	private JLabel label3 = new JLabel("JTextArea:");
	JTextArea area = new JTextArea();

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
			TelaPrincipal teste = new TelaPrincipal();
			teste.setVisible(true);
		});
	}

	public TelaPrincipal() {
		
		setTitle("Teste");
		getContentPane().add(montaTela());
		// setSize(150, 300);
		pack();
		setFocusInComponents(this.getContentPane());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JComponent montaTela() {

		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout());

		painel.add(label);
		painel.add(comp);

		painel.add(label2);
		painel.add(jt);
		jt.setPreferredSize(new Dimension(100, 20));

		painel.add(label3);
		painel.add(area);
		area.setPreferredSize(new Dimension(100, 100));

		return painel;
	}

	private void setFocusInComponents(Container container) {

		Component[] components = container.getComponents();

		for (Component comp : components) {

			if (comp instanceof Container) {
				setFocusInComponents((Container) comp);
			}

			comp.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					JComponent comp = (JComponent) e.getSource();

					comp.setBorder(new LineBorder(Color.GRAY));
					comp.setBackground(Color.WHITE);

				}

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					JComponent comp = (JComponent) e.getSource();

					comp.setBorder(new LineBorder(Color.RED));
					comp.setBackground(Color.LIGHT_GRAY);

				}
			});
		}
	}

}

class MeuComponente extends JPanel {

	public JTextField jt01 = new JTextField();
	public JTextField jt02 = new JTextField();

	public MeuComponente() {

		setLayout(new FlowLayout());
		add(jt01);
		jt01.setPreferredSize(new Dimension(70, 20));
		add(jt02);
		jt02.setPreferredSize(new Dimension(70, 20));
	}
}
