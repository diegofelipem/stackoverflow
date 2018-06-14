package swing.examples8;

import javax.swing.JFileChooser;

public class JFileChooserShowDirectoryOnly extends javax.swing.JFrame {
	
	
public JFileChooserShowDirectoryOnly() {
    initComponents();
//    jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
}
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void initComponents() {

    jFileChooser1 = new javax.swing.JFileChooser();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
}// </editor-fold>                        

public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(JFileChooserShowDirectoryOnly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(JFileChooserShowDirectoryOnly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(JFileChooserShowDirectoryOnly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(JFileChooserShowDirectoryOnly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new JFileChooserShowDirectoryOnly().setVisible(true);
        }
    });
}
// Variables declaration - do not modify                     
private javax.swing.JFileChooser jFileChooser1;
// End of variables declaration                   
}
