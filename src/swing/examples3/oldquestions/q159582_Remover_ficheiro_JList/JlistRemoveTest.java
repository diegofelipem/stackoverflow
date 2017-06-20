package swing.examples3.oldquestions.q159582_Remover_ficheiro_JList;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JlistRemoveTest extends JFrame {

	private JPanel contentPane;
	private DefaultListModel model;
	private String path = "C:\\Users\\diego.felipe\\workspace\\TestFiles";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JlistRemoveTest frame = new JlistRemoveTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JlistRemoveTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(23, 11, 160, 206);
		contentPane.add(list);

		model = new DefaultListModel();
		list.setModel(model);

		JButton btnDelete = new JButton("Delete");

		btnDelete.setBounds(61, 228, 89, 23);
		contentPane.add(btnDelete);
		System.out.println(getClass().getResource("").getPath());

		File[] files = new File(path).listFiles(new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(".rtf");
			}
		});

		for (int i = 0; i < files.length; i++) {
			model.addElement(files[i].getName());
		}
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ficheiroSelecionado = (String) list.getSelectedValue();

				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(ficheiroSelecionado)) {
						model.removeElement(ficheiroSelecionado);
						files[i].delete();
						System.out.println(files[i]);
					}
				}
			}
		});

	}
}
