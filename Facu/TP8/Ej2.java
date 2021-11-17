
/*
	2 Se pide que dado un nombre de usuario que eligió una persona que utiliza una aplicación, se valide si el mismo cumple con :
	Contener al menos 7 dígitos y si además los primeros 4 son letras y los 4 últimos son nros. No se puede usar caracteres especiales.

	La clave que utiliza el usuario debe contener 8 dígitos como máximo y 5 como mínimo y contener al menos un caracter especial
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args) {
		String username;
		
		Scanner scan = new Scanner(System.in);
		Pattern pattern = Pattern.compile("^[A-Za-z]{4,}(\\w|\\s)*\\d{4}$");
		
		Matcher matcher;
		boolean matchFound;
		
		do {
			System.out.println("El nombre de usuario debe contener al menos 7 digitos y si ademas los primeros 4 son letras y los 4 ultimos son nros.\nNo se puede usar caracteres especiales.");
			System.out.print("Ingrese el nombre de usuario: ");
			
			username = scan.nextLine();
			
			matcher = pattern.matcher(username);
			matchFound = matcher.find();
			if(!matchFound) System.out.println("El usuario ingresado es erroneo.\n");
		} while(!matchFound);
		
		pattern = Pattern.compile("\\d{1,}");
		Pattern pattern2 = Pattern.compile("^\\d{5,8}$");
		
		Pattern pattern3 = Pattern.compile("\\D{1,}");
		Pattern pattern4 = Pattern.compile("^\\W{1,}$");
		String passwd;
		
		boolean pass;
		do {
			pass = true;
			System.out.println("\nLa clave debe contener 8 digitos como maximo y 5 como minimo y contener al menos un caracter especial");
			System.out.print("Ingrese la contraseña: ");
			
			passwd = scan.nextLine();
			
			matcher = pattern.matcher(passwd);
			if(matcher.find()){
				String passwordDigits = matcher.group(0);
				matcher = pattern2.matcher(passwordDigits);
				if(!matcher.find())
					pass = false;
			}
			
			matcher = pattern3.matcher(passwd);
			if(matcher.find()) {
				String passwordNonDigits = matcher.group(0);
				matcher = pattern4.matcher(passwordNonDigits);
				if(!matcher.find())
					pass = false;
			}
			
			if(!pass) System.out.println("La contraseña ingresada es invalida.\n");
		} while(!pass);
		
		System.out.println("Su usuario es " + username + "\nSu contraseña es " + passwd);
	}
}