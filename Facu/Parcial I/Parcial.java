/* 
	Un hospital quiere guardar los datos de todos sus turnos para el área de traumatología, 
	para ello nos ha solicitado que generemos las estructuras necesarias para realizarlo. 
	
	El Hospital cuenta con un plantel de 2 traumatólogos: 
		1 de adultos y otra infantil. 
	
	Trabaja con dos turnos por cada doctor mañana y tarde.
	El de chico solo atiende por la mañana y el de adultos por la tarde.
	El horario es en cada turno de 3 horas.
	Se atiende máximo de pacientes por cada turno de 6 pacientes.
	
	Se le solicita que: 
		a.Genere las clases necesarias para realizar lo pedido, con los getters y setters correspondientes. 
			Usar una clase abstracta (20 p)
			---yes
		
		b.Generar un menú que permita tener las opciones de: (20 p)  
			---yes
			
			i.Realizar la carga y asignar a un turno. (Usar JOptionPane) (20p)
				---tiene errores que no se solucionar
			
			ii.Eliminar un turno que tiene un paciente (se pasa los datos por argumento) Usar Manejo de excepciones: (20p) 
				---no llego con el tiempo
			
			iii.Listar los turnos dados con los datos de los pacientes (por cada paciente: nombre y apellido, dni, domicilio, 
				fecha de turno, hora, monto de consulta). Si tiene O. Social monto = 0.(20p )
				---yes
			
			iv.Listar monto Total recaudado por todos los médicos en cada turno.(10p)
				---yes
			
			v.Listar los médicos por especialidad. (10p)
				---yes
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Parcial {
	
	abstract static class classPersona {
		String nombre;
		String apellido;
		int DNI;
		String domicilio;
		String fechaTurno;
		String hora;
		int monto;
		boolean pediatria;
		
		public String getNombre() {
			return this.nombre;
		}
		
		public String getApellido() {
			return this.apellido;
		}
		
		public String getDomicilio() {
			return this.domicilio;
		}
		
		public int getDNI() {
			return this.DNI;
		}
		
		public String getFechaTurno() {
			return this.fechaTurno;
		}
		
		public String getHoraTurno() {
			return this.hora;
		}
		
		public int getMonto() {
			return this.monto;
		}
		
		public boolean isMenor() {
			return this.pediatria;
		}
	}
	
	public static class classTraumatologo extends classPersona {
		public classTraumatologo(String nombre, String apellido) {
			super.nombre = nombre;
			super.apellido = apellido;
			System.out.println("INFO: Traumatologo Created! [" + nombre + "; " + apellido + "]; ");
		}
	}
	
	public static class classPaciente extends classPersona {
		public classPaciente(String nombre, String apellido, String domicilio, int DNI, String fechaTurno, String hora, int monto, boolean menor) {
			super.nombre = nombre;
			super.apellido = apellido;
			super.domicilio = domicilio;
			super.DNI = DNI;
			super.fechaTurno = fechaTurno;
			super.hora = hora;
			super.monto = monto;
			super.pediatria = menor;
			System.out.println("INFO: Paciente Created! [" + nombre + "; " + apellido + "; " + domicilio + "; " + DNI + "; " + fechaTurno + "; " + hora + "; " + monto + "; " + menor + "]; ");
		}
	}
	
	static ArrayList<classPaciente> Pacientes;
	static classTraumatologo TraumaM = new classTraumatologo("Jorge", "Perez");
	static classTraumatologo TraumaT = new classTraumatologo("Julieta", "Ivanovsky");
	
	public static void listarMedicos(int num) {
		int option = 0;
		System.out.println("INFO: Medicos Menu [" + num + "]");
		Object[] options = { "Pediatria", "Adultos", "Volver" };
		if(num != 2) {
			switch(num) {
				case 0: JOptionPane.showMessageDialog(null, "Doctor " + TraumaM.getNombre() + " " + TraumaM.getApellido() + "\n"); break;
				case 1: JOptionPane.showMessageDialog(null, "Doctor " + TraumaT.getNombre() + " " + TraumaT.getApellido() + "\n"); break;

			}
		}
		
		option = JOptionPane.showOptionDialog(null, "Medicos\n\nSeleccione una opcion para continuar:", "Medicos", 
									JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(option != 2) listarMedicos(option);
		
		System.out.println("INFO: Back");
	}
	
	public static boolean nuevoTurno() {
		int option = 0;
		boolean doctor;
		System.out.println("INFO: Turno Nuevo Menu");
		
		Object[] options = { "Pediatria", "Adultos", "Cancelar" };
		option = JOptionPane.showOptionDialog(null, "Medicos\n\nSeleccione una opcion para continuar:", "Medicos", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(option == 2) {
			System.out.println("INFO: Back");
			return false;
		}
		
		if(option == 0 && sinCupos(true) || option == 1 && sinCupos(false)) {
			System.out.println("ERROR: No hay mas cupos!");
			JOptionPane.showMessageDialog(null, "El documento ingresado es erroneo!", "Error", JOptionPane.ERROR_MESSAGE); 
			return false;
		}
		
		String nombre;
		try{
			nombre = askNombre(true);
		} catch(Exception e) {
			return false;
		}
		
		String apellido;
		try{
			apellido = askNombre(false);
		} catch(Exception e) {
			return false;
		}
		
		String domicilio;
		try{
			domicilio = askDomicilio();
		} catch(Exception e) {
			return false;
		}
		
		int dni;
		try{
			dni = askDNI();
		} catch(Exception e) {
			return false;
		}
		
		String fecha;
		try{
			fecha = askFecha(true);
		} catch(Exception e) {
			return false;
		}
		
		String hora;
		try{
			hora = askFecha(false);
		} catch(Exception e) {
			return false;
		}
		
		int monto;
		try{
			monto = askCosto();
		} catch(Exception e) {
			return false;
		}
		
		
		classPaciente pacienteNuevo = new classPaciente(nombre, apellido, domicilio, dni, fecha, hora, monto, (option == 0 ? true : false));
		Pacientes.add(pacienteNuevo);
		
		return true;
	}
	
	public static int askDNI() {
		Pattern pattern = Pattern.compile("^\\d{7,8}$");
		
		String inputValue;
		System.out.println("INFO: Obteniendo DNI");
		Matcher matcher;
		boolean found;
		
		do {
			inputValue = JOptionPane.showInputDialog("Ingrese el numero de DNI del paciente:"); 
			matcher = pattern.matcher(inputValue);
			found = matcher.find();
			if(!found) JOptionPane.showMessageDialog(null, "El documento ingresado es invalido!", "Error", JOptionPane.ERROR_MESSAGE); 
		} while(!found);

		return Integer.parseInt(inputValue);
	}
	
	public static int askCosto() {
		Pattern pattern = Pattern.compile("^\\d*$");
		
		String inputValue;
		System.out.println("INFO: Obteniendo Costo");
		Matcher matcher;
		boolean found;
		
		do {
			inputValue = JOptionPane.showInputDialog("Ingrese el costo del turno:"); 
			matcher = pattern.matcher(inputValue);
			found = matcher.find();
			if(found && Integer.parseInt(inputValue) < 0) JOptionPane.showMessageDialog(null, "El costo no puede ser menor a cero!", "Error", JOptionPane.ERROR_MESSAGE); 
			else if(found) break;
			else JOptionPane.showMessageDialog(null, "El costo ingresado es erroneo!", "Error", JOptionPane.ERROR_MESSAGE); 
		} while(!found);

		return Integer.parseInt(inputValue);
	}
	
	public static String askFecha(boolean fecha) {
		Pattern pattern;
		if(fecha) pattern = Pattern.compile("^\\d{1,2}\\/\\d{1,2}\\/\\d{1,2}$");
		else pattern = Pattern.compile("^\\d{1,2}:\\d{1,2}$");
		
		String inputValue;
		System.out.println("INFO: Get DNI");
		Matcher matcher;
		boolean found;
		
		do {
			inputValue = JOptionPane.showInputDialog("Ingrese la " + (fecha ? "fecha" : "hora") + " del turno:\n" + (fecha ? "DD/MM/YY" : "HH:MM")); 
			matcher = pattern.matcher(inputValue);
			found = matcher.find();
			if(!found) JOptionPane.showMessageDialog(null, "La " + (fecha ? "fecha" : "hora") + " ingresada es erronea!", "Error", JOptionPane.ERROR_MESSAGE); 
			else if(found) break;
		} while(!found);

		return inputValue;
	}
	
	public static String askDomicilio() {
		System.out.println("INFO: Obteniendo domicilio");
		return JOptionPane.showInputDialog("Ingrese el domicilio:");
	}
	
	public static String askNombre(boolean nom) {
		Pattern pattern = Pattern.compile("^\\w*$");
		System.out.println("INFO: Obteniendo " + (nom == true ? "nombre" : "apellido"));
		Matcher matcher;
		boolean found;
		String inputValue;
		
		do {
			inputValue = JOptionPane.showInputDialog("Ingrese el " + (nom == true ? "nombre" : "apellido") + " del paciente:"); 
			matcher = pattern.matcher(inputValue);
			found = matcher.find();
			if(!found) JOptionPane.showMessageDialog(null, "El " + (nom == true ? "nombre" : "apellido") + " es invalido.", "Error", JOptionPane.ERROR_MESSAGE); 
		} while(!found);
		return inputValue;
	}
	
	public static void listarTurnos(int num) {
		int option = 0;
		System.out.println("INFO: Turnos Menu [" + num + "]");
		Object[] options = { "Pediatria", "Adultos", "Volver" };
		switch(num) {
			case 1: JOptionPane.showMessageDialog(null, actuallyGetTurnos(true)); break;
			case 0: JOptionPane.showMessageDialog(null, actuallyGetTurnos(false)); break;
		}
		option = JOptionPane.showOptionDialog(null, "Turnos\n\nSeleccione una opcion para continuar:", "Turnos", 
								JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(option != 2) listarTurnos(option);
		System.out.println("INFO: Back");
	}
	
	public static String actuallyGetTurnos(boolean pediatria) {
		String retVal = "";
		boolean found = false;
		
		try{
				for(classPaciente Paciente : Pacientes) {
				if(Paciente.isMenor() != pediatria) continue;
				found = true;
				retVal = retVal + Paciente.getNombre() + " " + Paciente.getApellido() + "; DNI: " + Paciente.getDNI() + "; $" + Paciente.getMonto() + "\nDomicilio: " 
					+ Paciente.getDomicilio() + "\nTurno: " + Paciente.getFechaTurno() + " a las " + Paciente.getHoraTurno() + "\n";
				
				System.out.println(Paciente.getNombre() + " " + Paciente.getApellido() + "; DNI: " + Paciente.getDNI() + "; $" + Paciente.getMonto() + "\nDomicilio: " 
					+ Paciente.getDomicilio() + "\nTurno: " + Paciente.getFechaTurno() + " a las " + Paciente.getHoraTurno() + "\n");
			}
		}
		
		catch(Exception e) {
			if(!found) retVal = "No hay pacientes para listar!";
		}
		
		finally{
			return retVal;
		}
	}
	
	public static boolean sinCupos(boolean pediatria) {
		boolean found = false;
		int cupos = 0;
		
		try{
				for(classPaciente Paciente : Pacientes) {
				if(Paciente.isMenor() != pediatria) continue;
				found = true;
				cupos = cupos + 1;
			}
		}
		
		catch(Exception e) {
			cupos = 0;
		}
		
		finally{
			return (cupos >= 6 ? true : false);
		}
	}
	
	public static void listarRecaudacion() {
		String retVal = "";
		boolean found = false;
		int monto = 0;
		
		try{
			for(classPaciente Paciente : Pacientes) {
				found = true;
				monto = monto + Paciente.getMonto();
				System.out.println("INFO: +$" + Paciente.getMonto());
			}
			retVal = "Se recaudo un total de $" + monto;
		}
		
		catch(Exception e) {
			if(!found) retVal = "No hay turnos!\nLa recaudacion es $0.";
		}
		
		finally{
			JOptionPane.showMessageDialog(null, retVal);
		}
	}
	
	public static void main(String[] args) {
		int option;
		do {
			Object[] options = { "Nuevo Turno", "Eliminar Turno", "Listar Turnos", "Listar Recaudacion", "Listar Medicos", "Salir" };
			option = JOptionPane.showOptionDialog(null, "Menu Principal:\n\nSeleccione una opcion para continuar:", "Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
			switch(option) {
				case 0: if(nuevoTurno()) System.out.println("INFO: Nuevo paciente!"); else System.out.println("INFO: Cancelo paciente!"); break;
				// case 1: eliminarTurno(); break;
				case 2: listarTurnos(2); break;
				case 3: listarRecaudacion(); break;
				case 4: listarMedicos(2); break;
			}
		} while(option != 5);
	}
}