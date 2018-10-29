package swing.examples9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

public class SwingHTMLBrowser extends JFrame {
	
	private JTextArea userStatus, serverStatus;
	private JPanel actions;
	

	SwingHTMLBrowser() {
		
		

		super("Swing HTML Browser");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600, 400));
		
		userStatus =  new JTextArea(5,5);
		JScrollPane userStatusPane = new JScrollPane(userStatus);
		userStatusPane.setBorder(BorderFactory.createTitledBorder("user Status"));
		userStatusPane.setPreferredSize(new Dimension(this.getPreferredSize().width/6, this.getPreferredSize().height));
		
		serverStatus = new JTextArea(5,5);
		JScrollPane serverStatusPane = new JScrollPane(serverStatus);
		serverStatusPane.setBorder(BorderFactory.createTitledBorder("server Status"));
		serverStatusPane.setPreferredSize(new Dimension(this.getPreferredSize().width/6, this.getPreferredSize().height));
		
		actions = new JPanel();
		actions.add(new JLabel("actions"));
		actions.setPreferredSize(new Dimension(this.getPreferredSize().width, 100));
		actions.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JPanel secondaryPane = new JPanel();
		secondaryPane.setLayout(new BoxLayout(secondaryPane, BoxLayout.X_AXIS));
		secondaryPane.add(userStatusPane);
		secondaryPane.add(serverStatusPane);
		secondaryPane.add(new Browser());
		
		
		add(actions, BorderLayout.NORTH);
		add(secondaryPane, BorderLayout.CENTER);

		pack();
	}

	public static void main(String args[]) {

		SwingUtilities.invokeLater(() -> new SwingHTMLBrowser().setVisible(true));
	}
}

class Browser extends JPanel {
	
	private JTextField addressBar;
	private JEditorPane pane;

	public Browser() {
		setLayout(new BorderLayout());
		addressBar = new JTextField();
		pane = new JEditorPane();
		pane.setEditable(false);

		addressBar.addActionListener(e -> {
			String url = addressBar.getText();
			try {
				pane.setPage(url);
			} catch (IOException t) {
				t.printStackTrace();
			}

		});

		pane.addHyperlinkListener(evt -> {

			if (evt.getEventType() != HyperlinkEvent.EventType.ACTIVATED) {
				return;
			}

			JEditorPane srcPane = (JEditorPane) evt.getSource();

			if (evt instanceof HTMLFrameHyperlinkEvent) {
				HTMLDocument doc = (HTMLDocument) pane.getDocument();
				doc.processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent) evt);
			} else {
				String url = evt.getURL().toString();
				addressBar.setText(url);
				try {
					pane.setPage(url);
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		});
		add(addressBar, BorderLayout.NORTH);
		add(new JScrollPane(pane));
	}
}
