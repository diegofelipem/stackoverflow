package swing.experiences.chat;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Server extends JFrame implements ActionListener, Runnable {
	ServerSocket ss;
	Socket s;
	BufferedReader br;
	BufferedWriter bw;
	List list;
	JButton btnExit;
	JTextArea text;
	JButton btnSend;

	public Server() {
		setTitle("Secret Chat - Server");
		setSize(741, 495);
		setLocation(300, 0);
		getContentPane().setLayout(null);

		list = new List();
		list.setBounds(10, 48, 692, 275);
		getContentPane().add(list);

		btnExit = new JButton("Exit");
		btnExit.setBounds(613, 11, 89, 23);
		getContentPane().add(btnExit);
		btnExit.addActionListener(this);

		text = new JTextArea();
		text.setForeground(UIManager.getColor("ToggleButton.focus"));
		text.setLineWrap(true);
		text.setBounds(10, 338, 692, 74);
		getContentPane().add(text);

		btnSend = new JButton("Send");
		btnSend.setBounds(613, 423, 89, 23);
		getContentPane().add(btnSend);
		btnSend.addActionListener(this);

		setVisible(true);

		try {
			list.add("Aguardando conexão de cliente...\n");

			ss = new ServerSocket(8375);

			s = ss.accept();
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("... Você está conectado! ...");
			bw.newLine();
			bw.flush();
			Thread th;
			th = new Thread(this);
			th.start();
		} catch (Exception e) {
			// System.out.println("Exceção: " + e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		 new Server();

	}

	@Override
	public void run() {
		try {
			s.setSoTimeout(1);
		} catch (Exception e) {
			System.out.println("Exceção: " + e);
		}
		while (true) {
			try {
				list.add(br.readLine());
			} catch (Exception ex) {
				// System.out.println("Exceção: " + ex);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnExit))
			System.exit(0);
		else {
			try {
				list.add("Eu (Servidor): " + text.getText());
				bw.write("Patty " + text.getText());
				bw.newLine();
				bw.flush();
				text.setText("");
			} catch (Exception m) {
			}
		}

	}
}