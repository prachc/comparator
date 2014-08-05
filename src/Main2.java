import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		String[] strs = in.split(" ");
		int A = Integer.parseInt(strs[0]);
		int B = Integer.parseInt(strs[1]);
		int X = Integer.parseInt(strs[2]);
		int K = Integer.parseInt(strs[3]);
		int M = Integer.parseInt(strs[4]);
		
		for(int i=0;i<K+4;i++){
			if(i>=K-1)
				System.out.println(X);
			X = calculate(A,B,X,M);
		}
	}
	
	public static int calculate(int a,int b,int x, int m){
		return (a*x+b)%m;
	}

}
