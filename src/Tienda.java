import java.util.Map;
/**
 * 
 */

/**
 * @author Andres Montoya
 *
 */
public class Tienda {
	Map<String, String> inventoryMap;
	Map<String, Integer> cartMap;
	FactoryMap<String, String> fInv= new FactoryMap<String, String>();
	FactoryMap<String, Integer> fCart= new FactoryMap<String, Integer>();
	int nmap;
	/**
	 * 
	 * @param nMap
	 */
	public Tienda(int nMap) {
		inventoryMap = fInv.instanceMap(nMap);
		cartMap = fCart.instanceMap(nMap);
		nmap = nMap;
	}
	public void inv_add(String product, String category) {
		inventoryMap.put(product, category);
	}
	public void cart_add(String product) {
		if (inventoryMap.containsKey(product)) {
			boolean existscart=false;
			for(String i: cartMap.keySet()) {
				if(i.equals(product)) {
					existscart=true;
				}
			}
			if(existscart) {
				int temp = cartMap.get(product);
				cartMap.replace(product, temp+1);
			}else {
				cartMap.put(product, 1);
			}
			System.out.println("Producto agregado al carrito");
		}else {
			System.out.println("El producto no existe");
		}
		
	}
	public String inv_show() {
		String invString ="";
		for(String i: inventoryMap.keySet()) {
			invString+=inventoryMap.get(i)+"    "+i+"\n";
		}
		return invString;
	}
	public String show_category(String product) {
		return inventoryMap.get(product);
	}
	public String show_cart_unsorted() {
		String cart_itemString="";
		for(String i: inventoryMap.keySet()) {
			if(cartMap.containsKey(i)) {
				cart_itemString+="Categoria: "+inventoryMap.get(i)+"  Producto: "+i+"  Cantidad: "+ cartMap.get(i)+"\n";
			}
		}
		return cart_itemString;
	}
	public String show_cart_sorted() {
		String cart_itemString="";
		Map<String, String> inventoryMap_sorted =fInv.instanceMap(2);
		inventoryMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> inventoryMap_sorted.put(x.getKey(), x.getValue()));
		for(String i: inventoryMap_sorted.keySet()) {
			if(cartMap.containsKey(i)) {
				cart_itemString+="Categoria: "+inventoryMap.get(i)+"  Producto: "+i+"  Cantidad: "+ cartMap.get(i)+"\n";
			}
		}
		return cart_itemString;
	}
	public String inv_show_sorted() {
		String invString ="";
		Map<String, String> inventoryMap_sorted =fInv.instanceMap(2);
		inventoryMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> inventoryMap_sorted.put(x.getKey(), x.getValue()));
		for(String i: inventoryMap_sorted.keySet()) {
			invString+=inventoryMap_sorted.get(i)+"    "+i+"\n";
		}
		return invString;
	}
}
