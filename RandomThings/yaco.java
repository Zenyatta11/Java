
import java.util.*;

public class yaco {
    private static Scanner numeros;
	
	public static void main(String[] args) {
		numeros = new Scanner(System.in);

		int resultado=0;
		int n1 = 0;
		int n2 = 0;

		System.out.println("introduce el primer numero: ");
		n1= numeros.nextInt();

		System.out.println("introduce el segundo numero: ");
		n2= numeros.nextInt();

		resultado= n1+n2;
		System.out.println("el resultado de la suma de los numeros es "+resultado);
	}
}