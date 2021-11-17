/*
	7-Se solicita que realice un programa que contenga los datos de los productos de un mayorista.
	La estructura a usar será un ArrayList de String.
	Además se tendrá otro ArrayList que contenga los precios de los productos (tipo float).
	
	a.Se solicita que muestre por pantalla los productos ordenados por precio de mayor a menor con la descripción del producto (usar el nombre guardado en el primer ArrayList).
	b.Además mostrar el producto cuyo precio sea el mayor de todos por pantalla.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class ej7 {
	
	public static void main(String[] args) {
		ArrayList<String>Nombres = new ArrayList<String>();
		ArrayList<String>Nombres2 = new ArrayList<String>();
		
		ArrayList<Float>Precios = new ArrayList<Float>();
		ArrayList<Float>Precios2 = new ArrayList<Float>();
		int MAX = 5;
		float masAlto = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.print("\nIngrese el nombre de un producto: ");
			Nombres.add(scan.nextLine());
			
			System.out.print("Ingrese el precio del producto: ");
			Precios.add(scan.nextFloat());
			scan.nextLine();
			if(Precios.get(i) > masAlto)
				masAlto = Precios.get(i);
			
		}
		
		do {
			int maxi = Precios.size();
			for(int i = 0; i < maxi; i = i + 1) {
				float valor = Precios.get(i);
				if(valor == masAlto) {
					Precios.remove(i);
					Precios2.add(valor);
					Nombres2.add(Nombres.get(i));
					Nombres.remove(i);
					maxi = Precios.size();
				}
			}
			masAlto = 0;
			for(int i = 0; i < maxi; i = i + 1) {
				float valor = Precios.get(i);
				if(valor > masAlto)
					masAlto = valor;
			}
		} while(Precios.size() > 0);
		
		System.out.println("\nProducto mas caro: " + Nombres2.get(0) + "; Precio: $" + String.format("%.2f", Precios2.get(0)) + "\n");
		
		for(int i = 0; i < MAX; i = i + 1) {
			System.out.println("Producto: " + Nombres2.get(i) + "; Precio: $" + String.format("%.2f", Precios2.get(i)));
		}
	}
}