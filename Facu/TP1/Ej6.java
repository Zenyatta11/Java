import java.util.Scanner;

public class Ej6 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ejercicio 6 - Bienvenida");
		System.out.print("\nIngrese un mensaje: ");
		
		String mensaje = scan.nextLine();
		
		System.out.println("\nBienvenidos " + mensaje);
		scan.close();
	}
}