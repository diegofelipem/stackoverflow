package swing.examples2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Slider extends JFrame {

    public static final Color[] COLORS = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue};
    public static final String[] valuesColor = {"10", "20","30","40","50"};
    private static final int COMPRIMENTO = 30;
    private static final int ALTURA = 10;

    private JSlider slider = new JSlider(0, 100, 0);
    public JTextField campo = new JTextField();

    private double valor;

    public Slider() {
        setSize(525, 300);
        add(montaSlider());
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent montaSlider() {
        JPanel jpSlider = new JPanel();

        jpSlider.add(campo);
        campo.setPreferredSize(new Dimension(100, 20));

        campo.addActionListener(new ActionListener()//Caixa consulta é o campo que é digitado o código.
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        if (e.getID() == KeyEvent.KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_ENTER) {
                            //definePonteiro();
                        } else {

                        }
                        return false;
                    }
                });
            }
        });

        int majorSpacing = slider.getMaximum() / (COLORS.length - 1);
        Dictionary<Integer, JLabel> dictionary = new Hashtable<>();
        slider.setMajorTickSpacing(majorSpacing);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        for (int i = 0; i < COLORS.length; i++) {
            ImageIcon icon = createColorIcon(COLORS[i]);
            JLabel label = new JLabel(icon);
            label.setText(valuesColor[i]);
            label.setForeground(Color.white);
            label.setHorizontalTextPosition(JLabel.CENTER);
            int key = i * majorSpacing;
            dictionary.put(key, label);
        }
        slider.setLabelTable(dictionary);     
        jpSlider.add(slider, BorderLayout.CENTER);
        JButton btn = new JButton("change");
        btn.addActionListener(e -> {
        	String value = JOptionPane.showInputDialog("Digite um valor:");
        	
        	definePonteiro(Double.parseDouble(value));
        });
        jpSlider.add(btn, BorderLayout.SOUTH);
        return jpSlider;
    }

    private ImageIcon createColorIcon(Color color) {
        BufferedImage img = new BufferedImage(COMPRIMENTO, ALTURA, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, COMPRIMENTO, ALTURA);
        g.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Slider s = new Slider();
            }
        });
    }

	    public void definePonteiro(double valor) {
	    	
	        //valor = Double.valueOf(campo.getText());
	        //variavel que armazenará a posicao do knob
	        int sliderPos = 0;
	        
	        if (valor <= 11.5) {          
	            sliderPos = 0;
	        } else if (valor <= 20) {
	        	sliderPos = 25;
	        } else if (valor <= 30) {
	        	sliderPos = 50;
	        } else if (valor <= 40) {
	        	sliderPos = 75;
	        } else if (valor <= 50) {
	        	sliderPos = 100;
	        }
	        slider.setValue(sliderPos);
	    }
}