package othertests;

import java.util.stream.IntStream;

public class ChecarValorEmArrayTest {

	public static void main(String[] args) {

		int[] numbersArray = { 1, 2, 3, 4 };
		boolean contains = IntStream.of(numbersArray).anyMatch(x -> x == 5);

		System.out.println("Checando com Streams...");
		System.out.println();
		
		if (contains) {
			System.out.println("Contem o numero 5");
		} else {
			System.out.println("Nao contem o numero 5");
		}
		
		System.out.println("\nChecando sem Streams...");
		System.out.println();

		if (contains(numbersArray, 5)) {
			System.out.println("Contem o numero 5");
		} else {
			System.out.println("Nao contem o numero 5");
		}
	}

	public static boolean contains(final int[] array, final int v) {

		boolean result = false;

		for (int i : array) {
			if (i == v) {
				result = true;
				break;
			}
		}

		return result;
	}
}
