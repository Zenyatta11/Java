import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {        
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^\\w*\\@batatas\\.club{1}$");
        
        Matcher matcher;
        boolean matchFound;

        do {
            System.out.print("Ingrese su e-mail: ");
            matcher = pattern.matcher(scan.nextLine());
            matchFound = matcher.find();
        
        if(!matchFound) System.out.println("El numero ingresado es erroneo.\n");
        } while(!matchFound);
    
		if(matchFound){
			System.out.print("E-mail valido");
		}
    }
}