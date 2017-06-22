package swing.examples3;

public class FrameDes extends javax.swing.JFrame {

	public FrameDes() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		desktop = new javax.swing.JDesktopPane();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
		desktop.setLayout(desktopLayout);
		desktopLayout.setHorizontalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 852, Short.MAX_VALUE));
		desktopLayout.setVerticalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 428, Short.MAX_VALUE));

		jMenu3.setText("File");

		jMenuItem1.setText("ChamarPP");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem1);

		jMenuBar2.add(jMenu3);

		setJMenuBar(jMenuBar2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desktop));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING));

		setSize(new java.awt.Dimension(868, 488));
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		PrimeiraPagina tela = new PrimeiraPagina();
		tela.setVisible(true);
		desktop.add(tela); // TODO add your handling code here:
	}

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrameDes().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	public javax.swing.JDesktopPane desktop;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuItem jMenuItem1;
	// End of variables declaration
}

class PrimeiraPagina extends javax.swing.JInternalFrame {

	public PrimeiraPagina() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton1 = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);

		jButton1.setText("Abri segunda Pagina");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(256, 256, 256).addComponent(jButton1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(275, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(137, 137, 137).addComponent(jButton1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(163, Short.MAX_VALUE)));

		setBounds(0, 0, 697, 406);
	}// </editor-fold>

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	    SegundaPagina tela = new SegundaPagina();
	    System.out.println("mudar tela");
	    getParent().add(tela);
	    tela.setVisible(true);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	// End of variables declaration
}

class SegundaPagina extends javax.swing.JInternalFrame {

	public SegundaPagina() {
		initComponents();
		System.out.println("pagina mudada");
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel1.setText("Essa e a segunda pagina");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(172, 172, 172).addComponent(jLabel1)
						.addContainerGap(204, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(144, 144, 144).addComponent(jLabel1)
						.addContainerGap(190, Short.MAX_VALUE)));

		setBounds(0, 0, 657, 393);
	}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	// End of variables declaration
}
