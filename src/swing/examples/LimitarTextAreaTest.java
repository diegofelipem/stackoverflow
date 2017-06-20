package swing.examples;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class LimitarTextAreaTest extends JFrame {

    private JTextArea textArea;
    private DefaultStyledDocument doc;
    private JLabel remaningLabel = new JLabel();

    public LimitarTextAreaTest() {
        setLayout(new BorderLayout());

        textArea = new JTextArea(5, 15);
        doc = new DefaultStyledDocument();
        
       //aqui é atribuido um filtro ao DefaultStyledDocument, é esta classe que vai
       //limitar o número máximo de caracteres, basta alterar o 500
        doc.setDocumentFilter(new DocumentSizeFilter(500));
        //neste trecho, foi sobrescrito um DocumentListener,
        //que monitora alterações dentro do campo de texto
        //sempre que uma alteração for realizada, será invocado
        //o método updateCount, que vai atualizar o numero
        //de caracteres restantes
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCount();
            }
        });
        //finalmente o DefaultStyledDocument foi
        //atribuido ao seu campo de texto
        textArea.setDocument(doc);

        updateCount();

        add(textArea, BorderLayout.NORTH);
        add(remaningLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    private void updateCount() {
        remaningLabel.setText((500 - doc.getLength()) + " caracteres restantes");
    }

    public static void main(String[] args) {
        new LimitarTextAreaTest().setVisible(true);
    }

    //esta classe que faz a limitação de caracteres
    class DocumentSizeFilter extends DocumentFilter {

        int maxCharacters;
        boolean DEBUG = false;

        public DocumentSizeFilter(int maxChars) {
            maxCharacters = maxChars;
        }

        public void insertString(DocumentFilter.FilterBypass fb, int offs,
                String str, AttributeSet a)
                throws BadLocationException {
            if (DEBUG) {
                System.out.println("in DocumentSizeFilter's insertString method");
            }

            //This rejects the entire insertion if it would make
            //the contents too long. Another option would be
            //to truncate the inserted string so the contents
            //would be exactly maxCharacters in length.
            
            
            if ((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
                super.insertString(fb, offs, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        public void replace(DocumentFilter.FilterBypass fb, int offs,
                int length,
                String str, AttributeSet a)
                throws BadLocationException {
            if (DEBUG) {
                System.out.println("in DocumentSizeFilter's replace method");
            }
            //This rejects the entire replacement if it would make
            //the contents too long. Another option would be
            //to truncate the replacement string so the contents
            //would be exactly maxCharacters in length.
            if ((fb.getDocument().getLength() + str.length()
                    - length) <= maxCharacters) {
                super.replace(fb, offs, length, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }
}
