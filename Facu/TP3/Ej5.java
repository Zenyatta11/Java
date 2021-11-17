/*
Dado un Array de String, se pide que:
	a.Se lo cargue con valores.
	b.Se lo muestre por pantalla.
*/

import java.util.Scanner;

public class Ej5 {
	
	static int MAX;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Ingrese la cantidad de lineas a ingresar: ");
			MAX = scan.nextInt();
			scan.nextLine();
			if(MAX < 2) System.out.println("El numero ingresado es invalido.\n");
		} while(MAX < 2);
		
		String[] Datos = new String[MAX];
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otra") + " linea" +
								(i == 0 ? "" : " (Restan " + (MAX-i) + ") ") + ": ");
			Datos[i] = scan.nextLine();
		}
		
		System.out.println("");
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.println(Datos[i]);
		}
		System.out.println("");
		
	}
}