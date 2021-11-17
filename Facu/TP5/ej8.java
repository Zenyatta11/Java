/*
	8-Dada una clase que llamaremos transporte cuyos atributos son tipo (aéreo, terrestre, la-custre), capacidad_pasajeroscon sus respectivos métodos.
	Además tendremos dos sub-clases que llamaremos
	Auto: cuyos atributos son:
		velocidad_limite,
		característica (String): Sedan o deportivo

	y la otra subclase es avión: cuyos atributos son: 
		descripción (String): por ejemplo Boing, jet.
	
	a.Se pide que se muestre por pantalla al menos un objeto de cada subclase con los atributos solicitados.
*/

import javax.swing.JOptionPane;

public class ej8 {
	
	public static abstract class Transportes{
		String tipo;
		int capacidadPasajeros;
		
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public int getCapacidadPasajeros() {
			return capacidadPasajeros;
		}
		public void setCapacidadPasajeros(int capacidadPasajeros) {
			this.capacidadPasajeros = capacidadPasajeros;
		}
	}

	public static class Auto extends Transportes{
		int velocidadLimite;
		String caracteristica;

		public Auto(String tipo, int capacidadPasajeros, int velocidadLimite, String caracteristica){
			super.tipo = tipo;
			super.capacidadPasajeros = capacidadPasajeros;
			this.velocidadLimite = velocidadLimite;
			this.caracteristica = caracteristica;
		}

		public int getVelocidadLimite() {
			return velocidadLimite;
		}
		public void setVelocidadLimite(int velocidadLimite) {
			this.velocidadLimite = velocidadLimite;
		}

		public String getCaracteristica() {
			return caracteristica;
		}
		public void setCaracteristica(String caracteristica) {
			this.caracteristica = caracteristica;
		}
	}

	public static class Avion extends Transportes{
		String descripcion;

		public Avion(String tipo, int capacidadPasajeros, String descripcion){
			super.tipo = tipo;
			super.capacidadPasajeros = capacidadPasajeros;
			this.descripcion = descripcion;
		}

		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	}

	public static void main(String[] args) {
		Avion avion = new Avion("Aereo", 300, "Boing");
		Auto auto = new Auto("Terrestres", 4, 200, "Mini Cooper");

		JOptionPane.showMessageDialog(null, "Tipo de transporte: " + avion.getTipo() + "\nCapacidad de pasajeros: " + avion.getCapacidadPasajeros() + "\nDescripcion: " + avion.getDescripcion(), "Avion y sus caracteristicas", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Tipo de transporte: " + auto.getTipo() + "\nCapacidad de pajaeros: " + auto.getCapacidadPasajeros() + "\nCaracteristica: " + auto.getCaracteristica() + "\nVelocidad limite: " + auto.getVelocidadLimite(), "Auto y sus caracteristicas", JOptionPane.INFORMATION_MESSAGE);
	}
}
