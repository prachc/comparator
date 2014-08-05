import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main3 {

	/**
	 * @param args
	 */
	public static Map<Map<Integer,Integer>,Integer> data = new HashMap<Map<Integer,Integer>,Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] n_q =sc.nextLine().split(" ");
		int N = Integer.parseInt(n_q[0]);
		int Q = Integer.parseInt(n_q[1]);
		
		if(!validNQ(N,Q))
			System.exit(0);
		
		List<String> cmds = new ArrayList<String>();
		List<String> ans = new ArrayList<String>();
		
		for(int i=0;i<Q;i++){
			String cmd = sc.nextLine();
			cmds.add(cmd);
		}
		
		for(String buff:cmds){
			String[] cmd = buff.split(" ");
			if(cmd[0].equals("make"))
				make(cmd[1],cmd[2],cmd[3]);
			if(cmd[0].equals("check"))
				ans.add(check(cmd[1],cmd[2],cmd[3]));
		}
		
		for(String an:ans){
			System.out.println(an);
		}
	}
	
	public static boolean validNQ(int N, int Q){
		if(!(N>=2&&N<=20))
			return false;
		
		if(!(Q>=1&&Q<=500))
			return false;
		
		return true;
	}
	
	public static void make(String a, String b, String time){
		int A = Integer.parseInt(a);
		int B = Integer.parseInt(b);
		int T = Integer.parseInt(time);
		
		if(A>B){
			Map<Integer,Integer> conn = new HashMap<Integer,Integer>();
			conn.put(A, B);
			data.put(conn, T);
		}else if(A<B){
			Map<Integer,Integer> conn = new HashMap<Integer,Integer>();
			conn.put(B, A);
			data.put(conn, T);
		}
	}
	
	public static String check(String a, String b, String time){
		int A = Integer.parseInt(a);
		int B = Integer.parseInt(b);
		int T = Integer.parseInt(time);
		
		Map<Integer,Integer> conn = new HashMap<Integer,Integer>();
		conn.put(A, B);
		
		if(data.get(conn)==null || T > checkTime(conn)){
			return "NO";
		}
		
		return "YES";
	}
	
	public static int checkTime(Map<Integer,Integer> conn){
		return data.get(conn);
	}
}
