package othertests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static void main(String[] args) throws Exception {

		apagarArquivos(filtrarArquivos(new File("C:\\Temp")));
		listarArquivos(filtrarArquivos(new File("C:\\Temp")));
	}

	private static void apagarArquivos(List<File> files) throws IOException {

		files.forEach(f -> {
			try {
				Files.deleteIfExists(f.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	private static void listarArquivos(List<File> files) {

		if (files.isEmpty()) {
			System.out.println("Nenhum arquivo encontrado");
		} else {
			for (File file : files) {
				System.out.println(file.getAbsolutePath());
			}
		}
	}

	private static List<File> filtrarArquivos(File source) throws IOException {

		List<File> fileList = new ArrayList<>();

		Files.walk(source.toPath())
			.map(arquivo -> arquivo.toFile())
			.filter(arquivo -> arquivo.isFile())
			.forEach(fileList::add);

		return fileList;
	}
}
