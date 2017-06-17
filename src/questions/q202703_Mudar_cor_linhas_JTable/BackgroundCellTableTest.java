package questions.q202703_Mudar_cor_linhas_JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class BackgroundCellTableTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

			EventQueue.invokeLater(() -> {
				BackgroundCellTableTest frame = new BackgroundCellTableTest();
				frame.setVisible(true);
			});

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
	}

	public BackgroundCellTableTest() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		table = new JTable(new EstoqueTableModel());
		table.setDefaultRenderer(Object.class, new SaldoTableRenderer());
		//table.getColumnModel().getColumn(1).setCellRenderer(new SaldoTableRenderer());
		contentPane.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.NORTH);
		pack();

	}

}