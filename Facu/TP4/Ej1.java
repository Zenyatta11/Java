/*
	1 Hacer un programa que me permita crear un arrayList que contenga los nombres de los alumnos de la clase de programación II
	a. Realizar la carga del ArrayList.
	b. Se pide que dichos nombres sean mostrados por pantalla
*/

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
			System.out.print("Ingrese el nombre del alumno " + (i+1) + ": ");
			Alumnos.add(scan.nextLine());
		}
		
		System.out.println("\nListado de alumnos:");
		
		for(String Alumno : Alumnos) {
			System.out.println("El alumno se llama " + Alumno);
		}
		scan.close();
	}
}