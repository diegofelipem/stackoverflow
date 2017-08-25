package swing.examples4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;

import swing.examples.SaveLAFTest.Propriedade;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author diego.felipe
 * Baseado neste post: https://stackoverflow.com/a/767254/5524514
 *
 */
public class RightClickTest extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RightClickTest frame = new RightClickTest();
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
	public RightClickTest() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setPreferredSize(new Dimension(getPreferredSize().width/2,getPreferredSize().height/2));
		this.textArea = new JTextArea();
		this.textArea.addMouseListener(new PopClickListener());
		this.scrollPane.setViewportView(this.textArea);
		this.panel.add(this.scrollPane);
		pack();
	}
	
	class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    public void mouseReleased(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e){
	        PopUpDemo menu = new PopUpDemo();
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
	
	class PopUpDemo extends JPopupMenu {
		
		ArrayList<JMenuItem> itens = new ArrayList<>();
		
	    
	    public PopUpDemo(){
	    	
	    	JMenuItem itemCopy = new JMenuItem("Copy");
	    	itemCopy.setMnemonic('C');
	    	itemCopy.addActionListener(e-> {
	    		textArea.copy();
	    	});
	    	
	    	JMenuItem itemPaste = new JMenuItem("Paste");
	    	itemPaste.addActionListener(e -> {
	    		textArea.paste();
	    	});
	    	
	    	JMenuItem itemCut = new JMenuItem("Cut");
	    	itemCut.addActionListener(e -> {
	    		textArea.cut();
	    	});
	    	
	    	JMenuItem ItemSelAll = new JMenuItem("Select All");
	    	ItemSelAll.addActionListener(e -> {
	    		textArea.selectAll();
	    	});

	        add(itemCopy);
	        add(itemPaste);
	        add(itemCut);
	        addSeparator();
	        add(ItemSelAll);
	        
//	        Action copyAction = textArea.getActionMap().get("copy");
//	        Action cutAction = textArea.getActionMap().get("cut");
//	        Action pasteAction = textArea.getActionMap().get("paste");
//	        Action undoAction = textArea.getActionMap().get("undo");
//	        Action selectAllAction = textArea.getActionMap().get("selectAll");
//	        
//	        add(undoAction);
//	        addSeparator();
//	        add(cutAction);
//	        add(copyAction);
//	        add(pasteAction);
//	        addSeparator();
//	        add(selectAllAction);
	    }

	}

}
