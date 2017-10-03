package othertests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternTest {

	public static void main(String[] args) {

		String text = "um2tres4cinco6sete8";

		String regex = "[0-9]";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);

		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
