import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static String input;
	public static int res, MAX = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		
		// 0 앞의 숫자가 3 이상이면 해석할 수 없는 암호
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			// 1. 첫 번째 숫자가 0이면 이상한 암호
			if(i == 0 && c == '0') {
				System.out.println('0');
				return;
			}
			
			// 2. 0앞의 숫자가 3 이상이면 해석 X
			if(c == '0') {
				int pre = input.charAt(i-1) - '0';
				if(pre > 2 || pre == 0) {
					System.out.println('0');
					return;
				}
			}
		}
		
//		process(0);
//		System.out.println(res);
		process2();
	}
	
	public static void process2() {
		int[][] dp = new int[input.length()+1][2];
		dp[0][0] = 1;
		dp[1][0] = 1;
		
		for(int i = 2; i <= input.length(); i++) {
			int curr = input.charAt(i-1) - '0';
			int prev = input.charAt(i-2) - '0';
			if(curr == 0) {
				if(prev == 1 || prev == 2) dp[i][1] = (dp[i-2][0] + dp[i-2][1])%MAX;
			}else {
				dp[i][0] = (dp[i-1][0] + dp[i-1][1])%MAX;
				if(prev == 1) dp[i][1] = (dp[i-2][0] + dp[i-2][1])%MAX;
				else if(prev == 2 && curr <= 6) dp[i][1] = (dp[i-2][0] + dp[i-2][1])%MAX;
			}
		}
		
		System.out.println((dp[input.length()][0] + dp[input.length()][1]) % MAX);
	}
	
	// 첫 번째 방법 => 메모리 초과
	public static void process(int idx) {
		if(idx >= input.length()) {
			res = (res+1)%1000000;
			return;
		}
		
		// 숫자가 1개
		int num = input.charAt(idx) - '0';
		if(num != 0) {
			process(idx+1);
		}
		
		// 숫자가 2개
		if(num != 0 && idx+1 < input.length()) {
			num = Integer.parseInt(input.substring(idx, idx+2));
			if(num > 26) return;
			process(idx+2);
		}
	}
}
