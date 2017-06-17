package othertests;

import java.util.*;
import java.io.*;


public class RenamingFiles{

    public static void main(String[] args) throws Exception{

		File f = new File(".");
		File[] files = f.listFiles();

		for(File fl : files){
			String fileName = fl.getName();

			if(fileName.matches("^P - ")){

				System.out.println(fileName );
			}
		}
    }
}