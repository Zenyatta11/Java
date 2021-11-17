/*
	3 Hacer una función que me permita ordenar de menor a mayor los datos del punto #2.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Ej3 {
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
		Collections.sort(Alumnos,(alumno1, alumno2) -> alumno1.edad - alumno2.edad);
		
		for(alumnoClass Alumno : Alumnos) {
			System.out.println("El alumno se llama " + Alumno.nombre + " y tiene " + Alumno.edad + " anios.");
		}
		scan.close();
	}
}