package othertests;

public class ObjectTest {

	public static void main(String[] args) {
		if("a" instanceof String){
			
		}
		

	}
}

class SomeObject implements Comparable<SomeObject>{

	private String fieldOne;
	private int fieldTwo;

	public String getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}

	public int getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(int fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	@Override
	public int compareTo(SomeObject o) {
		
		return this.fieldTwo - o.fieldTwo;
	}
}
