package questions;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MultipleFilterTest extends JFrame {

	TableRowSorter<TableModel> sorter;

	public MultipleFilterTest() {
		iniciarComponentes();

		TableModel model = tableServicosAbertos.getModel();
		sorter = new TableRowSorter<TableModel>(model);
		tableServicosAbertos.setRowSorter(sorter);

		btnAplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFilterInJTable();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sorter.setRowFilter(null);			
			}
		});

	}

	private void iniciarComponentes() {

		jScrollPane2 = new javax.swing.JScrollPane();
		tableServicosAbertos = new javax.swing.JTable();
		comboboxStatus = new javax.swing.JComboBox();
		lblCategoria = new javax.swing.JLabel();
		lblStatus = new javax.swing.JLabel();
		txtAbertura = new javax.swing.JFormattedTextField();
		lblAbertura = new javax.swing.JLabel();
		lblUsuario = new javax.swing.JLabel();
		lblResponsavel = new javax.swing.JLabel();
		txtUsuario = new javax.swing.JTextField();
		txtResponsavel = new javax.swing.JTextField();
		lblCliente = new javax.swing.JLabel();
		txtCliente = new javax.swing.JTextField();
		txtNumero = new javax.swing.JFormattedTextField();
		lblNumero = new javax.swing.JLabel();
		comboboxCategoria = new javax.swing.JComboBox();
		btnAplicar = new javax.swing.JButton();
		btnLimpar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("SiGS - Sistema de gerenciamento de serviços");
		setMinimumSize(new java.awt.Dimension(1366, 768));
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowActivated(java.awt.event.WindowEvent evt) {

			}
		});

		tableServicosAbertos.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { "OS20160214", "SAS", "Redes", "20/11/2016", "Max Vargas", "Max Vargas", "Aberto" },
						{ "OS20160242", "Multiserv", "Computadores", "15/07/2016", "Max Vargas", "Mateus Nascimento",
								"Fechado" },
						{ "OS20165851", "Telecom", "CFTV", "16/07/2016", "Max Vargas", "Fabio Oliv.", "Fechado" },
						{ null, null, null, null, null, null, null } },
				new String[] { "Numero", "Cliente", "Categoria", "Abertura", "Usuario", "Responável", "Status" }));
		jScrollPane2.setViewportView(tableServicosAbertos);

		comboboxStatus.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", "Aberto", "Fechado", "Cancelado", "Pausado" }));

		lblCategoria.setText("Categoria:");

		lblStatus.setText("Status:");

		lblAbertura.setText(" Abertura:");

		lblUsuario.setText("Usuário:");

		lblResponsavel.setText("Responsável:");

		lblCliente.setText("Cliente:");

		lblNumero.setText("Número:");

		comboboxCategoria.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { " ", "Computadores", "CFTV", "Redes", "Telefonia", "Outros" }));

		btnAplicar.setText("OK");

		btnLimpar.setText("Limpar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addGap(10, 10, 10).addComponent(lblStatus)
																		.addGap(15, 15, 15)
																		.addComponent(comboboxStatus,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				95,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(85, 85, 85).addComponent(lblResponsavel)
																		.addGap(5, 5, 5).addComponent(txtResponsavel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				153,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(layout
																		.createSequentialGroup()
																		.addGroup(layout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(layout.createSequentialGroup()
																						.addComponent(lblCategoria)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																						.addComponent(comboboxCategoria,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(104, 104, 104)
																						.addComponent(lblUsuario)
																						.addGap(10, 10, 10)
																						.addComponent(txtUsuario,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								152,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(layout
																						.createSequentialGroup()
																						.addComponent(lblAbertura)
																						.addGap(10, 10, 10)
																						.addComponent(txtAbertura,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								95,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(105, 105, 105)
																						.addComponent(lblCliente)
																						.addGap(13, 13, 13)
																						.addComponent(txtCliente,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								150,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(28, 28, 28)
																		.addGroup(layout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(layout.createSequentialGroup()
																						.addComponent(btnAplicar,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								60,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(btnLimpar))
																				.addGroup(layout.createSequentialGroup()
																						.addComponent(lblNumero)
																						.addGap(19, 19, 19)
																						.addComponent(txtNumero,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								95,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))))
														.addGap(78, 78, 78))
												.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(90, 90, 90).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblCategoria).addComponent(comboboxCategoria,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumero).addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(10, 10, 10)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblStatus)
								.addComponent(comboboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblResponsavel).addComponent(txtResponsavel,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblAbertura)
												.addComponent(txtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCliente).addComponent(txtCliente,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(46, 46, 46).addComponent(jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 76,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnAplicar).addComponent(btnLimpar))))
						.addContainerGap(241, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}

	protected void setFilterInJTable() {
		
		
		String 	numero = txtNumero.getText().trim(),
				cliente = txtCliente.getText().trim(),
				categoria = comboboxCategoria.getSelectedItem().toString().trim(),
				abertura = txtAbertura.getText().trim(),
				usuario = txtUsuario.getText().trim(), 
				responsavel = txtResponsavel.getText().trim(),
				status = comboboxStatus.getSelectedItem().toString().trim();

		//cria uma lista para guardar os filtros de cada coluna
		List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>();
		filters.add(RowFilter.regexFilter("(?i)" + numero, 0));
		filters.add(RowFilter.regexFilter("(?i)" + cliente, 1));
		filters.add(RowFilter.regexFilter(categoria, 2));
		filters.add(RowFilter.regexFilter("(?i)" + abertura, 3));
		filters.add(RowFilter.regexFilter("(?i)" + usuario, 4));
		filters.add(RowFilter.regexFilter("(?i)" + responsavel, 5));
		filters.add(RowFilter.regexFilter(status, 6));
		//aplica os filtros no RowSorter que foi criado no construtor
		//utilizando o andFilter
		sorter.setRowFilter(RowFilter.andFilter(filters));

	}

	public static void main(String[] args) {

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if (("nimbus").equalsIgnoreCase(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MultipleFilterTest().setVisible(true);

			}
		});
	}

	// Variaveis
	private javax.swing.JButton btnAplicar;
	private javax.swing.JButton btnLimpar;
	private javax.swing.JComboBox comboboxCategoria;
	private javax.swing.JComboBox comboboxStatus;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblAbertura;
	private javax.swing.JLabel lblCategoria;
	private javax.swing.JLabel lblCliente;
	private javax.swing.JLabel lblNumero;
	private javax.swing.JLabel lblResponsavel;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JLabel lblUsuario;
	private javax.swing.JTable tableServicosAbertos;
	private javax.swing.JFormattedTextField txtAbertura;
	private javax.swing.JTextField txtCliente;
	private javax.swing.JFormattedTextField txtNumero;
	private javax.swing.JTextField txtResponsavel;
	private javax.swing.JTextField txtUsuario;

}
