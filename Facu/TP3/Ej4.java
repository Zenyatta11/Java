/*
Dado un Array de String llamado Cliente,se pide que:
	a.se realice la carga de los mismos pidiendo los datos por teclado. 
	b.Se pide mostrar por pantalla un listado con todos los clientes cargados.
	c.Se pide ordenar todos los clientes ordenados de menor a mayor.
*/

import java.util.Scanner;
import java.util.Arrays;

public class Ej4 {
	
	static int MAX;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Ingrese la cantidad de clientes a ingresar: ");
			MAX = scan.nextInt();
			scan.nextLine();
			if(MAX < 2) System.out.println("El numero ingresado es invalido.\n");
		} while(MAX < 2);
		
		String[] Cliente = new String[MAX];
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otro") + " cliente" +
								(i == 0 ? "" : " (Restan " + (MAX-i) + ") ") + ": ");
			Cliente[i] = scan.nextLine();
		}
		
		Arrays.sort(Cliente);
		System.out.println("");
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.println(Cliente[i]);
		}
		System.out.println("");
		
	}
}