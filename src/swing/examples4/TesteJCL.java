package swing.examples4;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class TesteJCL extends JFrame {

    public TesteJCL() {
        add(montaTela());
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JComponent montaTela() {
        JPanel montaTela = new JPanel();
        JComboList comboList = new JComboList();
        montaTela.add(comboList);
        return montaTela;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()
                -> {
            TesteJCL jcl = new TesteJCL();
            jcl.setVisible(true);
        });
    }
}

class JComboList extends JPanel {

    String[] values = new String[]{"Segunda - feira", "Terça - feira", "Quarta - feira", "Quinta - feira", "Sexta - feira", "Sábado", "Domingo"};

    public JComboList() {
        JComboBox<String> comboBox = new JComboBox<String>(values) {
            @Override
            public void setPopupVisible(boolean visible) {
                if (visible) {
                    super.setPopupVisible(visible);
                }
            }
        };

//        class CheckBoxRenderer implements ListCellRenderer<Object> {
        	class CheckBoxRenderer extends DefaultListCellRenderer {

            private Map<String, JCheckBox> items = new HashMap<>();

            public CheckBoxRenderer(String[] items) {
                for (String item : items) {
                    JCheckBox box = new JCheckBox(item);
                    this.items.put(item, box);
                }
            }

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
            	
                String selecteds = "";
                
                for(Map.Entry<String, JCheckBox> entry : items.entrySet()){
                	if(entry.getValue().isSelected()){
                		selecteds += entry.getKey();	
                	}
                }
                
                return new JLabel(selecteds);
            	
//                if (items.containsKey(value)) {
//                    return items.get(value);
//                } else {
//                    return null;
//                }
            }


//            public void setSelected(String item, boolean selected) {
//                    JCheckBox cb = items.get(item);
//                    cb.setSelected(selected);
//            }
            
            public void changeSelection(String item) {
                JCheckBox cb = items.get(item);
                cb.setSelected(!cb.isSelected());
        }
            
            
        }

        final CheckBoxRenderer renderer = new CheckBoxRenderer(values);

        comboBox.setRenderer(renderer);
//        comboBox.addItemListener(e -> {
//            String item = (String) e.getItem();
//            if (e.getStateChange() == ItemEvent.SELECTED) {
//                renderer.setSelected(item, true);
//            } else {
//                renderer.setSelected(item, false);
//            }
//        });
        
        comboBox.addActionListener(e -> {
        	JComboBox combo = (JComboBox) e.getSource();
        	String item = (String)combo.getSelectedItem();
        	
//        	renderer.setSelected(item);
        	renderer.changeSelection(item);
        	
        });
        add(comboBox);
    }
}