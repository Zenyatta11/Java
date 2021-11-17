/*
	Suponemos una clase padre transporte cuyos atributos son: velocidad_promedio, tipo (aéreo, terrestre, lacustre)
	Se tienen además las siguientes subclases: avión, colectivo, tren.
	Cada subclase heredade la clase padre transporte.
	Se pide mostrar por pantalla los datos de cada subclase, usando los atributos heredados y los propios.
	(elegir los propiosde acuerdo a los datos que se quieran mostrar).
	
	Por ejemplo: 
	Tren1: identificador: nro_1(como identificador); 
	velocidad_promedio: 25 kms/h; 
	tipo: terrestre; 
	horario_salida: 11:00hs; cant_pasajeros: 300.
*/



public class dataTransporte {
	enum tipoTransporte{TT_AEREO, TT_TERRESTRE, TT_LACUSTRE}
	float velocidadPromedio;
	static tipoTransporte tipo;
	
	public dataTransporte(float velocidadPromedio, tipoTransporte tipo) {
		this.velocidadPromedio = velocidadPromedio;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		switch(this.tipo) {
			case TT_AEREO: return "Aereo";
			case TT_LACUSTRE: return "Lacustre";
			case TT_TERRESTRE: return "Terrestre";
		}
		return "<invalid>";
	}
	
	public float getVelocidadPromedio() {
		return this.velocidadPromedio;
	}
	
	public static class dataAvion extends dataTransporte{
		int identificador;
		int horarioSalida;
		int cantPasajeros;
		String name;
		
		public dataAvion(int identificador, float velocidadPromedio, int horarioSalida, int cantPasajeros, String name) {
			super(velocidadPromedio, tipoTransporte.TT_AEREO);
			this.identificador = identificador;
			this.horarioSalida = horarioSalida;
			this.cantPasajeros = cantPasajeros;
			this.name = name;
		}
		
		public String getHorarioSalida() {
			return Integer.toString((int)(Math.floor(this.horarioSalida/60))) + ':' + Integer.toString((int)(this.horarioSalida-(Math.floor(this.horarioSalida/60)*60)));
		}
		
		public int getCantPasajeros() {
			return this.cantPasajeros;
		}
		
		public int getIdentificador() {
			return this.identificador;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	public static class dataColectivo extends dataTransporte{
		int identificador;
		int horarioSalida;
		int cantPasajeros;
		String name;
		
		public dataColectivo(int identificador, float velocidadPromedio, int horarioSalida, int cantPasajeros, String name) {
			super(velocidadPromedio, tipoTransporte.TT_TERRESTRE);
			this.identificador = identificador;
			this.horarioSalida = horarioSalida;
			this.cantPasajeros = cantPasajeros;
			this.name = name;
		}
		
		public String getHorarioSalida() {
		return Integer.toString((int)(Math.floor(this.horarioSalida/60))) + ':' + Integer.toString((int)(this.horarioSalida-(Math.floor(this.horarioSalida/60)*60)));
		}
		
		public int getCantPasajeros() {
			return this.cantPasajeros;
		}
		
		public int getIdentificador() {
			return this.identificador;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	public static class dataTren extends dataTransporte{
		int identificador;
		int horarioSalida;
		int cantPasajeros;
		String name;
		
		public dataTren(int identificador, float velocidadPromedio, int horarioSalida, int cantPasajeros, String name) {
			super(velocidadPromedio, tipoTransporte.TT_TERRESTRE);
			this.identificador = identificador;
			this.horarioSalida = horarioSalida;
			this.cantPasajeros = cantPasajeros;
			this.name = name;
		}
		
		public String getHorarioSalida() {
			return Integer.toString((int)(Math.floor(this.horarioSalida/60))) + ':' + Integer.toString((int)(this.horarioSalida-(Math.floor(this.horarioSalida/60)*60)));
		}
		
		public int getCantPasajeros() {
			return this.cantPasajeros;
		}
		
		public int getIdentificador() {
			return this.identificador;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	public static void main(String[] args){
		dataTren Trencito = new dataTren((int)(Math.random()*100), (float)Math.floor(Math.random()*10000)/100,
								(int)(((Math.random()*100) % 23) * 60 + (Math.random() * 100 % 60)), (int)(Math.random() * 1000), "General Roca");
		
		dataColectivo Colectivo = new dataColectivo(60, (float)Math.floor(Math.random()*10000)/100,
								(int)(((Math.random()*100) % 23) * 60 + (Math.random() * 100 % 60)), (int)((Math.random() * 100) % 60), "Linea 60");
		
		dataAvion Concord = new dataAvion((int)(Math.random()*100), (float)2158.13,
								(int)(((Math.random()*100) % 23) * 60 + (Math.random() * 100 % 60)), (int)((Math.random() * 100)%36 + 92), "Concorde");
		
		System.out.println("\nTransporte 1: " + Trencito.getName() + " (" + Trencito.getIdentificador() + ")" +
							"\nTipo: " + Trencito.getTipo() + 
							"\nVelocidad Promedio: " + Trencito.getVelocidadPromedio() +
							"km/h\nCapacitdad: " + Trencito.getCantPasajeros() + 
							"\nHorario de Salida: " + Trencito.getHorarioSalida());
							
		System.out.println("\nTransporte 2: " + Colectivo.getName() + " (" + Colectivo.getIdentificador() + ")" +
							"\nTipo: " + Colectivo.getTipo() + 
							"\nVelocidad Promedio: " + Colectivo.getVelocidadPromedio() +
							"km/h\nCapacitdad: " + Colectivo.getCantPasajeros() + 
							"\nHorario de Salida: " + Colectivo.getHorarioSalida());
							
		System.out.println("\nTransporte 3: " + Concord.getName() + " (" + Concord.getIdentificador() + ")" +
							"\nTipo: " + Concord.getTipo() + 
							"\nVelocidad Promedio: " + Concord.getVelocidadPromedio() +
							"km/h\nCapacitdad: " + Concord.getCantPasajeros() + 
							"\nHorario de Salida: " + Concord.getHorarioSalida());
	}
}