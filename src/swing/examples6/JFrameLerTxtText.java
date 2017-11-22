package swing.examples6;


import java.nio.charset.StandardCharsets;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

/**
*
* @author marqu
*/
public class JFrameLerTxtText extends javax.swing.JFrame {

   /**
    * Creates new form NewJFrame
    */
   public JFrameLerTxtText() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       lab = new javax.swing.JLabel();
       jButton1 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       lab.setBackground(new java.awt.Color(204, 204, 255));
       lab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
       lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       lab.setText("Controle da Catraca");

       jButton1.setText("Exibir historico");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addContainerGap()
                       .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(142, 142, 142)
                       .addComponent(jButton1)))
               .addContainerGap(18, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(38, 38, 38)
               .addComponent(jButton1)
               .addGap(18, 18, 18)
               .addComponent(lab, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
               .addContainerGap())
       );

       pack();
   }// </editor-fold>                        

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		// String dir = "C:/Users/marqu/OneDrive/Documentos/marco.txt"; //String com o
		// diretorio do arquivo txt
		String dir = "C:/Temp/teste.txt";
		Path caminho = Paths.get(dir);
		List<String> txt;

		try {
			txt = Files.readAllLines(caminho);
			StringBuilder builder = new StringBuilder();

			for (String s : txt)
				builder.append(s);

			lab.setText(builder.toString());

			Files.write(caminho, "".getBytes());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}                                     

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(JFrameLerTxtText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(JFrameLerTxtText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(JFrameLerTxtText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(JFrameLerTxtText.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new JFrameLerTxtText().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify                     
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel lab;
   // End of variables declaration                   
}