
/*
	6 Dado un Array De los nombres de los empleados de un comercio, se pide que realice la carga de los mismos y que utilice los 
	métodos de validación de String. Contemplar los casos que considere necesarios para la carga de esos datos
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Ej6 {

    public static Scanner scan;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Total de empleados: ");
        int totalEmpleados = scan.nextInt();
        scan.nextLine();

        String empleado;
        String empleados[] = new String [totalEmpleados];
        
        Pattern pattern = Pattern.compile("^\\w{1,}");
        
        Matcher matcher;
        boolean matchFound;
        
        System.out.println("Ingrese a continuacion los nombres de los empleados.");
        for(int i=0; i<totalEmpleados; i++){
            do {
                System.out.print("Empleado " + (i+1) + ": ");
                empleado = scan.nextLine();
                matcher = pattern.matcher(empleado);
                matchFound = matcher.find();
                if(!matchFound) System.out.println("El nombre ingresado es erroneo.\n");
            } while(!matchFound);
            empleados[i] = empleado;
        }

        scan.close();
    }
}