/*
	Usando constructores se pide que se realice el siguiente programa.
	Se ha presentado la necesidad de guardar los datos de los alumnos de una facultad.
	Sepide se muestre por pantalla los datos de un alumno dado que hereda dela clasepersona los atributos de 
	nombre, edad, nacionalidad.
	Como atributos propios alumno tiene: matricula, carrera, año_vigencia.
	Dichos datos son recibidos por parámetros.
	Se pide mostrar por pantalla los datos de un alumno dado.
*/
import java.util.Scanner;

public class dataPersona{
	String nombre;
	int edad;
	String nacionalidad;
	
	public dataPersona(String nombre, String nacionalidad, int edad) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public static class dataAlumno extends dataPersona{
		int matricula;
		String carrera;
		int anioVigencia;
		
		public dataAlumno(String nombre, String nacionalidad, int edad, int matricula, String carrera, int anioVigencia) {
			super(nombre, nacionalidad, edad);
			this.carrera = carrera;
			this.matricula = matricula;
			this.anioVigencia = anioVigencia;
		}
		
		public int getMatricula() {
			return this.matricula;
		}
		
		public int getAnioVigencia() {
			return this.anioVigencia;
		}
		
		public String getCarrera() {
			return this.carrera;
		}
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\nDatos del alumno.\n\nIngrese el nombre del alumno: ");
		String nombre1 = scan.nextLine();
		
		int edad1;
		do{
			System.out.print("Ingrese la edad del alumno: ");
			edad1 = scan.nextInt();
			if(!(edad1 > 18 && edad1 < 120))
				System.out.println("La edad ingresada es invalida!");
			scan.nextLine();
		}while(!(edad1 > 18 && edad1 < 120));
		
		System.out.print("\nIngrese la nacionalidad del alumno: ");
		String nacionalidad1 = scan.nextLine();
		
		System.out.print("\nIngrese la carrera del alumno: ");
		String carrera1 = scan.nextLine();
		
		int anio;
		do{
			System.out.print("Ingrese el anio vigente: ");
			anio = scan.nextInt();
			if(!(anio > 2020 && anio < 2100))
				System.out.println("El anio ingresado es invalido!");
			scan.nextLine();
		}while(!(anio > 2020 && anio < 2100));
		
		dataAlumno miAlumno = new dataAlumno(nombre1, nacionalidad1, edad1, (int)(Math.random()*300),carrera1, anio);
		
		System.out.println("\nAlumno " + miAlumno.getNombre() +
							"\nEdad: " + miAlumno.getEdad() +
							"anios\nNacionalidad: " + miAlumno.getNacionalidad() +
							"\n\nMatricula N. " + miAlumno.getMatricula() +
							"\nCarrera: " + miAlumno.getCarrera() +
							"\nCiclo: " + miAlumno.getAnioVigencia());
		
		scan.close();
	}
}
