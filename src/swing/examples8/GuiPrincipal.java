package swing.examples8;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class GuiPrincipal extends JFrame {

    private JTable table;
    List<Dados> dados = new ArrayList<Dados>();

    public GuiPrincipal(JTable table) throws HeadlessException {
        this.table = table;
    }

    public void addDadosInDados() {
        Dados dado = new Dados();
        dado.setColuna0("Dado qualquer");
        dado.setColunaInteiro(1);
        dados.add(dado);
    }

    public GuiPrincipal() {
        setLayout(new FlowLayout());
        setSize(new Dimension(700, 300));
        setLocationRelativeTo(null);
        setTitle("Exemplo JTable");
        addDadosInDados();// add dados em dados       
        table = new JTable(new TesteTableModel(dados));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.getColumnModel().getColumn(1).setCellEditor(new ShowMessageCellEditor(new JTextField()));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    // este é o método onde é executado nosso programa
    public static void main(String[] args) {
        GuiPrincipal gui = new GuiPrincipal();
        gui.setVisible(true);
    }
}

class ShowMessageCellEditor extends DefaultCellEditor{

	public ShowMessageCellEditor(JTextField textField) {
		super(textField);
	}
	
	@Override
	public boolean stopCellEditing() {
		JOptionPane.showMessageDialog(null, "celula modificada");
		return super.stopCellEditing();
	}
}	


class TesteTableModel extends AbstractTableModel {

    private String colunas[] = {"Coluna0", "colunaInteiro"};
    private List<Dados> dados;
    private final int COLUNA_0 = 0;
    private final int COLUNA_INTEIRO = 1;

    public TesteTableModel(List<Dados> dados) {
        this.dados = dados;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return dados.size();
    }

    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUNA_0:
                return String.class;
            case COLUNA_INTEIRO:
                return Integer.class;
            default:
                return String.class;
        }
    }
    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dados dados = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COLUNA_0:
                return dados.getColuna0();
            case COLUNA_INTEIRO:
                return dados.getColunaInteiro();
            default:
                return null;
        }
    }
}

class Dados {
    /**
     * @return the coluna0
     */
    public String getColuna0() {
        return coluna0;
    }
    /**
     * @param coluna0 the coluna0 to set
     */
    public void setColuna0(String coluna0) {
        this.coluna0 = coluna0;
    }
    /**
     * @return the colunaInteiro
     */
    public Integer getColunaInteiro() {
        return colunaInteiro;
    }
    /**
     * @param colunaInteiro the colunaInteiro to set
     */
    public void setColunaInteiro(Integer colunaInteiro) {
        this.colunaInteiro = colunaInteiro;
    }
    private String coluna0;
    private Integer colunaInteiro;
}
