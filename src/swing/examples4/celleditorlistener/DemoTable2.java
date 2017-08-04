package swing.examples4.celleditorlistener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DemoTable2 {

    private static void createAndShowUI() {
        JFrame frame = new JFrame("DemoTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] rows = { { "Column 1", null },
                { "Column 1", null } };
        Object[] columns = { "Column 1", null };

        final JTable table = new JTable(new DefaultTableModel(rows, columns));
        table.setDefaultEditor(Object.class, new ApproveClassEditor());

//        table.getDefaultEditor(String.class).addCellEditorListener(
//                new CellEditorListener() {
//                    public void editingCanceled(ChangeEvent e) {
//                        System.out.println("editingCanceled");
//                    }
//
//                    public void editingStopped(ChangeEvent e) {
//                        System.out.println("editingStopped: apply additional action");
//                    }
//                });

        frame.add(new JScrollPane(table));
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}