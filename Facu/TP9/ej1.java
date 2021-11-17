/*
	1.Crear un archivo en el directorio que Ud. Decida.
	El archivo debe ser de texto.
	En el interior debe escribir Programación II.
*/

import java.io.File;
import java.io.FileWriter;

public class ej1 {
	
	public static void main(String[] args) {
		File myFile = new File("./ejercicio_1.txt");
		try{
			if(myFile.createNewFile()){
				System.out.println("File created: " + myFile.getName());
				
				FileWriter myFile_W = new FileWriter("./ejercicio_1.txt");
				myFile_W.write("Programación II");
				myFile_W.close();
				System.out.println("Successfully wrote to the file.");
			} else
				System.out.println("File already exists.");
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
}