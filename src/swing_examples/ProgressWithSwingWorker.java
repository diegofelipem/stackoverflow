package swing_examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

public class ProgressWithSwingWorker extends JFrame {

    private JButton btnChecar;
    private JProgressBar progressBar;
    private JScrollPane ScrollPane;
    private JTable tabela;

    public ProgressWithSwingWorker() {
        initComponents();
    }

    private void initComponents() {

        ScrollPane = new JScrollPane();
        btnChecar = new JButton();
        progressBar = new JProgressBar();

        String[] columns = {"coluna 1", "coluna 2", "coluna 3", "coluna 4"};
        Object[][] data = new Object[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Boolean.class;
                } else {
                    return super.getColumnClass(columnIndex);
                }
            }
        };

        tabela = new JTable(model);

        ScrollPane.setViewportView(tabela);
        btnChecar.setText("Checar");
        //A "magica" acontece na classe ChecarComSwingWorker
        btnChecar.addActionListener(new ChecarComSwingWorker());

        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(ScrollPane, BorderLayout.NORTH);
        this.add(btnChecar, BorderLayout.CENTER);
        this.add(progressBar, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String args[]) {

        EventQueue.invokeLater(() -> {
            new ProgressWithSwingWorker().setVisible(true);
        });
    }

    class ChecarComSwingWorker implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            final int totalRows = tabela.getModel().getRowCount();
            progressBar.setMaximum(totalRows);
            progressBar.setMinimum(0);
            //passei parametros para facilitar o entendimento
            //- o primeiro é o retorno do doInBackground(não foi necessario uso neste exemplo)
            //- o segundo é o tipo do valor usado entre o publish e o process
            SwingWorker<Object, Integer> worker = new SwingWorker<Object, Integer>() {

                //este método é que executa em uma Thread paralela
                //todo processamento pesado que deve ser executado
                //fora da EDT, deve ser executado aqui 
                @Override
                protected Object doInBackground() {
                    for (int i = 0; i < totalRows; i++) {
                        try {
                            Boolean status = (Boolean) tabela.getModel().getValueAt(i, 3);
                            status = status == null ? true : !status;
                            tabela.getModel().setValueAt(status, i, 3);
                            //este método é que atualiza a barra de progresso
                            //passando cada iteração para o método process
                            publish(i);
                            Thread.sleep(400);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    return null;
                }

                //este método é que recebe o que é passado no publish
                //e atualiza a barra de progresso na EDT
                @Override
                protected void process(List<Integer> chunks) {
                    int valueRecent = chunks.get(chunks.size() - 1);
                    progressBar.setValue(valueRecent + 1);
                }

                //só é executado quando o doInBackground termina
                //o processamento
                @Override
                protected void done() {
                    progressBar.setValue(0);
                }
            };

            worker.execute();
        }
    }
}
