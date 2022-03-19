/**
 * 
 */
import java.awt.LinearGradientPaint;
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
		long time_initLong;
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
			FileReader r = new FileReader("ListadoProducto.txt");
			BufferedReader br = new BufferedReader(r);
			String line;
			while((line=br.readLine())!=null){
				String[] values = line.split("\\|");
				tienda.inv_add(values[1], values[0]);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("Ha ocurrido una excepcion de tipo IO: "+e);
		}
		
		boolean salir = false;
		while(!salir) {
			int opt =0;
			System.out.println("Ingrese la accion a realizar");
			System.out.println("1. Agregar producto");
			System.out.println("2. Mostrar categoria");
			System.out.println("3. Mostrar carrito");
			System.out.println("4. Mostrar carrito ordenado");
			System.out.println("5. Mostrar inventario");
			System.out.println("6. Mostrar inventario ordenado");
			opt = Integer.parseInt(scan.nextLine());
			switch (opt) {
			case 1:
				System.out.println("------------------------------------------------------------------------");
				System.out.println("Ingrese el nombre del producto:");
				String product = scan.nextLine();
				time_initLong = System.currentTimeMillis();
				tienda.cart_add(product);
				System.out.println(System.currentTimeMillis()-time_initLong+"ms");
				System.out.println("------------------------------------------------------------------------");
				break;
			case 2:
				System.out.println("------------------------------------------------------------------------");
				System.out.println("Ingrese el nombre del producto:");
				product = scan.nextLine();
				time_initLong = System.currentTimeMillis();
				System.out.println("El producto pertenece a: "+tienda.show_category(product));
				System.out.println(System.currentTimeMillis()-time_initLong+"ms");
				System.out.println("------------------------------------------------------------------------");
				break;
			case 3:
				System.out.println("------------------------------------------------------------------------");
				time_initLong = System.currentTimeMillis();
				System.out.println(tienda.show_cart_unsorted());
				System.out.println(System.currentTimeMillis()-time_initLong+"ms");
				System.out.println("------------------------------------------------------------------------");
				break;
			case 4:
				System.out.println("------------------------------------------------------------------------");
				time_initLong = System.currentTimeMillis();
				System.out.println(tienda.show_cart_sorted());
				System.out.println(System.currentTimeMillis()-time_initLong+"ms");
				System.out.println("------------------------------------------------------------------------");
				break;
			case 5:
				System.out.println("------------------------------------------------------------------------");
				time_initLong = System.currentTimeMillis();
				System.out.println(tienda.inv_show());
				System.out.println(System.currentTimeMillis()-time_initLong+"ms");
				System.out.println("------------------------------------------------------------------------");
				break;
			case 6:
				System.out.println("------------------------------------------------------------------------");
				time_initLong = System.currentTimeMillis();
				System.out.println(tienda.inv_show_sorted());
				System.out.println(System.currentTimeMillis()-time_initLong+"ms");
				System.out.println("------------------------------------------------------------------------");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}
			
		}

	}

}
