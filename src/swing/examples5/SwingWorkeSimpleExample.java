package swing.examples5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class SwingWorkeSimpleExample extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel northPanel;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JProgressBar progressBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(SwingWorkeSimpleExample::new);
	}

	public SwingWorkeSimpleExample() {
		setTitle("SwingWorker Test");
		initComponents();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(350, 300));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		this.contentPane.add(this.northPanel, BorderLayout.NORTH);

		this.btnSearch = new JButton("Search...");
		this.btnSearch.addActionListener(new ActionWorker());
		this.northPanel.add(this.btnSearch);

		this.textArea = new JTextArea();
		this.textArea.setBackground(Color.BLACK);
		this.textArea.setForeground(Color.WHITE);

		this.scrollPane = new JScrollPane(this.textArea);
		this.scrollPane.setBorder(new EmptyBorder(2, 0, 2, 0));
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);

		this.progressBar = new JProgressBar(0, 10);
		this.contentPane.add(this.progressBar, BorderLayout.SOUTH);
	}

	private void textAreaAppend(String str) {
		this.textArea.append(str + System.lineSeparator());
	}

	class ActionWorker implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

				@Override
				protected Void doInBackground() throws Exception {
					//aqui tudo ocorrerá em paralelo a gui
					//desativo o botão, adiciono uma mensagem inicial
					btnSearch.setEnabled(false);
					textAreaAppend("Searching...");
					//laço que alimenta a barra de progresso apenas para exemplo
					for (int i = 0; i < progressBar.getMaximum(); i++) {

						if (i > 0 && i % 4 == 0)
							textAreaAppend("Wait...");
						Thread.sleep(500);
						//esse metodo "publica" atualizações da tarefa
						//para a que a barra de progresso seja alimentada
						//conforme o incremento do laço
						publish(i);
					}

					textAreaAppend("Done!");
					return null;
				}

				@Override
				protected void process(List<Integer> chunks) {
					//este métodor recebe o que foi "publicado"
					// no doInBackground para que possamos atualizar
					//o progresso na tela
					progressBar.setValue(chunks.stream().reduce(Integer::sum).orElse(0));
				}

				@Override
				protected void done() {
					//entrará aqui quando terminar a tarefa, ou
					//ocorrer alguma exceção
					progressBar.setValue(0);
					btnSearch.setEnabled(true);
				}
			};
			worker.execute();
		}
	}
}
