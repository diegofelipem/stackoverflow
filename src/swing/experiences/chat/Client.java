package swing.experiences.chat;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Client extends JFrame implements ActionListener, Runnable {
	List list;
	JTextArea text;
	JButton btnExit;
	JButton btnSend;
	Socket s;
	BufferedReader br;
	BufferedWriter bw;

	public Client() {
		setTitle("Secret Chat - Client");
		getContentPane().setLayout(null);

		list = new List();
		list.setBounds(10, 47, 692, 275);
		getContentPane().add(list);

		text = new JTextArea();
		text.setLineWrap(true);
		text.setBounds(10, 338, 692, 74);
		getContentPane().add(text);

		btnExit = new JButton("Exit");
		btnExit.setBounds(613, 11, 89, 23);
		btnExit.addActionListener(this);
		getContentPane().add(btnExit);

		btnSend = new JButton("Send");
		btnSend.setBounds(613, 423, 89, 23);
		btnSend.addActionListener(this);
		getContentPane().add(btnSend);

		setSize(741, 495);
		setLocation(300, 0);

		setVisible(true);

		try {
			/*
			 * Put the current IP address for current machine if you didn't have an actual
			 * server and clients if you have an actual server and clients put the client IP
			 * address
			 */
			s = new Socket("localhost", 8375); // é aqui onde coloco o IP do servidor
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("... Um usuário anônimo se conectou! ...");
			bw.newLine();
			bw.flush();
			Thread th;
			th = new Thread(this);
			th.start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception {
		new Client();

	}

	@Override
	public void run() {
		try {
			s.setSoTimeout(2500);
		} catch (Exception e) {
			System.out.println("Exceção: " + e);
			e.printStackTrace();
		}

		while (true) {
			try {
				list.add(br.readLine());
			} catch (Exception e) {
				System.out.println("Exceção: " + e);
				e.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnExit))
			System.exit(0);
		else {
			try {
				list.add("Eu (Cliente): " + text.getText());
				bw.write("Anônimo: " + text.getText());
				bw.newLine();
				bw.flush();
				text.setText("");
			} catch (Exception ex) {
				// System.out.println("Exceção: " + ex);
				ex.printStackTrace();
			}
		}

	}
}