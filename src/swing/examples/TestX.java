package swing.examples;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TestX extends JFrame {

    private String[] colunas
            = {"Country", "Capital", "Population in Millions", "Democracy"};

    private Object[][] dados = {
        {"USA", "Washington DC", 280, true},
        {"Canada", "Ottawa", 32, true},
        {"United Kingdom", "London", 60, true},
        {"Germany", "Berlin", 83, true},
        {"France", "Paris", 60, true},
        {"Norway", "Oslo", 4.5, true},
        {"India", "New Delhi", 1046, true}
    };

    private DefaultTableModel model = new DefaultTableModel(dados, colunas);
    private JTable tabela = new JTable(model);

    private TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tabela.getModel());

    private JTextField barraPesquisa = new JTextField();
    private JButton botao = new JButton("OK");

    private JPanel painel = new JPanel();
    private JLabel label = new JLabel();

    public TestX() {
        add(x());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JComponent x() {
        JPanel painelX = new JPanel();
        painelX.setLayout(null);

        painelX.add(barraPesquisa);
        barraPesquisa.setBounds(20, 10, 270, 27);
        painelX.add(botao);
        botao.setBounds(300, 10, 65, 27);

        barraPesquisa.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = barraPesquisa.getText();

                //model.setRowCount(0); // limpar as linhas
                if (text.trim().length() == 0) {
                    barraPesquisa.setText("Digite aqui..");
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("^(?i)" + text, 0));
                    model.getRowCount();
                }
                label.setText(rowSorter.getViewRowCount() + " resultados encontrados");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = barraPesquisa.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                label.setText(rowSorter.getViewRowCount() + " resultados encontrados");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        tabela.setRowSorter(rowSorter);

        painelX.add(tabela);
        tabela.setBounds(5, 100, 500, 150);

        painelX.add(label);
        label.setBounds(10, 250, 150, 30);
        label.setText(model.getRowCount() + " resultados encontrados!");

        painelX.setBounds(1, 1, 600, 400);
        return painelX;
    }

    public static void main(String[] args) {
        TestX t = new TestX();
    }
}