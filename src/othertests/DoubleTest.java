package othertests;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class DoubleTest {
	
	public static void main(String[] args) throws ParseException {
		
		String str = "1.000";
		
		System.out.println(Double.parseDouble(str.replaceAll("\\.", "")));

	}
}
