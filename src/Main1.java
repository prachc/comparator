import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main1 {

	public static void main(String[] args) {
	}
	
	public int multiply (int a,int b){
		return a*b;
	}
	
	public String orderByOccurrance(String input){
		if(input==null) 
			return null;
		
		HashMap<Character,Integer> data = new HashMap<Character,Integer>();
		
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
			Integer v = data.get(c);
			if(data.get(c)==null)
				data.put(c, 1);
			else
				data.put(c, ++v);	
		}
		
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(data.entrySet());
		Collections.sort(list, new ValueThenKeyComparator<Character, Integer>());
		
		StringBuffer buff = new StringBuffer();
		
		for(Map.Entry<Character, Integer> elem:list){
			buff.append(elem.getKey());
		}
		
		return buff.toString();
	}

}

class ValueThenKeyComparator<K extends Comparable<? super K>,V extends Comparable<? super V>> implements Comparator<Map.Entry<K, V>> {

	public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
		int cmp1 = b.getValue().compareTo(a.getValue());
		if (cmp1 != 0) {
			return cmp1;
		} else {
			return a.getKey().compareTo(b.getKey());
		}
	}

}
