package othertests;

import java.util.HashSet;
import java.util.Set;

public class DuplicateObjectTest {

	public static void main(String[] args) {

		Set<CustomObject> objects = new HashSet<CustomObject>();

		for (int i = 0; i < 4; i++) {
			objects.add(new CustomObject(1, "someobject"));

		}

		for (CustomObject obj : objects) {
			System.out.println(obj.getCod() + " - " + obj.getDesc());
			System.out.println();
		}

	}

}

class CustomObject {

	private int cod;
	private String desc;

	public CustomObject(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}