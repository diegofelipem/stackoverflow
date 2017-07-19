package swing.examples4.placeholdersupport;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.text.JTextComponent;


/**
 * Classe responsável por definir um placeholder a um
 * componente de texto
 * 
 * @author diego
 *
 */
public class PlaceHolderSupport {

	private static JTextComponent textComponent;
	private static String placeHolder = "";


	/**
	 * Aplica o texto recebido como placeholder ao
	 * componente de texto
	 * 
	 * @param comp - Componente de texto
	 * @param strPlaceHolder - texto do placeholder
	 */
	public static void setPlaceHolder(JTextComponent comp, String strPlaceHolder) {

		textComponent = comp;
		placeHolder = strPlaceHolder;
	}

	/**
	 * Desenha uma string centralizada no meio do 
	 * componente representado pelo retangulo
	 * 
	 * @param g - Instancia de Graphics.
	 * @param text - String a ser desenhada.
	 * @param rect - Retangulo para centralizar o texto.
	 * @param font - Fonte a ser aplicada ao texto
	 */
	private static void drawPlaceHolderString(Graphics g, String text, Rectangle rect, Font font) {
		// Obtém as métricas da fonte do texto
		FontMetrics metrics = g.getFontMetrics(font);
		// Determina a coordenada X do texto conforme
		// o tamanho da borda interna esquerda
		int x = textComponent.getBorder().getBorderInsets(textComponent).left;
		// Determina a coordenada Y do texto para que
		//  fique centralizado verticalmente
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		// aplica a fonte
		g.setFont(font);
		// desenha a string
		g.drawString(text, x, y);
	}

	/**
	 * Desenha o placeholder no componente de texto
	 * 
	 * @param g - instancia de Graphics
	 */
	public static void onPaintComponent(Graphics g) {

		if (textComponent != null) {
			Font font = textComponent.getFont().deriveFont(Font.ITALIC);
			g.setColor(Color.gray);
			drawPlaceHolderString(g, placeHolder, textComponent.getBounds(), font);
		}
	}
}
