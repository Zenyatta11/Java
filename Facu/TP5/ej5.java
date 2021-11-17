/*
	5-Realice un programa que cree una clase llamada animales; se pide que se pida el ingreso por teclado de los datos nombre, raza, peso, tamaño.
	Además debe usar una estructura de array (limite 50) en la que guarde el objeto animal.
		
		A.Deberá mostrar por pantalla los datos de los animales ordenado por peso de menor a mayor.
		B.Sacar el valor promedio del peso de todos los animales.
		C.Listar todos los animales cuyo peso sea menor al promedio obtenido en el punto b.
*/

import java.util.Scanner;
import java.util.Arrays;

public class ej5 {
	
	private static final int MAX = 50;
	
	static class classAnimal implements Comparable<classAnimal> {
		String nombre;
		String raza;
		String tamanio;
		float peso;
		
		@Override
		public int compareTo(classAnimal o) {
			if(this.peso > o.peso) return 1;
			if(this.peso < o.peso) return -1;
			return 0;
		}
		
		public classAnimal(String nombre, String raza, float peso, String tamanio) {
			this.nombre = nombre;
			this.raza = raza;
			this.tamanio = tamanio;
			this.peso = peso;
		}
		
		public String getData() {
			String ret = this.nombre + ":\n";
			ret = ret + "Raza: " + this.raza + "\n";
			ret = ret + "Peso: " + String.format("%.2f", this.peso) + "kg\n";
			ret = ret + "Tamanio: " + this.tamanio + "\n";
			return ret;
		}
	}

	public static void main(String[] args) {
		classAnimal[] Animales = new classAnimal[MAX];
		Scanner scan = new Scanner(System.in);
		
		float promedio = 0;
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("\nIngrse el nombre del pichicho: ");
			String nombre = scan.nextLine();
			
			System.out.print("Ingrse la raza de " + nombre + ": ");
			String raza = scan.nextLine();
			
			System.out.print("Ingrse el peso de " + nombre + ": ");
			float peso = scan.nextFloat();
			scan.nextLine();
			
			System.out.print("Ingrse el tamanio de " + nombre + ": ");
			String tamanio = scan.nextLine();
			
			Animales[i] = new classAnimal(nombre, raza, peso, tamanio);
		}
		
		Arrays.sort(Animales);
		
		for(int i = 0; i < MAX; i = i + 1) {
			promedio = promedio + Animales[i].peso;
			System.out.println("Nombre: " + Animales[i].getData());
		}
		promedio = promedio / (float)MAX;
		
		System.out.println("El peso promedio es de " + String.format("%.2f", promedio));
		
		for(int i = 0; i < MAX; i = i + 1) {
			if(Animales[i].peso > promedio) continue;
			System.out.println("Nombre: " + Animales[i].getData());
		}
	}
}