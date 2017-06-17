package questions.q_159314;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class TableProdutoModel extends AbstractTableModel {

    private List<Produto> listProduto;
    private final String colunas[] = new String[]{"Produto", "Valor", "Quantidade", "Total"};

    public TableProdutoModel() {
        this.listProduto = new LinkedList<Produto>();
    }

    public TableProdutoModel(List<Produto> listProduto) {
        this.listProduto = listProduto;
    }

    @Override
    public int getRowCount() {
        return this.listProduto.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto p = listProduto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getProduto();
            case 1:
                return p.getValor();
            case 2:
                return p.getQnt();
            case 3:
                return p.getQnt() * p.getValor();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto p = listProduto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                p.setProduto(aValue.toString());
                break;
            case 1:
                p.setValor(new Double(aValue.toString()));
                break;
            case 2:
                p.setQnt(new Integer(aValue.toString()));
                break;
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex < colunas.length - 1;
    }

    public Double getTotal() {
        double total = 0;
        for (Produto p : listProduto) {
            total += p.getQnt() * p.getValor();
        }
        return total;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return null;
        }
    }
}