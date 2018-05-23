package swing.examples8;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.renderer.DefaultTableRenderer;

public class JTableAlterarCorSepColunas extends JFrame {
	// variaveis para uso da JTable
	private JTable table;
	private final String colunas[] = { "Nome:", "Idade:", "Sexo:" };
	private final String dados[][] = { { "Jack", "19", "Masculino" }, { "Eddie", "56", "Masculino" },
			{ "Gina", "34", "Feminino" }, { "Klaus", "18", "Masculino" }, { "Erika", "20", "Feminino" },
			{ "Roberto", "29", "Masculino" }, { "Maria", "30", "Feminino" } };

	/*
	 * Construtor da classe , antes de executar o metodo main(), irá construir o
	 * JFrame e a JTable
	 */
	public JTableAlterarCorSepColunas() {
		setLayout(new FlowLayout());// tipo de layout
		setSize(new Dimension(400, 300));// tamanho do Formulario
		setLocationRelativeTo(null);// centralizado
		setTitle("Exemplo JTable");// titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// setando a ação padrão de fechamento do Formulário,
		// neste caso irá fechar o programa

		// instanciando a JTable
		table = new JTable(dados, colunas) {

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				component.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.red));

				return component;
			}
		};

		table.setShowVerticalLines(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		
		DefaultTableRenderer renderer = new DefaultTableRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				JComponent comp = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				comp.setBackground(getBackground());
				comp.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.red));
				return comp;
			}
		};
		
		table.getTableHeader().setDefaultRenderer(renderer);


		table.setPreferredScrollableViewportSize(new Dimension(400, 300));// barra de rolagem
		table.setFillsViewportHeight(true);

		// adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

	// este é o método onde é executado nosso programa
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new JTableAlterarCorSepColunas().setVisible(true));
	}
}
