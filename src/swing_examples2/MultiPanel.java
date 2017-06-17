package swing_examples2;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

public class MultiPanel extends JFrame {

	private JPanel contentPane;
	private JPanel painelSuperior;
	private JPanel painelLabel;
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane;
	private JPanel painelTab;
	private JPanel painel1;
	private JPanel panel2;

	public static void main(String[] args) {
		EventQueue.invokeLater(() ->  {
			new MultiPanel().setVisible(true);
		});
	}


	public MultiPanel() {
		initComponents();
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//este painel será o container principal da tela
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(400, 250));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		painelSuperior = new JPanel();
		painelSuperior.setBorder(new TitledBorder( "Painel Superior"));
		contentPane.add(painelSuperior);
		
		painelLabel = new JPanel();
		painelLabel.setBorder(new TitledBorder("Painel do Label"));
		contentPane.add(painelLabel);
		
		lblNewLabel = new JLabel("New label");
		painelLabel.add(lblNewLabel);
		
		tabbedPane = new JTabbedPane();
		contentPane.add(tabbedPane);
		
		painelTab = new JPanel();
		tabbedPane.addTab("New tab", painelTab);
		//para que os paineis 1 e 2 fiquem alinhados horizontalmente
		painelTab.setLayout(new BoxLayout(painelTab, BoxLayout.X_AXIS));
		
		//paineis adicionados a aba do tabbedpane
		painel1 = new JPanel();
		painel1.setBorder(new TitledBorder("painel 1"));
		painelTab.add(painel1);
		
		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder("painel 2"));
		painelTab.add(panel2);
		pack();
	}
}
