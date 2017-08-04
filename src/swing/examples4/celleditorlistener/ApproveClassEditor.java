package swing.examples4.celleditorlistener;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class ApproveClassEditor extends AbstractCellEditor implements TableCellEditor {

	JComboBox combo;
	Object aValue;
	JTextField field;
	int columnEditing;
	

	public ApproveClassEditor() {
		this.combo = new JComboBox<>(new String[] { "aprovado", "reprovado" });
		field = new JTextField();
	}

	@Override
	public Object getCellEditorValue() {

		return aValue;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		Component component = null;

		if (column == 0) {
			columnEditing = 0;
			this.field.setText((String) value);
			aValue = value;
			component = field;

		} else if (column == 1) {
			columnEditing = 1;
			this.aValue = combo.getSelectedItem();
			component = combo;
		}
		return component;
	}

	@Override
	public boolean stopCellEditing() {
		
		
		return super.stopCellEditing();

	}

}
