package swing.examples4;

import javax.swing.*;
import java.awt.BorderLayout;

public class JMenuBottomDemo extends JFrame {
    public JMenuBottomDemo() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JMenu menu1 = new JMenu("Menu1");
        menu1.add(new JMenuItem("Item 1"));
        menu1.add(new JMenuItem("Item 2"));
        menu1.add(new JMenuItem("Item 3"));
        
        JMenu menu2 = new JMenu("Menu 2");
        menu2.add(new JMenuItem("Item 4"));
        menu2.add(new JMenuItem("Item 5"));
        menu2.add(new JMenuItem("Item 6"));        
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu1);
        menuBar.add(menu2);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.SOUTH);
        //this.setJMenuBar(menuBar);//, BorderLayout.SOUTH);
        
        pack();
        setSize(500, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JMenuBottomDemo().setVisible(true);
            }
        });        
    }
}