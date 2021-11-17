/*
	Se pide realizar un programa que me permita almacenar los datos de un profesor.
	Dicha clase tiene como atributos: nombre, edad, profesión, carrera_dicta.
	Se pide que usando los constructores que considere necesarios, se puedan mostrar por pantalla los datos de dicho profesor.
*/

import java.util.Scanner;

public class dataProfesor{
	String nombre;
	int edad;
	String profesion;
	String carreraDicta;
	
	public dataProfesor(String nombre, String profesion, String carreraDicta, int edad) {
		this.nombre = nombre;
		this.profesion = profesion;
		this.carreraDicta = carreraDicta;
		this.edad = edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getProfesion() {
		return this.profesion;
	}
	
	public String getCarrera() {
		return this.carreraDicta;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nDatos del profesor.\n\nIngrese el nombre del profesor: ");
		String nombre1 = scan.nextLine();
		
		int edad1;
		do{
			System.out.print("Ingrese la edad del profesor: ");
			edad1 = scan.nextInt();
			if(!(edad1 > 25 && edad1 < 120))
				System.out.println("La edad ingresada es invalida!");
			scan.nextLine();
		}while(!(edad1 > 25 && edad1 < 120));
		
		System.out.print("\nIngrese la profesion del profesor (hint: profesor): ");
		String profesion1 = scan.nextLine();
		
		System.out.print("\nIngrese la carrera que dicta: ");
		String carrera1 = scan.nextLine();
		
		dataProfesor elProfe = new dataProfesor(nombre1, profesion1,carrera1 , edad1);
		
		System.out.println("\nProfesor " + elProfe.getNombre() +
							"\nEdad: " + elProfe.getEdad() +
							"anios\nprofesion: " + elProfe.getProfesion() +
							"\nCarrera Dicta: " + elProfe.getCarrera());
		
		scan.close();
	}
}
