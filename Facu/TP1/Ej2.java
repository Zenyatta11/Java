import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args){
		System.out.print("Ejercicio 2 - Nombre y Apellido\n\nIngrese su nombre: ");
		
		Scanner scan = new Scanner(System.in);
		String nombre = scan.nextLine();
		
		System.out.print("Ingrese su apellido: ");
		String apellido = scan.nextLine();
		
		System.out.println("\nSu nombre completo es " + nombre + ' ' + apellido + '.');
		scan.close();
	}
}
