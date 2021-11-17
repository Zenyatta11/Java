/*
	12-Hacer unprogramaque me pida el ingreso de tres números por teclado. 
	Se pide devolver por pantalla: los tres números ordenados de menor a mayor, el mayor de todos y que se devuelva por pantalla el doble del menor de los tres números.
*/

import java.util.Scanner;
import java.util.Arrays;

public class ej12 {
	
	public static void main(String[] args) {
		int MAX = 3;
		int[] numeros = new int[MAX];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otro") + " numero" + (i == 0 ? "" : " (Restan " + (MAX-i) + ")") + ": ");
			numeros[i] = scan.nextInt();
		}
		
		Arrays.sort(numeros);
		System.out.println("\n");
		for(int i = 0; i < MAX; i = i + 1) 
			System.out.println("" + numeros[i]);
		System.out.println("\nEl numero mas grande: " + numeros[MAX-1]);
		System.out.println("El doble del numero mas chico: " + numeros[0] * 2);
	}
}