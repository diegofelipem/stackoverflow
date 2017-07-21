package swing.examples4.placeholdersupport;

import java.awt.Graphics;

import javax.swing.FocusManager;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class IconTextField extends JTextField {

	private IconTextComponentHelper mHelper = new IconTextComponentHelper(this);

	public IconTextField() {
		super();
		PlaceHolderSupport.setPlaceHolder(this, "Preencha este campo...");
	}

	public IconTextField(int cols) {
		super(cols);
		PlaceHolderSupport.setPlaceHolder(this, "Preencha este campo...");
	}

	private IconTextComponentHelper getHelper() {
		if (mHelper == null)
			mHelper = new IconTextComponentHelper(this);

		return mHelper;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		getHelper().onPaintComponent(graphics);
		PlaceHolderSupport.onPaintComponent(graphics);
	}

	public void setIcon(Icon icon) {
		getHelper().onSetIcon(icon);
	}

	@Override
	public void setBorder(Border border) {
		getHelper().onSetBorder(border);
		super.setBorder(getHelper().getBorder());
	}
}
