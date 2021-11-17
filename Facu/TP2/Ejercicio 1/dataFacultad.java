/*

Se tienen una clase facultad que tiene como atributos: el nombre de facultad, cantidad de carreras.
Se  pide  crear  además  una  subclase  que  llamaremos  carrera,  que  hereda  de  la clase facultad;
como atributos propios carrera además tiene: plan_vigente, cant_materias, nombre_carrera.
Realizar una  función  que  muestre por  pantalla  los  datos  de  una  carrera especifica (instanciar)
y  el nombre de la facultad al que pertenece.

*/


public class dataFacultad {

	String nombre_facultad;
	int carreras;
	
	public dataFacultad(String nombre, int carreras) {
		this.nombre_facultad = nombre;
		this.carreras = carreras;
	}
	
	public String getNombre() {
		return this.nombre_facultad;
	}
	
	public int getCarrerasCant() {
		return this.carreras;
	}
	
	
	public static class dataCarrera extends dataFacultad {
		int plan_vigente;
		int cant_materias;
		String nombre_carrera;
		
		public dataCarrera(String nombre_facultad, int carreras, String nombre_carrera, int plan_vigente, int cant_materias) {
			super(nombre_facultad, carreras);
			this.nombre_carrera = nombre_carrera;
			this.plan_vigente = plan_vigente;
			this.cant_materias = cant_materias;
		}
		
		public String Carrera_getNombre() {
			return this.nombre_carrera;
		}
		
		public int Carrera_getPlan() {
			return this.plan_vigente;
		}
		
		public int Carrera_getMateriasCant() {
			return this.cant_materias;
		}
		
	}
	
	
	public static void main(String[] args){
		dataFacultad miFacu = new dataFacultad("Universidad del Salvador", 3);
		dataCarrera veterinaria = new dataCarrera(miFacu.getNombre(), miFacu.getCarrerasCant(), "Veterinaria", 301, 40);
		dataCarrera ingInfo = new dataCarrera(miFacu.getNombre(), miFacu.getCarrerasCant(), "Ingenieria Informatica", 302, 41);
		dataCarrera ingInd = new dataCarrera(miFacu.getNombre(), miFacu.getCarrerasCant(), "Ingenieria Industrial", 303, 42);
		
		System.out.println("\nUniversidad: " + miFacu.getNombre() + "\nCantidad de Carreras: " + miFacu.getCarrerasCant() + "\n");
		
		System.out.println("Carrera: " + ingInfo.Carrera_getNombre());
		System.out.println("Plan Vigente: " + ingInfo.Carrera_getPlan());
		System.out.println("Materias: " + ingInfo.Carrera_getMateriasCant() + "\n\n");
		
		System.out.println("Carrera: " + ingInd.Carrera_getNombre());
		System.out.println("Plan Vigente: " + ingInd.Carrera_getPlan());
		System.out.println("Materias: " + ingInd.Carrera_getMateriasCant() + "\n\n");
		
		System.out.println("Carrera: " + veterinaria.Carrera_getNombre());
		System.out.println("Plan Vigente: " + veterinaria.Carrera_getPlan());
		System.out.println("Materias: " + veterinaria.Carrera_getMateriasCant() + "\n\n");
		
		
		
	}
}
