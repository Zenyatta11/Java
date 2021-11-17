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

public class ejercicio1 {
    
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

        public String getCarrera() {
            return carrera;
        }
        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        public String getClaveNumerica() {
            return claveNumerica;
        }
        public void setClaveNumerica(String claveNumerica) {
            this.claveNumerica = claveNumerica;
        }

        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmailInstitucional() {
            return emailInstitucional;
        }
        public void setEmailInstitucional(String emailinstitucional) {
            this.emailInstitucional = emailinstitucional;
        }
    }

    public static class classMateria{
        String nombre;
        ArrayList<classMateria> materiasCorrelativas = new ArrayList<classMateria>();

        public classMateria(String nombre){
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
		
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
		
		public void addCorrelativa(classMateria correlativa) {
            this.materiasCorrelativas.add(correlativa);
        }
		
		public String getCorrelativas() {
			String retVal = "";
			int max = materiasCorrelativas.size();
			
			for(int i = 0; i < max; i = i + 1)
				retVal = retVal + materiasCorrelativas.get(i).getNombre() + "\n";
			
			return retVal;
		}
    }

    static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    static ArrayList<classMateria> materias = new ArrayList<classMateria>();

    public static void generarAlumno(){
        boolean seguir = true;
        int opcion;
        Object[] opciones = {"Si", "No"};

        do{
            String nombre = JOptionPane.showInputDialog(null, "Nombre", "Ingreso de alumno", JOptionPane.OK_OPTION);
            String apellido = JOptionPane.showInputDialog(null, "Apellido", "Ingreso de alumno", JOptionPane.OK_OPTION);
            String carrera = JOptionPane.showInputDialog(null, "Carrera", "Ingreso de alumno", JOptionPane.OK_OPTION);
            String claveNumerica = JOptionPane.showInputDialog(null, "Clave numerica", "Ingreso de alumno", JOptionPane.OK_OPTION);
            String user = JOptionPane.showInputDialog(null, "Nombre de usuario", "Ingreso de alumno", JOptionPane.OK_OPTION);
            String password = JOptionPane.showInputDialog(null, "Contraseña", "Ingreso de alumno", JOptionPane.OK_OPTION);
            String emailInstitucional = user + "@usal.edu.ar";

            Alumno alumno = new Alumno(nombre, apellido, carrera, claveNumerica, user, password, emailInstitucional);
            alumnos.add(alumno);

            opcion = JOptionPane.showOptionDialog(null, "Continua ingresando alumnos?", "Ingreso de alumno", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == 0){
                seguir = true;
            } else if (opcion == 1){
                seguir = false;
            }
        } while(seguir);
    }

    public static void alumnosCarrera(){
        String carrera = JOptionPane.showInputDialog(null, "Carrera", "Listado de alumnos", JOptionPane.DEFAULT_OPTION);
        
        if (alumnos.size() == 0){
            JOptionPane.showMessageDialog(null, "No existen alumnos anotados a la materia", "Listado de alumnos", JOptionPane.OK_OPTION);
        }else {
            for (int i=0; i<alumnos.size(); i++){
                if (alumnos.get(i).getCarrera() == carrera){
                    JOptionPane.showMessageDialog(null, alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido(), "Listado de Alumnos", JOptionPane.OK_OPTION);
                }
            }
        }
    }

    public static void materia(){
        String materia = JOptionPane.showInputDialog(null, "Materia", "Listado de materias", JOptionPane.DEFAULT_OPTION);


    }

    public static void infoAlumno(){
        
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