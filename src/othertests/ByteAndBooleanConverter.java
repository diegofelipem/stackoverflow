package othertests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ByteAndBooleanConverter {
	
	public static void main(String args[]) throws Exception {
		
		boolean[] boolArray = {true, true, true, true, false, false, false, false};
		
		byte b = boolArrToByte(boolArray);
		System.out.println(b);
		
		System.out.println(Arrays.toString(byteToBoolArr(b)));
		
		testConvert();
		
	}
	
	
	public static boolean[] byteToBoolArr(byte b) {
	    boolean[] array = new boolean[8];
	    for (int i=0; i<8 ;i++){
	        array[i] = (b & (1 << i)) != 0;
	    }
	    return array;
	}
	
	
	public static byte boolArrToByte(boolean[] array) {
	    if (array.length != 8) throw new IllegalArgumentException();
	    byte b = 0;
	    for (int i = 0; i < 8; i++) {
	        if (array[i]) {
	        b |= 1 << i;
	        }
	    }
	    return b;
	}
	
	public static void testConvert() throws Exception{
	    boolean[] esperado =  {true, true, true, true, false, false, false, false};
	    byte[] result;
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(bos);

	    oos.writeObject(esperado);

	    oos.flush(); 
	    result = bos.toByteArray();

	    System.out.println(result.length);

	    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(result));

	    boolean[] obtido = (boolean[]) ois.readObject();

	    for(int i = 0; i < esperado.length; i++){
	        System.out.println(esperado[i]);
	    }
	}
}
