package swing.examples6;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.UIManager;

public class UIManagerColorKeys {
	
	public static void main(String[] args) throws Exception {
		
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//			System.out.println(info);
			if (info.getName().equalsIgnoreCase("Windows")) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		Set<Entry<Object, Object>> entries = UIManager.getLookAndFeelDefaults().entrySet();
		
		for (Entry entry : entries) {
			if(entry.getKey().equals("MenuItem.selectionForeground"))
			System.out.println(entry.getValue());
		}
		
//		listColorKeys(entries);
//		saveDefaults(entries);

	}

	static void listColorKeys(Set<Entry<Object, Object>> entries) {

		List<String> colorKeys = new ArrayList<String>();

		for (Entry entry : entries) {
			if (entry.getValue() instanceof Color) {
				System.out.println((String) entry.getKey() + " - " + entry.getValue());
			}
		}

		// sort the color keys
		Collections.sort(colorKeys);

		// print the color keys
		for (String colorKey : colorKeys) {
			System.out.println(colorKey);
		}
	}
	
	static void saveDefaults(Set<Entry<Object, Object>> entries) throws IOException {
		
		StringBuilder builder = new StringBuilder();
		File file = new File("C:\\Users\\diego\\Desktop\\Default.txt");
		FileWriter fileWriter = new FileWriter(file);

		for (Entry entry : entries) {
			builder.append(entry.getKey().toString());
			builder.append(" - ");
			builder.append(entry.getValue().toString());
			builder.append(System.lineSeparator());
		}
		
		fileWriter.write(builder.toString());
		fileWriter.flush();
		fileWriter.close();
	}
}
