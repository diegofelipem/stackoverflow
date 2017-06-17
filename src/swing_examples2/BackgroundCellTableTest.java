package swing_examples2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class BackgroundCellTableTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {

//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Windows".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}

			EventQueue.invokeLater(() -> {
				BackgroundCellTableTest frame = new BackgroundCellTableTest();
				frame.setVisible(true);
			});

//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| javax.swing.UnsupportedLookAndFeelException ex) {
//			ex.printStackTrace();
//		}
	}

	public BackgroundCellTableTest() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 466);
		contentPane = new JPanel();
		setContentPane(contentPane);

		table = new JTable(new EstoqueTableModel()) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

				final Component c = super.prepareRenderer(renderer, row, column);

				Integer saldo = (int) table.getValueAt(row, 1);

				if (saldo <= 0) {
					c.setBackground(Color.red);
					c.setForeground(Color.white);
				} else {
					c.setBackground(table.getBackground());
					c.setForeground(table.getForeground());
				}
				return c;
			}
		};
		
		contentPane.setLayout(new BorderLayout(0, 0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		pack();

	}

}

class EstoqueTableModel extends AbstractTableModel {

	List<Estoque> estoques;
	List<String> colunas = Arrays.asList("PRODUTO", "SALDO");

	public EstoqueTableModel() {
		Random r = new Random();
		estoques = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			int s = r.nextInt(3) * i;
			Estoque e = new Estoque("Produto" + i, s);
			estoques.add(e);
		}
	}

	@Override
	public int getRowCount() {
		return estoques.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.size();
	}

	public int getColumnIndex(String coluna) {
		return colunas.indexOf(coluna);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Estoque e = estoques.get(rowIndex);
		String columnName = getColumnName(columnIndex);
		switch (columnName) {
		case "PRODUTO":
			return e.getNomeProduto();
		case "SALDO":
			return e.getSaldo();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return colunas.get(column);
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}
}

class Estoque {

	private String nomeProduto;
	private int saldo;

	public Estoque(String nomeProduto, int saldo) {
		this.nomeProduto = nomeProduto;
		this.saldo = saldo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}