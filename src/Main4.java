import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		System.out.println(encodeHex("abcd"));
		
		TreeSet<String> a = new TreeSet<String>();
		TreeSet<String> b = new TreeSet<String>();
		TreeSet<String> c = new TreeSet<String>();
		
		/*
		a.add(encodeHex("java"));
		a.add(encodeHex("web"));
		a.add(encodeHex("api"));
		
		b.add(encodeHex("ruby"));
		b.add(encodeHex("web"));
		b.add(encodeHex("api"));
		
		c.add(encodeHex("web"));
		c.add(encodeHex("data"));
		c.add(encodeHex("search"));
		*/
		
		a.add("java");
		a.add("web");
		a.add("api");
		
		b.add("ruby");
		b.add("web");
		b.add("api");
		
		c.add("web");
		c.add("data");
		c.add("search");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		List<String> list = new ArrayList<String>();
		list.addAll(a);
		System.out.println(encodeHex(join(list)));
		//System.out.println(checkSimilarity(a,b));
		//System.out.println(checkSimilarity(b,c));
		//System.out.println(checkSimilarity(a,c));
		
		HashMap<HashPair,Double> pattPoint = new HashMap<HashPair,Double>();
		HashPair pairA = new HashPair(new BigInteger("111"),new BigInteger("222"));
		HashPair pairB = new HashPair(new BigInteger("222"),new BigInteger("333"));
		HashPair pairC = new HashPair(new BigInteger("333"),new BigInteger("444"));
		pattPoint.put(pairA, 60.0);
		pattPoint.put(pairB, 70.0);
		pattPoint.put(pairC, 50.0);
		System.out.println(pattPoint.get(pairA));
		System.out.println(pattPoint.get(pairB));
		System.out.println(pattPoint.get(pairC));
		
		ValueComparator bvc =  new ValueComparator(pattPoint);
        TreeMap<HashPair,Double> sorted_map = new TreeMap<HashPair,Double>(bvc);
        sorted_map.putAll(pattPoint);
        System.out.println("results: "+sorted_map);
	}

	
	public static BigInteger encodeHex(String a) throws NoSuchAlgorithmException{
		final MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(a.getBytes());
		byte[] digest = m.digest();
		return new BigInteger(1,digest);
	}
	
	public static double checkSimilarity(TreeSet<BigInteger> a, TreeSet<BigInteger> b){
		TreeSet<BigInteger> one = (TreeSet<BigInteger>) a.clone();
		one.retainAll(b);
		
		System.out.println("one="+one+"/"+one.size());
		double asize = (double) a.size();
		double onesize = (double) one.size();
		return (onesize/asize)*100.0;
	}
	
	public static String join(List<String> strs){
		StringBuffer b = new StringBuffer();
		
		for(String str:strs)
			b.append(str);
		
		return b.toString();
	}
	
}

class HashPair{
	BigInteger pattA;
	BigInteger pattB;
	
	public HashPair(BigInteger A, BigInteger B){
		this.pattA = A;
		this.pattB = B;
	}	
}

class ValueComparator implements Comparator<HashPair> {

    Map<HashPair, Double> base;
    public ValueComparator(Map<HashPair, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(HashPair a, HashPair b) {
        if (base.get(b) >= base.get(a)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
