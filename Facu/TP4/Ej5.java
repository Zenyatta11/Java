/*
	5 Hacer una función que dado un ArrayList de Enteros, me permita mostrar el valor menor contenido en dicha estructura con el
	mensaje el valor menor es:
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Ej5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> Numeros = new ArrayList<Integer>();
		
		int amt;
		
		do {
			System.out.print("Ingrese la cantidad de numeros a ingresar: ");
			amt = scan.nextInt();
			scan.nextLine();
		} while(amt <= 0);
		
		System.out.println("\n");
		
		for(int i = 0; i < amt; i = i + 1) {
			System.out.print("Ingrese " + (i == 0 ? "un" : "otro") + " numero" + (i == 0 ? "" : " (Restan " + (amt-i) + ")") + ": ");
			Numeros.add(scan.nextInt());
			scan.nextLine();
		}
		
		int menor = Numeros.get(0);
		
		for(Integer Numero : Numeros) {
			if(Numero < menor) menor = Numero;
		}
		System.out.println("El numero menor es: " + menor);
		scan.close();
	}
}