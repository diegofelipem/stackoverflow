package questions.q202703_Mudar_cor_linhas_JTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.table.AbstractTableModel;

public class EstoqueTableModel extends AbstractTableModel {

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
        switch(columnName) {
            case "PRODUTO": return e.getNomeProduto();
            case "SALDO": return Integer.toString(e.getSaldo());
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
