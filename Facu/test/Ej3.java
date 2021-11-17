import java.util.Scanner;
import java.util.Arrays;

public class Ej3 {
	public static void main(String[] args){
		int max = 3;
		int[] numeros = new int[max];
		
		System.out.print("Ejercicio 3 - Mayor a Menor\n\n");
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < max; i = i + 1) {
			System.out.print("Ingrese un numero: " + (i == 0 ? "" : "(Restan " + (max-i) + ") "));
			numeros[i] = scan.nextInt();
		}
		
		Arrays.sort(numeros);
		System.out.print("\nArray en orden:\n");
		
		for(int i = max-1; i >= 0; i = i - 1)
			System.out.println("Array[" + i + "] = " + numeros[i] + ";");
		
		System.out.println("");
		scan.close();
	}
}
