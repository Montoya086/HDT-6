/**
 * 
 */
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author Andres
 *
 */
public class FactoryMap <K, V>{
	public Map<K, V> instanceMap (int type){
		Map<K, V> map=null;
		if(type==1) {
			map=new HashMap<K, V>();
		}else if(type ==2) {
			map=new LinkedHashMap<K, V>();
		}else {
			map=new TreeMap<K, V>();
		}
		return map;
	}
}
