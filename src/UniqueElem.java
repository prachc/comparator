import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class UniqueElem {
	public static void main(String[] args) {
		int B[] = {1,1,1,3,3,3,20,4,4,4}; 
		int ones = 0 ; 
		int twos = 0 ; 
		int not_threes, z ; 

		for( int i=0; i< B.length; i++ ) { 
			z = B[i]; 
			twos |= ones & z ; 
			ones ^= z ; 
			not_threes = ~(ones & twos) ; 
			ones &= not_threes ; 
			twos &= not_threes ; 
		} 

		System.out.println("unique element ="+ones+" \n"); 

		Integer[] a = {1,2,3,4,0,1,5,2,1};
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int x : a)
		{
			if (map.containsKey(x))  map.put(x,map.get(x)+1);
			else map.put(x,1);
		}
		Integer [] keys = map.keySet().toArray(new Integer[map.size()]);
		for(int x : keys)
		{
			if(map.get(x)!=1){
				System.out.println(x+" repeats : "+map.get(x));
			}else{
				System.out.println(x+" unique");
			}
		}
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println("binarySearch index "+binarySearch(arr,7));
		//randInts();
		ArrayList<Integer> list = asList(arr);
		Collections.shuffle(list);
		System.out.println(list);
		
	}
	
	public static ArrayList<Integer> asList(int[] array){
		ArrayList<Integer> list = new ArrayList<Integer>(array.length);
		for (int i = 0; i < array.length; i++)
			list.add(Integer.valueOf(array[i]));
		return list;
    }

	public static int binarySearch(int[] arr, int v){
		int low = 0;
		int high = arr[arr.length-1];
		while (low <= high) 
		{
			int mid = (low + high) / 2;
			if (arr[mid] > v)
				high = mid - 1;
			else if (arr[mid] < v)
				low = mid + 1;
			else
				return mid; // found
		}
		return -1;

	}
	
	public static Set<Integer> pickRandom(int n, int k) {
	    Random random = new Random(); // if this method is used often, perhaps define random at class level
	    Set<Integer> picked = new HashSet<Integer>();
	    while(picked.size() < n) {
	        picked.add(random.nextInt(k + 1));
	    }
	    return picked;
	}
	
	public static boolean checkPermutation(String str1,String str2){
		if(str1.length() != str2.length())
			return false;

		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		int len = a.length;

		for(int i = 0; i < len; i++)
			if(b[i] != a[i])
				return false;

		return true;
	}
}
