package swing.examples7.servidor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cliente2 {
	public Socket cliente;
	double num1;
	double num2;
	int operacao = 0;
	char opr;

	JTextField texto1 = new JTextField(5);
	JTextField texto2 = new JTextField(5);

	public static void main(String[] args) {

		new Cliente2();

	}

	public Cliente2() {

		JFrame f = new JFrame();

		JButton connect = new JButton("Conectar");
		JButton stop = new JButton("sair");

		JButton sum = new JButton("+");
		JButton minus = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");

		f.add(connect);
		f.add(stop);
		f.add(texto1);
		f.add(texto2);
		f.add(sum);
		f.add(minus);
		f.add(multiply);
		f.add(divide);

		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cliente = new Socket("127.0.0.1", 22);
					System.out.println("O cliente conectou ao servidor");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * try {
				 * 
				 * System.out.println(cliente.isConnected());
				 * 
				 * ObjectInputStream resultado = new
				 * ObjectInputStream(cliente.getInputStream());
				 * 
				 * ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());
				 * 
				 * 
				 * num1 = Double.parseDouble(texto1.getText()); num2 =
				 * Double.parseDouble(texto2.getText());
				 * 
				 * 
				 * 
				 * dados.writeInt(1); dados.writeDouble(num1); dados.writeDouble(num2);
				 * dados.flush();
				 * 
				 * double total = resultado.readDouble(); opr = resultado.readChar(); boolean
				 * check = true;
				 * 
				 * 
				 * 
				 * System.out.println("Total de " + num1 + opr + num2 + " = " + total +
				 * " is closed:::: " + cliente.isClosed() + " ?? Is Connected " +
				 * cliente.isConnected());
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * resultado.close(); dados.close();
				 * 
				 * 
				 * 
				 * 
				 * } catch (Exception e1) { e1.printStackTrace(); }
				 */

				Client result = new Client();
				result.run();

			}

		});

		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					System.out.println(cliente.isConnected());

					ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());

					ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

					num1 = Double.parseDouble(texto1.getText());
					num2 = Double.parseDouble(texto2.getText());
					/*
					 * while (!((operacao >= 1) && (operacao <= 4))) { operacao =
					 * Integer.parseInt(JOptionPane.
					 * showInputDialog("Qual operação desejada? 1= +, 2= -,3= X,4= / ")); if
					 * (!((operacao >= 1) && (operacao <= 4))) {
					 * System.out.println("Você digitou uma operação inválida."); } }
					 */

					dados.writeInt(1);
					dados.writeDouble(num1);
					dados.writeDouble(num2);
					dados.flush();

					double total = resultado.readDouble();
					opr = resultado.readChar();
					boolean check = true;

					System.out.println("Total de " + num1 + opr + num2 + " = " + total + " is closed:::: "
							+ cliente.isClosed() + " ?? Is Connected " + cliente.isConnected());

					resultado.close();
					dados.close();

					// cliente.close();

					// cliente.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		f.setLayout(new GridLayout(3, 3));

		f.setVisible(true);
		f.pack();

	}

	/*************************************************/
	class Client extends Thread {
		public void run() {

			System.out.println(cliente.isClosed());

			ObjectInputStream resultado;
			ObjectOutputStream dados;
			try {
				resultado = new ObjectInputStream(cliente.getInputStream());
				dados = new ObjectOutputStream(cliente.getOutputStream());

				num1 = Double.parseDouble(texto1.getText());
				num2 = Double.parseDouble(texto2.getText());
				/*
				 * while (!((operacao >= 1) && (operacao <= 4))) { operacao =
				 * Integer.parseInt(JOptionPane.
				 * showInputDialog("Qual operação desejada? 1= +, 2= -,3= X,4= / ")); if
				 * (!((operacao >= 1) && (operacao <= 4))) {
				 * System.out.println("Você digitou uma operação inválida."); } }
				 */

				dados.writeInt(1);
				dados.writeDouble(num1);
				dados.writeDouble(num2);
				dados.flush();

				double total = resultado.readDouble();
				opr = resultado.readChar();
				boolean check = true;

				System.out.println("Total de " + num1 + opr + num2 + " = " + total + " is closed:::: "
						+ cliente.isClosed() + " ?? Is Connected " + cliente.isConnected());
				
				System.out.println("1 " + cliente.isClosed());
				
				resultado.close();
				
				System.out.println("2 " + cliente.isClosed());
				
				dados.close();
				
				System.out.println("3 " + cliente.isClosed());

				// resultado.close();
				// dados.close();

				// cliente.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*********************************************/

}
