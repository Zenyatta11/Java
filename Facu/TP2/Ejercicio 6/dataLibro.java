/*
	Se pide realizarun programa que me permita almacenar y mostrar los datos de un libro por pantalla.
	Los atributos de la clase libro son: nombre, editorial, autor, género.
	Se pide usar los constructores necesarios para poder realizar lo pedido.
	Incluir la función main() con la que se puede validar.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class dataLibro {
	
	String nombre;
	String editorial;
	String autor;
	String genero;
	
	public dataLibro(String nombre, String editorial, String autor, String genero) {
		this.nombre = nombre;
		this.editorial = editorial;
		this.autor = autor;
		this.genero = genero;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getEditorial() {
		return this.editorial;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String nombre1;
		String editorial1;
		String autor1;
		String genero1;
		char input;
		boolean cont = true;
		List<dataLibro> biblioteca = new ArrayList<dataLibro>();
		
		while(cont) {
			System.out.print("\nBiblioteca\n\nIngrese el nombre del libro: ");
			nombre1 = scan.nextLine();
			System.out.print("Ingrese la editorial del libro: ");
			editorial1 = scan.nextLine();
			System.out.print("Ingrese el autor del libro: ");
			autor1 = scan.nextLine();
			System.out.print("Ingrese el genero del libro: ");
			genero1 = scan.nextLine();
			
			biblioteca.add(new dataLibro(nombre1, editorial1, autor1, genero1));
			
			do{
				System.out.print("\nDesea agregar otro libro? (S/N o Y/N) ");
				input = scan.next(".").charAt(0);
				scan.nextLine();
			} while(!(input == 'Y' || input == 'y' || input == 'n' || input == 'N' || input == 'S' || input == 's'));
			
			switch(input) {
				case 'n':
				case 'N': cont=false; break;
			}
		}
		
		dataLibro[] biblio = biblioteca.toArray(new dataLibro[biblioteca.size()]);
		for(int i = 0; i < biblio.length; i = i + 1) {
			System.out.println("\nLibro " + biblio[i].getNombre() +
								"\nEditorial: " + biblio[i].getEditorial() +
								"\nAutor: " + biblio[i].getAutor() +
								"\nGenero: " + biblio[i].getGenero() +
								"\n\nPresione enter para continuar");
			scan.nextLine();
		}
		scan.close();
	}
}