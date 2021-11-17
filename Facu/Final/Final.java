/*
	Programación II. Examen Final 2021

	1. Una empresa de telefonía quiere manejar los datos de sus abonados. Se le solicita que realice un
		programa que me permita seleccionar de un menú (USAR JOptionPane) las siguientes opciones de
		menú: Alta de usuario
	
	2. Modificación de usuario.
	
	3. Carga de saldo para llamadas a cuenta de un nro de celular ( un usuario puede tener mas de uno) Solo
		para clientes que no tengan abono fijo (esos casos indicar que plan tienen)
	
	4. Eliminar un nro de celular (Aca debe manejar excepciones)
	
	5. Pagar factura.
	
	6. Listado de usuarios en mora
	
	7. Generación de archivo e impresión. La información debe ser un listado con los datos de los abonados
		y sus cuentas asociadas a los nros de celular y el saldo de cada una. --Excento del tema de archivos
	
	Consideraciones:
		Para la cantidad de La cantidad de pesos a ser cargados. En este punto se pide que se haga una validación del
			valor ingresado ( nros float, si son enteros convertirlos). Usar JOptionPane.
		
		El nro celular al cual se le cargará el saldo en la opción #3.
		
		Tener en cuenta que un cliente puede tener varias facturas asociadas.
		
		Incluir al menos una clase abstracta. Usar Herencia.

	NOTAS IMPORTANTES:
		El examen dura 2 horas
		Realizar los ejercicios de acuerdo a lo solicitado.
		Se necesita el 60 % resuelto correctamente del examen para aprobar. 
*/

// ========================================================================================= //
// Project				:	Final Programacion II											 //
// Authors				:	Zenyatta11     													 //
// Description			:	Examen Final turno noche, 16/07/2021							 //
// ========================================================================================= //
// Table of Contents
//
// Section 00 : Imports 
//
// Section 01 : Globals 
//
// Section 02 : Class Declarations 
//
// Section 02 : 01 Class Persona Abstracta
// Section 02 : 02 Class Cliente
// Section 02 : 03 Class Linea
//
// Section 03 : Standalone Functions
//
// Section 04 : Search Functions
//
// Section 04 : 01 Get Clientes
// Section 04 : 02 Get Morados
// Section 04 : 03 Get Telefonos
// Section 04 : 04 Get Prepagas
// Section 04 : 05 Celular Exists
// Section 04 : 06 User Exists
// Section 04 : 07 Get User
// Section 04 : 08 Get Linea
//
// Section 05 : Primary Functions
//
// Section 05 : 01 New User
// Section 05 : 02 Delete User
// Section 05 : 03 Cargar Prepagas
// Section 05 : 04 Pagar Facturas
// Section 05 : 05 Modify User
// Section 05 : 06 Ver Adeudados
//
// Section 06 : Updaters
//
// Section 06 : 01 Delete Phone
// Section 06 : 02 Delete Client
// Section 06 : 03 Create Client
// Section 06 : 04 Create Phone
// Section 06 : 05 Modify User Data
// Section 06 : 05 534543
//
// Section 07 : Main GUI
//
// Section 08 : Initialization
// ========================================================================================= 

// =========================================================================================
// Section 00 : Imports 
// =========================================================================================

import java.awt.Dimension;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.Window;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class Final {

// =========================================================================================
// Section 01 : Globals 
// =========================================================================================

	static boolean GLOB_ESC = false;
	
	public ArrayList<classCliente> Clientes = new ArrayList<classCliente>();

// =========================================================================================
// Section 02 : Class Declarations
// =========================================================================================
	
	// Section 02 : 01 Class Persona Abstracta
	public abstract class absClass_Persona {
		String Nombre;
		int DNI;
		
		public absClass_Persona(String Nombre, int DNI) {
			this.Nombre = Nombre;
			this.DNI = DNI;
		}
	}
	
	// Section 02 : 02 Class Cliente
	public class classCliente extends absClass_Persona{
		float Deuda;
		ArrayList<classLinea> Celulares = new ArrayList<classLinea>();
		
		public classCliente(String Nombre, int DNI, float Deuda) {
			super(Nombre, DNI);
			this.Deuda = Deuda;
		}
		
		public void addLinea(classLinea linea) {
			this.Celulares.add(linea);
		}
		
		public void removeLinea(classLinea linea) {
			this.Celulares.remove(linea);
		}
	}
	
	// Section 02 : 03 Class Linea
	public class classLinea {
		String Celular;
		float carga = 0;
		boolean prepaga;
		
		public classLinea(String Celular, boolean prepaga) {
			this.Celular = Celular;
			this.prepaga = prepaga;
		}
	}

// =========================================================================================
// Section 03 : Standalone Functions
// =========================================================================================
	
	public static void log(String message) {
		System.out.println(message);
	}

// =========================================================================================
// Section 04 : Search Functions
// =========================================================================================
	// Section 04 : 01 Get Clientes
	public ArrayList<String> getClientes() {
		int max = Clientes.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1)
			retVal.add(Clientes.get(i).Nombre);
		
		return retVal;
	}
	
	// Section 04 : 02 Get Morados
	public ArrayList<String> getMorados() {
		int max = Clientes.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1)
			if(Clientes.get(i).Deuda > 0)
				retVal.add(Clientes.get(i).Nombre);
		
		return retVal;
	}
	
	// Section 04 : 03 Get Telefonos
	public ArrayList<String> getTelefonos() {
		int max = Clientes.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1) {
			int max2 = Clientes.get(i).Celulares.size();
			for(int j = 0; j < max2; j = j + 1) {
				retVal.add(Clientes.get(i).Celulares.get(j).Celular);
			}
		}
		
		return retVal;
	}

	// Section 04 : 04 Get Prepagas
	public ArrayList<String> getPrepagas() {
		int max = Clientes.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1) {
			int max2 = Clientes.get(i).Celulares.size();
			for(int j = 0; j < max2; j = j + 1) {
				if(Clientes.get(i).Celulares.get(j).prepaga)
					retVal.add(Clientes.get(i).Celulares.get(j).Celular);
			}
		}
		
		return retVal;
	}
	
	// Section 04 : 05 Celular Exists
	public boolean celularExists(String needle) {
		int max = Clientes.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1) {
			int max2 = Clientes.get(i).Celulares.size();
			for(int j = 0; j < max2; j = j + 1) {
				if(Clientes.get(i).Celulares.get(j).Celular.equals(needle))
					return true;
			}
		}
		
		return false;
	}
	
	// Section 04 : 06 User Exists
	public boolean userExists(String needle) {
		int max = Clientes.size();
		
		for(int i = 0; i < max; i = i + 1)
			if(needle.equals(Clientes.get(i).Nombre))
				return true;
		
		return false;
	}
	
	// Section 04 : 07 Get User
	public int getUser(String needle) {
		int max = Clientes.size();
		
		for(int i = 0; i < max; i = i + 1)
			if(needle.equals(Clientes.get(i).Nombre))
				return i;
		
		return 0;
	}
	
	// Section 04 : 08 Get Linea
	public ArrayList<Integer> getLinea(String needle) {
		int max = Clientes.size();
		ArrayList<Integer> retVal = new ArrayList<Integer>();
		
		for(int i = 0; i < max; i = i + 1) {
			int max2 = Clientes.get(i).Celulares.size();
			for(int j = 0; j < max2; j = j + 1) {
				if(Clientes.get(i).Celulares.get(j).Celular.equals(needle)) {
					retVal.add(i);
					retVal.add(j);
					return retVal;
				}
			}
		}
		retVal.add(0);
		return retVal;
	}
	
// =========================================================================================
// Section 05 : Primary Functions
// =========================================================================================
	// Section 05 : 01 New User
	public void newUser() {
		int opcion;
		Object[] opciones = {"Nuevo Cliente", "Nueva Linea", "Volver"};
		opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Telefonica - Nuevo Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		switch(opcion) {
			case 0: newClient(); break;
			case 1: newPhone(); break;
		}
	}
	
	// Section 05 : 02 Delete User
	public void delUser() {
		int opcion;
		Object[] opciones = {"Eliminar Cliente", "Eliminar Linea", "Volver"};
		opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Telefonica - Eliminar Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		switch(opcion) {
			case 0: delClient(); break;
			case 1: delPhone(); break;
		}
	}
	
	// Section 05 : 03 Cargar Prepaga
	public void cargarPrepaga() {
		ArrayList<String> Prepagas = getPrepagas();
		
		if(Prepagas.size() == 0) {
			JOptionPane.showMessageDialog(null,
				"No hay lineas prepagas cargadas!",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Object[] options = Prepagas.toArray();
		
		String telefono = (String)JOptionPane.showInputDialog(null, "Carga de Saldo Prepaga:\n\nSeleccione la linea:", 
			"Telefonica - Carga Prepaga", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(telefono == null) return;
		
		ArrayList<Integer> Datos = getLinea(telefono);
		
		classLinea ringring = Clientes.get(Datos.get(0)).Celulares.get(Datos.get(1));
		
		Pattern patternCarga = Pattern.compile("^\\d{1,}$|(\\d*\\.{1}\\d{2})$");
		
		String input = "";
		Matcher matcher;
		boolean invalid;
		
		float carga = 0;
		
		do {
			input = JOptionPane.showInputDialog(null, "Ingrese el monto a cargar: \nActualmente posee $" + String.valueOf(ringring.carga), "Telefonica - Carga Prepaga", JOptionPane.QUESTION_MESSAGE);
			matcher = patternCarga.matcher(input);
			invalid = !matcher.find();
		} while(invalid);
		carga = Float.parseFloat(input);
		
		ringring.carga = ringring.carga + carga;
		JOptionPane.showMessageDialog(null,
				"La linea " + ringring.Celular + " fue cargada con exito!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Section 05 : 04 Pagar Factura
	public void pagarFactura() {
		ArrayList<String> Morados = getMorados();
		
		if(Morados.size() == 0) {
			JOptionPane.showMessageDialog(null,
				"No hay clientes con facturas impagas!",
				"Error/Success?",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Object[] options = Morados.toArray();
		
		String titular = (String)JOptionPane.showInputDialog(null, "Abono de facturas:\n\nSeleccione el cliente:", 
			"Telefonica - Abono Facturas", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(titular == null) return;
		
		classCliente Titular = Clientes.get(getUser(titular));
		
		JOptionPane.showMessageDialog(null,
				"Esta por abonar $" + Titular.Deuda + " adeudado por el cliente " + Titular.Nombre + ".",
				"Notice !",
				JOptionPane.INFORMATION_MESSAGE);
		
		Titular.Deuda = 0;
		
		JOptionPane.showMessageDialog(null,
				"La factura fue abonada con exito!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Section 05 : 05 Modify User
	public void modUser() {
		String titular = "";
		if(Clientes.size() == 0) {
			JOptionPane.showMessageDialog(null,
				"No hay clientes cargados!",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			Object[] options = getClientes().toArray();
		
			titular = (String)JOptionPane.showInputDialog(null, "Modificacion de Usuario:\n\nSeleccione al titular:", 
				"Telefonica - Modificaciones", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		if(titular == null) return;
		
		classCliente Titular = Clientes.get(getUser(titular));
		
		Object[] opciones = {"Modificar Deuda", "Modificar DNI", "Modificar Nombre"};
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion:", "Telefonica - Modificar Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		if(modUser(opcion, Titular)) {
			JOptionPane.showMessageDialog(null,
				"Los datos fueron modificados con exito!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
				"Ocurrio un error al modificar los datos.",
				"Error",
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// Section 05 : 06 Ver Adeudados
	public void debt() {
		String message = "<html>"; //resulta que permite html
		
		int max = Clientes.size();
		for(int i = 0; i < max; i = i + 1){
			classCliente titular = Clientes.get(i);
			
			if(titular.Deuda == 0) continue;
			
			message = message + titular.Nombre + "<br>DNI: " + titular.DNI + "<br>Deuda: $" + titular.Deuda + "<br><br>";
		}
		
		JLabel textArea = new JLabel(message + "</html>");
		
		JScrollPane sp = new JScrollPane(textArea);
		sp.setPreferredSize( new Dimension( 640, 480 ) );
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JOptionPane.showMessageDialog(null, sp);
	}
	
// =========================================================================================
// Section 06 : Secondary Functions
// =========================================================================================
	// Section 06 : 01 Delete Phone
	public void delPhone() {
		ArrayList<String> Telefonos = getTelefonos();
		
		if(Telefonos.size() == 0) {
			JOptionPane.showMessageDialog(null,
				"No hay lineas cargadas!",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Object[] options = Telefonos.toArray();
		
		String telefono = (String)JOptionPane.showInputDialog(null, "Eliminacion de Linea:\n\nSeleccione la linea:", 
			"Telefonica - Eliminar Linea", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(telefono == null) return;
		
		ArrayList<Integer> Datos = getLinea(telefono);
		
		Clientes.get(Datos.get(0)).Celulares.remove(telefono);
		
		JOptionPane.showMessageDialog(null,
				"La linea " + telefono + " fue eliminada con exito!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Section 06 : 02 Delete Client
	public void delClient() {
		ArrayList<String> Usuarios = getClientes();
		
		if(Usuarios.size() == 0) {
			JOptionPane.showMessageDialog(null,
				"No hay clientes cargados!",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Object[] options = Usuarios.toArray();
		
		String titular = (String)JOptionPane.showInputDialog(null, "Eliminacion de Titular:\n\nSeleccione el titular:", 
			"Telefonica - Eliminar Cliente", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(titular == null) return;
		
		int index = getUser(titular);
		
		Clientes.remove(Clientes.get(index));
		
		JOptionPane.showMessageDialog(null,
				"El cliente " + titular + " fue eliminado con exito!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Section 06 : 03 Create Client
	public void newClient() {
		
		Pattern patternName = Pattern.compile("\\W");
		Pattern patternDNI = Pattern.compile("^\\d{7,8}$");
		Pattern patternDeuda = Pattern.compile("^\\d{1,}$|(\\d*\\.{1}\\d{2})$");
		
		String input = "";
		String nombre = "";
		Matcher matcher;
		boolean invalid;
		
		do {
			input = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario: ", "Telefonica - Nuevo Cliente", JOptionPane.QUESTION_MESSAGE);
			matcher = patternName.matcher(input);
			invalid = matcher.find();
			if(!invalid) invalid = userExists(input);
		} while(invalid);
		nombre = input;
		
		int DNI = 0;
		
		do {
			input = JOptionPane.showInputDialog(null, "Ingrese el DNI del usuario: ", "Telefonica - Nuevo Cliente", JOptionPane.QUESTION_MESSAGE);
			matcher = patternDNI.matcher(input);
			invalid = !matcher.find();
		} while(invalid);
		DNI = Integer.parseInt(input);
		
		float deuda = 0;
		
		do {
			input = JOptionPane.showInputDialog(null, "Ingrese la deuda del usuario: ", "Telefonica - Nuevo Cliente", JOptionPane.QUESTION_MESSAGE);
			matcher = patternDeuda.matcher(input);
			invalid = !matcher.find();
		} while(invalid);
		deuda = Float.parseFloat(input);
		
		classCliente Persona = new classCliente(nombre, DNI, deuda);
		Clientes.add(Persona);
		JOptionPane.showMessageDialog(null,
				nombre + " fue cargado con exito!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Section 06 : 04 Create Phone
	public void newPhone() {
		String titular = "";
		if(Clientes.size() == 0) {
			JOptionPane.showMessageDialog(null,
				"No hay clientes cargados!",
				"Error",
				JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			Object[] options = getClientes().toArray();
		
			titular = (String)JOptionPane.showInputDialog(null, "Nueva Linea:\n\nSeleccione al titular:", 
				"Telefonica - Nueva Linea", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		}
		
		classCliente Titular = Clientes.get(getUser(titular));
		
		Pattern patternTelefono = Pattern.compile("^\\(\\d{3}\\)\\s\\d{4}\\-\\d{4}$");
		
		String input = "";
		String telefono = "";
		Matcher matcher;
		boolean invalid;
		boolean opcion;
		
		do {
			input = JOptionPane.showInputDialog(null, "Ingrese el numero de telefono nuevo: \nFormato (xxx) xxxx-xxxx", "Telefonica - Nueva Linea", JOptionPane.QUESTION_MESSAGE);
			matcher = patternTelefono.matcher(input);
			invalid = !matcher.find();
			
			if(!invalid) {
				boolean exists = celularExists(input);
				if(exists)
					JOptionPane.showMessageDialog(null,
						"La linea " + telefono + " ya existe!",
						"Error!",
						JOptionPane.ERROR_MESSAGE);
				invalid = exists;
			}
			
		} while(invalid);
		telefono = input;
		
		Object[] opciones = {"Prepaga", "Abono Mensual"};
		opcion = (JOptionPane.showOptionDialog(null, "Tipo de plan:", "Telefonica - Nuevo Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]) == 0 ? true : false);
		
		
		classLinea LineaCelular = new classLinea(telefono, opcion);
		Titular.Celulares.add(LineaCelular);
		JOptionPane.showMessageDialog(null,
				"La linea " + telefono + " fue asignada con exito al usuario " + Titular.Nombre + "!",
				"Success!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Section 06 : 05 Modify User Data
	public boolean modUser(int opcion, classCliente Titular) {
		Pattern patternName = Pattern.compile("\\W");
		Pattern patternDNI = Pattern.compile("^\\d{7,8}$");
		Pattern patternDeuda = Pattern.compile("^\\d{1,}$|(\\d*\\.{1}\\d{2})$");
		
		String input = "";
		String nombre = "";
		Matcher matcher;
		boolean invalid;
		
		if(opcion == 2) {
			do {
				input = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario: \nViejo: " + Titular.Nombre, "Telefonica - Modificar Cliente", JOptionPane.QUESTION_MESSAGE);
				matcher = patternName.matcher(input);
				invalid = matcher.find();
				if(!invalid) invalid = userExists(input);
			} while(invalid);
			
			try {
				Titular.Nombre = input;
				return true;
			} catch(Exception e) {
				return false;
			}
		} else if(opcion == 1) {
			int DNI = 0;
			
			do {
				input = JOptionPane.showInputDialog(null, "Ingrese el DNI del usuario: \nViejo: " + String.valueOf(Titular.DNI), "Telefonica - Modificar Cliente", JOptionPane.QUESTION_MESSAGE);
				matcher = patternDNI.matcher(input);
				invalid = !matcher.find();
			} while(invalid);
			DNI = Integer.parseInt(input);
			
			try {
				Titular.DNI = DNI;
				return true;
			} catch(Exception e) {
				return false;
			}
		} else if(opcion == 0) {
			float deuda = 0;
			
			do {
				input = JOptionPane.showInputDialog(null, "Ingrese la deuda del usuario: \nViejo: $" + String.valueOf(Titular.Deuda), "Telefonica - Modificar Cliente", JOptionPane.QUESTION_MESSAGE);
				matcher = patternDeuda.matcher(input);
				invalid = !matcher.find();
			} while(invalid);
			deuda = Float.parseFloat(input);
			
			try {
				Titular.Deuda = deuda;
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		return true;
	}
	
// =========================================================================================
// Section 07 : Main GUI
// =========================================================================================

	public class GUI_MainMenu implements ActionListener {
		JDialog dialog = null;
		JOptionPane optionPane = null;
		
		public GUI_MainMenu() {
			log("INFO: Menu Principal");
			GLOB_ESC = true;
			
			optionPane = new JOptionPane();
			optionPane.setMessage("Menu Principal");
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3,2));
			
			String[] options = { "Alta de Usuario",
								"Modificacion de Usuario",
								"Carga de Saldo Prepagas",
								"Baja de Usuario",
								"Abono de Factura",
								"Moratorias"
							};
							
			JButton[] buttons = new JButton[options.length];
			
			for (int i = 0; i < options.length; i++) {
				buttons[i] = new JButton(options[i]);
				buttons[i].setActionCommand(String.valueOf(i));
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			}
			
			JLabel whitespace = new JLabel("");
			panel.add(whitespace);
			
			buttons[0] = new JButton("Salir");
			buttons[0].setActionCommand("6");
			buttons[0].addActionListener(this);
			panel.add(buttons[0]);
			
			optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
			optionPane.setOptions(new Object[]{});
			optionPane.add(panel,1);
			
			dialog = optionPane.createDialog(null, "Menu Principal");
			dialog.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent event) {
			
			int option = Integer.parseInt(event.getActionCommand());
			log("INFO: Button click: " + option);
			
			switch(option) {
				case 0: newUser(); break;
				case 1: modUser(); break;
				case 2: cargarPrepaga(); break;
				case 3: delUser(); break;
				case 4: pagarFactura(); break;
				case 5: debt(); break; 
				case 6: System.exit(0);
			}
			GLOB_ESC = false;
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}

// =========================================================================================
// Section 08 : Initialization
// =========================================================================================

	public void init() {
		while(!GLOB_ESC) {
			GUI_MainMenu menu = new GUI_MainMenu();
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Final file = new Final();
		file.init();
	}
	
	
	
}