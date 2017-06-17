package questions.q_159314;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Tables extends JFrame {
	private JScrollPane scrollPane;
	private final JTable table = new JTable();
	private LabelTotal labelTotal;

	public Tables() {
		init();
	}

	final void init() {
		List<Produto> l = new LinkedList<Produto>();
		l.add(new Produto("Produto 1", 3.5, 650));
		l.add(new Produto("Produto 2", 53.5, 450));
		l.add(new Produto("Produto 3", 300.0, 120));
		l.add(new Produto("Produto 4", 50.5, 55));
		l.add(new Produto("Produto 5", 38.55, 80));
		l.add(new Produto("Produto 6", 74.0, 60));
		l.add(new Produto("Produto 7", 0.5, 20));
		l.add(new Produto("Produto 8", 1.5, 500));
		table.setModel(new TableProdutoModel(l));
		labelTotal = new LabelTotal(((TableProdutoModel) table.getModel()).getTotal());
		table.setDefaultRenderer(Double.class, new TableProdutoRender());
		((TableProdutoModel) table.getModel()).addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				labelTotal.setText(((TableProdutoModel) table.getModel()).getTotal());
			}
		});
		scrollPane = new JScrollPane(table);
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(labelTotal, BorderLayout.PAGE_END);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Tables();
			}
		});
	}
}