package othertests;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringSplitStreamTest {

	public static void  main(String[] args) {
		
		String str = "0.1253729 09863637 02937382 029828020";
		
	    String[] array = Pattern.compile("\\s").splitAsStream(str).toArray(String[]::new);
	    
	    System.out.println(Arrays.toString(array));
	}
	
}
