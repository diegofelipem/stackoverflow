package swing.examples8;

public class JInternalFrameErroTest extends javax.swing.JFrame {
    private frameInterno register;

    public JInternalFrameErroTest() {
        initComponents();
    }

    private void initComponents() {

        painelDesktop = new javax.swing.JDesktopPane();
        btnAbrirFrame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout painelDesktopLayout = new javax.swing.GroupLayout(painelDesktop);
        painelDesktop.setLayout(painelDesktopLayout);
        painelDesktopLayout.setHorizontalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelDesktopLayout.setVerticalGroup(
            painelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        btnAbrirFrame.setText("Abrir Frame");
        btnAbrirFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDesktop)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(btnAbrirFrame)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAbrirFrame)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnAbrirFrameActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (register == null) {
            register = new frameInterno();
            painelDesktop.add(register);	
        }
 
        if (!register.isVisible()) {
            register.setVisible(true);
        }
        register.toFront();
    }                                             

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JInternalFrameErroTest().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAbrirFrame;
    private javax.swing.JDesktopPane painelDesktop;

}




class frameInterno extends javax.swing.JInternalFrame {

    public frameInterno() {
        initComponents();
    }

    private void initComponents() {

        btnSair = new javax.swing.JButton();

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {  
    	this.setVisible(false);
    }

    private javax.swing.JButton btnSair;
}
