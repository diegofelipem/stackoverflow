package swing.examples9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JTablePaginada extends JFrame {

	private JPanel contentPane, buttonPane;
	private JButton btnFirst, btnPrevious, btnNext, btnLast, btnClean;
	private JTable table;
	private TesteTableModel model;
	
	private static final int ITENS_POR_PAG = 5;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(()-> new JTablePaginada().setVisible(true));
	}


	public JTablePaginada() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 400));
		contentPane = new JPanel();
		
		model = new TesteTableModel(JSONUtils.JSONtoList());
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//o width é um pequeno "workaround pra tabela ficar certinha na tela
		//a altura é definida pela quantidade de itens que quer exibir 
		//mais a altura do cabeçalho
		scrollPane.setPreferredSize(new Dimension(getPreferredSize().width - 20, table.getRowHeight() * ITENS_POR_PAG + table.getTableHeader().getPreferredSize().height));

		contentPane.add(scrollPane);
		this.add(contentPane, BorderLayout.CENTER);
		
		btnClean = new JButton("Remover tudo");
		btnFirst = new JButton("<<");
		btnFirst.addActionListener(e -> {
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setValue(0);
		});
		
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(e -> {
			int height = table.getRowHeight() * (ITENS_POR_PAG - 1);
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setValue(bar.getValue() - height);
		});
		
		btnNext = new JButton(">");
		btnNext.addActionListener(e -> {
			int height = table.getRowHeight() * (ITENS_POR_PAG - 1);
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setValue(bar.getValue() + height);
		});
		
		btnLast = new JButton(">>");
		btnLast.addActionListener(e -> {
			JScrollBar bar = scrollPane.getVerticalScrollBar();
			bar.setValue(bar.getMaximum());
		});
		
		buttonPane = new JPanel();
		buttonPane.add(btnFirst);
		buttonPane.add(btnPrevious);
		buttonPane.add(btnNext);
		buttonPane.add(btnLast);
		
		this.add(buttonPane, BorderLayout.SOUTH);		
		pack();
	}
}

//===================================================

class TesteTableModel extends AbstractTableModel {

	private List<TesteModel> dados;
	private String[] colunas = { "Selecionar", "Nome" };

	//flexibilizando o tablemodel
	public TesteTableModel(List<TesteModel> model) {
		this.dados = model;
	}

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
			tm.setSelecionado((boolean) valor);
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
		// nao precisa disso, basta zerar o numero de linhas
		// basta limpar a lista e notificar a tabela
		this.dados.clear();
		this.fireTableDataChanged();
	}

	// nao é finalidade do tablemodel ler json e muito menos converter-lo
	// pra List, isso viola o principio de responsabilidade unica
}

//===================================================

class TesteModel {
	private Boolean select;
	private String name;

	public Boolean getSelecionado() {
		return select;
	}

	public void setSelecionado(Boolean selecionado) {
		this.select = selecionado;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

}


//=============================================================

class JSONUtils {

	private static String strjson = null;

	
	//isso é pra evitar instanciacao da classe
	//ja que os métodos sao estaticos
	private JSONUtils() {

		if (strjson == null)
			strjson = lerArquivo();
	}

	public static List<TesteModel> JSONtoList() {
		String str = lerArquivo();
		Type type = new TypeToken<List<TesteModel>>() {
		}.getType();

		Gson gson = new GsonBuilder().create();
		List<TesteModel> lista = gson.fromJson(str, type);

		for (TesteModel teste : lista) {
			System.out.println(teste.getSelecionado());
			System.out.println(teste.getNome());
		}
		return lista;
	}

	private static String lerArquivo() {
		String linha = "";

		try {
//			FileReader arq = new FileReader("C:\\temp\\alunos.json");
//			BufferedReader lerArq = new BufferedReader(arq);
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(JTablePaginacao.class.getResourceAsStream("/res/alunos.json")));

			linha = lerArq.readLine();
			/*
			 * while (linha != null) { System.out.printf(linha); linha = lerArq.readLine();
			 * // lê da segunda até a última linha }
			 */
//			arq.close();

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		// System.out.println(linha);
		return linha;
	}
}
