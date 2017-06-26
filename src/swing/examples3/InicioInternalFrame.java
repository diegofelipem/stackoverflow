package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class InicioInternalFrame {

	JFrame frmTeczGerenciamento;
	static JLabel txtStatusDeConexao = new JLabel();
	JDesktopPane panel = new JDesktopPane();
	public JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioInternalFrame window = new InicioInternalFrame();
					window.frmTeczGerenciamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioInternalFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTeczGerenciamento = new JFrame();
		frmTeczGerenciamento.getContentPane().setMaximumSize(new Dimension(0, 0));
		frmTeczGerenciamento.getContentPane().setLocation(new Point(1280, 1024));
		frmTeczGerenciamento.getContentPane().setFocusTraversalKeysEnabled(false);
		frmTeczGerenciamento.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmTeczGerenciamento.getContentPane().setBackground(Color.WHITE);
		frmTeczGerenciamento.setTitle("Vers\u00E3o 1.0.8");
		frmTeczGerenciamento.setBounds(100, 100, 1280, 900);
		frmTeczGerenciamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar toolBar = new JToolBar();
		frmTeczGerenciamento.getContentPane().add(toolBar, BorderLayout.SOUTH);

		txtStatusDeConexao.setEnabled(true);
		txtStatusDeConexao.setText("Status de conex\u00E3o");
		toolBar.add(txtStatusDeConexao);

		JLabel lblNewLabel_2 = new JLabel(" TecZ Gerencial - TecZ Sistemas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		toolBar.add(lblNewLabel_2);

		panel.setBorder(UIManager.getBorder("List.cellNoFocusBorder"));
		panel.setBackground(new Color(176, 196, 222));
		frmTeczGerenciamento.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		desktopPane.setBounds(209, 0, 1227, 792);
		panel.add(desktopPane);

		JMenuBar menuBar = new JMenuBar();
		frmTeczGerenciamento.setJMenuBar(menuBar);

		JMenu mnModulosEmDesenvolvimento = new JMenu("PCP");
		mnModulosEmDesenvolvimento.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnModulosEmDesenvolvimento);

		JMenuItem mntmGerenciar = new JMenuItem("Gerenciar");
		mnModulosEmDesenvolvimento.add(mntmGerenciar);
		mntmGerenciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				GerenciarOrcamentos orcamento;
				orcamento = new GerenciarOrcamentos();
				desktopPane.add(orcamento);
				orcamento.setVisible(true);
			}
		});
		mntmGerenciar.setFont(new Font("Segoe UI", Font.BOLD, 12));
	}
}

/**
 * 
 * 
 * 
 * ############## CLASSE 
 * 
 * 
 */
class GerenciarOrcamentos extends JInternalFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarOrcamentos frame = new GerenciarOrcamentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenciarOrcamentos() {
		setResizable(false);
		setTitle("Gerenciar Or\u00E7amentos");

		setMaximizable(true);

		setBounds(100, 100, 956, 637);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel filtros = new JPanel();
		filtros.setBackground(new Color(214, 217, 223));
		filtros.setBounds(47, 0, 53, 21);
		contentPane.add(filtros);
		filtros.setLayout(null);
		String data = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

		JPanel detalhes_orcamentos = new JPanel();
		detalhes_orcamentos.setLayout(null);
		detalhes_orcamentos.setBackground(UIManager.getColor("ArrowButton.background"));
		detalhes_orcamentos.setBounds(47, 275, 144, 18);
		contentPane.add(detalhes_orcamentos);

		JPanel desc_item = new JPanel();
		desc_item.setLayout(null);
		desc_item.setBackground(UIManager.getColor("ArrowButton.background"));
		desc_item.setBounds(47, 458, 127, 27);
		contentPane.add(desc_item);

		JButton btnEmitirPedido = new JButton("Chamar JInternalFrame");
		btnEmitirPedido.setBounds(160, 107, 266, 42);
		contentPane.add(btnEmitirPedido);
		btnEmitirPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarOrcamento internalFrame;
				try {
					internalFrame = new EditarOrcamento();
					internalFrame.setClosable(true);
					internalFrame.setIconifiable(true);
					getParent().add(internalFrame);
					System.out.println("teste");
					internalFrame.setVisible(true);
				} catch (FileNotFoundException | ParseException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		
		btnEmitirPedido.setBackground(SystemColor.activeCaption);

		JLabel lblAoApertarO = new JLabel(
				"Ao apertar o bot\u00E3o, o JInternalFrame deve ser exibido no JDesktopPane da Classe Inicio");
		lblAoApertarO.setBounds(6, 75, 491, 27);
		contentPane.add(lblAoApertarO);

	}

}
/**
 * 
 * 
 * 
 * ############## CLASSE 
 * 
 * 
 */

class EditarOrcamento extends JInternalFrame {
	private JPanel contentPane;
	private static final int BUFFER_SIZE = 4096;
	String valorTotalRec = null;
	String id = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarOrcamento frame = new EditarOrcamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	public EditarOrcamento() throws FileNotFoundException, ParseException {
		setTitle("Editar Or\u00E7amento - Tratermik Metais");
		setMaximizable(true);

		setBounds(100, 100, 956, 637);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(568, 106, 372, 1);
		contentPane.add(separator_1);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		lblProduto.setBounds(100, 115, 83, 14);

	}

}