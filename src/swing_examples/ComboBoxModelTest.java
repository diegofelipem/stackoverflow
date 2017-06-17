package swing_examples;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ComboBoxModelTest extends JFrame {

	private JComboBox comboBox;

	private JPanel contentPane;
	private JLabel lblNewLabel;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ComboBoxModelTest frame = new ComboBoxModelTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboBoxModelTest() {
		initComponents();

		List<Estado> estados = new ArrayList<>();
		estados.add(new Estado("MG", "Minas Gerais"));
		estados.add(new Estado("SP", "Sao Paulo"));
		estados.add(new Estado("RJ", "Rio de Janeiro"));

		comboBox.setModel(new GenericComboModel<Estado>(estados));
	}

	public void initComponents() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(157, 180, 95, 25);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Estado e = (Estado) evt.getItem();
				lblNewLabel.setText(e.getSigla());
			}
		});
		comboBox.setBounds(157, 111, 95, 20);
		contentPane.add(comboBox);
	}

	class Estado {

		private String sigla;
		private String nome;

		public Estado(String sigla, String nome) {
			this.sigla = sigla;
			this.nome = nome;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return this.nome;
		}
	}

	class GenericComboModel<E> extends AbstractListModel<E> implements ComboBoxModel<E> {

		private List<E> itemList;
		private E selection;

		public GenericComboModel(List<E> list) {
			this.itemList = list;
		}

		@Override
		public int getSize() {
			return this.itemList.size();
		}

		@Override
		public E getElementAt(int index) {
			return this.itemList.get(index);
		}

		@Override
		public Object getSelectedItem() {
			return this.selection;
		}

		@Override
		public void setSelectedItem(Object anItem) {
			this.selection = (E) anItem;
		}
	}
}