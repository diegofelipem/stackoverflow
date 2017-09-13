package othertests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DiaDaSemanaptbrTest {

	public static void main(String[] args) {
		System.out.println(getWeek("07/09/2017"));

	}
	
	public static String getWeek(String date){ //ex 07/03/2017
        String dayWeek = "---";
        GregorianCalendar gc = new GregorianCalendar();
        try {
            gc.setTime(new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR")).parse(date));
           return new SimpleDateFormat("EEE", new Locale("pt", "BR")).format(gc.getTime()).toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayWeek;
    }

}
