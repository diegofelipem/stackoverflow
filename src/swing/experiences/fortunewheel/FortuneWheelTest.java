package swing.experiences.fortunewheel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class FortuneWheelTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton spinButton;
	private Board board;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(() -> new FortuneWheelTest().setVisible(true));
	}

	public FortuneWheelTest() {
		initComponents();
	}

	private void initComponents() {
		
		setTitle("Fortune Wheel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 300));
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		board = new Board();

		contentPane.add(board, BorderLayout.CENTER);

		JPanel controlsPane = new JPanel(new GridLayout(0, 1, 0, 0));
		controlsPane.setBorder(new EmptyBorder(5, 1, 1, 1));

		spinButton = new JButton("Spin!");
		spinButton.addActionListener(e -> girar());
		spinButton.setFocusable(false);

		controlsPane.add(spinButton);

		contentPane.add(controlsPane, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
	
    // Medidas em graus por segundo.
    private static final double VELOCIDADE_ANGULAR_INICIAL_MINIMA = 180;
    private static final double VELOCIDADE_ANGULAR_INICIAL_MAXIMA = 720;

    // Unidade de aceleração, medido em graus por segundo a cada segundo.
    private static final double ATRITO = -50;

    // Tempo entre ticks, em MICROsegundos.
    // Quanto menor for, mais preciso fica, porém mais custoso será.
    private static final int MICRO_DELTA_T = 10_000;

    // Tempo entre ticks, em segundos.
    private static final double DELTA_T = MICRO_DELTA_T / 1_000_000.0;

    private void girar() {
    	spinButton.setEnabled(false);

        SwingWorker<Void, Double> worker = new SwingWorker<Void, Double>() {
            @Override
            protected Void doInBackground() {

                ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

                // Sorteia a velocidade inicial da roleta em graus por segundo.
                double velocidadeInicial =
                        Math.random() * (VELOCIDADE_ANGULAR_INICIAL_MAXIMA - VELOCIDADE_ANGULAR_INICIAL_MINIMA)
                        + VELOCIDADE_ANGULAR_INICIAL_MINIMA;

                // Armazena a velocidade angular atual em graus por segundo.
                AtomicReference<Double> vref = new AtomicReference<>(velocidadeInicial);

                Runnable run = () -> {
                    // Obtém a velocidade angular atual.
                    double velocidadeAngular = vref.get();

                    // Publica no SwingWorker a distância angular percorrida.
                    // Obs: Velocidade * tempo = distância (deg/s * s = deg)
                    publish(velocidadeAngular * DELTA_T);

                    // Aplica o atrito para reduzir a velocidade.
                    // Obs: Aceleração * tempo = velocidade (deg/s² * s = deg/s)
                    double velocidadeAngularNova = velocidadeAngular + ATRITO * DELTA_T;
                    vref.set(velocidadeAngularNova);

                    // Se parou, termina.
                    if (isCancelled() || velocidadeAngularNova <= 0.0) ses.shutdown();
                };

                ses.scheduleAtFixedRate(run, 0, MICRO_DELTA_T, TimeUnit.MICROSECONDS);
                try {
                    ses.awaitTermination(99999, TimeUnit.DAYS);
                } catch (InterruptedException e) {
                    // Ignora a exceção e deixa o SwingWorker terminar graciosamente.
                }
                return null;
            }

            @Override
            protected void process(List<Double> doubles) {
                double distanciaAngular = doubles.stream().reduce(Double::sum).orElse(0.0);
                board.spin(distanciaAngular);
            }

            @Override
            protected void done() {
            	spinButton.setEnabled(true);
            }
        };
        worker.execute();
    }
}
