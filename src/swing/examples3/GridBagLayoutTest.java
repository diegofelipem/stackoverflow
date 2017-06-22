package swing.examples3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GridBagLayoutTest extends JPanel {

	protected void makebutton(String name, GridBagLayout gridbag, GridBagConstraints c) {
		
		JButton button = new JButton(name);
		gridbag.setConstraints(button, c);
		add(button);
	}

	public GridBagLayoutTest() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridbag);
		c.weightx = 1.0;
		c.weighty = 1.0;
		makebutton("Button 1", gridbag, c);
		c.fill = GridBagConstraints.BOTH;
		makebutton("Button 2", gridbag, c);
	}
	
	public void setFocusInComponents(Container container) {

		Component[] components = container.getComponents();

		for (Component comp : components) {

			if (comp instanceof Container) {
				setFocusInComponents((Container) comp);
			}

			comp.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					JComponent comp = (JComponent) e.getSource();

					comp.setBorder(new LineBorder(Color.GRAY));
					comp.setBackground(Color.WHITE);

				}

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					JComponent comp = (JComponent) e.getSource();

					comp.setBorder(new LineBorder(Color.RED));
					comp.setBackground(Color.LIGHT_GRAY);

				}
			});
		}
	}

	public static void main(String args[]) {
		JFrame f = new JFrame();
		GridBagLayoutTest mgb = new GridBagLayoutTest();
		f.add("Center", mgb);
		f.pack();
		mgb.setFocusInComponents(f.getContentPane());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);
	}
}
