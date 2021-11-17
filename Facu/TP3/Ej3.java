/*
Dado un Array de reales llamados precios, se pide que:
	a.Realice la carga pidiendo el ingreso los datos por teclado.
	b.saque el menor valor y lo muestre por pantalla, indicando que es el menor valor.
*/


import java.util.Scanner;

public class Ej3{
	
	static int MAX;
	static double promedio;
	static int suma;
	
	public static int getMenorNumero(double[] arrayToSearch) {
		int min = 0;
		for(int i = 0; i < MAX; i = i + 1) 
			if(arrayToSearch[i] < arrayToSearch[min]) 
				min = i;
		
		return min;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Ingrese la cantidad de precios a ingresar: ");
			MAX = scan.nextInt();
			if(MAX < 2) System.out.println("El numero ingresado es invalido.\n");
		} while(MAX < 2);
		
		double[] preciosArray = new double[MAX];
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otro") + " precio" +
								(i == 0 ? "" : " (Restan " + (MAX-i) + ") ") + ": ");
			preciosArray[i] = scan.nextDouble();
		}
		
		int menor = getMenorNumero(preciosArray);
		
		System.out.println("\nEl valor menor es $" + preciosArray[menor] + ", ubicado en la posicion " + menor);
		scan.close();
	}
}