/*
	13-Hacer unprogramaque de una clase padre que llamaremos persona, se tengan dos clases hijas llamadas profesor y administrativo.
	La clase persona posee los siguientes atributos: 
		genero, edad, nombre, apellido.
		
	La clase profesor tiene además los atributos: 
		profesión, cátedra. 
		
	La clase administrativo además tiene los atributos: 
		horario(String--fulltime o partime) y categoría(String. Pasante o empleado). 
	
	a-Se solicita que se genere la estructura necesaria para poder guardar los datos de al menos 2 objetos de profesor y 2 de administrativo.
	b-dicha información debería ser mostrada por pantalla.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ej13 {
	
	public static abstract class classPersona{
		String genero;
		int edad;
		String nombre;
		String apellido;
		
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
	}

	public static class classProfesor extends classPersona{
		String profesion;
		String catedra;

		public classProfesor(String genero, int edad, String nombre, String apellido, String profesion, String catedra){
			super.genero = genero;
			super.edad = edad;
			super.nombre = nombre;
			super.apellido = apellido;
			this.profesion = profesion;
			this.catedra = catedra;
		}

		public String getProfesion() {
			return profesion;
		}
		public void setProfesion(String profesion) {
			this.profesion = profesion;
		}

		public String getCatedra() {
			return catedra;
		}
		public void setCatedra(String catedra) {
			this.catedra = catedra;
		}
	}

	public static class classAdministrativo extends classPersona{
		String horario; //fulltime o partime
		String categoria; //pasante o empleado

		public classAdministrativo(String genero, int edad, String nombre, String apellido, String horario, String categoria){
			super.genero = genero;
			super.edad = edad;
			super.nombre = nombre;
			super.apellido = apellido;
			this.horario = horario;
			this.categoria = categoria;
		}

		public String getHorario() {
			return horario;
		}
		public void setHorario(String horario) {
			this.horario = horario;
		}

		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
	}

	public static Scanner scan;

	public static void main(String[] args) {
		ArrayList<classAdministrativo> administrativos = new ArrayList<classAdministrativo>();
		ArrayList<classProfesor> profesores = new ArrayList<classProfesor>();

		Scanner scan = new Scanner(System.in);

		boolean seguir = true;
		int contador = 0;

		System.out.println("A continuacion ingrese los datos de los profesores y administrativos.\n");
		do{
			System.out.println("Profesor");
			System.out.print("Nombre: ");
			String nombre = scan.nextLine();
			System.out.print("Apellido: ");
			String apellido = scan.nextLine();
			System.out.print("Genero (ingrese M o F): ");
			String genero = scan.nextLine();
			System.out.print("Edad: ");
			int edad = scan.nextInt();
			scan.nextLine();
			System.out.print("Profesion: ");
			String profesion = scan.nextLine();
			System.out.print("Catedra: ");
			String catedra = scan.nextLine();

			classProfesor profesor = new classProfesor(genero, edad, nombre, apellido, profesion, catedra);
			profesores.add(profesor);

			System.out.println("Administrativo");
			System.out.print("Nombre: ");
			nombre = scan.nextLine();
			System.out.print("Apellido: ");
			apellido = scan.nextLine();
			System.out.print("Genero (ingrese M o F): ");
			genero = scan.nextLine();
			System.out.print("Edad: ");
			edad = scan.nextInt();
			scan.nextLine();
			System.out.print("Horario: ");
			String horario = scan.nextLine();
			System.out.print("Categoria: ");
			String categoria = scan.nextLine();

			classAdministrativo administrativo = new classAdministrativo(genero, edad, nombre, apellido, horario, categoria);
			administrativos.add(administrativo);

			contador = contador + 1;

			if (contador >= 2){
				System.out.println("Desea continuar ingresando administrativos y profesores? 1 para Si, 0 para No");
				int x = scan.nextInt();
				if (x == 1){
					seguir = true;
				}else {
					seguir = false;
				}
			}

		}while(seguir);

		System.out.println("Listado de profesores.\n");
		for (int i=0; i<profesores.size(); i++){
			System.out.print("Nombre: " + profesores.get(i).getNombre() + "\nApellido: " + profesores.get(i).getApellido() + "\nGenero: " + profesores.get(i).getGenero()
								 + "\nEdad: " + profesores.get(i).getEdad() + "\nProfesion: " + profesores.get(i).getProfesion() + "\nCatedra: " + profesores.get(i).getCatedra() 
								 + "Nombre: " + profesores.get(i).getNombre());
		}

		System.out.println("\n\nListado de administrativos.\n");
		for (int i=0; i<administrativos.size(); i++){
			System.out.print("Nombre: " + administrativos.get(i).getNombre() + "\nApellido: " + administrativos.get(i).getApellido() + "\nGenero: " + administrativos.get(i).getGenero()
								 + "\nEdad: " + administrativos.get(i).getEdad() + "\nHorario: " + administrativos.get(i).getHorario() + "\nCategoria: " + 
								 administrativos.get(i).getCategoria() + "Nombre: " + profesores.get(i).getNombre());
		}
	}
}
