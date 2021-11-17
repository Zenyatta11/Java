/*
Dada una Universidad, que consta de varias facultades, 
se pide lo siguiente:
	Dada una facultad, me permita realizar la 
	inscripción de una persona (alumno) a una carrera 
	dada, generando de esa manera, una clave 
	única(matricula), un usuario y una password. 
	Además se le deberá asignar un email institucional. 
	Dicho usuario y clave podrán ser usados para acceder 
	a la plataforma virtual de la Universidad.
	Se pide que genere un menú por consola o usando 
	JOptionPane.
	Me permita por carrera, ver la cantidad de alumnos 
	inscriptos por turno. Ver listado Ordenado.
	Limite alumnos: 50
	Tener una función que por materia 
	(de una facultad dada):
		o Permita ver las materias correlativas de la misma, 
		que condiciones especiales se pueden presentar 
		para cursar dicha asignatura.
	Tener una función que me permita ver por alumno:
		o Las materias a las que está inscripto.
		o Cuál es su plan de carrera (año) y que liste el 
		mismo (plan de materias por carrera).
*/

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class TrabajoPractico6 {
	
	public static class Alumno {
		String nombre;
		String apellido;
		String carrera;
		String claveNumerica;
		String user;
		String password;
		String emailInstitucional;

		public Alumno(String nombre, String apellido, String carrera, String claveNumerica, String user, String password, String emailInstitucional){
			this.nombre = nombre;
			this.apellido = apellido;
			this.carrera = carrera;
			this.claveNumerica = claveNumerica;
			this.user = user;
			this.password = password;
			this.emailInstitucional = emailInstitucional;
		}

	}

	static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

	public static void generarAlumno(){
		boolean seguir = true;
		int opcion;
		Object[] opciones = {"Si", "No"};

		do{
			String nombre = JOptionPane.showInputDialog(null, "Nombre", "Ingreso de alumno", JOptionPane.QUESTION_MESSAGE);
			
			String apellido = JOptionPane.showInputDialog(null, "Apellido", "Ingreso de alumno", JOptionPane.QUESTION_MESSAGE);
			
			Object[] opciones2 = {"Veterinaria", "Ingenieria Informatica"};
			
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una carrera", "Inscripcion de Alumno", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);
			
			String claveNumerica = JOptionPane.showInputDialog(null, "Clave numerica", "Ingreso de alumno", JOptionPane.QUESTION_MESSAGE);
			
			String user = JOptionPane.showInputDialog(null, "Nombre de usuario", "Ingreso de alumno", JOptionPane.QUESTION_MESSAGE);
			
			String password = JOptionPane.showInputDialog(null, "Contraseña", "Ingreso de alumno", JOptionPane.QUESTION_MESSAGE);
			
			String emailInstitucional = user + "@usal.edu.ar";
			
			
			String carrera = "";
			switch(opcion){
				case 0: carrera = "Veterinaria"; break;
				case 1: carrera = "Ingenieria Informatica"; break;
			}
			
			Alumno alumno = new Alumno(nombre, apellido, carrera, claveNumerica, user, password, emailInstitucional);
			alumnos.add(alumno);

			opcion = JOptionPane.showOptionDialog(null, "Continua ingresando alumnos?", "Ingreso de alumno", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		} while(opcion == 0);
		
	}

	public static void alumnosCarrera(){
		Object[] opciones = {"Veterinaria", "Ingenieria Informatica"};
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione una carrera", "Alumnos por Carrera", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		String query = "";
		switch(opcion){
			case 0: query = "Veterinaria"; break;
			case 1: query = "Ingenieria Informatica"; break;
		}
		
		if (alumnos.size() == 0){
			JOptionPane.showMessageDialog(null, "No existen alumnos anotados a la materia", "Listado de alumnos", JOptionPane.QUESTION_MESSAGE);
		}else {
			String showVal = "";
			for (int i=0; i<alumnos.size(); i++){
				if (alumnos.get(i).carrera.equals(query)){
					showVal = showVal + alumnos.get(i).nombre + " " + alumnos.get(i).apellido + "\n";
				}
			}
			JOptionPane.showMessageDialog(null, showVal, "Listado de Alumnos", JOptionPane.QUESTION_MESSAGE);
		}
	}
	
	public static ArrayList<String> getAlumnos() {
		int max = alumnos.size();
		ArrayList<String> retVal = new ArrayList<String>();
		
		for(int i = 0; i < max; i = i + 1) {
			retVal.add(alumnos.get(i).nombre);
		}
		
		return retVal;
	}
	
	public static void materia(){
		Object[] opciones = {"Veterinaria", "Ingenieria Informatica"};
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione una carrera", "Alumnos por Carrera", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		String query = "";
		
		switch(opcion){
			case 0: JOptionPane.showMessageDialog(null, "Anatomia Animal - Sin Correlativa\nHistologia - Sin Correlativa\n\nFisiologia Animal - Requiere Anatomia\nParasitologia - Requiere Histologia\n\nCirugia - Requiere Fisiologia e y Parasitologia", "Materias Veterinaria", JOptionPane.QUESTION_MESSAGE); break;
			case 1: JOptionPane.showMessageDialog(null, "Programacion - Sin Correlativa\nParadigmas - Sin Correlativa\n\nProgramacion II - Requiere Programacion\nBases de Datos - Requiere Programacion y Paradigmas\n\n", "Materias Ingenieria Informatica", JOptionPane.QUESTION_MESSAGE); break;
		}
		
	}

	public static void infoAlumno(){
		Object[] opciones = getAlumnos().toArray();
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione un alumno", "Informacion de Alumnos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		String query = "";
		
		Alumno elAl = alumnos.get(opcion);
		JOptionPane.showMessageDialog(null, "" + elAl.nombre + " " + elAl.apellido + "\n\nCursa: " + elAl.carrera + "\nNombre de Usuario: " + elAl.user + "\nEmail: " + elAl.emailInstitucional, "Materias Veterinaria", JOptionPane.QUESTION_MESSAGE);
	}

	public static void main(String[] args) {
		int opcion;
		
		do{
			Object[] opciones = {"Generar Alumno", "Alumnos por carrera", "Materia", "Ver alumno", "Salir"};
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menu de la Universidad", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			switch(opcion){
				case 0: generarAlumno(); break;
				case 1: alumnosCarrera(); break;
				case 2: materia(); break;
				case 3: infoAlumno(); break;
			}
		}while(opcion != 4);
	}
}