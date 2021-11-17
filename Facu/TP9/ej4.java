/*
	4. Modificar los datos del archivo creado en el punto #3.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class ej4 {
	
	public static int showMatrix(ArrayList<String> Datos) {
		int max = Datos.size();
		int maxLength = 0;
		
		for(String line : Datos)
			if(line.length() > maxLength)
				maxLength = line.length();
		
		drawLine(maxLength);
		
		for(int i = 0; i < 2; i = i + 1) {
			System.out.print(" | " + (i+1));
			for(int j = 0; j < maxLength-2; j = j + 1) {
				System.out.print(" ");
			}
			System.out.print(" ");
		}
		
		System.out.print("|\n");
		drawLine(maxLength);
		
		int i;
		for(i = 0; i+1 < max; i = i + 2) {
			System.out.print((i/2+1) + "| " + Datos.get(i));
			int mxLngth = Datos.get(i).length();
			
			for(int j = 0; j < maxLength-mxLngth; j = j + 1) {
				System.out.print(" ");
			}
			
			System.out.print(" | " + Datos.get(i+1));
			mxLngth = Datos.get(i+1).length();
			
			for(int j = 0; j < maxLength-mxLngth; j = j + 1) {
				System.out.print(" ");
			}
			System.out.println("|");
			drawLine(maxLength);
		}
		return i / 2;
	}
	
	public static void drawLine(int maxLength) {
		for(int i = 0; i < maxLength*2 + 7; i = i + 1) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {		
		ArrayList<String> Datos = new ArrayList<String>();
		Scanner scan;
		try {
			File fileObj = new File("./ejercicio_3.csv");
			scan = new Scanner(fileObj);
			String data = new String();
			
			data = scan.nextLine();
			while (scan.hasNextLine()) 
				data = data + "\n" + scan.nextLine();
			
			String[] Data2 = data.split("(,|\n)", 100);
			
			for(String line : Data2)
				Datos.add(line);
			
			scan.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		int maxLines = showMatrix(Datos);
		scan = new Scanner(System.in);
		int modCol;
		do {
			System.out.print("\nIngrese la columna a modificar (Max 2, min 1): ");
			modCol = scan.nextInt();
			scan.nextLine();
		} while(!(modCol >= 1 && modCol <= 2));
		
		int modLne;
		do {
			System.out.print("\nIngrese la columna a modificar (Max " + maxLines + ", min 1): ");
			modLne = scan.nextInt();
			scan.nextLine();
		} while(!(modLne >= 1 && modLne <= maxLines));
		
		System.out.print("Ingrese el valor nuevo de la celda: ");
		Datos.set((modCol-1) + ((modLne-1) * 2), scan.nextLine());
		
		try{
			FileWriter myFile_W = new FileWriter("./ejercicio_3.csv", false);
			int max = Datos.size();
			for(int i = 0; i < max; i = i + 1) {
				myFile_W.write(Datos.get(i) + (i % 2 == 0 ? "," : "\n"));
			}
			myFile_W.close();
			System.out.println("Successfully written to the file.");
		} catch(Exception e) {
			System.out.println("Error");
		}
		
		while(Datos.size() > 0)
			Datos.remove(0);
		
		try {
			File fileObj = new File("./ejercicio_3.csv");
			scan = new Scanner(fileObj);
			String data = new String();
			
			data = scan.nextLine();
			while (scan.hasNextLine()) 
				data = data + "\n" + scan.nextLine();
			
			String[] Data2 = data.split("(,|\n)", 100);
			
			for(String line : Data2)
				Datos.add(line);
			
			scan.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		int thisdsad = showMatrix(Datos);
	}
}