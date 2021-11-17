/*
	2 Hacer  un  programa que  me  permita  crear  un  arrayList
		que  guarde  las  edades  de  un grupo de alumnos de la comisión de prog II.
		a. Se pide mostrar dicha información por pantalla.
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int amt;
		int edad;
		
		class alumnoClass {
			String nombre;
			int edad;
			
			public alumnoClass(String nombre, int edad) {
				this.edad = edad;
				this.nombre = nombre;
			}
		}
		
		ArrayList<alumnoClass> Alumnos = new ArrayList<alumnoClass>();
		
		do {
			System.out.print("Ingrese la cantidad de alumnos a ingresar: ");
			amt = scan.nextInt();
			scan.nextLine();
		} while(amt <= 0);
		
		System.out.println("\n");
		
		for(int i = 0; i < amt; i = i + 1) {
			System.out.print("Ingrese el nombre del alumno " + (i+1) + ": ");
			String nombre = scan.nextLine();
			
			do {
				System.out.print("Ingrese la edad del alumno: ");
				edad = scan.nextInt();
				scan.nextLine();
			} while(edad <= 0);
			alumnoClass alumno = new alumnoClass(nombre, edad);
			Alumnos.add(alumno);
		}
		
		System.out.println("\nListado de alumnos:");
		
		for(alumnoClass Alumno : Alumnos) {
			System.out.println("El alumno se llama " + Alumno.nombre + " y tiene " + Alumno.edad + " anios.");
		}
		scan.close();
	}
}