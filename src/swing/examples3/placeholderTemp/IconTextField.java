package swing.examples3.placeholderTemp;

import java.awt.Graphics;

import javax.swing.FocusManager;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class IconTextField extends JTextField{

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

		if (this.getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
			PlaceHolderSupport.onPaintComponent(graphics);
		} else {
			repaint();
		}
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
