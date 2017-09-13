package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NextFocusTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField firstComp;
	private JComboBox<String> thirdComp;
	private JTextField secondComp;
	private JButton fourthComp;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			NextFocusTest frame = new NextFocusTest();
			frame.setVisible(true);
		});
	}

	public NextFocusTest() {

		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 200));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panel = new JPanel();
		this.panel.setBorder(new EmptyBorder(0, 20, 0, 20));
		this.panel.setLayout(new GridLayout(2, 2, 20, 5));
		this.contentPane.add(this.panel, BorderLayout.NORTH);

		this.firstComp = new JTextField();
		this.firstComp.setPreferredSize(new Dimension(100, 20));
		this.panel.add(this.firstComp);

		this.thirdComp = new JComboBox<String>();
		this.thirdComp.setModel(new DefaultComboBoxModel<String>(new String[] { "teste 1", "teste 2", "teste 3" }));
		this.thirdComp.setPreferredSize(new Dimension(100, 20));
		this.panel.add(this.thirdComp);

		this.secondComp = new JTextField();
		this.secondComp.setPreferredSize(new Dimension(100, 20));
		this.panel.add(this.secondComp);

		this.fourthComp = new JButton("OK");
		this.fourthComp.setPreferredSize(new Dimension(90, 23));
		this.panel.add(this.fourthComp);
		
		ArrayList<Component> focusList = new ArrayList<>();
		focusList.add(firstComp);
		focusList.add(secondComp);
		focusList.add(thirdComp);
		focusList.add(fourthComp);

		pack();
		
		setFocusTraversalPolicy(new PoliticaFoco(focusList));
		setLocationRelativeTo(null);
	}

	class PoliticaFoco extends FocusTraversalPolicy {

		protected final List<Component> componentes;
		private int focado = 0;

		public PoliticaFoco(List<Component> components) {
			this.componentes = components;
		}

		@Override
		public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
			this.focado = (this.focado + 1) % this.componentes.size();

			return this.componentes.get(focado);
		}

		@Override
		public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
			this.focado = (this.componentes.size() + this.focado - 1) % this.componentes.size();

			return this.componentes.get(focado);
		}

		@Override
		public Component getDefaultComponent(Container focusCycleRoot) {
			return this.componentes.get(0);
		}

		@Override
		public Component getLastComponent(Container focusCycleRoot) {
			return this.componentes.get(this.componentes.size() - 1);
		}

		@Override
		public Component getFirstComponent(Container focusCycleRoot) {
			return this.componentes.get(0);
		}
	}
}
