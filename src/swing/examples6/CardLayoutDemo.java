package swing.examples6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CardLayoutDemo  extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel cards; 
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
    
    public CardLayoutDemo() {

        setTitle("CardLayoutDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem submenu01 = new JMenuItem("Painel de botoes");
        submenu01.setActionCommand(BUTTONPANEL);
        submenu01.addActionListener(new ChangeCardlayoutListener());
        JMenuItem submenu02 = new JMenuItem("Painel de texto");
        submenu02.setActionCommand(TEXTPANEL);
        submenu02.addActionListener(new ChangeCardlayoutListener());
        menu.add(submenu01);
        menu.add(submenu02);
        menubar.add(menu);
        setJMenuBar(menubar);
    	
        //cria o painel de botoes
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        //cria o painel de campos de texto
        JPanel card2 = new JPanel(new GridLayout(2, 1, 5, 5));
        card2.add(new JTextField("TextField", 20));
        card2.add(new JTextField("TextField2", 20));
        
        //este painel é quem será o container para o cardlyout
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);

        getContentPane().add(cards, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    
    class ChangeCardlayoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, (String)evt.getActionCommand());
		}  	
    }   

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(CardLayoutDemo::new);
    }
}
