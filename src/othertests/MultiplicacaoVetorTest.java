package othertests;

public class MultiplicacaoVetorTest {

	public static void main(String[] args){
		int[] vetA = {1,2,3,4,5};
		int[] vetB = {1,2,3,4,5};
		int[][] mat =  new int[5][5];
		
		for(int i = 0; i < vetA.length;i++){
			for(int j = 0; j < vetB.length; j++){
				mat[i][j] = vetA[i] * vetB[j];
 			}
		}
		
		for(int i = 0; i < mat[0].length; i++){
			for(int j = 0; j < mat.length;j++ ){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
