package othertests;

import java.util.List;
import java.util.Vector;

public class CovarianceTest {
	
	  public static void main(String args[]){
		    List<? extends Number> ml=new Vector<Number>();

		    ml.get(0); //v�lido
//		    ml.add(7); // erro de compila��o
//		    ml.add(new Double(7d));// erro de compila��o
//		    ml.add(new Object());//n�o compila
		    
		    List<? super Number> foo =new Vector<Number>();
		    
		    foo.add(new Double(7d));// v�lido
//		    foo.get(new Double(7d)); //n�o compila
		  }
}
