package swing.examples4;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.NumberFormatter;

public class Peso extends JFrame {

	public static void main(String[] args) {
		Peso t = new Peso();
		t.setVisible(true);
	}

	CampoPeso peso = new CampoPeso();
	JPanel painel = new JPanel();

	public Peso() {
		JLabel label = new JLabel("Peso:");
		painel.add(label);
		painel.add(peso);
		add(painel);

		setSize(220, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class CampoPeso extends JFormattedTextField {

	public CampoPeso() {
		setColumns(5);

		setFormatterFactory(new AbstractFormatterFactory() {

			@Override
			public AbstractFormatter getFormatter(JFormattedTextField tf) {
				NumberFormat format = new DecimalFormat();
				format.setMinimumFractionDigits(2);
				format.setMaximumFractionDigits(2);
				format.setRoundingMode(RoundingMode.HALF_UP);
				NumberFormatter formatter = new NumberFormatter(format);
				formatter.setAllowsInvalid(false);
				formatter.setMinimum(0.00);
				formatter.setMaximum(999.99);
				return formatter;
			}

		});

	}

	// para pegar o valor
	public Float getValor() {
		return new Float(getText().replace(".", "").replace(",", "."));
	}

	// setar o valor
	public void setValor(Object valor) {
		setText(valor.toString());
	}
}