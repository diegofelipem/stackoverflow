package swing.examples3.oldquestions.q202703_Mudar_cor_linhas_JTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SaldoTableRenderer extends DefaultTableCellRenderer {
	
	final Color defaultBackground, defaultForeground;

	public SaldoTableRenderer() {
		this.defaultBackground = getBackground();
		this.defaultForeground = getForeground();
		setHorizontalAlignment(javax.swing.JLabel.RIGHT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			Integer saldo = Integer.valueOf((String)table.getModel().getValueAt(row, 1));

			if (saldo <= 0) {
				c.setBackground(Color.red);
				c.setForeground(Color.white);
			}else{
				c.setBackground(defaultBackground);
				c.setForeground(defaultForeground);				
			}
			setText(saldo.toString());

		return c;
	}

}