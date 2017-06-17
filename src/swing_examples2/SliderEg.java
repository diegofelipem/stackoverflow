package swing_examples2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.*;

public class SliderEg extends JPanel {
	
   public static final Color[] COLORS = { Color.red, Color.orange,
         Color.yellow, Color.green, Color.blue, Color.cyan};
 
//   private static final int BI_W = 33;
   private static final int BI_H = 10;
  
   private JSlider slider = new JSlider(0, 100, 0);

   public SliderEg() {
      int majorSpacing = slider.getMaximum() / (COLORS.length - 1);
      Dictionary<Integer, JLabel> dictionary = new Hashtable<Integer, JLabel>();
      slider.setMajorTickSpacing(majorSpacing);
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.setSnapToTicks(true);
      for (int i = 0; i < COLORS.length; i++) {
         ImageIcon icon = createColorIcon(COLORS[i]);
         JLabel label = new JLabel(icon);
         int key = i * majorSpacing;
         dictionary.put(key, label);
      }
      
      slider.setLabelTable(dictionary);

      setLayout(new BorderLayout());
      add(slider, BorderLayout.CENTER);
   }
   
//   @Override
//	public Dimension getPreferredSize() {
//		// TODO Auto-generated method stub
//		return new Dimension(400, 100);
//	}

   private ImageIcon createColorIcon(Color color) {
//      BufferedImage img = new BufferedImage(BI_W, BI_H,
//            BufferedImage.TYPE_INT_RGB);
	      BufferedImage img = new BufferedImage(getPreferredSize().width/COLORS.length, BI_H,
	              BufferedImage.TYPE_INT_RGB);
      Graphics g = img.getGraphics();
      g.setColor(color);
      g.fillRect(0, 0, getPreferredSize().width/COLORS.length, BI_H);
      g.dispose();

      return new ImageIcon(img);
   }

   private static void createAndShowGui() {
      SliderEg mainPanel = new SliderEg();

      JFrame frame = new JFrame("SliderEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
