package othertests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CalcularIdadeTest {

	public static void main(String[] args) throws ParseException {

		Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse("03/09/1990");

		LocalDate ldirthday = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		System.out.println(Period.between(ldirthday, LocalDate.now()).getYears());
	}

}
