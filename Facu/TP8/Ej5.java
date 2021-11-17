import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

public class Ej5 {
    
    public static void main(String[] args) {
        Matcher matcher;
        
        ArrayList<String> Matricula = new ArrayList<String>();
        
        Matricula.add("2345-987654");
        Matricula.add("3682-197358");
        Matricula.add("6372-481572");
        Matricula.add("5575-127384");
        Matricula.add("2345-634");
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[1-5]\\d{3}\\-\\d{6}$");
        
        boolean matchFound;
        
        for(int i=0; i<5;i++){
			matcher = pattern.matcher(Matricula.get(i));
			matchFound = matcher.find();
			if(!matchFound) System.out.println("La Matricula " +(i+1)+ " es erronea.\n");
			else System.out.println("La Matricula " +(i+1)+ " es valida!\n");
        }
    }
}