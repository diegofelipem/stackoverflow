package swing.examples4;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class JTextPaneExample {

	public void createAndShowGUI() {
		JFrame f = new JFrame("JTextPaneExample");

		// cria um StyleContext e um Document para o jtextpane
		StyleContext sc = new StyleContext();
		final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
		JTextPane pane = new JTextPane(doc);
		pane.setEditable(false);

		// cria um estilo e adiciona atributos personalizados nele
		final Style redStyle = sc.addStyle("RED", null);
		redStyle.addAttribute(StyleConstants.Foreground, Color.red);
		redStyle.addAttribute(StyleConstants.FontSize, new Integer(16));

		final Style blueStyle = sc.addStyle("BLUE", null);
		blueStyle.addAttribute(StyleConstants.Foreground, Color.blue);
		blueStyle.addAttribute(StyleConstants.FontSize, new Integer(14));
		blueStyle.addAttribute(StyleConstants.Bold, new Boolean(true));

		try {
			// insere um texto inicial com uma style
			doc.insertString(0, "Texto inicial ", redStyle);
			// insere texto concatenado com outra style
			doc.insertString(pane.getText().length(), "texto concatenado", blueStyle);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}

		f.getContentPane().add(new JScrollPane(pane));
		f.setSize(400, 300);
		f.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			new JTextPaneExample().createAndShowGUI();;
		});
	}

}
