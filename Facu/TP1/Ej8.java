import java.util.Scanner;

public class Ej8 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ejercicio 8 - Informacion de un Estudiante\n");
		
		System.out.print("Ingrese el nombre del estudiante: ");
		String nombre = scan.nextLine();
		
		System.out.print("Ingrese el apellido del estudiante: ");
		String apellido = scan.nextLine();
		
		System.out.print("Ingrese la edad del estudiante: ");
		int edad = scan.nextInt();
		
		scan.nextLine();
		
		System.out.print("Ingrese la carrera del estudiante: ");
		String carrera = scan.nextLine();
		
		System.out.print("\nI N F O R M A C I O N\n\nNombre Completo: " + nombre + " " +
			apellido + "\nEdad: " + edad + " anos\nCarrera: " + carrera + "\n\n");
		
		scan.close();
	}
}