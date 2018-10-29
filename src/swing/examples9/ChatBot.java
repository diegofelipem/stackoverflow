package swing.examples9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.text.Normalizer;

public class ChatBot extends JFrame {

//Este metodo compara a pergunta com todas no cartel e seleciona a mais proxima.

public float percentageCommomWords(String stringA, String stringB) {
String[] stringASplit = stringA.split(" ");
String[] stringBSplit = stringB.split(" ");

int count = 0;

for (int i = 0; i < stringASplit.length ; i++) {
    for (int j = 0; j < stringBSplit.length ; j++) {
        if(stringASplit[i].equalsIgnoreCase(stringBSplit[j])) {
            count++;
        }
    }
}

int min = Math.min(stringASplit.length, stringBSplit.length);

return (float)count/(float)min;
}   

private static final long serialVersionUID = 1L;


// Esse metodo tira os acentos das variaveis
public String removeAcentos(final String str) {
String strSemAcentos = Normalizer.normalize(str, Normalizer.Form.NFD);
strSemAcentos = strSemAcentos.replaceAll("[^\\p{ASCII}]", "");
return strSemAcentos;
}

//Local para escrever o texto
public JTextField txtEnter = new JTextField();

//Local para colocar os Textos
public JTextArea txtChat = new JTextArea();

public ChatBot() {
//Frame Attributes:
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setSize(900, 600);
this.setVisible(true);
this.setResizable(false);
this.setLayout(null);
this.setTitle("Pipo Chat Bot");

//txtEnter Attributes:
txtEnter.setLocation(2, 540);
txtEnter.setSize(590, 30);

//txtEnter Action Event:    
txtEnter.addActionListener(new ActionListener(){



    public void actionPerformed(ActionEvent arg0) {




        // informa que a variavel uText retorna o que está dentro do             TxtField 
        String uText = txtEnter.getText();
        // Declaro que a variavel uText fica toda em minusculo
        uText = uText.toLowerCase();
        // Declaro aqui que minha variavel tem que passar pelo             tratamento do metodo removeAcentos
        uText = removeAcentos(uText);
        String percentageCommomWords;



        txtChat.append("You: " + uText + "\n");


        if(uText.contains("oi") ){
            botFala("Oi!");
        }else if(uText.contains("bom dia")){
            botFala("bom dia !");
        }else if(uText.contains("boa tarde")){
            botFala("boa tarde!");
        }else if(uText.contains("boa noite")){
            botFala("boa noite!");
        }else if(uText.contains("quem é voce")){
            botFala("eu sou exterminador!");
        }else if(uText.contains("o que voce faz")){
            botFala("só tento responder sua pergunta!");
        }else if(uText.contains("e se eu nao tiver pergunta")){
            botFala("eu nao respondo!");
        }else if(uText.contains("podemos ser amigos")){
            botFala("sim!");
        }else if(uText.contains("você sabe o que é AI")){
            botFala("Artificial inteligencia? Ainda não estou tentando aprender os conceitos básicos, e complexos.!");
        }else if(uText.contains("você sabe responder em ingles?")){
            botFala("Não, no momento só falo uma lingua PT-BR!");
        }
        else if(uText.contains("como voce esta")){
            int decider = (int) (Math.random()*2+1);
            if(decider == 1){
                botFala("Estou bem e você?");
            }
            else if(decider == 2){
                botFala("Ate o momento tudo ok.");
            }
            }
        else{
            int decider = (int) (Math.random()*3+1);
            if(decider == 1){
                botFala("Não entendi o que você quis dizer");
            }
            else if(decider == 2){
                botFala("Por favor, você pode refazer a pergunta? Obrigado!");
            }
            else if(decider == 3){
                botFala("???");
            }
        }
        txtEnter.setText("");

    }
});

//txtChat Attributes:
txtChat.setLocation(15, 5);
txtChat.setSize(560, 510);
txtChat.setEditable(false);

//Add Items To Frame:
this.add(txtEnter);
this.add(txtChat);
}

public void botFala(String s){
txtChat.append("Exterminador da computação: " + s + "\n");
}

public static void main(String[] args){
new ChatBot();
}
}
