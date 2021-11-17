/*
6.Dado un Array de alumnos (usar Array de objetos),  se pide que el objeto alum tenga como atributos: nombre, apellido, edad, nacionalidad y documento.
	a.Realizar los métodos necesarios para que se pueda trabajar con los atributos
	b.Se pide que se muestren por pantalla los alumnos ordenados por nro de documento y que se visualicen todos los datos del mismo
*/

import java.util.Scanner;
import java.util.Arrays;

public class Ej6 {
	
	static int MAX;
	
	public static class classAlumno {
		String nombre, apellido, nacionalidad;
		int edad;
		long documento;
		
		public classAlumno(String nombre, String apellido, String nacionalidad, int edad, long documento) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.nacionalidad = nacionalidad;
			this.edad = edad;
			this.documento = documento;
		}
		
		public String getName() {
			return this.nombre + this.apellido;
		}
		
		public String getNacionalidad() {
			return this.nacionalidad;
		}
		
		public int getEdad() {
			return this.edad;
		}
		
		public long getDNI() {
			return this.documento;
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("Ingrese la cantidad de alumnos a ingresar: ");
			MAX = scan.nextInt();
			scan.nextLine();
			if(MAX < 2) System.out.println("El numero ingresado es invalido.\n");
		} while(MAX < 2);
		
		classAlumno[] Alumnos = new classAlumno[MAX];
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("\nIngrese el nombre del alumno: ");
			String nombre = scan.nextLine();
			
			System.out.print("Ingrese el apellido de " + nombre + ": ");
			String apellido = scan.nextLine();
			
			System.out.print("Ingrese la nacionalidad nombre de " + nombre + ": ");
			String nacionalidad = scan.nextLine();
			
			int edad;
			do{
				System.out.print("Ingrese la edad de " + nombre + ": ");
				edad = scan.nextInt();
				if(edad <= 0) System.out.println("La edad es invalida.\n");
			} while(edad <= 0);
			scan.nextLine();
			
			long dni;
			do{
				System.out.print("Ingrese el DNI de " + nombre + ": ");
				dni = scan.nextLong();
				if(dni <= 9999999) System.out.println("El DNI es invalido.\n");
			} while(dni <= 9999999);
			scan.nextLine();
			
			Alumnos[i] = new classAlumno(nombre, apellido, nacionalidad, edad, dni);
		}
		
		System.out.println("");
		
		for(int i = 1; i < MAX; i = i + 1) {
			System.out.println("doing " + Alumnos[i-1].getDNI() + " and " + Alumnos[i].getDNI());
			if(Alumnos[i-1].getDNI() > Alumnos[i].getDNI()) {
				System.out.println("yes");
				classAlumno tmpA = Alumnos[i];
				Alumnos[i] = Alumnos[i-1];
				Alumnos[i-1] = tmpA;
				i = 1;
			}
		}
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.println(Alumnos[i].getName() + " de nacionalidad " + Alumnos[i].getNacionalidad() + ", DNI " + Alumnos[i].getDNI() + " de " + Alumnos[i].getEdad() + " anios.");
		}
		
	}
}