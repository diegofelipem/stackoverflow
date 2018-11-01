package swing.examples9;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class JTableApagarLinhas extends JFrame {
	// MAIN METHOD
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// INITIALIZE JFRAME FORM
				JTableApagarLinhas form = new JTableApagarLinhas();
				form.setVisible(true);
			}
		});

	}

	private JTextField txtId;

	TesteTableModel tableModel = new TesteTableModel();
	private final JTable table;

	// CONSTRUCTOR
	public JTableApagarLinhas() {
		setLayout(null);
		setSize(794, 548);

		JLabel lblListaDePendencias = new JLabel("Lista de Pend\u00EAncias:");
		lblListaDePendencias.setBounds(10, 11, 120, 14);
		add(lblListaDePendencias);

		JPanel panel = new JPanel();
		panel.setBounds(10, 31, 774, 380);
		add(panel);
		panel.setLayout(null);

		table = new JTable(tableModel);
		table.setBounds(0, 0, 774, 380);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 774, 380);
		panel.add(scrollPane);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JButton btnRemoverPendencias = new JButton("Remover");
		btnRemoverPendencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModel.deletarLinhas();
			}
		});
		btnRemoverPendencias.setBounds(10, 422, 157, 23);
		add(btnRemoverPendencias);

		TesteModel t1 = new TesteModel();
		t1.setSelecionado(false);
		t1.setNome("Pedro");

		TesteModel t2 = new TesteModel();
		t2.setSelecionado(false);
		t2.setNome("Maria");

		TesteModel t3 = new TesteModel();
		t3.setSelecionado(false);
		t3.setNome("João");

		TesteModel t4 = new TesteModel();
		t4.setSelecionado(false);
		t4.setNome("Helena");

		TesteModel t5 = new TesteModel();
		t5.setSelecionado(false);
		t5.setNome("Lúcia");

		tableModel.addRow(t1);
		tableModel.addRow(t2);
		tableModel.addRow(t3);
		tableModel.addRow(t4);
		tableModel.addRow(t5);

	}
}

class TesteModel {

	private Boolean selecionado;
	private String nome;

	public Boolean getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Boolean selecionado) {
		this.selecionado = selecionado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

class TesteTableModel extends AbstractTableModel {

	private List<TesteModel> dados = new ArrayList<>();
	private String[] colunas = { "Selecionar", "Nome" };

	public Class<?> getColumnClass(int columnIndex) {
		return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getSelecionado();
		case 1:
			return dados.get(linha).getNome();
		}

		return null;
	}

	public void setValueAt(Object valor, int linha, int coluna) {
		TesteModel tm = dados.get(linha);
		switch (coluna) {
		case 0:
			tm.setSelecionado(new Boolean((Boolean) valor));
			break;
		}
		fireTableDataChanged();
	}

	public void addRow(TesteModel tm) {
		this.dados.add(tm);
		this.fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
			
		return columnIndex == 0; 
	}

	public void deletarLinhas() {
		
		for (int i = getRowCount() - 1; i >= 0; i--) {

			if (dados.get(i).getSelecionado()) {
				removeRow(i);
				System.out.println(i);
			}
		}
	}
}