import java.util.HashMap;


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
}
