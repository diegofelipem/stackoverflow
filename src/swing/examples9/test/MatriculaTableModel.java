package swing.examples9.test;


import java.text.SimpleDateFormat; import java.util.ArrayList; import java.util.List; import javax.swing.table.AbstractTableModel;

public class MatriculaTableModel extends AbstractTableModel {

private List<MatriculaModel> dados = new ArrayList<>();
private String[] colunas = {"Selecionar", "Nome", "Data"};

public MatriculaTableModel(List<MatriculaModel> model) {
    this.dados = model;
}


public Class<?> getColumnClass(int columnIndex) {
    return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
}

@Override
public String getColumnName(int column){
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
    switch(coluna){
        case 0:
            return dados.get(linha).getSelecionado();
        case 1:
            return dados.get(linha).getNome();
        case 2:
            return dados.get(linha).getData();
    }

    return null;
}

public void setValueAt(Object valor, int linha, int coluna) {
    MatriculaModel tm = dados.get(linha);
    switch (coluna) {
    case 0:
        tm.setSelecionado(new Boolean((Boolean) valor));
        break;
    }
    fireTableDataChanged();
}

public void addRow(MatriculaModel tm) {
    this.dados.add(tm);
    this.fireTableDataChanged();    
}

public void removeRow(int linha){
    this.dados.remove(linha);
    this.fireTableRowsDeleted(linha, linha);
}

public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex == 0; 
}

public void deletarLinhas() {
    this.dados.clear();
    this.fireTableDataChanged();
}
}