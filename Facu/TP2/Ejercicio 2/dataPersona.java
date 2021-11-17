/*
	Usando Super y extend se pide que dada una clase persona cuyos atributos son Nombre, apellido y profesión, edad,
	usando un constructor se reciban esos atributos por argumento. Se tiene a su vez dos clases tenista y polista 
	que heredan de Persona los atributos y los métodos. Se pide que se instancie cada una de las clases de tenista 
	y de polista, se muestren sus datos por pantalla usando una función Main().
*/

public class dataPersona {

	String nombre;
	String apellido;
	String profesion;
	int edad;
	
	public dataPersona(String nombre, String apellido, String profesion, int edad) {
		this.nombre = nombre;
		this.profesion = profesion;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getProfesion() {
		return this.profesion;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public static class dataTenista extends dataPersona {
		
		public dataTenista(String nombre, String apellido, String profesion, int edad) {
			super(nombre, apellido, profesion, edad);
		}
		
	}
	
	public static class dataPolista extends dataPersona {
		
		public dataPolista(String nombre, String apellido, String profesion, int edad) {
			super(nombre, apellido, profesion, edad);
		}
		
	}
	
	public static void main(String[] args){
		dataTenista tenista = new dataTenista("Daniil", "Medvedev", "Agente del KGB", (int)(Math.floor((Math.random()*100) % 40 + 12)));
		dataPolista polista = new dataPolista("Harold Ernest", "Brassey", "Guardia Real", (int)(Math.floor((Math.random()*100) % 40 + 12)));
		
		System.out.println("\nTenista: " + tenista.getNombre() + ' ' + tenista.getApellido() + "\nProfesion: " + tenista.getProfesion() + "\nEdad: " + tenista.getEdad() + " años\n");
		System.out.println("\nPolista: " + polista.getNombre() + ' ' + polista.getApellido() + "\nProfesion: " + polista.getProfesion() + "\nEdad: " + polista.getEdad() + " años\n");
		
	}
}