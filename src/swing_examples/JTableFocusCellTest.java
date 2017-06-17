package swing_examples;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author diego.felipe
 */
public class JTableFocusCellTest extends JFrame {

    private JButton btnChecar;
    private JScrollPane ScrollPane;
    private JTable tabela;

    public JTableFocusCellTest() {
        initComponents();
    }

    private void initComponents() {

        ScrollPane = new JScrollPane();
        btnChecar = new JButton();

        String[] columns = {"coluna 1", "coluna 2", "coluna 3", "coluna 4"};
        Object[][] data = new Object[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);

        tabela = new JTable(model) {
            @Override
            public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
//                editCellAt(rowIndex, columnIndex);
            }
        };
        tabela.setDefaultEditor(Object.class, new CustomCellEditor());

        ScrollPane.setViewportView(tabela);
        btnChecar.setText("Checar");

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.add(ScrollPane, BorderLayout.CENTER);
        this.add(btnChecar, BorderLayout.SOUTH);

    }

    public static void main(String args[]) {

        EventQueue.invokeLater(() -> {
            new JTableFocusCellTest().setVisible(true);
        });
    }

    class CustomCellEditor extends AbstractCellEditor
            implements TableCellEditor, ActionListener {

        String texto;
        JFormattedTextField field = new JFormattedTextField();

        @Override
        public Object getCellEditorValue() {
            return this.texto;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.texto = (String) value;
            field.setText(texto);
            field.addActionListener(this);
            try {
                MaskFormatter mft = new MaskFormatter("##:##");
                mft.install(field);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            return field;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFormattedTextField myField = (JFormattedTextField) e.getSource();
            texto = myField.getText();
            fireEditingStopped();
        }
    }
}
