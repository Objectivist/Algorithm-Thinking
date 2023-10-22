import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static String num;
	public static int limit;
	public static HashSet<String> hs = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = br.readLine();
		limit = num.length() * (num.length()+1) / 2;
		
		for(int i = 0; i < num.length(); i++) {
			dfs(i, i, "" + num.charAt(i));
		}
		
		System.out.println(hs.size());
	}
	
	public static void dfs(int left, int right, String sNum) {
		if(sNum.length() == limit) {
			hs.add(sNum);
			return;
		}
		
		if(left > 0) dfs(left-1, right, sNum+num.substring(left-1, right+1));
		if(right < num.length()-1) dfs(left, right+1, sNum+num.substring(left, right+2));
	}
}
