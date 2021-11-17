/* 

Realizar un programa que pida el ingreso de dos números por teclado y que muestre la suma de los dos por pantalla.

*/
import java.util.Scanner;

public class toto {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ejercicio 1 - Suma de dos numeros\n");
		System.out.print("Ingrese un numero: ");
		int numA = input.nextInt();
		
		System.out.print("Ingrese otro numero: ");
		int numB = input.nextInt();
		
		System.out.println("La cuenta es: " + numA + " + " + numB + " = " + (numA+numB));
		
		input.close();
	}
}

