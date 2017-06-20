package swing.examples;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Properties;

/**
 *
 * @author diego.felipe
 */
public class SaveLAFTest {

    private void start() {
        final JFrame frame = new JFrame();
        frame.setTitle("Frame principal");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComboBox comboLAF = new JComboBox();

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            comboLAF.addItem(info.getName());
        }

        comboLAF.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String LAFSelected = (String) e.getItem();
                    changeLookAndFeel(LAFSelected);
                    SwingUtilities.updateComponentTreeUI(frame);
                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(comboLAF);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void changeLookAndFeel(String name) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equalsIgnoreCase(name)) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    Propriedade.setLookAndFeel(name);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            String myLAF = Propriedade.getLookAndFeel();
            if (myLAF == null || myLAF.isEmpty()) {
                Propriedade.setLookAndFeel(UIManager.getLookAndFeel().getName());
            } else {

                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if (myLAF.equalsIgnoreCase(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SaveLAFTest f = new SaveLAFTest();
                f.start();
            }
        });
    }

    public static class Propriedade {

        private static Properties prop;
        private static String path = "config.properties";

        private static void LoadPropertiesFile() throws IOException {
            prop = new Properties();
            File f = new File(path);

            if (f.isFile()) {
                FileInputStream file = new FileInputStream(f);
                prop.load(file);
            } else {
                f.createNewFile();
                FileInputStream file = new FileInputStream(f);
                prop.load(file);
                setLookAndFeel("");
            }
        }

        public static String getLookAndFeel() throws IOException {
            LoadPropertiesFile();
            return prop.getProperty("lookandfeel.name");
        }

        public static void setLookAndFeel(String name) throws IOException {
            LoadPropertiesFile();
            prop.setProperty("lookandfeel.name", name);
            prop.store(new FileOutputStream(path), "");
        }
    }
}
