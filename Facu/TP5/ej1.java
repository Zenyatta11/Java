/*
	1- Haga un programa que permita el ingreso por teclado de 10 números, ordenarlos de menor a mayor y de mayor a menor.
	Muestre también en una variable la suma de todos los nros y además se muestre en otra variable el promedio
*/

import java.util.Scanner;
import java.util.Arrays;

public class ej1 {
	
	public static final int MAX = 10;
	
	public static String printArray(int[] numeros, boolean invertido) {
		int maximo = numeros.length;
		String retVal = "";
		
		if(invertido)
			for(int i = 0; i < maximo; i = i + 1)
				retVal = retVal + String.valueOf(numeros[i]) + "; ";
		else
			for(int i = maximo - 1; i >= 0; i = i - 1)
				retVal = retVal + String.valueOf(numeros[i]) + "; ";
		
		return retVal;
	}
	
	public static void main(String[] args) {
		int[] numeros = new int[MAX];
		int suma = 0;
		float promedio = 0;
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otro") + " numero" + (i == 0 ? ": " : " (Restan " + (MAX-i) + "): "));
			numeros[i] = scan.nextInt();
			suma = suma + numeros[i];
		}
		
		promedio = (float)suma / (float)MAX;
		Arrays.sort(numeros);
		
		System.out.println("\nNumeros de Mayor a Menor: " + printArray(numeros, false) + "\nNumeros de Menor a Mayor: " + printArray(numeros, true));
		System.out.printf("\nSuma de los numeros: %d; Promedio: %.2f\n\n", suma, promedio);
		
		scan.close();
	}
}