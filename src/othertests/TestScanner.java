package othertests;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestScanner {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String resposta = "";
		
		resposta = input.next();
		
		if (resposta.equals("goku")) {
			JOptionPane.showMessageDialog(null, "Correto");

		} else {
			JOptionPane.showMessageDialog(null, "Errado");
		}

		resposta = input.next();

		if (resposta.equals("arroz")) {
			JOptionPane.showMessageDialog(null, ":D");
		}

	}
}
