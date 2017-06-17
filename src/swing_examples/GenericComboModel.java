package swing_examples;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class GenericComboModel<E> extends AbstractListModel<E> implements ComboBoxModel<E>{
	
	private List<E> itemList;
	private E selection;
	
	public GenericComboModel(List<E> list) {
		this.itemList = list;
	}

	@Override
	public int getSize() {
		return this.itemList.size();
	}

	@Override
	public E getElementAt(int index) {
		return this.itemList.get(index);
	}

	@Override
	public Object getSelectedItem() {
		return this.selection;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		this.selection = (E) anItem;
	}

}
