package swing.examples4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTextFieldWithCustomToolTipTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblCampo;
	private MyInfoBubble info = new MyInfoBubble();
	private boolean isMouseMoving = true;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JTextFieldWithCustomToolTipTest frame = new JTextFieldWithCustomToolTipTest();
			frame.setVisible(true);
		});
	}

	/**
	 * Create the frame.
	 */
	public JTextFieldWithCustomToolTipTest() {
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		contentPane = new JPanel();
		this.contentPane
				.setBorder(new TitledBorder(null, "ToolTipTest", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.CENTER, 0, 0);
		this.contentPane.setLayout(fl_contentPane);

		this.lblCampo = new JLabel("Campo:");
		this.contentPane.add(this.lblCampo);

		this.textField = new JTextField();
		this.textField.setColumns(10);
		this.textField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("parou");
				info.setLocation(new Point(e.getPoint().x + (textField.getWidth()/2), e.getPoint().y + textField.getHeight()));
				info.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				info.setVisible(false);
			}
		});
		
		textField.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.contentPane.add(this.textField);
		this.contentPane.add(info);
		pack();
	}

	class MyInfoBubble extends JPanel {

		public MyInfoBubble() {
			setBackground(new Color(200, 200, 200, 100));
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLUE);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(100, 50);
		}
	}
}
