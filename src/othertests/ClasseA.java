package othertests;

public 	class ClasseA {
	
	private static int instances = 0;
	
	public ClasseA() {
		instances++;
	}
	
	public static int getNumberInstances(){
		return instances;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Instanciando ClasseA...");
		ClasseA a = new ClasseA();
		System.out.println("No. de instancias: " + ClasseA.getNumberInstances());
		
		System.out.println("Instanciando ClasseB...");
		ClasseB b = new ClasseB();
		System.out.println("No. de instancias: " + ClasseA.getNumberInstances());
		
		System.out.println("Instanciando ClasseC...");
		ClasseC c = new ClasseC();
		System.out.println("No. de instancias: " + ClasseA.getNumberInstances());
	}
}


class ClasseB extends ClasseA {
	
}

class ClasseC extends ClasseA{
	
}