
import java.util.ArrayList;
import java.util.Scanner;

public class Ej1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> Alumnos = new ArrayList<String>();
		
		int amt;
		
		do {
			System.out.print("Ingrese la cantidad de alumnos a ingresar: ");
			amt = scan.nextInt();
			scan.nextLine();
		} while(amt <= 0);
		
		System.out.println("\n");
		
		for(int i = 0; i < amt; i = i + 1) {
			System.out.print("Ingrese el nombre del alumno " + i + ": ");
			Alumnos.add(scan.nextLine());
		}
		
		System.out.println("\n");
		
		for(String Alumno : Alumnos) {
			System.out.println("El alumno se llama " + Alumno);
		}
		scan.close();
	}
}