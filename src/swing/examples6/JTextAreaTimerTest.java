package swing.examples6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextAreaTimerTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btn;
	private JPanel pane;
	private JTextArea textArea;
	private volatile int index = 0;

	public JTextAreaTimerTest() {

		setPreferredSize(new Dimension(300, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = new JPanel(new BorderLayout(5, 5));
		pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(pane);

		pane.add(new JTextField(10), BorderLayout.NORTH);

		textArea = new JTextArea();
		pane.add(textArea, BorderLayout.CENTER);

		btn = new JButton("disparar");
		btn.addActionListener(e -> {

			CarroDAO dao1 = new CarroDAO();

			ArrayList<Carro> carros = dao1.listar();

			ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

			Runnable run = () -> {

				if (index < carros.size()) {
					SwingUtilities.invokeLater(() -> {
						textArea.append(String.valueOf("ID: " + carros.get(index).getId() + "\n"));
						textArea.append("Marca: " + carros.get(index).getMarca() + "\n");
						textArea.append("Modelo: " + carros.get(index).getModelo() + "\n");
						textArea.append("Cor: " + carros.get(index).getCor() + "\n");
						textArea.append("Placa: " + carros.get(index).getMarca() + "\n" + "\n");
						textArea.append("=================");
						index++;
					});
				} else {
					index = 0;
					ses.shutdown();
				}

			};
			ses.scheduleAtFixedRate(run, 0, 20, TimeUnit.SECONDS);

		});

		pane.add(btn, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(JTextAreaTimerTest::new);
	}

	class Carro {

		public String getModelo() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getCor() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getMarca() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	class CarroDAO {

		public ArrayList<Carro> listar() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
