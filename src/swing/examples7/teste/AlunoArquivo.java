package swing.examples7.teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AlunoArquivo {

	public static File arquivo = new File("exibir.txt");
	// static DadoResultadoAluno dra = new DadoResultadoAluno();
	// private static String c1;
	// private static String c2;

	public static List<String> Read() {
		List<String> conteudo = new ArrayList<>();

		if (arquivoExiste()) {

			try {

				FileReader arq = new FileReader(arquivo);
				BufferedReader lerArq = new BufferedReader(arq);
				String linha = "";

				while (linha != null) {
					conteudo.add(linha);
					linha = lerArq.readLine();
				}
				arq.close();

				return conteudo;
			} catch (IOException ex) {
				System.out.println("Erro: Não foi possível ler o arquivo!");
			}
		}

		return null;
	}

	public static boolean Write(String Texto) {
		try {
			if (!arquivoExiste()) {
				arquivo.createNewFile();
				System.out.println("not");
			}
			System.out.println("Yes");
			FileWriter arq = new FileWriter(arquivo, true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(Texto);
			gravarArq.close();

			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void salvar(DadoResultadoAluno dra) {

		String print = dra.getQtdAcertoPlanificacao() + ";" + dra.getQtdErroPlanificacao();

		if (AlunoArquivo.Write(print)) {
			System.out.println("Arquivo salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar o arquivo!");
		}
	}

	public static boolean arquivoExiste() {
		return arquivo.exists();
	}

	// public static List<String> Read() {
	// List<String> conteudo = new ArrayList<>();
	//
	// try {
	// FileReader arq = new FileReader(arquivo);
	// BufferedReader lerArq = new BufferedReader(arq);
	// String linha = "";
	// try {
	// while (linha != null) {
	// conteudo.add(linha);
	// linha = lerArq.readLine();
	// }
	// arq.close();
	// return conteudo;
	// } catch (IOException ex) {
	// System.out.println("Erro: Não foi possível ler o arquivo!");
	// }
	// } catch (FileNotFoundException ex) {
	// System.out.println("Erro: Arquivo não encontrado!");
	// }
	// return null;
	// }

	// public static boolean Write(String Caminho, String Texto) {
	// try {
	// if (!arquivoExiste()) {
	// arquivo.createNewFile();
	// System.out.println("not");
	// } else {
	// System.out.println("Yes");
	// FileWriter arq = new FileWriter(arquivo, true);
	// PrintWriter gravarArq = new PrintWriter(arq);
	// gravarArq.println(Texto);
	// gravarArq.close();
	// }
	// return true;
	// } catch (IOException e) {
	// System.out.println(e.getMessage());
	// return false;
	// }
	// }

	// public static void salvar(int countQtdAcertoPlanificacao, int
	// countQtdErroPlanificacao, String ArqConfig) {
	//
	// dra.setQtdAcertoPlanificacao(countQtdAcertoPlanificacao);
	// dra.setQtdErroPlanificacao(countQtdErroPlanificacao);
	//
	// String print = dra.getQtdAcertoPlanificacao() + ";" +
	// dra.getQtdErroPlanificacao();
	// System.out.println("ultimo cont: " + countQtdErroPlanificacao + "");
	//
	// if (AlunoArquivo.Write(ArqConfig, print)) {
	// System.out.println("Arquivo salvo com sucesso!");
	// } else {
	// System.out.println("Erro ao salvar o arquivo!");
	// }
	// }

	// public static void mostrar(String ArqConfig) {
	//
	// if(!arquivoExiste())
	// return;
	//
	// List<String> conteudo = AlunoArquivo.Read(ArqConfig);
	//
	// for (String linha : conteudo) {
	// c1 = linha.split(";")[0];
	// c2 = linha.split(";")[1];
	// }
	// }

	// public static String getC1() {
	// return c1;
	// }
	//
	// public static String getC2() {
	// return c2;
	// }

}