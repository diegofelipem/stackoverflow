package questions;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class CustomPromptTest {

	public JComponent makeUI() {
		JTextArea textArea = new JTextArea(8, 0);
		textArea.setText("> ");
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Lucida Console", 1, 12));
		textArea.setCaretColor(Color.WHITE);
		((AbstractDocument) textArea.getDocument()).setDocumentFilter(new NonEditableLineDocumentFilter());
		JPanel p = new JPanel(new BorderLayout());
		p.setPreferredSize(new Dimension(300, 200));
		p.add(new JScrollPane(textArea));
		return p;
	}

	public static void createAndShowGUI() {
		JFrame f = new JFrame();
		f.setTitle("Custom Prompt Java");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.getContentPane().add(new CustomPromptTest().makeUI());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

	class NonEditableLineDocumentFilter extends DocumentFilter {

		@Override
		public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			if (string == null) {
				return;
			} else {
				replace(fb, offset, 0, string, attr);
			}
		}

		@Override
		public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
			replace(fb, offset, length, "", null);
		}

		private static final String PROMPT = "> ";

		@Override
		public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
				throws BadLocationException {
			Document doc = fb.getDocument();
			Element root = doc.getDefaultRootElement();
			int count = root.getElementCount();
			int index = root.getElementIndex(offset);
			Element cur = root.getElement(index);
			int promptPosition = cur.getStartOffset() + PROMPT.length();

			if (index == count - 1 && offset - promptPosition >= 0) {
				if (text.equals("\n")) {
					String cmd = doc.getText(promptPosition, offset - promptPosition);
					if (cmd.isEmpty()) {
						text = "\n" + PROMPT;
					} else {
						text = "\n" + cmd + "\n" + PROMPT;
					}
				}
				fb.replace(offset, length, text, attrs);
			}
		}
	}
}
