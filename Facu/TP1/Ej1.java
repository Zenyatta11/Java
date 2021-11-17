import java.util.Scanner;

public class Ej1 {
	public static void main(String[] args){
		System.out.print("Ejercicio 1 - Suma de dos numeros\n\nIngrese un numero: ");
		Scanner scan = new Scanner(System.in);
		int numA = scan.nextInt();
		System.out.print("Ingrese un segundo numero: ");
		int numB = scan.nextInt();
		System.out.println("\nLa suma de los numeros es " + (numA + numB) + '.');
		scan.close();
	}
}
