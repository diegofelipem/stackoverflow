package swing.examples3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class JMenuBarChangeColor extends javax.swing.JFrame {


public JMenuBarChangeColor() {
    initComponents();
    customizeMenuBar(jMenuBar2);
}

private void customizeMenuBar(JMenuBar menuBar) {

    menuBar.setUI(new BasicMenuBarUI() {

        @Override
        public void paint(Graphics g, JComponent c) {
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }

    });

    MenuElement[] menus = menuBar.getSubElements();

    for (MenuElement menuElement : menus) {

        JMenu menu = (JMenu) menuElement.getComponent();
        changeComponentColors(menu);
        menu.setOpaque(true);

        MenuElement[] menuElements = menu.getSubElements();

        for (MenuElement popupMenuElement : menuElements) {

            JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
            popupMenu.setBorder(null);

            MenuElement[] menuItens = popupMenuElement.getSubElements();

            for (MenuElement menuItemElement : menuItens) {

                JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                changeComponentColors(menuItem);
                menuItem.setOpaque(true);

            }
        }
    }
}

private void changeComponentColors(Component comp) {
    comp.setBackground(Color.cyan);
    comp.setForeground(Color.black);
}

private void initComponents() {

    jMenuBar2 = new javax.swing.JMenuBar();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenuItem8 = new javax.swing.JMenuItem();
    jMenuItem9 = new javax.swing.JMenuItem();
    jMenuItem10 = new javax.swing.JMenuItem();
    jMenuItem11 = new javax.swing.JMenuItem();
    jMenuItem12 = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jMenu3.setText("File");

    jMenuItem1.setText("jMenuItem1");
    jMenu3.add(jMenuItem1);

    jMenuItem2.setText("jMenuItem1");
    jMenu3.add(jMenuItem2);

    jMenuItem3.setText("jMenuItem1");
    jMenu3.add(jMenuItem3);

    jMenuItem4.setText("jMenuItem1");
    jMenu3.add(jMenuItem4);

    jMenuItem5.setText("jMenuItem1");
    jMenu3.add(jMenuItem5);

    jMenuItem6.setText("jMenuItem1");
    jMenu3.add(jMenuItem6);

    jMenuBar2.add(jMenu3);

    jMenu4.setText("Edit");

    jMenuItem7.setText("jMenuItem7");
    jMenu4.add(jMenuItem7);

    jMenuItem8.setText("jMenuItem7");
    jMenu4.add(jMenuItem8);

    jMenuItem9.setText("jMenuItem7");
    jMenu4.add(jMenuItem9);

    jMenuItem10.setText("jMenuItem7");
    jMenu4.add(jMenuItem10);

    jMenuItem11.setText("jMenuItem7");
    jMenu4.add(jMenuItem11);

    jMenuItem12.setText("jMenuItem7");
    jMenu4.add(jMenuItem12);

    jMenuBar2.add(jMenu4);

    setJMenuBar(jMenuBar2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 548, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 376, Short.MAX_VALUE)
    );

    pack();
}// </editor-fold>                        

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
        java.util.logging.Logger.getLogger(JMenuBarChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(JMenuBarChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(JMenuBarChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(JMenuBarChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new JMenuBarChangeColor().setVisible(true);
        }
    });
}

// Variables declaration - do not modify                     
private javax.swing.JMenu jMenu3;
private javax.swing.JMenu jMenu4;
private javax.swing.JMenuBar jMenuBar2;
private javax.swing.JMenuItem jMenuItem1;
private javax.swing.JMenuItem jMenuItem10;
private javax.swing.JMenuItem jMenuItem11;
private javax.swing.JMenuItem jMenuItem12;
private javax.swing.JMenuItem jMenuItem2;
private javax.swing.JMenuItem jMenuItem3;
private javax.swing.JMenuItem jMenuItem4;
private javax.swing.JMenuItem jMenuItem5;
private javax.swing.JMenuItem jMenuItem6;
private javax.swing.JMenuItem jMenuItem7;
private javax.swing.JMenuItem jMenuItem8;
private javax.swing.JMenuItem jMenuItem9;
// End of variables declaration 


}