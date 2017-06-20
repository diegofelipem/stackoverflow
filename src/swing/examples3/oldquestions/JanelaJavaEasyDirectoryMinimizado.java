package swing.examples3.oldquestions;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javax.swing.JSeparator;

public class JanelaJavaEasyDirectoryMinimizado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JanelaJavaEasyDirectoryMinimizado frame = new JanelaJavaEasyDirectoryMinimizado();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaJavaEasyDirectoryMinimizado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Abaixo é para adicionar um novo diretório ao comboBox
		JLabel lblDiretorio = new JLabel("Diretório:");
		lblDiretorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiretorio.setBounds(59, 40, 68, 14);
		contentPane.add(lblDiretorio);

		JTextField campoNovoDiretorio = new JTextField();
		campoNovoDiretorio.setBounds(144, 38, 264, 20);
		contentPane.add(campoNovoDiretorio);
		campoNovoDiretorio.setColumns(10);

		JButton btnAddDiretorio = new JButton("Adicionar diretório");
		btnAddDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String novoDiretorio = campoNovoDiretorio.getText();

				JComboBox campoDiretorio = SingletonComboDiretorio.getInstance();
				DefaultComboBoxModel model = (DefaultComboBoxModel) campoDiretorio.getModel();

				if (novoDiretorio.isEmpty())
					JOptionPane.showMessageDialog(null, "Nome do diretório não pode ser em branco!");
				else if (model.getIndexOf(novoDiretorio) != -1) {
					JOptionPane.showMessageDialog(null, "Diretório ja existe, adicione outro!");
				} else {
					campoDiretorio.addItem(novoDiretorio);
					JOptionPane.showMessageDialog(null, "Diretório adicionado à lista:\n " + novoDiretorio, "Mensagem",
							1);
				}
			}
		});
		btnAddDiretorio.setBounds(143, 68, 264, 25);
		contentPane.add(btnAddDiretorio);

		// Abaixo é área para poder selecionar o diretório que contém no
		// comboBox e o nome da pasta.
		JLabel lblDiretrio = new JLabel("Diret\u00F3rio:");
		lblDiretrio.setToolTipText("Selecione um diret\u00F3rio.");
		lblDiretrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiretrio.setBounds(59, 140, 68, 14);
		contentPane.add(lblDiretrio);

		JComboBox campoDiretorio = SingletonComboDiretorio.getInstance();
		campoDiretorio.setModel(new DefaultComboBoxModel(new String[] { "Sem diretório" }));
		campoDiretorio.setBounds(144, 140, 264, 20);
		contentPane.add(campoDiretorio);

		JLabel lblNomeDoArquivo = new JLabel("Nome da pasta:");
		lblNomeDoArquivo.setToolTipText("Insira o nome da pasta que deseja criar.");
		lblNomeDoArquivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoArquivo.setBounds(15, 170, 112, 14);
		contentPane.add(lblNomeDoArquivo);

		JTextField campoNomeDoArquivo = new JTextField();
		campoNomeDoArquivo.setBounds(144, 170, 264, 20);
		contentPane.add(campoNomeDoArquivo);
		campoNomeDoArquivo.setColumns(10);

		JButton btnCriarDiretrio = new JButton("Criar diret\u00F3rio");
		btnCriarDiretrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomeDirDesejado = (String) campoDiretorio.getSelectedItem();

				String nomePasta = campoNomeDoArquivo.getText();

				File novaPasta = new File(nomeDirDesejado, nomePasta);
				novaPasta.mkdir();

				if (nomePasta.isEmpty())
					throw new IllegalArgumentException();
				else
					JOptionPane.showMessageDialog(null, "Diretório criado em:\n" + nomeDirDesejado + "\\" + nomePasta,
							"Mensagem", 1);

			}
		});
		btnCriarDiretrio.setBounds(150, 200, 126, 23);
		contentPane.add(btnCriarDiretrio);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 115, 434, 14);
		contentPane.add(separator);

		JLabel lblRenanNarciso = new JLabel("Renan Narciso - 2017");
		lblRenanNarciso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRenanNarciso.setBounds(144, 244, 155, 14);
		contentPane.add(lblRenanNarciso);

	}
}

// Classe criada sob o padrão de projeto Singleton para poder usar um JComboBox
// estatático.
class SingletonComboDiretorio {

	private static JComboBox compoDiretorio;

	private SingletonComboDiretorio() {

	}

	public static synchronized JComboBox getInstance() {
		if (compoDiretorio == null) {
			compoDiretorio = new JComboBox();
		}
		return compoDiretorio;
	}
}