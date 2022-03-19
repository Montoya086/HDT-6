import java.util.Map;

/**
 * 
 */

/**
 * @author Andres
 *
 */
public class Tienda {
	Map<String, String> inventoryMap;
	Map<String, Integer> cartMap;
	FactoryMap<String, String> fInv= new FactoryMap<String, String>();
	FactoryMap<String, Integer> fCart= new FactoryMap<String, Integer>();
	public Tienda(int nMap) {
		inventoryMap = fInv.instanceMap(nMap);
		cartMap = fCart.instanceMap(nMap);
	}
}
