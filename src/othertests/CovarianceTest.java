package othertests;

import java.util.List;
import java.util.Vector;

public class CovarianceTest {
	
	  public static void main(String args[]){
		    List<? extends Number> ml=new Vector<Number>();

		    ml.get(0); //válido
//		    ml.add(7); // erro de compilação
//		    ml.add(new Double(7d));// erro de compilação
//		    ml.add(new Object());//não compila
		    
		    List<? super Number> foo =new Vector<Number>();
		    
		    foo.add(new Double(7d));// válido
//		    foo.get(new Double(7d)); //não compila
		  }
}
