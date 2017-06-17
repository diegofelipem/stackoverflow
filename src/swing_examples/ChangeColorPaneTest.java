package swing_examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ChangeColorPaneTest extends JFrame {

    JTextField field;
    ColorPane pane;
    boolean alternate = true;

    public void startFrame() {
        pane = new ColorPane();
        pane.setBackground(new Color(245, 245, 245));

        field = new JTextField();
        field.setPreferredSize(new Dimension(getSize().width, 25));
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color textColor = alternate ? Color.red : Color.BLUE;
                pane.append(textColor, field.getText());
                alternate = !alternate;
                field.setText("");
            }
        });

        JScrollPane scrollpane = new JScrollPane(pane);
        scrollpane.setPreferredSize(new Dimension(400, 200));
        setTitle("ColorPane example");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(scrollpane, BorderLayout.CENTER);
        add(field, BorderLayout.PAGE_END);
        field.requestFocusInWindow();
        pack();
        setVisible(true);
    }

    class ColorPane extends JTextPane {

        public void append(Color c, String s) {
            //implementação utilizando StyleContext
            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                    StyleConstants.Foreground, c);

            int len = getDocument().getLength(); // tamanho do texto já no component
            setCaretPosition(len); // altera a posicao do cursor para o fim(se não houver seleção)
            setCharacterAttributes(aset, false);
            //O \n é apenas para o texto ser quebrado
            //para fins de demonstracao
            replaceSelection(s.concat("\n")); //se não houver seleção, adiciona o texto no fim
        }

    }

    public static void main(String argv[]) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChangeColorPaneTest pane = new ChangeColorPaneTest();
                pane.startFrame();
            }
        });
    }
}
