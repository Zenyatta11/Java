/*
	5. Crear un archivo, escribir en el y mostrar el contenido del mismo por pantalla.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class ej5 {
	
	public static void main(String[] args) {
		try{
			FileWriter myFile_W = new FileWriter("./ejercicio_5.txt", true);
			myFile_W.write("\n\nMateo Roizman, Agustin Pezzoni, Bruno Santalucia, Tomas Veloso Neves\nSegundo año");
			myFile_W.close();
			System.out.println("Successfully written to the file.");
		} catch(Exception e) {
			System.out.println("Error");
		}
		
		try {
			File fileObj = new File("./ejercicio_5.txt");
			Scanner scan = new Scanner(fileObj);
			while (scan.hasNextLine()) {
				String data = scan.nextLine();
				System.out.println(data);
			}
			scan.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
