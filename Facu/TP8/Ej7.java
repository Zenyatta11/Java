
/*
	7. Dado un Array que contiene los sueldos de los empleados del punto 6, 
	se pide que valide la carga de los datos mediante (Usar JOptionPanepara 
	el pedido de carga) y validar los mismos luego. Considerar sueldo como 
	Intero. Si es de otro tipo realizar la conversión de dato
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ej7 {

	public static void main(String[] args) {
		String inputValue = JOptionPane.showInputDialog("Ingrese total de empleados: "); 
		
		int totalEmpleados = Integer.parseInt(inputValue);
		String empleado;
		Integer empleados[] = new Integer [totalEmpleados];
		
		Pattern pattern = Pattern.compile("\\D");
		
		Matcher matcher;
		boolean matchFound;
		
		for(int i=0; i<totalEmpleados; i++){
			do {
				inputValue = JOptionPane.showInputDialog("Ingrese el sueldo del empleado " + (i+1)); 
				matcher = pattern.matcher(inputValue);
				matchFound = matcher.find();
				if(matchFound) JOptionPane.showMessageDialog(null, "El sueldo ingresado es erroneo!", "Error", JOptionPane.ERROR_MESSAGE); 
				if(!matchFound && Integer.parseInt(inputValue) <= 0) JOptionPane.showMessageDialog(null, "El sueldo no puede ser cero o negativo!", "Error", JOptionPane.ERROR_MESSAGE); 
			} while(matchFound);
			empleados[i] = Integer.parseInt(inputValue);
		}
	}
}
