package swing.examples3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

public class JTextFieldDecoratedIconTest {

	public void start() throws IOException {

		final JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 350));

		JTextField field2 = new JTextField();
		IconTextField field = new IconTextField();

		URL path = new URL("https://i.imgur.com/WKfl8uV.png");
		Image icone = ImageIO.read(path);

		field.setIcon(new ImageIcon(icone));

		frame.add(field, BorderLayout.NORTH);
		field.setPreferredSize(new Dimension(250, 30));

		field.addFocusListener(new FocusListener() {

			Color defaultBg = field.getBackground();

			@Override
			public void focusGained(FocusEvent e) {
				field.setBorder(new LineBorder(new Color(108, 85, 255)));
				field.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void focusLost(FocusEvent e) {
				field.setBorder(new LineBorder(Color.GRAY));
				field.setBackground(defaultBg);
			}
		});

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
				new JTextFieldDecoratedIconTest().start();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
}

/*
 * 
 * class IconTextField
 * 
 */

class IconTextField extends JTextField {

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

/*
 * 
 * class IconTextComponentHelper
 * 
 */

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

/**
 * Classe responsável por definir um placeholder a um componente de texto
 * 
 * @author diego
 *
 */
class PlaceHolderSupport {

	private static JTextComponent textComponent;
	private static String placeHolder = "";

	/**
	 * Aplica o texto recebido como placeholder ao componente de texto
	 * 
	 * @param comp
	 *            - Componente de texto
	 * @param strPlaceHolder
	 *            - texto do placeholder
	 */
	public static void setPlaceHolder(JTextComponent comp, String strPlaceHolder) {

		textComponent = comp;
		placeHolder = strPlaceHolder;
	}

	/**
	 * Desenha uma string centralizada no meio do componente representado pelo
	 * retangulo
	 * 
	 * @param g
	 *            - Instancia de Graphics.
	 * @param text
	 *            - String a ser desenhada.
	 * @param rect
	 *            - Retangulo para centralizar o texto.
	 * @param font
	 *            - Fonte a ser aplicada ao texto
	 */
	private static void drawPlaceHolderString(Graphics g, String text, Rectangle rect, Font font) {
		// Obtém as métricas da fonte do texto
		FontMetrics metrics = g.getFontMetrics(font);
		// Determina a coordenada X do texto conforme
		// o tamanho da borda interna esquerda
		int x = textComponent.getBorder().getBorderInsets(textComponent).left;
		// Determina a coordenada Y do texto para que
		// fique centralizado verticalmente
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		// aplica a fonte
		g.setFont(font);
		// desenha a string
		g.drawString(text, x, y);
	}

	/**
	 * Desenha o placeholder no componente de texto
	 * 
	 * @param g
	 *            - instancia de Graphics
	 */
	public static void onPaintComponent(Graphics g) {

		if (textComponent != null) {
			Font font = textComponent.getFont().deriveFont(Font.ITALIC);
			g.setColor(Color.gray);
			drawPlaceHolderString(g, placeHolder, textComponent.getBounds(), font);
		}
	}
}
