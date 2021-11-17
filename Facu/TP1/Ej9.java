import java.util.Scanner;

public clss Ej9 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ejercicio 9 - Informacion de una Persona\n");
		
		System.out.print("Ingrese el nombre completo de la persona: ");
		String nombre = scan.nextLine();
		
		char sexo;
		do{
			System.out.print("Ingrese el sexo de la persona: ");
			sexo = scan.findInLine(".").charAt(0);
			scan.nextLine();
			
			if(sexo != 'm' && sexo != 'M' && sexo != 'f' && sexo != 'F')
				System.out.println("El sexo ingresado es invalido!\n");
			
		} while(sexo != 'm' && sexo != 'M' && sexo != 'f' && sexo != 'F');
		
		int edad;
		do{
			System.out.print("Ingrese la edad de la persona: ");
			edad = scan.nextInt();
			scan.nextLine();

			if(edad <= 0 || edad > 120)
				System.out.println("La edad ingresada es invalida!");
			
		} while(edad <= 0 || edad > 120);
		
		int dni;
		do{
			System.out.print("Ingrese el documento de la persona: ");
			dni = scan.nextInt();
			scan.nextLine();

			if(dni <= 999999 || dni > 99999999)
				System.out.println("El documento ingresado es invalido!\n");
			
		} while(dni <= 999999 || dni > 99999999);
		
		System.out.print("Ingrese la profesion de la persona: ");
		String carrera = scan.nextLine();
		
		System.out.print("\nI N F O R M A C I O N\n\nNombre Completo: " + nombre 
					+ "\nSexo: " + sexo +
					"\nEdad: " + edad + " anos\nProfesion: "
					+ carrera + "\nDNI: "
					+ dni + "\n\n");
		
		scan.close();
	}
}