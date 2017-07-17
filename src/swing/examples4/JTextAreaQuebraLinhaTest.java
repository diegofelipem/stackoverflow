package swing.examples4;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaQuebraLinhaTest extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new JTextAreaQuebraLinhaTest().setVisible(true);
		});
	}

	public JTextAreaQuebraLinhaTest() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));

		this.contentPane = new JPanel();
		this.contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(this.contentPane);

		this.textArea = new JTextArea(5, 15);
		// quebra a linha ao chegar no limite
		// da textarea
		this.textArea.setLineWrap(true);
		// define a quebra de linha sem quebrar
		// a palavra no final da linha, caso
		// nao caiba inteira
		this.textArea.setWrapStyleWord(true);

		this.scrollPane = new JScrollPane(this.textArea);
		this.contentPane.add(this.scrollPane);
		
		pack();
		setLocationRelativeTo(null);
	}
}
