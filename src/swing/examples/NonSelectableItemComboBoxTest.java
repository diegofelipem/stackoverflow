package swing.examples;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;

public class NonSelectableItemComboBoxTest extends JFrame {
	
	public static void main(String[] args){
		
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Windows".equalsIgnoreCase(info.getName())) {
				javax.swing.UIManager.put("control", new Color(230, 230, 230));
				javax.swing.UIManager.put("background", new Color(0, 230, 230));
				javax.swing.UIManager.put("Table.showGrid", true);
				javax.swing.UIManager.put("Table.alternateRowColor", new Color(232, 232, 232));
				try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new NonSelectableItemComboBoxTest().setVisible(true);	
			}
		});
	}
	
	public NonSelectableItemComboBoxTest() {

		initComponents();
	}

	private void initComponents() {
		setSize(new Dimension(200, 200));
		setResizable(false);
		getContentPane().setLayout(null);

		JComboBox<Placa> comboBox = new JComboBox();
		comboBox.setBounds(28, 65, 137, 30);
		getContentPane().add(comboBox);

		List<Placa> objList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Placa p = new Placa();
			p.setId(i);
			p.setNumero(new Random().nextInt(9999) + 1);
			objList.add(p);

		}

		comboBox.setModel(new GenericComboModel<Placa>(objList));
		
		comboBox.setRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> arg0, Object aValue, int index, boolean arg3,
					boolean arg4) {
				super.getListCellRendererComponent(arg0, aValue, index, arg3, arg4);
				
				if(index == 1){
					System.out.println();
				}
				
				if(aValue == null){
					setText("Selecione um item:");
				}else if (aValue instanceof Placa){
					Placa p = (Placa) aValue;
					setText(p.getId() + " - " + p.getNumero());
				}
				return this;
			}
			
		});
	}
	
	class Placa {

		private int id;
		private long numero;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public long getNumero() {
			return numero;
		}

		public void setNumero(long numero) {
			this.numero = numero;
		}
	}
}



	