package swing.examples5;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class IdadeMaior extends JFrame {

	JLabel dataNascLabel = new JLabel("Data nascimento: ");
	JDateChooser dataNasc = new JDateChooser();
	JButton botao = new JButton("Calcular");

	public static void main(String[] args) {
		IdadeMaior idade = new IdadeMaior();
		idade.setVisible(true);
	}

	public IdadeMaior() {

		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout());

		painel.add(dataNascLabel);
		painel.add(dataNasc);
		dataNasc.setPreferredSize(new Dimension(105, 23));

		painel.add(botao);
		botao.setPreferredSize(new Dimension(90, 22));
		botao();
		add(painel);

		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void botao() {
		botao.addActionListener((ActionEvent e) -> {
			String msg;

			if (!testeData()) {
				msg = "Data invalida!";
				dataNasc.requestFocus();
			} else {
				msg = "Data valida!";
			}
			JOptionPane.showMessageDialog(null, msg);
		});

	}

	Date dataAtual = new Date();

	private boolean testeData() {
		// data não pode ser menor que 12

		boolean dataValida = false;

		Date dataNascimento = dataNasc.getDate();

		if (dataNascimento != null && dataNascimento.before(dataAtual)) {

			Calendar calendarA = new GregorianCalendar();
			Calendar calendarB = new GregorianCalendar();

			calendarA.setTime(dataAtual);
			calendarB.setTime(dataNascimento);

			int diferenca = calendarA.get(Calendar.YEAR) - calendarB.get(Calendar.YEAR);

			if (calendarA.get(Calendar.MONTH) < calendarB.get(Calendar.MONTH)
					|| calendarA.get(Calendar.MONTH) == calendarB.get(Calendar.MONTH)
							&& calendarA.get(Calendar.DAY_OF_MONTH) < calendarB.get(Calendar.DAY_OF_MONTH)) {
				diferenca--;
			}
			dataValida = diferenca >= 12 ? true : false;
		}

		return dataValida;
	}

}