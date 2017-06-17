package swing_examples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class JTableCreatingDemo extends JFrame {

	public void createAndShowGUI() {

		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
				{ "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
		Object columnNames[] = { "Column One", "Column Two", "Column Three" };
		JTable table = new JTable(rowData, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[]) throws IllegalAccessException {

		try {
			changeHeaderTableNimbusDefault();
			/*
			 * for (UIManager.LookAndFeelInfo info :
			 * UIManager.getInstalledLookAndFeels()) { if
			 * (info.getName().equalsIgnoreCase("nimbus")) {
			 * UIManager.setLookAndFeel(info.getClassName()); break; } }
			 */
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JTableCreatingDemo().createAndShowGUI();

			}
		});
	}

	public static void changeHeaderTableNimbusDefault() throws UnsupportedLookAndFeelException {
		// inicia a simulação of LAF
		NimbusLookAndFeel nimbusTmp = new NimbusLookAndFeel();
		// copia o objeto original
		Object nimbusBlueGreyOrg = UIManager.get("nimbusBlueGrey");
		// altera a cor padrão do nimbus
		UIManager.put("nimbusBlueGrey", Color.gray);
		// seta o LAF temporário
		UIManager.setLookAndFeel(nimbusTmp);
		// copia o painter gerado com a cor que foi mudada
		// apenas para a o estado de coluna ativa, sem foco
		Object painter1 = UIManager.get("TableHeader:\"TableHeader.renderer\"[Enabled].backgroundPainter");
		// descarrega o LAF temporario
		UIManager.getLookAndFeel().uninitialize();

		nimbusTmp = new NimbusLookAndFeel();
		UIManager.put("nimbusBlueGrey", Color.darkGray);
		UIManager.setLookAndFeel(nimbusTmp);
		Object painter2 = UIManager.get("TableHeader:\"TableHeader.renderer\"[MouseOver].backgroundPainter");
		UIManager.getLookAndFeel().uninitialize();

		// reverte a alteração da cor padrão
		UIManager.put("nimbusBlueGrey", nimbusBlueGreyOrg);
		// carrega o tema completo
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		// altera o painter pro que "capturamos" acima
		UIManager.put("TableHeader:\"TableHeader.renderer\"[Enabled].backgroundPainter", painter1);
		UIManager.put("TableHeader:\"TableHeader.renderer\"[MouseOver].backgroundPainter", painter2);

	}
}
