package swing.examples7;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exibir extends JFrame {

    private final Combo cb = new Combo(100, 22);

    public static void main(String[] args) {
        Exibir e = new Exibir();
        e.setVisible(true);
    }

    public Exibir() {
        add(painel());
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        vericaKey();
    }

    private JPanel painel() {
        JPanel painel = new JPanel();
        painel.add(cb);
        cb.addItem("Item 01");
        cb.addItem("Item 02");
        cb.addItem("Item 03");
        return painel;
    }

    private void vericaKey() {
        cb.addItemListener(e -> {
            System.out.println("Selecionou: " + cb.getSelectedItem());
        });
    }
}

class Combo extends JComboBox {

    public Combo(int largura, int altura) {
        setPreferredSize(new Dimension(100, 22));
    }

    public Object getValor() {
        return getSelectedItem();
    }

    public Object addItensMap(Map<String, String> map) {

        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            String key = it.next();
            addItem(key);
        }

        String key = (String) getSelectedItem();
        String customer = map.get(key);
        return customer;
    }
}