/*
	9-Se tiene un ArrayList que me permite guardar las notas de los alumnos de una comisión.
	La clase alumnos tiene como atributos: 
		nombre, apellido,nota, materia.
	
	a.Se pide hacer una función que me muestre por pantalla en una variable la mayor nota de todas y el nombre de ese alumno.
	b.Además se pide que se saque un promedio con todas las notas.
	c.Mostrar todos los alumnos cuya nota sea menor a la nota promedio que se calculo en el punto b.
*/

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ej9 {
	
	public static class Alumno{
		String nombre;
		String apellido;
		String nota;
		String materia;

		public Alumno(String nombre, String apellido, String nota, String materia){
			this.nombre = nombre;
			this.apellido = apellido;
			this.nota = nota;
			this.materia = materia;
		}

		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getNota() {
			return nota;
		}
		public void setNota(String nota) {
			this.nota = nota;
		}

		public String getMateria() {
			return materia;
		}
		public void setMateria(String materia) {
			this.materia = materia;
		}   
	}

	static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

	public static void alumnoMayorNota(ArrayList<Alumno> arrayList){
		int mayor = 0;
		int nota;

		for(int i=0; i<arrayList.size(); i++){
			nota = Integer.parseInt(arrayList.get(i).getNota());
			if (nota > mayor){
				mayor = nota;
			}
		}

		for(int i=0; i<arrayList.size(); i++){
			nota = Integer.parseInt(arrayList.get(i).getNota());
			if (nota == mayor){
				JOptionPane.showMessageDialog(null, "Alumno con nota mas alta\n" + alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido(), "Notas", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static double promedio(ArrayList<Alumno> arrayList){
		double promedio = 0;
		int nota;

		for(int i=0; i<arrayList.size(); i++){
			nota = Integer.parseInt(arrayList.get(i).getNota());
			promedio = nota + promedio;
		}

		promedio = promedio / arrayList.size();

		return promedio;
	}

	public static void notaMenorAPromedio(ArrayList<Alumno> arrayList, double promedio){
		for(int i=0; i<arrayList.size(); i++){
			Integer nota = Integer.parseInt(arrayList.get(i).getNota());
			if (nota < promedio){
				JOptionPane.showMessageDialog(null, "Alumno con nota mas baja que el promedio\n" + alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido(), "Notas", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		boolean seguir = true;
		String nombre;
		String apellido;
		String nota;
		String materia;
		double promedio;
		Object[] opciones = {"Si", "No"};
		
		JOptionPane.showMessageDialog(null, "A continuacion ingrese los datos de los alumnos", "Alumnado", JOptionPane.INFORMATION_MESSAGE);

		do{
			nombre = JOptionPane.showInputDialog(null, "Nombre");
			apellido = JOptionPane.showInputDialog(null, "Apellido");
			nota = JOptionPane.showInputDialog(null, "Nota");
			Integer.parseInt(nota);
			materia = JOptionPane.showInputDialog(null, "Materia");

			Alumno alumno = new Alumno(nombre, apellido, nota, materia);
			alumnos.add(alumno);
			
			int opcion = JOptionPane.showOptionDialog(null, "Continua ingresando alumnos?", "Ingreso de alumno", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

			if (opcion == 0){
				seguir = true;
			} else if (opcion == 1){
				seguir = false;
			}
		} while(seguir);

		alumnoMayorNota(alumnos);

		promedio = promedio(alumnos);
		JOptionPane.showMessageDialog(null, "Promedio de la notas: " + promedio, "Promedio", JOptionPane.INFORMATION_MESSAGE);

		notaMenorAPromedio(alumnos, promedio);
	}
}
