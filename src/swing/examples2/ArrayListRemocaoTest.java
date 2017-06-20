package swing.examples2;

import java.util.ArrayList;

public class ArrayListRemocaoTest {
	
	public static void main(String[] args) {
		
		System.out.println("- Removendo o primeiro item/indice");		
		executarTeste("0");
		System.out.println();
		System.out.println("- Removendo um item/indice intermediario");
		executarTeste("5000");
		System.out.println();
		System.out.println("- Removendo o ultimo item/indice");
		executarTeste("9999");
		
	}

	private static void executarTeste(String valueIndex) {
		
		ArrayList<String> array1 = new ArrayList<>(10000);
		ArrayList<String> array2 = new ArrayList<>(10000);
		
		for(int i = 0; i < 10000; i++){
			array1.add(i+"");
			array2.add(i+"");
		}

		int indice = Integer.valueOf(valueIndex);
		
		long startTime = System.nanoTime();
		array1.remove(indice);
		long endTime = System.nanoTime();

		double duration1 = (endTime - startTime)/1000000d;
		
		System.out.println("Tempo de remoção do remove(index)(ms): " + String.format("%.3f", duration1));		
		
		startTime = System.nanoTime();
		array2.remove(valueIndex);
		endTime = System.nanoTime();

		double duration2 = (endTime - startTime)/1000000d;
		
		System.out.println("Tempo de remoção do remove(Element)(ms): " + String.format("%.3f", duration2));
		
		System.out.println("Diferença de tempo entre as duas formas: " + String.format("%.3f", (duration2-duration1)));
	}

}
