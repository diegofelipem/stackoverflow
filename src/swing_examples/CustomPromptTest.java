package swing_examples;

import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.text.*;

public class CustomPromptTest {
	
	public static final String PROMPT = ComputerInfo.getUserName() + "@" + ComputerInfo.getComputerName() + "> ";

	public JComponent makeUI() {

		JTextArea textArea = new JTextArea(8, 0);
		textArea.setText(CustomPromptTest.PROMPT);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Lucida Console", 0, 12));
		textArea.setCaretColor(Color.WHITE);

		((AbstractDocument) textArea.getDocument()).setDocumentFilter(new NonEditableLineDocumentFilter());
		JPanel p = new JPanel(new BorderLayout());
		p.setPreferredSize(new Dimension(600, 300));
		p.add(new JScrollPane(textArea));

		return p;
	}

	public void createAndShowGUI() {
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
				new CustomPromptTest().createAndShowGUI();;
			}
		});
	}

}

class NonEditableLineDocumentFilter extends DocumentFilter {

	@Override
	public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {
		if (string == null) {
			return;
		} else {
			super.replace(fb, offset, 0, string, attr);
		}
	}

	@Override
	public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
		super.replace(fb, offset, length, "", null);
	}

	@Override
	public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {

		Document doc = fb.getDocument();
		Element root = doc.getDefaultRootElement();
		int count = root.getElementCount();
		int index = root.getElementIndex(offset);
		Element cur = root.getElement(index);

		int promptPosition = cur.getStartOffset() + CustomPromptTest.PROMPT.length();

		if (index == count - 1 && offset - promptPosition >= 0) {

			if (text.equals("\n")) {
				String cmd = doc.getText(promptPosition, offset - promptPosition);
				if (cmd.isEmpty()) {
					text = "\n" + CustomPromptTest.PROMPT;
				} else {
					text = "\n" + cmd + "\n" + CustomPromptTest.PROMPT;
				}
			}
			fb.replace(offset, length, text, attrs);
		}
	}
}

class ComputerInfo {

	static String getComputerName() {

		String computerName = null;
		InetAddress localMachine;

		try {
			localMachine = InetAddress.getLocalHost();
			computerName = localMachine.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return computerName;
	}

	static String getUserName() {
		return System.getProperty("user.name");
	}
}