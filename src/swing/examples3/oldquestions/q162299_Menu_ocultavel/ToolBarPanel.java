package swing.examples3.oldquestions.q162299_Menu_ocultavel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
*
* @author diego.felipe
*/

public class ToolBarPanel extends JPanel implements ItemListener {

	private final JComponent barComponent;
	private final int prefwitdh;
	private final int MINIMUM_WIDTH = 5;
	private JToggleButton botaoConfig = new JToggleButton(">>");

	public ToolBarPanel(JComponent toolBar) {
		this.barComponent = toolBar;
		this.prefwitdh = barComponent.getPreferredSize().width;
		this.setLayout(new BorderLayout());

		botaoConfig.addItemListener(this);
		botaoConfig.setPreferredSize(new Dimension(30, 30));
		botaoConfig.setMargin(new Insets(0, 0, 0, 0));
		botaoConfig.setFocusable(false);

		this.add(botaoConfig, BorderLayout.WEST);
		this.add(toolBar, BorderLayout.CENTER);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			barComponent.setPreferredSize(new Dimension(MINIMUM_WIDTH, 0));
			((AbstractButton) e.getSource()).setText("<<");

		} else if (e.getStateChange() == ItemEvent.DESELECTED) {

			barComponent.setPreferredSize(new Dimension(prefwitdh, 0));
			((AbstractButton) e.getSource()).setText(">>");

		}
		revalidate();
	}

}
