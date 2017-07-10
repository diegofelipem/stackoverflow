package swing.examples3;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TesteFor extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(()
                -> {
            TesteFor ts = new TesteFor();
            ts.setVisible(true);
        });
    }

    public TesteFor() {
        setTitle("Teste");
        add(componentesTela());
        setPreferredSize(new Dimension(375, 300));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent componentesTela() {
        JPanel jp = new JPanel();

       String tituloColuna[] = {"Coluna 01", "Coluna 02"};

        //Tabela apenas para indicar de onde veio os valores, não estou adicionando ela no exemplo.
        JTable tabela = new JTable();
        tabela.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "", ""
                }
        ));

        int numeroColunas = tabela.getColumnModel().getColumnCount();
        
        for (int i = 0; i < numeroColunas; i++) {
            JRadioButton radio = new JRadioButton("Ocultar " + tituloColuna[i]);
            jp.add(radio);
            radio.setActionCommand(tituloColuna[i]); //e.getActionCommand() vai retornar o nome do radio clicado
            final int currentIndex = i;
            radio.addActionListener(e -> {
                    alterarTabela(currentIndex);
                    System.out.println("Peguei a " + e.getActionCommand());
            });
        }
        return jp;
    }

    private void alterarTabela(int indiceColuna) {
        //alterar colunas de acordo com o indice.
    }
}