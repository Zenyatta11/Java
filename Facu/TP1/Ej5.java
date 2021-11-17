import java.util.Scanner;
import java.lang.Math;

public class Ej5 {
	public static void main(String[] args){
		System.out.print("Ejercicio 5 - Operaciones Aritmeticas\n\nIngrese un numero: ");
		Scanner scan = new Scanner(System.in);
		int numA = scan.nextInt();
		System.out.print("Ingrese un segundo numero: ");
		int numB = scan.nextInt();
		System.out.print("\nLa suma de los numeros es " + (numA + numB) + '.');
		System.out.print("\nLa resta de los numeros es " + (numA - numB) + '.');
		System.out.print("\nLa multiplicacion de los numeros es " + (numA * numB) + '.');
		System.out.print("\nLa division de los numeros es " + Math.floor(((float)numA / (float)numB)*100)/100 + ".\n\n");
		scan.close();
	}
}
