package othertests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

public class LeituraArquivo {

	public static void main(String[] args) {
		Escreve();
		
		String caminho = "C:/Users/Vinicius/Documents/NetBeansProjects/ProjetoORI/inseremarca.exe";
		
		System.out.println(new File(caminho).getParent());
	}

	public static void Escreve() {

		char[][] grid = { { 'W', 'S', 'W', 'W' }, { 'W', 'W', '_', 'E' } };

		File newFile = new File("D:\\workspace\\StackOverflow\\src\\res\\doc.txt");

		if (newFile.exists()) {

			System.out.println("já existe");

		} else {

			try {
				newFile.createNewFile();
				FileWriter fileW = new FileWriter(newFile);
				BufferedWriter buffW = new BufferedWriter(fileW);
				for (char[] g : grid) {
					buffW.write(String.valueOf(g) + System.getProperty("line.separator"));
				}

				buffW.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	
	
	
}
