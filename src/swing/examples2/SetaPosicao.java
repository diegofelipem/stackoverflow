package swing.examples2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

public class SetaPosicao extends JFrame {

	private final JTextField campo = new JTextField();
	private final JFormattedTextField campo2 = new JFormattedTextField();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			SetaPosicao tela = new SetaPosicao();
			tela.setVisible(true);
		});
		
	}

	public SetaPosicao() {
		add(colocaCampo());
		setSize(500, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {
			MaskFormatter mf = new MaskFormatter("#####-###");
			mf.install(campo2);
		} catch (Exception e) {

		}
	}

	private JComponent colocaCampo() {
		
		JPanel painel = new JPanel();
		JLabel label = new JLabel("TextField");
		JLabel label2 = new JLabel("Formatted");

		campo.setPreferredSize(new Dimension(120, 22));
		
		campo.addFocusListener(new CaretPosition());
		campo2.addFocusListener(new CaretPosition());
		campo2.setPreferredSize(new Dimension(80, 22));

		painel.add(label);
		painel.add(campo);
		
		painel.add(label2);		
		painel.add(campo2);
		
		return painel;
	}

	class CaretPosition extends FocusAdapter{
		
		@Override
		public void focusGained(FocusEvent e) {
			
			JTextComponent comp = (JTextComponent) e.getSource();
			comp.setCaretPosition(0);
		}		
	} 
}