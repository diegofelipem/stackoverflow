package othertests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Exception {
		
		final String  CONFIG_FILE = "teste.properties";
		
		File file = new File(CONFIG_FILE);

			if (!file.exists()) file.createNewFile();
		
		
		Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(CONFIG_FILE);
        prop.load(fis);
        
        prop.setProperty("prop.teste.excl", "CQT-SUST,NATONE");
        prop.store(new FileWriter("teste.properties"), null);
        
        String[] array = prop.getProperty("prop.teste.excl").split(",");
        
        System.out.println(Arrays.toString(array));
	}

}
