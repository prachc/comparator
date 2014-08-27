import java.util.LinkedHashMap;
import java.util.Map.Entry;
 
public class LRUCache < K, V > extends LinkedHashMap < K, V > {
	private static final long serialVersionUID = 1L;
	private int capacity; 
     
    public LRUCache(int capacity) { 
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Entry<K,V> entry) {
        return (size() > this.capacity);
    } 
    
    public static <K,V> LRUCache<K,V> newInstance(int size){
    	return new LRUCache<K,V>(size);
    }
    
    public static void main(String[] args) {
		LRUCache<String,String> lrunCache = LRUCache.newInstance(2);
		lrunCache.put("1", "1");
		System.out.println(lrunCache);
		lrunCache.put("2", "2");
		System.out.println(lrunCache);
		lrunCache.put("3", "3");
		System.out.println(lrunCache);
		lrunCache.put("4", "4");
		System.out.println(lrunCache);
	}
}