package othertests;

public class ProblemaDiamanteTest {

	public static void main(String[] args) {
		C c = new C();
		c.foo2();

	}

}


interface A {
	
	void foo();
	default void foo2(){
		System.out.println("foo2 interface A");
	}
}

interface B {
	void foo();
	
	default void foo2(){
		System.out.println("foo2 interface B");
	}
}

class C implements A, B{

	@Override
	public void foo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void foo2() {
		// TODO Auto-generated method stub
		B.super.foo2();
	}

}