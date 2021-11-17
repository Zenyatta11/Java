
public class dataAnimal{
	
	String nombre, diagnostico, observaciones, tratamiento;
	int edad;
	float peso;
	
	public dataAnimal(String nombre, String diagnostico, String observaciones, String tratamiento, int edad, float peso) {
		this.nombre = nombre;
		this.diagnostico = diagnostico;
		this.observaciones = observaciones;
		this.tratamiento = tratamiento;
		this.edad = edad;
		this.peso = peso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDiagnostico() {
		return this.diagnostico;
	}
	
	public String getObservaciones() {
		return this.observaciones;
	}
	
	public String getTratamiento() {
		return this.tratamiento;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public float getPeso() {
		return this.peso;
	}
	
	public static class dataPerro extends dataAnimal {
		String raza;
		
		public dataPerro(String nombre, String diagnostico, String observaciones, String tratamiento, int edad, float peso, String raza) {
			super(nombre, diagnostico, observaciones, tratamiento, edad, peso);
			this.raza = raza;
		}
		
		public String getRaza() {
			return this.raza;
		}
	}
	
	public static class dataGato extends dataAnimal {
		String raza;
		String antedecentes;
		
		public dataGato(String nombre, String diagnostico, String observaciones, String tratamiento, int edad, float peso, String raza, String antecedentes) {
			super(nombre, diagnostico, observaciones, tratamiento, edad, peso);
			this.raza = raza;
			this.antedecentes = antecedentes;
		}
		
		public String getRaza() {
			return this.raza;
		}
		
		public String getAntedecentes() {
			return this.antedecentes;
		}
	}
	
	public static void main(String[] args){
		
		dataPerro perrito = new dataPerro("Fatiga", "Sobredosis de Bizcochitos", "El mejor perrito de toda la tele, muy lindos anteojos de sol", "Prohibicion de comer bizcochitos", (int)(Math.floor((Math.random()*100) % 10 + 1)), (float)(Math.floor((Math.random()*100) % 30 + 5)), "Mestizo");
		dataGato gatito = new dataGato("Garfield", "Sobrepeso", "Muy vago, odia los lunes porque quiere mucho a John (no trabaja el)", "Prohibicion de comer lasania como dieta comun", (int)(Math.floor((Math.random()*100) % 10 + 1)), (float)(Math.floor((Math.random()*100) + 60)), "Naranja", "Obsesion con la lasania");
		
		Class<?> classPerrito = perrito.getClass();
		Class<?> classgatito = gatito.getClass();
		
		System.out.println("\nPaciente: " + perrito.getNombre() + 
							"\nTipo: " + (perrito.getClass() == classPerrito ? "Canino" : "Felino") + 
							"\nRaza: " + perrito.getRaza() + 
							"\nDiagnostico: " + perrito.getDiagnostico() + 
							"\nObservaciones: " + perrito.getObservaciones() + 
							"\nTratamiento: " + perrito.getTratamiento() + 
							"\nEdad: " + perrito.getEdad() + " anios" + 
							"\nPeso: " + Math.floor(perrito.getPeso() * 100)/100 + "kg" +
							"\n");
		
		System.out.println("\nPaciente: " + gatito.getNombre() + 
							"\nTipo: " + (gatito.getClass() == classPerrito ? "Canino" : "Felino") + 
							"\nRaza: " + gatito.getRaza() + 
							"\nAntecedentes: " + gatito.getAntedecentes() +
							"\nDiagnostico: " + gatito.getDiagnostico() + 
							"\nObservaciones: " + gatito.getObservaciones() + 
							"\nTratamiento: " + gatito.getTratamiento() + 
							"\nEdad: " + gatito.getEdad() + " anios" + 
							"\nPeso: " + Math.floor(gatito.getPeso() * 100)/100 + "kg" +
							"\n");
		
	}
}