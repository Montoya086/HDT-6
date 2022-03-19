/**
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author Andres
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nMap =1;
		Scanner scan = new Scanner(System.in);
		boolean bandera1 = true;
		while(bandera1) {
			System.out.println("Ingrese el tipo de mapa a utilizar:");
			System.out.println("1. HashMap");
			System.out.println("2. LinkedHashMap");
			System.out.println("3. TreeMap");
			nMap = Integer.parseInt(scan.nextLine());
			if (nMap==1 || nMap == 2 || nMap == 3) {
				bandera1 = false;
			}
		}
		Tienda tienda = new Tienda(nMap);
		try {
			FileReader r = new FileReader("datos.txt");
			BufferedReader br = new BufferedReader(r);
			String line;
			while((line=br.readLine())!=null){
				
			}
			br.close();
		}catch(IOException e) {
			System.out.println("Ha ocurrido una excepcion de tipo IO: "+e);
		}

	}

}
