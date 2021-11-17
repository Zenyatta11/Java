import java.util.Scanner;

public class Ej4 {
	public static void main(String[] args){
		int numA, numB;
		String showVal;
		
		System.out.print("Ejercicio 4 - Mayor o Igual\n");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Ingrese un numero: ");
		numA = scan.nextInt();

		System.out.print("Ingrese otro numero: ");
		numB = scan.nextInt();
		
		if(numA == numB)
			showVal = "Los numeros son iguales.";
		else if(numA > numB)
			showVal = "El primer numero ingresado es mayor.";
		else
			showVal = "El segundo valor ingresado es mayor.";
		
		System.out.println("\n" + showVal);
		
		scan.close();
	}
}
