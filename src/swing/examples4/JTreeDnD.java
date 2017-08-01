package swing.examples4;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeDnD extends JFrame {

	private JTree arvore;
	private DefaultMutableTreeNode noRaiz = null;

	public static void main(String[] args) {
		JTreeDnD frame = new JTreeDnD();
		frame.setVisible(true);

	}

	public JTreeDnD() {
		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("JTree");

		noRaiz = new DefaultMutableTreeNode("-");
		arvore = new JTree(noRaiz);
		geraArvore();

		arvore.setDragEnabled(true);
		arvore.setTransferHandler(new TransferHandler() {
			// Aqui preciso realizar a operação de drag and drop

			@Override
			public boolean canImport(TransferSupport support) {
				// TODO Auto-generated method stub
				return super.canImport(support);
			}

			@Override
			public boolean importData(TransferSupport support) {
				return super.importData(support);
			}

		});

		JScrollPane scrollArvore = new JScrollPane(arvore);

		Container p = getContentPane();
		p.add(scrollArvore);

	}

	private void geraArvore() {
		DefaultMutableTreeNode noEmpreiteiro = new DefaultMutableTreeNode();
		DefaultMutableTreeNode noEquipe = new DefaultMutableTreeNode();
		DefaultMutableTreeNode noEmpregado = new DefaultMutableTreeNode();

		noEmpreiteiro = new DefaultMutableTreeNode("Empreiteiro 1");
		noRaiz.add(noEmpreiteiro);

		noEquipe = new DefaultMutableTreeNode("Equipe 1");
		noEmpreiteiro.add(noEquipe);

		noEmpregado = new DefaultMutableTreeNode("Empregado 1");
		noEquipe.add(noEmpregado);

		noEquipe = new DefaultMutableTreeNode("Equipe 2");
		noEmpreiteiro.add(noEquipe);

		noEmpregado = new DefaultMutableTreeNode("Empregado 2");
		noEquipe.add(noEmpregado);

		noEmpregado = new DefaultMutableTreeNode("Empregado 3");
		noEquipe.add(noEmpregado);

	}

}