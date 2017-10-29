package othertests;

import java.util.Scanner;

public class TrianguloAsteriscoTest {

	public TrianguloAsteriscoTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("base: ");
		int base = input.nextInt();
		
		for(int linha = 0; linha < base; linha++) {
			System.out.println("");
			for(int coluna = 0; coluna < linha; coluna++) {
				System.out.print("*");
			}
		}

	}

}
