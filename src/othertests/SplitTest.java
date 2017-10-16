package othertests;

import java.util.Arrays;

public class SplitTest {


	public static void main(String[] args) {
		
		String teste = "espaco pontoevirgula;QUEBRA\ndelinha;;";
		
		String[] stringSeparada = teste.split("((?<=;)|(?=;))|[\\s]|[\\r?\\n]");
		
		System.out.println(Arrays.toString(stringSeparada));

	}

}
