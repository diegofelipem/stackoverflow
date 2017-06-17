package othertests;

public class ParseToStringTest {

	public static void main(String[] args) {
		new ParseToStringTest().parseTest();
	}

	public void parseTest() {

		SomeObj o = new SomeObj();
		System.out.println(o.toString());
		System.out.println(String.valueOf(o));

	}

	class SomeObj {}
}
