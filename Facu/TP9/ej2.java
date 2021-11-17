/*
	2. Modificar el archivo creado en el punto 1, e incluir en él su nombre, apellido y año que cursa.
*/

import java.io.FileWriter;

public class ej2 {
	
	public static void main(String[] args) {
		try{
			FileWriter myFile_W = new FileWriter("./ejercicio_1.txt", true);
			myFile_W.write("\n\nMateo Roizman, Agustin Pezzoni, Bruno Santalucia, Tomas Veloso Neves\nSegundo año");
			myFile_W.close();
			System.out.println("Successfully appended to the file.");
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
}