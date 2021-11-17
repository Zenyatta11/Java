/*
	Dado un Array de enteros llamado Edades, saque el promedio de los mismos y muéstrelos por pantalla
*/


import java.util.Scanner;

public class Ej2{
	
	static int MAX;
	static double promedio;
	static int suma;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Ingrese la cantidad de edades a ingresar: ");
			MAX = scan.nextInt();
			if(MAX < 2) System.out.println("El numero ingresado es invalido.\n");
		} while(MAX < 2);
		
		int[] preciosArray = new int[MAX];
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otra") + " edad" +
								(i == 0 ? "" : " (Restan " + (MAX-i) + ") ") + ": ");
			preciosArray[i] = scan.nextInt();
			suma = suma + preciosArray[i];
		}
		promedio = (double)suma / MAX;
		promedio = Math.floor(promedio * 100)/100;
		
		System.out.println("\nPromedio de edad: " + promedio + " anios");
		scan.close();
	}
}