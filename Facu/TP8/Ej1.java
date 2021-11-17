
/*
	Se pide que dado un dato de tipo entero, se valide si su extensión cumple con 
	el mínimo requerido de 8 dígitos y mostrarlo por pantalla.
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Ej1 {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		Pattern pattern = Pattern.compile("^\\d{8,}$");
		
		Matcher matcher;
		boolean matchFound;
		
		do {
			System.out.print("Ingrese un numero de al menos 8 digitos: ");
			
			matcher = pattern.matcher(scan.nextLine());
			matchFound = matcher.find();
			if(!matchFound) System.out.println("El numero ingresado es erroneo.\n");
		} while(!matchFound);
		
		System.out.println("El numero es valido!");
	}
}