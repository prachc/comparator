import java.util.ArrayList;


public class Combination {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutation("abcd"));		
		System.out.println(combination("abcd"));
	}
	
	public static ArrayList<String> permutation(String str) { 
		ArrayList<String> list = new ArrayList<String>();
	    permutation("", str, list);
	    return list;
	}

	private static void permutation(String prefix, String str, ArrayList<String> list) {
	    int n = str.length();
	    if (n == 0) 
	    	list.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),list);
	    }
	}
	
	public static ArrayList<String> combination(String str) { 
		ArrayList<String> list = new ArrayList<String>();
	    combination(str.length(), str.toCharArray(),"", list);
	    return list;
	}

	public static void combination(int maxLength, char[] alphabet, String curr, ArrayList<String> list) {
        // If the current string has reached it's maximum length
        if(curr.length() == maxLength) {
        	list.add(curr);

        // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                combination(maxLength,alphabet,curr,list);
                curr = oldCurr;
            }
        }
    }
}
