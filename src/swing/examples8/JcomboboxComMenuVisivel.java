package swing.examples8;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class JcomboboxComMenuVisivel extends javax.swing.JFrame {

	JCheckBox[] jcb1 = new JCheckBox[3];

	public JcomboboxComMenuVisivel() {
		jcb1[0] = new JCheckBox("Inclusão");
		jcb1[1] = new JCheckBox("Alteração");
		jcb1[2] = new JCheckBox("Exclusão");
		initComponents();
		jComboBox1.insertItemAt("Opções", 0);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jComboBox1 = new JComboCheckBox(jcb1);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(84, 84, 84).addComponent(jComboBox1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(202, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(62, 62, 62)
						.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(218, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JcomboboxComMenuVisivel.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JcomboboxComMenuVisivel().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JComboBox<String> jComboBox1;
	// End of variables declaration
}

class JComboCheckBox extends JComboBox {
	
	private boolean selectedHasChanged = false;

	public JComboCheckBox() {
		addStuff();
	}

	public JComboCheckBox(JCheckBox[] items) {
		super(items);
		addStuff();
	}

	private void addStuff() {
		setRenderer(new ComboBoxRenderer());
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				itemSelected();
			}
		});
	}

	private void itemSelected() {
		if (getSelectedItem() instanceof JCheckBox) {
			JCheckBox jcb = (JCheckBox) getSelectedItem();
			jcb.setSelected(!jcb.isSelected());
			setSelectedIndex(0);
		}
		selectedHasChanged = true;
	}
	
	@Override
	public void setPopupVisible(boolean v) {
		
		super.setPopupVisible(selectedHasChanged);
	}

	class ComboBoxRenderer implements ListCellRenderer {

		private JLabel defaultLabel;

		public ComboBoxRenderer() {
			setOpaque(true);
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (value instanceof Component) {
				Component c = (Component) value;
				if (isSelected) {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				} else {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				}
				return c;
			} else {
				if (defaultLabel == null) {
					defaultLabel = new JLabel(value.toString());
				} else {
					defaultLabel.setText(value.toString());
				}
				return defaultLabel;
			}
		}
	}
}
