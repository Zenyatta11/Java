
/*
Dado un listado de precios (Estructura de Array), se pide que:
	a.	Se realice la carga del mismo pidiendo los datos por teclado.
	b.	ordénelo de mayor a menor.
*/

import java.util.Scanner;
import java.util.Arrays;

public class Ej1{
	
	static int MAX;
	
	public static void showArray(int[] arrayToShow) {
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print(arrayToShow[i] + (i == MAX-1 ? "];\n" : ", "));
		}
	}
	
	public static int[] reverseArray(int[] arrayToReverse) {
		int[] newArray = new int[MAX];
		int j = 0;
		for(int i = MAX-1; i >= 0; i = i - 1) {
			newArray[j] = arrayToReverse[i];
			j = j + 1;
		}
		return newArray;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Ingrese la cantidad de precios a ingresar: ");
			MAX = scan.nextInt();
			if(MAX < 2) System.out.println("El numero ingresado es invalido.\n");
		} while(MAX < 2);
		
		int[] preciosArray = new int[MAX];
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otro") + " numero" +
								(i == 0 ? "" : " (Restan " + (MAX-i) + ") ") + ": ");
			preciosArray[i] = scan.nextInt();
		}
		
		Arrays.sort(preciosArray);
		preciosArray = reverseArray(preciosArray);
		
		System.out.print("\nArrays' Sort: [");
		showArray(preciosArray);
		System.out.println("");
		scan.close();
	}
}