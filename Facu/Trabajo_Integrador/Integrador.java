// ========================================================================================= //
// Project				:	Trabajo Integrador												 //
// Authors				:	Beelzebufo     													 //
//        				:	Zenyatta11   													 //
//          			:	ValknutGG       												 //
//        				:	totoveloso          											 //
// Description			:	Trabajo integrador final de la materia Programacion II			 //
// ========================================================================================= //
// Table of Contents
//
// Section 00 : Imports 
//
// Section 01 : Globals 
//
// Section 02 : Class Declarations 
//
// Section 02 : 01 Class Persona
// Section 02 : 02 Class Permiso
// Section 02 : 03 Class Pasaporte
// Section 02 : 04 Class Pasaje
// Section 02 : 05 Class Punto de Vacunacion
// Section 02 : 06 Class Vacuna
// Section 02 : 07 Class Fecha
// Section 02 : 08 Class Listado de Vacunas
//
// Section 03 : GUI Classes
//
// Section 03 : 01 GUI de Permisos Nuevos
// Section 03 : 02 GUI Auxiliar de Permisos Existentes
// Section 03 : 03 GUI del listado de Permisos Existentes
// Section 03 : 04 GUI de Informacion Ciudadana
// Section 03 : 05 GUI de Mapa de Vacunacion
// Section 03 : 06 GUI de Estadististicas de los Puntos de Vacunacion
// Section 03 : 07 GUI de Ciudadanos que perdieron turno para vacunarse
// Section 03 : 08 GUI Auxiliar de Informes de Vuelos
// Section 03 : 09 GUI Principal
//
// Section 04 : Generadores
//
// Section 04 : 01 Generador de Centros de Vacunacion
// Section 04 : 02 Generador de Codigos
// Section 04 : 03 Generador de Fechas
// Section 04 : 04 Generador de Integers
// Section 04 : 05 Generador de Reportes (Todos)
// Section 04 : 06 Generador de Pasaportes
// Section 04 : 07 Generador de Aerolineas
// Section 04 : 08 Generador de Destinos
// Section 04 : 09 Generador de Pasajes
//
// Section 05 : Reportes
//
// Section 05 : 01 Reportes Estadisticos de Centros de Vacunacion
// Section 05 : 02 Reportes de Vuelos / Aeropuertos
// Section 05 : 03 Reportes de Ausencias para Vacunarse
// Section 05 : 04 Reportes de Vacunas
//
// Section 06 : Updaters
//
// Section 07 : Miscelaneo
//
// Section 07 : 01 Obtener Cantidad de Vacunas Aplicadas
// Section 07 : 02 Obtener Nombre de Vacuna por ID
// Section 07 : 03 Obtener timestamp actual
// Section 07 : 04 Obtener Nombres de Todas las Personas
// Section 07 : 05 Obtener Maximo de Dias por Mes
// Section 07 : 06 Logging
// Section 07 : 07 Debug Logger
// Section 07 : 08 Buscar Persona por Nombre
//
// Section 08 : Auxiliares
//
// Section 09 : Main
// ========================================================================================= 

// =========================================================================================
// Section 00 : Imports 
// =========================================================================================

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

import java.io.File;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class Integrador {
	
// =========================================================================================
// Section 01 : Globals 
// =========================================================================================
	
	public ArrayList<classPersona> Personas = new ArrayList<classPersona>();
	public ArrayList<classPuntoDeVacunacion> Centros = new ArrayList<classPuntoDeVacunacion>();
	
	public String regiones[] = { "Andes Patagonicos", "Cuyo", "Llanura Chaquena", "Llanura Pampeana", 
									"Meseta Patagonica", "Mesopotamia", "Noroeste", "Sierras Pampeanas" };
	
	public String nombres[] = { "Adrian", "Analia", "Andrea", "Andres", "Bonasso", "Carlos", "Carolina", "Constanza", 
								"Diego", "Edith", "Fabian", "Fabiana", "Francisco", "Hernan", "Itati", "Jimena", 
								"Karina", "Laura", "Ludmila", "Maria", "Mirtha", "Nadia", "Noemi", "Paola", 
								"Pilar", "Rodolfo", "Roxana", "Silvia", "Silvina", "Stella", "Valeria", "Veronica", 
								"Victoria", "Victorio", "Walter" };
	
	public String apellidos[] = {"Podetti", "Daino", "Guerra", "Garrido", "Bronstein", "Rafael-Tercero", "Barreto", "Galise", 
								"CarballoLongo", "Arena", "Lopez", "Bonardo", "Longo", "Paz", "Alfonzo", "Ambrus", 
								"Gimenez", "Ferrera", "Barragan", "Bechara", "Pisa", "Pszemiarower", "Mascioli", "Ferrer" };
	
	String[] aerolineas = {"American Jet", "Aerolineas Argentinas", "Andes Lineas Aereas", "Austral Lineas Aereas", 
							"Avianca Argentina", "Lineas Aereas del Estado ", "LATAM Argentina ", "TAPSA Aviacion" };
	
	String[] destinos = { "AEP", "AFA", "BHI", "BRC", "CNQ", "COR", "CPC", "CRD", "CTC", "EPA", "EQS", "EZE", "FMA", 
							"FTE", "IGR", "IRJ", "JUJ", "LGS", "LUQ", "MDQ", "MDZ", "NQN", "PMY", "PRA", "PSS", "RCQ", 
							"RCU", "REL", "RES", "RGA", "RGL", "RHD", "ROS", "RSA", "SDE", "SFN", "SLA", "TUC", "UAQ", 
							"USH", "VDM", "VLG" };
	
	public boolean AM = true;
	public final boolean const_debug = false;
	
	public long debounce = getTime();
	
	public int lastReport = 0;
	public int daysPassed = 1;
	
// =========================================================================================
// Section 02 : Class Declarations 
// =========================================================================================
	
	// Section 02 : 01 Class Persona
	
	public class classPersona {
		ArrayList<classPermiso> Permisos = new ArrayList<classPermiso>();
		
		boolean AM;
		
		classPasaje Pasaje;
		classPasaporte Pasaporte;
		
		int dni;
		int edad;
		
		String nombre;
		String region;
		
		public classPersona (String nombre, int dni, int edad, String region){
			log("INFO: Nueva persona!");
			
			this.nombre = nombre;
			this.dni = dni;
			this.edad = edad;
			this.region = region;
		}
		
		public String printInfoHabitante() {
			return this.nombre + "\n\nCodigo: " + this.Pasaporte.codigo + 
					"\nRegion: " + this.region + "\nDNI: " + this.dni + 
					" Edad: " + this.edad + "\n" + (AM ? "Turno Diurno" : "Turno Nocturno");
		}
	}
	
	// Section 02 : 02 Class Permiso
	
	public class classPermiso {
		boolean emergencia;
		
		classDate vigencia;
		
		String codigo;
		
		public classPermiso (classDate vigencia, boolean emergencia){
			log("INFO: Nuevo permiso!");
			this.codigo = generarCodigo();
			this.vigencia = vigencia;
			this.emergencia = emergencia;
		}
	}
	
	// Section 02 : 03 Class Pasaporte
	
	public class classPasaporte {
		VacunaArrayList<classVacuna> Vacunas = new VacunaArrayList<classVacuna>();
		
		String codigo;
		
		public classPasaporte (VacunaArrayList<classVacuna> vacunas){
			log("INFO: Nuevo pasaporte!");
			this.Vacunas = vacunas;
			this.codigo = generarCodigo();
		}
	}
	
	// Section 02 : 04 Class Pasaje
	
	public class classPasaje{
		classDate fechaSalida;
		
		String aerolinea;
		String destino;
		String numeroVuelo;
		
		public classPasaje() {
			log("INFO: Nuevo pasaje!");
			
			this.numeroVuelo = generarCodigo();
			this.destino = randomDestino();
			this.aerolinea = randomAerolinea();
			this.fechaSalida = randomDate();
		}
	}
	
	// Section 02 : 05 Class Punto de Vacunacion
	
	public class classPuntoDeVacunacion {
		int aplicadas;
		int recibidas;
		
		String nombre;
		
		public classPuntoDeVacunacion (String nombre){
			log("INFO: Nuevo Centro de Vacunacion!");
			this.nombre = nombre;
		}
	}
	
	// Section 02 : 06 Class Vacuna
	
	public class classVacuna {
		classDate fecha;
		
		int numero;
		
		String laboratorio;
		String nombre;
		
		public classVacuna(int numero, classDate fecha) {
			log("INFO: Nueva vacuna!");
			this.laboratorio = getVacuna(numero, true);
			this.nombre = getVacuna(numero, false);
			this.fecha = fecha;
			this.numero = numero;
		}
	}
	
	// Section 02 : 07 Class Fecha
	
	public class classDate {
		int day;
		int month;
		int year;
		
		public classDate (int day, int month, int year){
			log("INFO: Nueva fecha!");
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		public String getFormateado() {
			return this.year + "/" + String.format("%02d", this.month) + "/" + String.format("%02d", this.day);
		}
	}
	
	// Section 02 : 08 Class Listado de Vacunas
	
	public class VacunaArrayList<classVacuna> extends ArrayList<classVacuna> {
		public String getDetallado() {
			int max = size();
			String retVal = "";
			
			for(int i = 0; i < max; i = i + 1) {
				Integrador.classVacuna vacuna = this.get(i);
				retVal = retVal + (i == 0 ? "" : ",\"\"\r\n,\"\",\"\",\"\",\"\",\"") + vacuna.nombre + "\",\"" + 
									vacuna.fecha.getFormateado() + "\",\"" + vacuna.laboratorio + "\"";
			}
			
			if(max == 0) return "\"N/A\",\"N/A\",\"N/A\"";
			return retVal;
		}
	}
	
// =========================================================================================
// Section 03 : GUI Classes
// =========================================================================================
	
	// Section 03 : 01 GUI de Permisos Nuevos
	
	public void GUI_GenerarPermiso() {
		int situacion;
		String usuario;
		
		Object[] options = { "Esencial", "No Esencial", "Emergencia", "Cancelar" };
		situacion = JOptionPane.showOptionDialog(null, "Permiso Nuevo:\n\nSeleccione la situacion correspondiente:", 
						"Permiso Nuevo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(situacion == 3) return;
		
		Object[] options2 = getAllNames().toArray();
		usuario = (String)JOptionPane.showInputDialog(null, "Permiso Nuevo:\n\nSeleccione al titular:", 
							"Permiso Nuevo", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
		
		classPersona titular = findPersona(usuario);
		
		if(titular == null) {
			log("ERROR: El titular no existe!");
			return;
		}
		
		int cantVacunas = titular.Pasaporte.Vacunas.size();
		
		if(situacion == 1 && cantVacunas != 2 || situacion == 0 && randomInt(5) == 5) {
			JOptionPane.showMessageDialog(null, "El pedido se reboto.", "Permiso Nuevo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		classPermiso permisoDijoUnPetizo = new classPermiso(randomDate(), (situacion == 2 ? true : false));
		titular.Permisos.add(permisoDijoUnPetizo);
		JOptionPane.showMessageDialog(null, "El pedido se aprobo!\nEl permiso de circulacion de " + titular.nombre + 
									" tiene vigencia hasta el " + permisoDijoUnPetizo.vigencia.getFormateado() + 
									"\nEl codigo del permiso es " + permisoDijoUnPetizo.codigo);
		
		return;
	}
	
	// Section 03 : 02 GUI Auxiliar de Permisos Existentes
	
	public void GUI_ListarPermisos() {
		String usuario;
		Object[] options2 = getAllNames().toArray();
		
		usuario = (String)JOptionPane.showInputDialog(null, "Busqueda de Permisos:\n\nSeleccione al titular:", 
						"Busqueda de Permisos", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
		
		classPersona titular = findPersona(usuario);
		
		if(titular == null) {
			log("ERROR: El titular no existe!");
			return;
		}
		
		new GUI_ListadoPermisos(titular);
		
		return;
	}
	
	// Section 03 : 03 GUI del listado de Permisos Existentes
	
	public class GUI_ListadoPermisos implements ActionListener {
		JDialog dialog = null;
		JOptionPane optionPane = null;
		
		public GUI_ListadoPermisos(classPersona persona) {
			
			optionPane = new JOptionPane();
			optionPane.setMessage("Permisos de " + persona.nombre);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

			JPanel panel = new JPanel();
			
			int max = persona.Permisos.size();
			panel.setLayout(new GridLayout(max*5 + 2,3));
			
			JLabel textArea;
			
			for(int i = 0; i < max; i = i + 1) {
				classPermiso permisoDijoUnPetizo = persona.Permisos.get(i);
				
				textArea = new JLabel("Codigo:");
				panel.add(textArea);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				textArea = new JLabel(permisoDijoUnPetizo.codigo);
				panel.add(textArea);
				
				textArea = new JLabel("DNI Registrado:");
				panel.add(textArea);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				textArea = new JLabel(String.valueOf(persona.dni));
				panel.add(textArea);
				
				textArea = new JLabel("Titular:");
				panel.add(textArea);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				textArea = new JLabel(persona.nombre);
				panel.add(textArea);
				
				textArea = new JLabel("Vigencia:");
				panel.add(textArea);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				textArea = new JLabel(permisoDijoUnPetizo.vigencia.getFormateado());
				panel.add(textArea);
			}
			
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			JButton buttons = new JButton("Volver");
			buttons.setActionCommand("1");
			buttons.addActionListener(this);
			panel.add(buttons);
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
			optionPane.setOptions(new Object[]{});
			optionPane.add(panel,1);
			
			dialog = optionPane.createDialog(null, "Permiso de Circulacion");
			dialog.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent event) {
			if((debounce + 2L) > getTime()) return;
			
			debounce = getTime();

			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
	
	// Section 03 : 04 GUI de Informacion Ciudadana
	
	public class GUI_InformacionMenu implements ActionListener {
		JDialog dialog = null;
		JOptionPane optionPane = null;
		int scroll = 0;
		
		public GUI_InformacionMenu(int persona) {
			this.scroll = persona;
			
			if(this.scroll >= Personas.size()) this.scroll = Personas.size() - 1;
			else if(this.scroll < 0) this.scroll = 0;
			
			optionPane = new JOptionPane();
			optionPane.setMessage("Registro #" + this.scroll);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

			JPanel panel = new JPanel();
			
			panel.setLayout(new GridLayout(7,3));
			
			JLabel textArea = new JLabel(Personas.get(this.scroll).nombre);
			panel.add(textArea);
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			textArea = new JLabel("Edad: " + Personas.get(this.scroll).edad);
			panel.add(textArea);
			
			textArea = new JLabel("Region: " + Personas.get(this.scroll).region);
			panel.add(textArea);
			
			textArea = new JLabel("Numero de DNI: " + Personas.get(this.scroll).dni);
			panel.add(textArea);
			
			textArea = new JLabel("Codigo de Pasaporte: " + Personas.get(this.scroll).Pasaporte.codigo);
			panel.add(textArea);
			
			int vacunasDadas = Personas.get(this.scroll).Pasaporte.Vacunas.size();
			
			textArea = new JLabel("Vacunas Aplicadas: " + vacunasDadas);
			panel.add(textArea);
			
			if(vacunasDadas == 0) {
				textArea = new JLabel("No se presento a vacunar");
				textArea.setForeground(Color.red);
				Font font = new Font("Arial Black", Font.BOLD,12);
				textArea.setFont(font);
				panel.add(textArea);
			} else {
				textArea = new JLabel("");
				panel.add(textArea);
			}
			
			JButton buttons = new JButton("Anterior");
			buttons.setActionCommand("0");
			buttons.addActionListener(this);
			panel.add(buttons);
			
			buttons = new JButton("Siguiente");
			buttons.setActionCommand("2");
			buttons.addActionListener(this);
			panel.add(buttons);
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			buttons = new JButton("Volver");
			buttons.setActionCommand("1");
			buttons.addActionListener(this);
			panel.add(buttons);
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
			optionPane.setOptions(new Object[]{});
			optionPane.add(panel,1);
			
			dialog = optionPane.createDialog(null, "Informacion Ciudadana");
			dialog.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent event) {
			if((debounce + 2L) > getTime()) return;
			
			debounce = getTime();
			
			int option = Integer.parseInt(event.getActionCommand());
			
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			
			switch(option) {
				case 0: new GUI_InformacionMenu(this.scroll - 1); break;
				case 2: new GUI_InformacionMenu(this.scroll + 1); break;
			}
		}
	}
	
	// Section 03 : 05 GUI de Mapa de Vacunacion
	
	public class GUI_MapaVacunacion implements ActionListener {
		JDialog dialog = null;
		JOptionPane optionPane = null;
		
		String sortOrder[] = { "Por Vacuna", "Por Region", "Por Edad", "Volver" };
		
		public GUI_MapaVacunacion(int sortForm) {
			
			optionPane = new JOptionPane();
			optionPane.setMessage("Vacunas por " + sortOrder[sortForm]);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

			if(sortForm == 0) {
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(14,3));
				
				JLabel textArea;
				
				for(int i = 0; i < 12; i = i + 1) {
					textArea = new JLabel(getVacuna(i, false));
					panel.add(textArea);
					
					textArea = new JLabel("");
					panel.add(textArea);
					
					textArea = new JLabel(String.valueOf(getNumeroAplicadas(i, 0)));
					panel.add(textArea);
				}
				
				JButton buttons = new JButton("Generar Reporte");
				buttons.setActionCommand("0");
				buttons.addActionListener(this);
				panel.add(buttons);
				
				
				buttons = new JButton("Volver");
				buttons.setActionCommand("1");
				buttons.addActionListener(this);
				panel.add(buttons);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
				optionPane.setOptions(new Object[]{});
				optionPane.add(panel,1);
				
				dialog = optionPane.createDialog(null, "Informacion Ciudadana");
				dialog.setVisible(true);
				
			} else if(sortForm == 1) {
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(10,3));
				
				JLabel textArea;
				
				for(int i = 0; i < 8; i = i + 1) {
					textArea = new JLabel(regiones[i]);
					panel.add(textArea);
					
					textArea = new JLabel("");
					panel.add(textArea);
					
					textArea = new JLabel(String.valueOf(getNumeroAplicadas(i, 1)));
					panel.add(textArea);
				}
				
				JButton buttons = new JButton("Generar Reporte");
				buttons.setActionCommand("0");
				buttons.addActionListener(this);
				panel.add(buttons);
				
				
				buttons = new JButton("Volver");
				buttons.setActionCommand("1");
				buttons.addActionListener(this);
				panel.add(buttons);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
				optionPane.setOptions(new Object[]{});
				optionPane.add(panel,1);
				
				dialog = optionPane.createDialog(null, "Informacion Ciudadana");
				dialog.setVisible(true);
				
			} else {
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(7,3));
				
				JLabel textArea;
				
				for(int i = 0; i < 5; i = i + 1) {
					textArea = new JLabel("" + i * 20 + " a " + ((i + 1) * 20 - 1) + " anios");
					panel.add(textArea);
					
					textArea = new JLabel(String.valueOf(getNumeroAplicadas(i, 2)));
					panel.add(textArea);
				}
				
				JButton buttons = new JButton("Generar Reporte");
				buttons.setActionCommand("0");
				buttons.addActionListener(this);
				panel.add(buttons);
				
				
				buttons = new JButton("Volver");
				buttons.setActionCommand("1");
				buttons.addActionListener(this);
				panel.add(buttons);
				
				textArea = new JLabel("");
				panel.add(textArea);
				
				optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
				optionPane.setOptions(new Object[]{});
				optionPane.add(panel,1);
				
				dialog = optionPane.createDialog(null, "Informacion Ciudadana");
				dialog.setVisible(true);
			}
		}
		
		public void actionPerformed(ActionEvent event) {
			if(debounce + 3L > getTime()) return;
			debounce = getTime();
			
			int option = Integer.parseInt(event.getActionCommand());
			
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			
			switch(option) {
				case 0: generarReporte(); break;
			}
		}
	}
	
	// Section 03 : 06 GUI de Estadististicas de los Puntos de Vacunacion
	
	public class GUI_Estadisticas implements ActionListener {
		JDialog dialog = null;
		JOptionPane optionPane = null;
		
		public GUI_Estadisticas() {
			
			JOptionPane optionPane = new JOptionPane();
			
			optionPane.setMessage("Estadisticas de los Centros de Vacunacion");
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			
			int max = Centros.size();
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(max+2,3));
			
			updateCentros();
			JLabel textArea;
			
			textArea = new JLabel("Centro de Vacunacion");
			panel.add(textArea);
			
			textArea = new JLabel("Vacunas Recibidas");
			panel.add(textArea);
			
			textArea = new JLabel("Vacunas Aplicadas");
			panel.add(textArea);
			
			for(int i = 0; i < max; i = i + 1) {
				classPuntoDeVacunacion centroVac = Centros.get(i);
				textArea = new JLabel(centroVac.nombre);
				panel.add(textArea);
				
				textArea = new JLabel(String.valueOf(centroVac.recibidas));
				panel.add(textArea);
				
				textArea = new JLabel(String.valueOf(centroVac.aplicadas));
				panel.add(textArea);
				
			}
			
			JButton buttons = new JButton("Generar Reporte");
			buttons.setActionCommand("0");
			buttons.addActionListener(this);
			panel.add(buttons);
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			buttons = new JButton("Volver");
			buttons.setActionCommand("1");
			buttons.addActionListener(this);
			panel.add(buttons);
			
			optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
			optionPane.setOptions(new Object[]{});
			optionPane.add(panel,1);
			
			dialog = optionPane.createDialog(null, "Informacion Ciudadana");
			dialog.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent event) {
			if(debounce + 3L > getTime()) return;
			debounce = getTime();
			
			int option = Integer.parseInt(event.getActionCommand());
			
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			
			switch(option) {
				case 0: generarReporteEst(); break;
			}
		}
	}
	
	// Section 03 : 07 GUI de Ciudadanos que perdieron turno para vacunarse
	
	public void GUI_Ausentes() {
		int max = Personas.size();
		String message = "<html>";
		for(int i = 0; i < max; i = i + 1){
			classPersona persona = Personas.get(i);
			if(persona.Pasaporte.Vacunas.size() != 0) continue;
			message = message + persona.nombre + "<br>DNI: " + persona.dni + "<br>Edad: " + persona.edad + "<br>Region: " + 
						persona.region + "<br><br>";
		}
		
		JLabel textArea = new JLabel(message + "</html>");
		JScrollPane sp = new JScrollPane(textArea);
		sp.setPreferredSize( new Dimension( 640, 480 ) );
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JOptionPane.showMessageDialog(null, sp);
		
		int option;
		Object[] options = { "Generar Reporte", "No Generar" };
		option = JOptionPane.showOptionDialog(null, "Desea generar un reporte de los ausentes?", "Ausentes", 
												JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	
		if(option == 0) generarReporteAusentes();
	}
	
	// Section 03 : 08 GUI Auxiliar de Informes de Vuelos
	
	public void GUI_MostrarInforme() {
		sacarPasajes();
		int max = Personas.size();
		
		int option;
		Object[] options = { "Buscar por Aerolinea", "Buscar por Aeropuerto", "Listar Todo", "Volver" };
		option = JOptionPane.showOptionDialog(null, "Menu Principal:\n\nSeleccione una opcion para continuar:", 
					"Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		String query = "";
		switch(option) {
			case 0: query = (String)JOptionPane.showInputDialog(null, "Seleccione la aerolinea:", "Informes Vuelos", 
					JOptionPane.QUESTION_MESSAGE, null, aerolineas, aerolineas[0]); 
					break;
					
			case 1: query = (String)JOptionPane.showInputDialog(null, "Seleccione el destino:", "Informes Vuelos", 
					JOptionPane.QUESTION_MESSAGE, null, destinos, destinos[0]); 
					break;
					
			case 3: return;
		}
		
		String message = "<html>"; //resulta que permite html
		
		for(int i = 0; i < max; i = i + 1){
			classPersona persona = Personas.get(i);
			
			if(persona.Pasaje == null) continue;
			
			debug("DEBUG: Tiene pasaje, option " + option + "; Aero: [" + persona.Pasaje.aerolinea + "]; Destino: [" + persona.Pasaje.destino + "]; ");
			
			if(option == 2 || option == 0 && persona.Pasaje.aerolinea.equals(query) || persona.Pasaje.destino.equals(query) && option == 1)
				message = message + persona.nombre + "<br>DNI: " + persona.dni + "<br>Edad: " + persona.edad + "<br>Region: " + 
						persona.region + "Numero de vuelo: " + persona.Pasaje.numeroVuelo + "<br>Destino: " + persona.Pasaje.destino + 
						"<br>Aerolinea: " + persona.Pasaje.aerolinea + "<br>Fecha de vuelo: " + persona.Pasaje.fechaSalida.getFormateado() + 
						"<br><br>";
		}
		
		JLabel textArea = new JLabel(message + "</html>");
		
		JScrollPane sp = new JScrollPane(textArea);
		sp.setPreferredSize( new Dimension( 640, 480 ) );
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JOptionPane.showMessageDialog(null, sp);
		
		Object[] options3 = { "Generar Reporte", "No Generar" };
		option = JOptionPane.showOptionDialog(null, "Desea generar un reporte de los ausentes?", "Ausentes", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);
	
		if(option == 0) generarReportesVuelos();
	}
	
	// Section 03 : 09 GUI Principal
	
	public class GUI_MenuPrincipal implements ActionListener {
		JDialog dialog = null;
		JOptionPane optionPane = null;
		
		public GUI_MenuPrincipal() {
			optionPane = new JOptionPane();
			optionPane.setMessage("Menu Principal");
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(4,3));
			
			JLabel textArea = new JLabel("Turno " + (AM ? "Diurno" : "Nocturno"));
			panel.add(textArea);
			
			textArea = new JLabel("");
			panel.add(textArea);
			
			textArea = new JLabel("Nuevos reportes: " + lastReport);
			panel.add(textArea);
			
			String[] options = { "Informacion de los Habitantes",
								"Mapa de Vacunacion / Pasaportes Sanitarios",  // yes
								"Generar Permiso de Circulacion",
								"Informacion de permisos",
								"Consultar Informe de Aeropuerto",
								"Estadistica de Vacunacion", 
								"Reporte Ausentes", "Reportes Todo", "Salir"
							};
							
			JButton[] buttons = new JButton[options.length];
			
			for (int i = 0; i < options.length; i++) {
				buttons[i] = new JButton(options[i]);
				buttons[i].setActionCommand(String.valueOf(i));
				buttons[i].addActionListener(this);
				panel.add(buttons[i]);
			}
			
			
			optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
			optionPane.setOptions(new Object[]{});
			optionPane.add(panel,1);
			
			dialog = optionPane.createDialog(null, "Menu Principal");
			dialog.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent event) {
			if(debounce + 2L > getTime()) return;
			debounce = getTime();
			
			int option = Integer.parseInt(event.getActionCommand());
			log("INFO: Button click: " + option);
			
			if(option != 7)
				lastReport = generarPasaporte();
			
			switch(option) {
				case 0: mostrarInfoHabitantes(); break;
				case 1: mostrarMapaVacunacion(); break;
				case 2: GUI_GenerarPermiso(); break;
				case 3: GUI_ListarPermisos(); break;
				case 4: GUI_MostrarInforme(); break;
				case 5: new GUI_Estadisticas(); break;
				case 6: GUI_Ausentes(); break;
				case 7: generarTodosReportes(); break;
				case 8: System.exit(0);
			}
			
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
	
// =========================================================================================
// Section 04 : Generadores
// =========================================================================================
	
	// Section 04 : 01 Generador de Centros de Vacunacion
	
	public void generarCentros() {
		log("INFO: Generando centros...");
		
		Centros.add(new classPuntoDeVacunacion("Hospital Pedro de Elizalde Pediatria"));
		Centros.add(new classPuntoDeVacunacion("Hospital Ramos Mejia Atencion Hospitalaria General Balvanera"));
		Centros.add(new classPuntoDeVacunacion("Hospital Gutierrez Pediatria Recoleta"));
		Centros.add(new classPuntoDeVacunacion("Hospital Argerich Atencion Hospitalaria General"));
		Centros.add(new classPuntoDeVacunacion("Hospital Alvarez Atencion Hospitalaria General Flores"));
		Centros.add(new classPuntoDeVacunacion("Hospital Tornu Atencion Hospitalaria General Villa Ortuzar"));
		Centros.add(new classPuntoDeVacunacion("Hospital Penna Atencion Hospitalaria General Parque Patricios"));
		Centros.add(new classPuntoDeVacunacion("Hospital Alvear Psiquiatria La Paternal"));
		Centros.add(new classPuntoDeVacunacion("Hospital Durand Atencion Hospitalaria General"));
		Centros.add(new classPuntoDeVacunacion("Hospital Piniero Atencion Hospitalaria General"));
		Centros.add(new classPuntoDeVacunacion("Hospital Zubizarreta Atencion Hospitalaria General Villa Devoto"));
		Centros.add(new classPuntoDeVacunacion("Hospital Udaondo Gastroenterologia Parque Patricios"));
		Centros.add(new classPuntoDeVacunacion("Hospital Santojanni Atencion Hospitalaria General"));
		Centros.add(new classPuntoDeVacunacion("Hospital Pedro Lagleyze Oftalmologia Villa Gral. Mitre"));
		Centros.add(new classPuntoDeVacunacion("Hospital Velez Sarsfield Atencion Hospitalaria General"));
		Centros.add(new classPuntoDeVacunacion("Hospital Tobar Garcia Neuropsiquiatria infantil"));
		Centros.add(new classPuntoDeVacunacion("Hospital Garrahan"));
		Centros.add(new classPuntoDeVacunacion("Hospital Espaniol Balvanera"));
		Centros.add(new classPuntoDeVacunacion("Hospital Aleman Oncologia, Toxoplasmosis, Quemaduras"));
		Centros.add(new classPuntoDeVacunacion("Hospital Italiano Atencion Hospitalaria General"));
		Centros.add(new classPuntoDeVacunacion("Hospital Naval Central"));
		
		Centros.add(new classPuntoDeVacunacion("Maternidad Sarda Maternidad Parque Patricios"));
		
		Centros.add(new classPuntoDeVacunacion("Sanatorio Julio Mendez Caballito"));
		Centros.add(new classPuntoDeVacunacion("Sanatorio de los Arcos"));
		
		log("INFO: Centros generados!");
	}
	
	// Section 04 : 02 Generador de Codigos
	
	public String generarCodigo() {
		return String.valueOf(ThreadLocalRandom.current().nextInt(10, 64)) + "-" + 
			String.valueOf(System.currentTimeMillis() % 1000000) + "-" + (char)ThreadLocalRandom.current().nextInt(65, 91);
	}
	
	// Section 04 : 03 Generador de Fechas
	
	public classDate randomDate() {
		int month = randomInt(11);
		return new classDate(randomInt(getMonthMax(month)-1)+1, month+1, (randomInt(1) == 0 ? 2020 : 2021));
	}
	
	// Section 04 : 04 Generador de Integers
	
	public int randomInt(int max) {
		return ThreadLocalRandom.current().nextInt(0, max+1);
	}
	
	// Section 04 : 05 Generador de Reportes (Todos)
	
	public void generarTodosReportes() {
		generarReporte();
		generarReporteAusentes();
		generarReporteEst();
		generarReportesVuelos();
	}
	
	// Section 04 : 06 Generador de Pasaportes
	
	public int generarPasaporte() {
		int max = randomInt(11)+1;
		int sinVacunas = 0;
		
		log("INFO: Generando Pasaportes (" + max + ")");
		
		for(int i = 0; i < max; i = i + 1) {
			int dni = randomInt(60000000) + 10000000;
			int edad = randomInt(90)+1;
			
			String region = regiones[randomInt(regiones.length-1)];
			
			debug("DEBUG: Nueva persona (" + nombres[randomInt(nombres.length-1)] + " " + apellidos[randomInt(apellidos.length-1)]+ 
					", " + dni+ ", " + edad+ ", " + region + ")");
			
			classPersona persona = new classPersona(nombres[randomInt(nombres.length-1)] + " " + 
						apellidos[randomInt(apellidos.length-1)], dni, edad, region);
			
			VacunaArrayList<classVacuna> Vacunas = new VacunaArrayList<classVacuna>();
			
			if(randomInt(3) == 3) {
				int vacunaNum = randomInt(10);
				debug("DEBUG: Vacuna tipo " + vacunaNum);
				
				classVacuna newVacuna = new classVacuna(vacunaNum, randomDate());
				Vacunas.add(newVacuna);
				
				if(randomInt(5) == 5) {
					debug("DEBUG: Vacuna tipo " + vacunaNum + 1);
					Vacunas.add(new classVacuna(vacunaNum + 1, new classDate(newVacuna.fecha.day, newVacuna.fecha.month, 
								newVacuna.fecha.year + 1 + randomInt(2))));
				}
			} else {
				sinVacunas = sinVacunas + 1;
			}
			
			classPasaporte pasaporte = new classPasaporte(Vacunas);
			
			persona.Pasaporte = pasaporte;
			persona.AM = AM;
			Personas.add(persona);
			
			debug("DEBUG: Persona agregada");
		}
		
		if(sinVacunas != 0) 
			JOptionPane.showMessageDialog(null,
				"Hay " + sinVacunas + " reportes nuevos de ciudadanos que no se han presentado al turno de vacunacion.",
				"Ciudadanos Negandose a Vacunar",
				JOptionPane.ERROR_MESSAGE);
		
		AM = !AM;
		
		if(AM) daysPassed = daysPassed + 1;
		return max;
	}
	
	// Section 04 : 07 Generador de Aerolineas
	
	public String randomAerolinea() {
		return aerolineas[randomInt(aerolineas.length-1)];
	}
	
	// Section 04 : 08 Generador de Destinos
	
	public String randomDestino() {
		return destinos[randomInt(destinos.length-1)];
	}
	
	// Section 04 : 09 Generador de Pasajes
	
	public void sacarPasajes() {
		int max = Personas.size();
		
		for(int i = 0; i < max; i = i + 1) {
			if(randomInt(5) != 1) continue;
			classPasaje nosVamosAMiami = new classPasaje();
			Personas.get(i).Pasaje = nosVamosAMiami;
		}
	}
	
// =========================================================================================
// Section 05 : Reportes
// =========================================================================================
	
	// Section 05 : 01 Reportes Estadisticos de Centros de Vacunacion
	
	public void generarReporteEst() {
		String fileName = "./ReporteCentros_" + getTime() + ".csv";
		File myFile = new File(fileName);
		
		try{
			if(myFile.createNewFile()) log("INFO: File created! " + myFile.getName());
			else System.out.println("WARN: File already exists.");
			
			FileWriter myFile_W = new FileWriter(fileName, false);
			myFile_W.write("\"ID\",\"Centro\",\"Recibidas\",\"Aplicadas\"\r\n");
			
			int max = Centros.size();
			
			for(int i = 0; i < max; i = i + 1){
				classPuntoDeVacunacion centroVac = Centros.get(i);
				myFile_W.write("\"" + i + "\",\"" + centroVac.nombre + "\",\"" + centroVac.recibidas + "\",\"" + centroVac.aplicadas + "\"\r\n");
			}
			
			myFile_W.close();
			System.out.println("INFO: Reporte generado!");
			JOptionPane.showMessageDialog(null, "Se genero el reporte " + fileName + " satisfactoriamente!");
			
		} catch(Exception e) {
			System.out.println("ERROR: No se pudo generar el reporte!");
		}
	}
	
	// Section 05 : 02 Reportes de Vuelos / Aeropuertos
	
	public void generarReportesVuelos() {
		String fileName = "./ReporteVuelos_" + getTime() + ".csv";
		File myFile = new File(fileName);
		
		try{
			if(myFile.createNewFile()) log("INFO: File created! " + myFile.getName());
			else System.out.println("WARN: File already exists.");
			
			FileWriter myFile_W = new FileWriter(fileName, false);
			myFile_W.write("\"ID\",\"Nombre\",\"DNI\",\"Edad\",\"Region\",\"Numero de Vuelo\",\"Destino\",\"Aerolinea\",\"Fecha de Salida\"\r\n");
			
			int max = Personas.size();
			
			for(int i = 0; i < max; i = i + 1){
				
				classPersona persona = Personas.get(i);
				
				if(persona.Pasaje == null) continue;
				
				debug("DEBUG: " + "\"" + i + "\",\"" + persona.nombre + "\",\"" + persona.dni + "\",\"" + 
						persona.edad + "\",\"" + persona.region + "\",\"" + persona.Pasaje.numeroVuelo + 
						"\",\"" + persona.Pasaje.destino + "\",\"" + persona.Pasaje.aerolinea + "\",\"" + 
						persona.Pasaje.fechaSalida.getFormateado() + "\"\r\n");
				
				myFile_W.write("\"" + i + "\",\"" + persona.nombre + "\",\"" + persona.dni + "\",\"" + 
							persona.edad + "\",\"" + persona.region + "\",\"" + persona.Pasaje.numeroVuelo + 
							"\",\"" + persona.Pasaje.destino + "\",\"" + persona.Pasaje.aerolinea + "\",\"" + 
							persona.Pasaje.fechaSalida.getFormateado() + "\"\r\n");
			}
			
			myFile_W.close();
			System.out.println("INFO: Reporte generado!");
			
			JOptionPane.showMessageDialog(null, "Se genero el reporte " + fileName + " satisfactoriamente!");
		} catch(Exception e) {
			System.out.println("ERROR: No se pudo generar el reporte!");
		}
	}
	
	// Section 05 : 03 Reportes de Ausencias para Vacunarse
	
	public void generarReporteAusentes() {
		String fileName = "./ReporteAusentes_" + getTime() + ".csv";
		File myFile = new File(fileName);
		
		try{
			if(myFile.createNewFile()) log("INFO: File created! " + myFile.getName());
			else System.out.println("WARN: File already exists.");
			
			FileWriter myFile_W = new FileWriter(fileName, false);
			myFile_W.write("\"ID\",\"Nombre\",\"DNI\",\"Edad\",\"Region\"\r\n");
			
			int max = Personas.size();
			for(int i = 0; i < max; i = i + 1){
				classPersona persona = Personas.get(i);
				if(persona.Pasaporte.Vacunas.size() != 0) continue;
				myFile_W.write("\"" + i + "\",\"" + persona.nombre + "\",\"" + persona.dni + "\",\"" + 
								persona.edad + "\",\"" + persona.region + "\"\r\n");
			}
			
			myFile_W.close();
			System.out.println("INFO: Reporte generado!");
			JOptionPane.showMessageDialog(null, "Se genero el reporte " + fileName + " satisfactoriamente!");
			
		} catch(Exception e) {
			System.out.println("ERROR: No se pudo generar el reporte!");
		}
	}
	
	// Section 05 : 04 Reportes de Vacunas
	
	public void generarReporte() {
		String fileName = "./ReporteGeneral_" + getTime() + ".csv";
		File myFile = new File(fileName);
		
		try{
			if(myFile.createNewFile()) log("INFO: File created! " + myFile.getName());
			else System.out.println("WARN: File already exists.");
			
			FileWriter myFile_W = new FileWriter(fileName, false);
			myFile_W.write("\"ID\",\"Nombre\",\"DNI\",\"Edad\",\"Region\",\"Vacuna\",\"Fecha\",\"Laboratorio\",\"\"\r\n");
			
			int max = Personas.size();
			for(int i = 0; i < max; i = i + 1){
				classPersona persona = Personas.get(i);
				myFile_W.write("\"" + i + "\",\"" + persona.nombre + "\",\"" + persona.dni + "\",\"" + 
							persona.edad + "\",\"" + persona.region + "\"," + persona.Pasaporte.Vacunas.getDetallado() + ",\"\"\r\n");
			}
			
			myFile_W.close();
			System.out.println("INFO: Reporte generado!");
			JOptionPane.showMessageDialog(null, "Se genero el reporte " + fileName + " satisfactoriamente!");
			
		} catch(Exception e) {
			System.out.println("ERROR: No se pudo generar el reporte!");
		}
	}
	
// =========================================================================================
// Section 06 : Updaters
// =========================================================================================
	
	public void updateCentros() {
		int max = Centros.size();
		log("INFO: Repartiendo vacunas...");
		
		for(int i = 0; i < max; i = i + 1) {
			int recibidas = randomInt(142857);
			int aplicadas = randomInt((int)(recibidas * 0.2));
			
			classPuntoDeVacunacion centroVac = Centros.get(i);
			
			centroVac.recibidas = recibidas;
			centroVac.aplicadas = aplicadas;
			
			log("INFO: Repartiendo al " + centroVac.nombre + "...");
		}
		
		log("INFO: Vacunas repartidas!");
	}
	
// =========================================================================================
// Section 07 : Miscelaneo
// =========================================================================================
	
	// Section 07 : 01 Obtener Cantidad de Vacunas Aplicadas
	
	public int getNumeroAplicadas(int ID, int search) {
		int num = 0;
		int max = Personas.size();
		
		debug("DEBUG: Search: " + search);
		
		for(int i = 0; i < max; i = i + 1) {
			int vacunaCant = Personas.get(i).Pasaporte.Vacunas.size();
			if(vacunaCant == 0) continue;
			
			String region = Personas.get(i).region;
			int edad = Personas.get(i).edad;
			debug("DEBUG: Region: " + region);
			for(int j = 0; j < vacunaCant; j = j + 1) {
				int vacunaNum = Personas.get(i).Pasaporte.Vacunas.get(j).numero;
				switch(search) {
					case 0: if(vacunaNum == ID) num = num + 1; break;
					case 1: if(region.equals(regiones[ID])) num = num + 1; break;
					case 2: if(edad <= ID*20 && edad > (ID-1)*20) num = num + 1; break;
				}
			}
		}
		return num;
	}
	
	// Section 07 : 02 Obtener Nombre de Vacuna por ID
	
	public String getVacuna(int numero, boolean labo) {
		if(!labo) {
			switch(numero) {
				case 0: return "AstraZeneca - Dosis I";
				case 1: return "AstraZeneca - Dosis II";
				case 2: return "Johnson and Johnson's Janssen";
				case 3: return "Johnson and Johnson's Janssen";
				case 4: return "Moderna - Dosis I";
				case 5: return "Moderna - Dosis II";
				case 6: return "Novavax - Dosis I";
				case 7: return "Novavax - Dosis II";
				case 8: return "Pfizer - Dosis I";
				case 9: return "Pfizer - Dosis II";
				case 10: return "Sputnik V - Dosis I";
				case 11: return "Sputnik V - Dosis II";
			}
		} else {
			switch(numero) {
				case 0: return "AstraZeneca";
				case 1: return "AstraZeneca";
				case 2: return "Johnson and Johnson's Janssen";
				case 3: return "Moderna";
				case 4: return "Moderna";
				case 5: return "Novavax";
				case 6: return "Novavax";
				case 7: return "Pfizer";
				case 8: return "Pfizer";
				case 9: return "Gamaleya"; // soiyuz nerushimij respublik sovdonik
				case 10: return "Gamaleya";
			}
		}
		return "null";
	}
	
	// Section 07 : 03 Obtener timestamp actual
	
	public long getTime() {
		long time = System.currentTimeMillis() / 1000L;
		
		debug("DEBUG: Time: " + time);
		
		return time;
	}
	
	// Section 07 : 04 Obtener Nombres de Todas las Personas
	
	public ArrayList<String> getAllNames() {
		int max = Personas.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1)
			retVal.add(Personas.get(i).nombre);
		
		return retVal;
	}
	
	// Section 07 : 05 Obtener Maximo de Dias por Mes
	
	public int getMonthMax(int month) {
		switch(month) {
			case 0: return 31;
			case 1: return 28;
			case 2: return 31;
			case 3: return 30;
			case 4: return 31;
			case 5: return 30;
			case 6: return 31;
			case 7: return 31;
			case 8: return 30;
			case 9: return 31;
			case 10: return 30;
			case 11: return 31;
		}
		return 30;
	}
	
	// Section 07 : 06 Logging
	
	public void log(String text) {
		System.out.println(text);
	}
	
	// Section 07 : 07 Debug Logger
	
	public void debug(String text) {
		if(const_debug) System.out.println(text);
	}
	
	// Section 07 : 08 Buscar Persona por Nombre
	
	public classPersona findPersona(String usuario) {
		int max = Personas.size();
		for(int i = 0; i < max; i = i + 1) {
			classPersona buscar = Personas.get(i);
			if(buscar.nombre.equals(usuario)) return buscar;
		}
		return null;
	}

// ========================================================================================
// Section 08 : Auxiliares
// ========================================================================================

	public void mostrarInfoHabitantes() {
		log("INFO: Mostrando informacion de habitantes.");
		new GUI_InformacionMenu(Personas.size() - 1);
	}
	
	public void mostrarMapaVacunacion() {
		int option;
		do {
			Object[] options = { "Por Vacuna", "Por Region", "Por Edad", "Volver" };
			option = JOptionPane.showOptionDialog(null, "Mapa Vacunacion\n\nOrdenar por:", "Mapa de Vacunacion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
			switch(option) {
				case 0:
				case 1:
				case 2: new GUI_MapaVacunacion(option); break;
			}
		} while(option != 3);
	}
	
	public void begin() {
		while(true) {
			GUI_MenuPrincipal menu = new GUI_MenuPrincipal();
			menu.dialog.setVisible(false);
		}
	}
	
// ========================================================================================
// Section 09 : Main
// ========================================================================================

	public static void main(String[] args) {
		
		Integrador file = new Integrador();
		file.generarCentros();
		file.begin();
		
	}
	
// ========================================================================================
// Final
// ========================================================================================
}
