package othertests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ChecarPermissaoTest {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\TESTEJAVA\\test.txt");
		
		System.out.println(Files.isWritable(new File("C:\\TESTEJAVA").toPath()));
		file.createNewFile();		
	}

}
