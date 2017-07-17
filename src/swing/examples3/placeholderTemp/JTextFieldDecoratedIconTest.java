package swing.examples3.placeholderTemp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class JTextFieldDecoratedIconTest {

	public void start() throws IOException {

		final JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 350));

		JTextField field2 = new JTextField();
		IconTextField field = new IconTextField();

		 URL path = new URL("https://i.imgur.com/WKfl8uV.png");
		 Image icone = ImageIO.read(path);
		//Image icone = ImageIO.read(getClass().getResource("/res/user-log.png"));

		field.setIcon(new ImageIcon(icone));

		frame.add(field, BorderLayout.NORTH);
		field.setPreferredSize(new Dimension(250, 30));

		// bibilioteca swingx-core-1.6.2 ↓
		// PromptSupport.setPrompt("Digite..", field);
		
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
