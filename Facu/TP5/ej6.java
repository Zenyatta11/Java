/*
	6-Hacer un programa que me permita almacenar en una estructura tipo array objetos libro. 
	La clase Libro tendrá como atributos: nombre, editorial, año_de_edicion, genero, valor.
	
	A.Se pide que se permita guardar los datos ingresados por teclado en un array cuya longitud será de 30. 
	B.Listar todos los libros ordenados de menor a mayor por el atributo valor.
	C.Listar todos los libros cuyo autor sea el mismo.
	D.Dar en una variable la suma de todos los valores cuyo autor sea el mismo.
	E.Listar los libros de mayor a menor por año de edición.
*/


import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class ej6 {
	
	private static final int MAX = 30;
	
	private static class SortValor implements Comparator<classLibro>{
		// Used for sorting in ascending order of
		// roll number
		public int compare(classLibro a, classLibro b)
		{
			return (int)(a.valor - b.valor);
		}
	}
	
	private static class SortEdicion implements Comparator<classLibro>{
		// Used for sorting in ascending order of
		// roll number
		public int compare(classLibro a, classLibro b)
		{
			return a.anioEdicion - b.anioEdicion;
		}
	}
	
	private static class SortAutor implements Comparator<classLibro>{
		// Used for sorting in ascending order of
		// roll number
		public int compare(classLibro a, classLibro b)
		{
			return a.editorial.compareTo(b.editorial);
		}
	}
	
	static class classLibro {
		String nombre;
		String editorial;
		String genero;
		int anioEdicion;
		float valor;
		
		public classLibro(String nombre, String editorial, String genero, int anioEdicion, float valor) {
			this.nombre = nombre;
			this.editorial = editorial;
			this.genero = genero;
			this.anioEdicion = anioEdicion;
			this.valor = valor;
		}
		
		public String getData() {
			String ret = this.nombre + ":\n";
			ret = ret + "Editorial: " + this.editorial + "\n";
			ret = ret + "Genero: " + this.genero + "\n";
			ret = ret + "Anio de Edicion: " + this.anioEdicion + "\n";
			ret = ret + "Valor: $" + String.format("%.2f", this.valor) + "\n";
			return ret;
		}
	}
	
	public static classLibro[] Libros = new classLibro[MAX];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		float promedio = 0;
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("\nIngrse el nombre del libro: ");
			String nombre = scan.nextLine();
			
			System.out.print("Ingrse la editorial de " + nombre + ": ");
			String editorial = scan.nextLine();
			
			System.out.print("Ingrse el genero de " + nombre + ": ");
			String genero = scan.nextLine();
			
			System.out.print("Ingrse el anio de edicion de " + nombre + ": ");
			int anioEdicion = scan.nextInt();
			scan.nextLine();
			
			System.out.print("Ingrse el valor de " + nombre + ": $");
			float valor = scan.nextFloat();
			scan.nextLine();
			
			Libros[i] = new classLibro(nombre, editorial, genero, anioEdicion, valor);
		}
		
		Arrays.sort(Libros, new SortValor());
		System.out.println("Orden por Valor: ");
		for(int i = 0; i < MAX; i = i + 1)
			System.out.println("Nombre: " + Libros[i].getData());
		
		Arrays.sort(Libros, new SortAutor());
		System.out.println("Autores Iguales: ");
		String oldAuthor = Libros[0].editorial;
		float valores = 0;
		for(int i = 0; i < MAX; i = i + 1) {
			if(!oldAuthor.equals(Libros[i].editorial)) {
				System.out.println("Suma de valores: $" + String.format("%.2f", valores) + "\n");
				valores = 0;
				oldAuthor = Libros[i].editorial;
			}
			valores = valores + Libros[i].valor;
			System.out.println("Nombre: " + Libros[i].getData());
		}
		
		Arrays.sort(Libros, new SortEdicion());
		System.out.println("\n\nOrden por Anio de Edicion (Reciente a antiguo): ");
		for(int i = MAX; i >= 0; i = i - 1)
			System.out.println("Nombre: " + Libros[i].getData());
		
	}
}