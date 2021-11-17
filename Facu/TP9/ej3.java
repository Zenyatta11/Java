/*
	3. Crear un archivo que guarde los datos que se tienen en una estructura de tipo ArrayList que contiene los datos de los productos de una Farmacia. 
	Se deben ordenar por código de producto de menor a mayor.
*/

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;

public class ej3 {
	
	public static class classProducto {
		String nombre = "";
		int codigo = 0;
		
		public classProducto(int codigo, String nombre) {
			this.codigo = codigo;
			this.nombre = nombre;
		}
	}
	
	static class SortCodigo implements Comparator<classProducto>{
		public int compare(classProducto o1, classProducto o2) {
			return o1.codigo - o2.codigo;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<classProducto> Productos = new ArrayList<classProducto>();
		int option;
		
		do {
			Pattern pattern = Pattern.compile("^\\d*$");
			
			String inputValue;
			System.out.println("INFO: Obteniendo Codigo de Producto");
			Matcher matcher;
			boolean found = false;
			
			do {
				inputValue = JOptionPane.showInputDialog("Ingrese el codigo del producto: "); 
				
				matcher = pattern.matcher(inputValue);
				found = matcher.find();
				
				if(found) break;
				else JOptionPane.showMessageDialog(null, "El codigo ingresado es erroneo!", "Error", JOptionPane.ERROR_MESSAGE); 
			} while(!found);
			
			int codigo = Integer.parseInt(inputValue);
			
			inputValue = JOptionPane.showInputDialog("Ingrese el nombre del producto:"); 
			Productos.add(new classProducto(codigo, inputValue));
			
			Object[] options = { "Si", "No" };
			option = JOptionPane.showOptionDialog(null, "Desea continuar?", "Continuar?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		} while(option == 0);
		
		Productos.sort( new SortCodigo());
		
		File myFile = new File("./ejercicio_3.csv");
		try{
			if(myFile.createNewFile()) System.out.println("INFO: File created! " + myFile.getName());
			else System.out.println("NOTICE: File already exists.");
			
			FileWriter myFile_W = new FileWriter("./ejercicio_3.csv", false);
			myFile_W.write("Código,Nombre\n");
			
			int max = Productos.size();
			for(int i = 0; i < max; i = i + 1)
				myFile_W.write("" + Productos.get(i).codigo + "," + Productos.get(i).nombre + "\n");
			
			myFile_W.close();
			System.out.println("INFO: Successfully wrote to the file.");
		} catch(Exception e) {
			System.out.println("ERROR: Couldn't access the file");
		}
	}
}