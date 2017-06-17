package swing_examples2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

public class ControlPanel extends JPanel {
    private static final int GAP = 3;
    private Map<Control, JSlider> sliderMap = new EnumMap<>(Control.class);

    public ControlPanel() {
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(1, 0, GAP, GAP));
        for (Control control : Control.values()) {
            JSlider slider = new JSlider(JSlider.VERTICAL, 0, control.getMaxValue(), 0);
            slider.setPaintLabels(true);
            slider.setPaintTicks(true);
            slider.setPaintTrack(true);
            slider.setMajorTickSpacing(100);
            slider.setMinorTickSpacing(20);
            slider.addChangeListener(new SliderListener(control));
            sliderMap.put(control, slider);
            JPanel panel = new JPanel(new BorderLayout());
            TitledBorder titleBorder = BorderFactory.createTitledBorder(control.getText());
            titleBorder.setTitleColor(control.getColor());
            panel.setBorder(titleBorder);
            panel.add(slider);
            add(panel);            
        }
    }

    private class SliderListener implements ChangeListener {
        private Control control;

        public SliderListener(Control control) {
            this.control = control;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();
            int value = slider.getValue();            
            System.out.printf("Control: %s, Value: %d%n", control, value);
        }

    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Control Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ControlPanel());
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



enum Control {
    HEIGHT("Height", 500, Color.BLACK), WIDTH("Width", 500, Color.black), RED("Red", 255, Color.RED), 
    GREEN("Green", 255, Color.GREEN), BLUE("Blue", 255, Color.BLUE);

    private String text;
    private int maxValue;
    private Color color;

    private Control(String text, int maxValue, Color color) {
        this.text = text;
        this.maxValue = maxValue;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public Color getColor() {
        return color;
    }

}