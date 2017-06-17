package questions.q_159314;

import java.text.DecimalFormat;
import javax.swing.JLabel;

class LabelTotal extends JLabel {

    public LabelTotal(Double valor) {
        this.setText(valor);
        this.setHorizontalAlignment(JLabel.RIGHT);
    }

    public void setText(Double valor) {
        setText("Total: " + new DecimalFormat("¤###,##0.00").format(valor));
    }
}