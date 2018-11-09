package swing.examples9.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import swing.examples9.JTablePaginacaoExemplo;

public class JSONUtils {

    private static String strjson = null;

    private JSONUtils() {

        if (strjson == null)
            strjson = lerArquivo();
    }

    public static List<MatriculaModel> JSONtoList() {
        String str = lerArquivo();
        Type type = new TypeToken<List<MatriculaModel>>() {
        }.getType();

        Gson gson = new GsonBuilder().create();
        List<MatriculaModel> lista = gson.fromJson(str, type);

        for (MatriculaModel teste : lista) {
            System.out.println(teste.getSelecionado());
            System.out.println(teste.getNome());
        }
        return lista;
    }

    private static String lerArquivo() {
        String linha = "";

        try {
//            FileReader arq = new FileReader("C:\\Users\\maily\\Documents\\NetBeansProjects\\Matricula\\src\\matricula\\dados.json");
//            BufferedReader lerArq = new BufferedReader(arq);
        	BufferedReader lerArq = new BufferedReader(new InputStreamReader(JTablePaginacaoExemplo.class.getResourceAsStream("/res/matricula.json")));

            linha = lerArq.readLine();
            /*
             * while (linha != null) { System.out.printf(linha); linha = lerArq.readLine();
             * // lê da segunda até a última linha }
             */
//            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        // System.out.println(linha);
        return linha;
    }
}