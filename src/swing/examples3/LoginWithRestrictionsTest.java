package swing.examples3;

import java.awt.*;
import javax.swing.*;

public class LoginWithRestrictionsTest extends JFrame {

	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(() -> {
			LoginWithRestrictionsTest frame = new LoginWithRestrictionsTest();
			frame.createAndShowGUI();
		});
	}

	public LoginWithRestrictionsTest() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {

		desktopPane = new JDesktopPane();
		this.desktopPane.setBackground(Color.LIGHT_GRAY);

		LoginIFrame internalframe = new LoginIFrame();
		internalframe.getContentPane().setForeground(Color.WHITE);

		desktopPane.add(internalframe);
		internalframe.getContentPane().setLayout(null);

		internalframe.setVisible(true);

		setContentPane(desktopPane);
		setTitle("Login Demo");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

/**
 * 
 * 
 * CLASSE LoginIFrame
 *
 */

class LoginIFrame extends JInternalFrame {

	static final int xOffset = 30, yOffset = 30;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField userField;
	private JTextField passField;
	private JButton btnLogin;
	private JComboBox<String> comboBox;
	MenuIFrame pFrame;

	public LoginIFrame() {
		super("LoginIFrame", false, true, true, true);
		initComponents();
	}

	private void initComponents() {

		setSize(250, 200);

		getContentPane().setLayout(null);

		this.lblNewLabel = new JLabel("User:");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblNewLabel.setBounds(10, 32, 46, 14);
		getContentPane().add(this.lblNewLabel);

		this.lblNewLabel_1 = new JLabel("Pass:");
		this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblNewLabel_1.setBounds(10, 57, 46, 14);
		getContentPane().add(this.lblNewLabel_1);

		this.userField = new JTextField();
		this.userField.setBounds(66, 29, 121, 20);
		getContentPane().add(this.userField);

		this.passField = new JTextField();
		this.passField.setBounds(66, 54, 121, 20);
		getContentPane().add(this.passField);

		this.btnLogin = new JButton("Login");
		this.btnLogin.setBounds(98, 119, 89, 23);
		getContentPane().add(this.btnLogin);

		btnLogin.addActionListener(e -> {
			if (pFrame != null) {
				pFrame.dispose();
			}
			pFrame = new MenuIFrame(comboBox.getSelectedItem().equals("Gerente"));
			getParent().add(pFrame);
			pFrame.setVisible(true);
		});

		setLocation(xOffset, yOffset);

		this.comboBox = new JComboBox<String>();
		this.comboBox.addItem("Funcionario");
		this.comboBox.addItem("Gerente");
		this.comboBox.setBounds(66, 85, 121, 20);

		getContentPane().add(this.comboBox);
	}
}

/**
 * 
 * 
 * CLASSE MenuIFrame
 *
 */
class MenuIFrame extends JInternalFrame {

	static final int xOffset = 350, yOffset = 30;
	JMenu menu1, menu2;
	JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
	JMenuBar menuBar = new JMenuBar();

	public MenuIFrame(boolean isFullLevelAccess) {
		super("MenuIFrame", false, true, true, true);
		initComponents();
		menuItem3.setVisible(isFullLevelAccess);
		menu2.setVisible(isFullLevelAccess);
		
	}
	
	private void initComponents(){
		setSize(300, 300);
		setLocation(xOffset, yOffset);



		menu1 = new JMenu("Menu 1");
		menuItem1 = new JMenuItem("Item 1");
		menuItem2 = new JMenuItem("Item 2");
		menuItem3 = new JMenuItem("Item 3");
		// Esse sub-item só estará acessivel
		// se o usuario tiver acesso completo
		//menuItem3.setEnabled(isFullLevelAccess);

		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);

		menu2 = new JMenu("Menu 2");
		// Esse menu e todos os seus sub-itens só estarão acessíveis
		// se o usuario tiver acesso completo
		//menu2.setEnabled(isFullLevelAccess);
		menuItem4 = new JMenuItem("Item 4");
		menuItem5 = new JMenuItem("Item 5");

		menu2.add(menuItem4);
		menu2.add(menuItem5);

		menuBar.add(menu1);
		menuBar.add(menu2);

		setJMenuBar(menuBar);

	}
}