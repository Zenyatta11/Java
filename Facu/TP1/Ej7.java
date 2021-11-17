
public class Ej7 {
	public static void main(String[] args){
		System.out.println("Ejercicio 7 - Divisibles por 2 y 3\n");
		
		int max = 30;
		int divisor = 6; // Si es divisible por 2 y 3, es divisible por 6.
						 // Nos ahorramos un if
		
		for(int i = 1; i <= max; i = i + 1) {
			if(i % 6 == 0) {
				String output = i + (i == max ? ";\n\n" : ", ");
				System.out.print(output);
			}
		}
	}
}