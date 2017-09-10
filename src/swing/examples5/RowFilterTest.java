package swing.examples5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

public class RowFilterTest extends JFrame {

	private String[] colunas = { "0", "1", "2", "3" };

	private Object[][] dados = { { "1", "Estados Unidos", "USA", "true" }, { "2", "Canada", "CNA", "true" },
			{ "3", "United Kingdom", "UN", "true" }, { "4", "Germany", "GER", "true" },
			{ "5", "France", "FRA", "true" } };

	private DefaultTableModel dtm = new DefaultTableModel(dados, colunas);
	private JTable tabela = new JTable(dtm);

	private TableRowSorter<TableModel> sorter;
	private JScrollPane jsp = new JScrollPane(tabela);

	private JComponent[] componentes = { new JTextField(), new JTextField(), new JTextField() };

	public RowFilterTest() {
		setTitle("Teste - RowFilter");
		add(montaTela());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JComponent montaTela() {
		JPanel painel = new JPanel();
		painel.setLayout(new BorderLayout());

		// resgata o TableModel da sua JTable
		TableModel model = tabela.getModel();
		// Cria um RowSorter baseado no TableModel resgatado
		sorter = new TableRowSorter<>(model);
		// Aplica o RowSorte na na JTable
		tabela.setRowSorter(sorter);

		painel.add(pesquisa(), BorderLayout.NORTH);
		painel.add(jsp, BorderLayout.CENTER);
//		setaFiltrosPesquisa();// seta o filtro
		return painel;
	}

	private JComponent pesquisa() {
		JPanel painelPesquisa = new JPanel();
		painelPesquisa.setLayout(new FlowLayout());

		for (int i = 0; i < componentes.length; i++) {
			if (componentes[i] != null) {
				if (componentes[i] instanceof JTextComponent) {
					painelPesquisa.add(new JLabel("Coluna " + i));
					painelPesquisa.add(componentes[i]);
					componentes[i].setPreferredSize(new Dimension(80, 22));
				}
			}
		}
		
		JButton btn = new JButton("Search!");
		btn.addActionListener(getActionSearch());
		painelPesquisa.add(btn);
		return painelPesquisa;
	}

//	private void setaFiltrosPesquisa() {
//
//		for (int i = 0; i < componentes.length; i++) {
//			final int index = i;
//
//			((JTextComponent) componentes[i]).getDocument().addDocumentListener(new DocumentListener() {
//				String[] filtros = new String[componentes.length];
//				List<RowFilter<Object, Object>> filters = new ArrayList<>();
//
//				@Override
//				public void insertUpdate(DocumentEvent e) {
//					if (componentes[index] instanceof JTextComponent) {
//						filtros[index] = ((JTextComponent) componentes[index]).getText().trim();
//					}
//
//					if (filtros[index].trim().length() == 0) {
//						sorter.setRowFilter(null);
//					} else {
//						filters.add(RowFilter.regexFilter("(?i)" + filtros[index], index));
//						dtm.getRowCount();
//					}
//					sorter.setRowFilter(RowFilter.andFilter(filters));
//				}
//
//				@Override
//				public void removeUpdate(DocumentEvent e) {
//
//					if (filtros[index].trim().length() == 0) {
//						sorter.setRowFilter(null);
//					} else {
//						filters.add(RowFilter.regexFilter("(?i)" + filtros[index], index));
//					}
//					sorter.setRowFilter(RowFilter.andFilter(filters));
//				}
//
//				@Override
//				public void changedUpdate(DocumentEvent e) {
//
//				}
//			});
//		}
//	}
	
	public ActionListener getActionSearch(){
		
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<RowFilter<Object, Object>> filters = new ArrayList<>();
				
				int fieldEmptyCount = 0;
				
				for (int i = 0; i < componentes.length; i++) {
					String search = ((JTextComponent) componentes[i]).getText().trim();
					if (search.trim().length() == 0) {
						fieldEmptyCount++;
					} else {
						filters.add(RowFilter.regexFilter("(?i)" + search, i));
						dtm.getRowCount();
					}
				}
				
				if(fieldEmptyCount  < 3){
					sorter.setRowFilter(RowFilter.andFilter(filters));
				}else {
					sorter.setRowFilter(null);
				}
				
			}
		};
		
		return action;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			RowFilterTest t = new RowFilterTest();
		});
	}
}