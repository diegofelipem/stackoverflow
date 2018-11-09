package swing.examples9.test;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Matricula extends JFrame {

    private static final int ITENS_POR_PAG = 5;

    public Matricula() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jdcDataDeInicio = new com.toedter.calendar.JDateChooser();
        lblDe = new javax.swing.JLabel();
        lblAte = new javax.swing.JLabel();
        jdcDataDeFim = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdcDataDeInicio.setDateFormatString("dd/MM/yyyy");
        jdcDataDeFim.setDateFormatString("dd/MM/yyyy");
        
        model = new MatriculaTableModel(JSONUtils.JSONtoList());
        table = new JTable(model);
        sorter = new TableRowSorter<TableModel>(model);

//        TableModel tableModel = table.getModel();
//        sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);

//        model = new MatriculaTableModel(JSONUtils.JSONtoList());

//        table = new JTable(model);

        jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setPreferredSize(new Dimension(getPreferredSize().width - 20, table.getRowHeight() * ITENS_POR_PAG + table.getTableHeader().getPreferredSize().height));

        jScrollPane.setViewportView(table);

        btnFirst.setText("<<");

        btnPrevious.setText("<");

        btnNext.setText(">");

        btnLast.setText(">>");

        btnFiltrar.setText("Filtrar");

        lblDe.setText("De");

        lblAte.setText("Até");

        btnFirst = new JButton("<<");
        btnFirst.addActionListener(e -> {
            JScrollBar bar = jScrollPane.getVerticalScrollBar();
            bar.setValue(0);
        });

        btnPrevious = new JButton("<");
        btnPrevious.addActionListener(e -> {
            int height = table.getRowHeight() * (ITENS_POR_PAG);
            JScrollBar bar = jScrollPane.getVerticalScrollBar();
            bar.setValue(bar.getValue() - height);
        });

        btnNext = new JButton(">");
        btnNext.addActionListener(e -> {
            int height = table.getRowHeight() * (ITENS_POR_PAG);
            JScrollBar bar = jScrollPane.getVerticalScrollBar();
            bar.setValue(bar.getValue() + height);
        });

        btnLast = new JButton(">>");
        btnLast.addActionListener(e -> {
            JScrollBar bar = jScrollPane.getVerticalScrollBar();
            bar.setValue(bar.getMaximum());
        });

        btnFiltrar.addActionListener(e -> {
            aplicaFiltros();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFirst)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcDataDeInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDataDeFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btnFiltrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiltrar)
                        .addComponent(lblAte))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDe)
                        .addComponent(jdcDataDeInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcDataDeFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }                      

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matricula().setVisible(true);
            }
        });
    }

    public void aplicaFiltros(){

        //String nome = txtNome.getText().trim();
      Date dataInicio = jdcDataDeInicio.getDate(),
              dataFim = jdcDataDeFim.getDate();

      
      List<RowFilter<Object,Object>> filtrosTabela = new ArrayList<RowFilter<Object,Object>>(2);
      filtrosTabela.add( RowFilter.dateFilter(ComparisonType.AFTER, dataInicio, 2) );
      filtrosTabela.add( RowFilter.dateFilter(ComparisonType.BEFORE, dataFim, 2) );
//      rf = RowFilter.andFilter(filters);
//      sorter.setRowFilter(rf);
      
//        Set<RowFilter<Object, Object>> filtrosTabela = new HashSet<>();
//        //filtrosTabela.add(RowFilter.regexFilter(nome, 1));
//
//        filtrosTabela.add( RowFilter.dateFilter(ComparisonType.AFTER, dataInicio));
//        filtrosTabela.add( RowFilter.dateFilter(ComparisonType.BEFORE, dataFim));


        sorter.setRowFilter(RowFilter.andFilter(filtrosTabela));

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private JScrollPane jScrollPane;
    private com.toedter.calendar.JDateChooser jdcDataDeFim;
    private com.toedter.calendar.JDateChooser jdcDataDeInicio;
    private javax.swing.JLabel lblAte;
    private javax.swing.JLabel lblDe;
    private javax.swing.JTable table;
    private MatriculaTableModel model;
    private TableRowSorter<TableModel> sorter;
    // End of variables declaration                   
}