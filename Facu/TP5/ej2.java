/*
	2- Haga un programa que pida ingreso de datos por teclado de nombre y apellido y los muestre por pantalla con la leyenda Hola + datos ingresados
*/
import java.util.Scanner;

public class ej2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Ingrese su nombre y apellido: ");
		String nombre = scan.nextLine();
		System.out.println("\nHola " + nombre + "!\n");
		
		scan.close();
	}
}