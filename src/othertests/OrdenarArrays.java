package othertests;

import java.util.Arrays;

public class OrdenarArrays {

	public static void main(String[] args) {

		int[] vet = { 7, 4, 10, 8, 2, 5 };

		System.out.println("Array sem ordenacao:");

		for (int n : vet) {
			System.out.print(n + " ");
		}
		System.out.println();

		for (int i = 1; i < vet.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vet[i] > vet[j]) {
					int aux = vet[i];
					vet[i] = vet[j];
					vet[j] = aux;
				}

			}
		}

		System.out.println("Array em ordem decrescente:");

		for (int n : vet) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
