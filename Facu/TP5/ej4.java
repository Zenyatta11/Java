/*
	4-Hacer un programa que me permita comparar dos números ingresados por teclado y muestre el mayor.
	Luego el menor.
*/

import java.util.Scanner;

public class ej4 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numA;
		int numB;
		
		System.out.print("Ingrese un numero: ");
		numA = scan.nextInt();
		
		System.out.print("Ingrese otro numero: ");
		numB = scan.nextInt();
		
		if(numA > numB) System.out.println("El numero " + numA + " es mayor y el numero " + numB + " es menor.\n");
		else System.out.println("El numero " + numB + " es mayor y el numero " + numA + " es menor.\n");
		
		scan.close();
	}
}