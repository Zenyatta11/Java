/*
	11-Se tiene un array de 10 posiciones, que guarda los nombres de los alumnos. 
	Además se tiene otro array que guarda las notas de los alumnos.
	
	a-se pide hacer una función que recorriendo ambos arrays, me muestre la mejor nota.
	b-Calcule y muestre el promedio de todas las notas (del array).
*/

import java.util.Arrays;
import java.util.Scanner;

public class ej11 {
	
	public static void main(String[] args) {
		int MAX = 4;
		String[] nombres = new String[MAX];
		int[] notas = new int[MAX];
		int maxNota = 0;
		float promedio = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("\nIngrese el nombre de alumno: ");
			nombres[i] = scan.nextLine();
			
			System.out.print("Ingrese la nota de " + nombres[i] + ": ");
			notas[i] = scan.nextInt();
			scan.nextLine();
			
			if(notas[maxNota] < notas[i])
				maxNota = i;
			promedio = promedio + (float)notas[i];
		}
		
		promedio = promedio / (float)MAX;
		
		System.out.println("\nEl alumno con la mejor nota es " + nombres[maxNota] + " con una nota de " + notas[maxNota] + 
			"\nEl promedio de las notas es de " + String.format("%.2f", promedio));
		
		scan.close();
	}
}