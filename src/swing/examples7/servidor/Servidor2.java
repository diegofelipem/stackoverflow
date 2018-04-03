package swing.examples7.servidor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Servidor2 {

	public static void main(String[] args) throws IOException {

		new Servidor2();
	}

	ServerSocket servidor;
	ObjectOutputStream resultado;
	ObjectInputStream dados;

	double num1, num2, total = 0.0;
	int operacao;
	char opr = '\n';

	public Servidor2() throws IOException {

		JFrame f = new JFrame();

		JTextField texto = new JTextField(5);
		texto.setEditable(false);
		JButton start = new JButton("Ligar Servidor");
		JButton stop = new JButton("Parar Servidor");

		f.add(texto);
		f.add(start);
		f.add(stop);
		f.setLayout(new GridLayout(3, 3));

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texto.setText("servidor inciado!!");
				final Multi3 m1 = new Multi3();
				final Thread t1 = new Thread(m1);

				t1.start();
			}
		});

		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					texto.setText("servidor desligado");
					servidor.close();
					// t1.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		f.setVisible(true);
		f.pack();

	}

}

class Multi3 implements Runnable {
	public void run() {
		System.out.println("thread is running...");
		double num1, num2, total = 0.0;
		int operacao;
		char opr = '\n';

		// Cria um socket na porta 12342
		ServerSocket servidor;

		try {
			servidor = new ServerSocket(22);
			System.out.println("Porta " + servidor.getLocalPort() + " aberta!");

			// Aguarda alguém se conectar. A execução do servidor
			// fica bloqueada na chamada do método accept da classe
			// ServerSocket. Quando alguém se conectar ao servidor, o
			// método desbloqueia e retorna com um objeto da classe
			// Socket, que é uma porta da comunicação.

			System.out.print("Aguardando conexão do cliente...");
			Socket cliente = servidor.accept();

			System.out.println(
					"\nNova conexao com o cliente " + cliente.getInetAddress().getHostAddress() + cliente.toString());

			ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

			operacao = dados.readInt();
			num1 = dados.readDouble();
			num2 = dados.readDouble();

			switch (operacao) {
			case 1:
				opr = '+';
				total = (num1 + num2);

				resultado.writeDouble(total);
				resultado.writeChar(opr);
				resultado.flush();
				break;

			case 2:
				opr = '-';
				total = (num1 - num2);

				resultado.writeDouble(total);
				resultado.writeChar(opr);
				resultado.flush();
				break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
