/*
	10-Se pide crear una estructura tipo Array de 10 posiciones que contenga el objeto pelicula (atributos: nombre, codigo, año, genero, actor y actriz).
	a-Se pide hacer la carga de los objetos y mostrar por pantalla la pelicula/s que se hayan estrenado este año.
	b-Además se pide mostrar el listado ordenado por codigo de mayor a menor.
*/

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;

public class ej10 {
	
	public static class Pelicula implements Comparable<Pelicula>{
		String nombre;
		int codigo;
		int anio;
		String genero;
		String actor;
		String actriz;

		public Pelicula(String nombre, int codigo, int anio, String genero, String actor, String actriz){
			this.nombre = nombre;
			this.codigo = codigo;
			this.anio = anio;
			this.genero = genero;
			this.actor = actor;
			this.actriz = actriz;
		}

		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public int getAnio() {
			return anio;
		}
		public void setAnio(int anio) {
			this.anio = anio;
		}

		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}

		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}

		public String getActriz() {
			return actriz;
		}
		public void setActriz(String actriz) {
			this.actriz = actriz;
		}

		public int compareTo(Pelicula o){
			if (codigo < o.codigo){
				return -1;
			}
			if (codigo > o.codigo){
				return 1;
			}
			return 0; 
		}

	}

	public static void mismoAnioPeliculas(ArrayList<Pelicula> arrayList){
		for(int i=0; i<arrayList.size(); i++){
			if (arrayList.get(i).getAnio() == 2021){
				JOptionPane.showMessageDialog(null, arrayList.get(i).getNombre(), "Peliculas del 2021", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula> ();

		String nombre;
		int codigo;
		int anio;
		String genero;
		String actor;
		String actriz;

		JOptionPane.showMessageDialog(null, "Ingrese a continuacion las 10 peliculas que desee", "Peluclas", JOptionPane.INFORMATION_MESSAGE);
		for(int i=0; i<10; i++){
			nombre = JOptionPane.showInputDialog(null, "Nombre: ");
			codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo de 6 digitos: "));
			anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Anio de salida: "));
			genero = JOptionPane.showInputDialog(null, "Genero: ");
			actor = JOptionPane.showInputDialog(null, "Actor: ");
			actriz = JOptionPane.showInputDialog(null, "Actriz: ");

			Pelicula pelicula = new Pelicula(nombre, codigo, anio, genero, actor, actriz);
			peliculas.add(pelicula);
		}

		mismoAnioPeliculas(peliculas);

		Collections.sort(peliculas, Collections.reverseOrder());
		for (int i=0; i<10; i++){
			System.out.println(peliculas.get(i).getNombre() + "" + peliculas.get(i).getCodigo() + "" + peliculas.get(i).getAnio() + "" + peliculas.get(i).getGenero() + "" + peliculas.get(i).getActor() + "" + peliculas.get(i).getActriz());
		}
	}
}
