/*
	3- Se pide hacer unprogramaque me permita mostrar por pantalla las iniciales del nombre y del apellido de los datos ingresados por teclado
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej3 {
	
	public static final Pattern patron = Pattern.compile("(^\\w|\\s\\w)");
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String iniciales = "";
		Matcher match;
		boolean found;
		
		do {
			found = false;
			System.out.print("Ingrese su nombre y apellido: ");
			match = patron.matcher(scan.nextLine());
			found = match.find();
			if(found) {
				iniciales = iniciales + match.group() + " ";
			}
		} while(!found);
		
		while(match.find()) 
			iniciales = iniciales + match.group() + " ";;
		
		System.out.println("\nSus iniciales son: " + iniciales);
		scan.close();
	}
}