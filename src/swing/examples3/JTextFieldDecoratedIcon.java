package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.FocusManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.prompt.PromptSupport;

public class JTextFieldDecoratedIcon {

	public void start() throws IOException {

		final JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 350));

		JTextField field2 = new JTextField();
		IconTextField field = new IconTextField();

		//URL path = new URL("https://i.imgur.com/WKfl8uV.png");
		//Image icone = ImageIO.read(path);
		Image icone = ImageIO.read(getClass().getResource("/res/user-log.png"));

		field.setIcon(new ImageIcon(icone));
		field.setPlaceHolder("Digite algo...");

		frame.add(field, BorderLayout.NORTH);
		field.setPreferredSize(new Dimension(250, 30));

		// bibilioteca swingx-core-1.6.2 ↓
		// PromptSupport.setPrompt("Digite..", field);

		frame.add(field2, BorderLayout.SOUTH);
		field2.setPreferredSize(new Dimension(100, 30));

		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				new JTextFieldDecoratedIcon().start();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
}

class IconTextField extends JTextField {
	
	private IconTextComponentHelper mHelper = new IconTextComponentHelper(this);
	private String placeHolder = "";

	public IconTextField() {
		super();
	}

	public IconTextField(int cols) {
		super(cols);
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
		
		if (this.getText().isEmpty()
				&& !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
			graphics.setFont(this.getFont().deriveFont(Font.ITALIC));
			graphics.drawString(placeHolder, getBorder().getBorderInsets(this).left, getBorder().getBorderInsets(this).top + getHeight()/2);
			
		} else {
			repaint();
			graphics.drawString("", getBorder().getBorderInsets(this).left, getBorder().getBorderInsets(this).top + getHeight()/2);
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
	
	public void setPlaceHolder(String text){
		if(text !=  null){
			placeHolder = text;
		}
	}
}

class IconTextComponentHelper {

	private static final int ICON_SPACING = 4;

	private Border mBorder;
	private Icon mIcon;
	private Border mOrigBorder;
	private JTextComponent mTextComponent;

	IconTextComponentHelper(JTextComponent component) {
		mTextComponent = component;
		mOrigBorder = component.getBorder();
		mBorder = mOrigBorder;
	}

	Border getBorder() {
		return mBorder;
	}

	void onPaintComponent(Graphics g) {
		if (mIcon != null) {
			Insets iconInsets = mOrigBorder.getBorderInsets(mTextComponent);
			mIcon.paintIcon(mTextComponent, g, iconInsets.left, iconInsets.top);
		}

	}

	void onSetBorder(Border border) {
		mOrigBorder = border;

		if (mIcon == null) {
			mBorder = border;
		} else {
			Border margin = BorderFactory.createEmptyBorder(0, mIcon.getIconWidth() + ICON_SPACING, 0, 0);
			mBorder = BorderFactory.createCompoundBorder(border, margin);
		}
	}

	void onSetIcon(Icon icon) {
		mIcon = icon;
		resetBorder();
	}

	private void resetBorder() {
		mTextComponent.setBorder(mOrigBorder);
	}
}
