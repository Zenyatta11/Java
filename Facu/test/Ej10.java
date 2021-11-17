import java.util.Scanner;

public class Ej10 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ejercicio 10 - Primera Letra de un String\n");
		
		System.out.print("Ingrese un mensaje: ");
		String strA = scan.nextLine();
		
		System.out.print("Ingrese otro mensaje: ");
		String strB = scan.nextLine();
		
		System.out.println("\nLas primeras letras son " + strA.charAt(0) + " y " +
		strB.charAt(0) + ".\n\n");
		
		scan.close();
	}
}