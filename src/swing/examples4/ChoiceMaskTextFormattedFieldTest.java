package swing.examples4;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ChoiceMaskTextFormattedFieldTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField fmtField;
	private JRadioButton radioButtonCNPJ;
	private JRadioButton radioButtonCPF;
	private MaskFormatter CNPJMask;
	private MaskFormatter CPFMask;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new ChoiceMaskTextFormattedFieldTest().setVisible(true);
		});
	}

	public ChoiceMaskTextFormattedFieldTest() {
		initComponents();
	}

	public void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(190, 250));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		fmtField = new JFormattedTextField();
		radioButtonCPF = new JRadioButton();

		radioButtonCNPJ = new JRadioButton();

		radioButtonCPF.setText("CPF");
		radioButtonCNPJ.setText("CNPJ");

		// adiciona os radiobuttons no groupbutton
		// pra que apenas um seja selecionavel
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioButtonCPF);
		radioGroup.add(radioButtonCNPJ);

		// cria as mascaras e já a deixa pronta pra uso
		try {
			CNPJMask = new MaskFormatter("##.###.###/####-##");
			CPFMask = new MaskFormatter("###.###.###-##");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		// adiciona um listener aos radiobuttons
		radioButtonCPF.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					fmtField.setValue(null);
					fmtField.setFormatterFactory(new DefaultFormatterFactory(CPFMask));
				}
			}
		});

		radioButtonCNPJ.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					fmtField.setValue(null);
					fmtField.setFormatterFactory(new DefaultFormatterFactory(CNPJMask));
				}
			}
		});

		contentPane.add(fmtField);
		contentPane.add(Box.createVerticalStrut(30));
		contentPane.add(radioButtonCPF);
		contentPane.add(radioButtonCNPJ);
		contentPane.add(Box.createVerticalStrut(100));
		pack();
	}
}
