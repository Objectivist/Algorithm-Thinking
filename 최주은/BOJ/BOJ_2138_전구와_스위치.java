import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	public static int N, res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean[] numB = new boolean[N];
		boolean[] numA = new boolean[N];
		boolean[] goal = new boolean[N];
		
		StringBuilder sbN = new StringBuilder(br.readLine());
		StringBuilder sbG = new StringBuilder(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numA[i] = sbN.charAt(i) != '0';
			numB[i] = sbN.charAt(i) != '0';
			goal[i] = sbG.charAt(i) != '0';
		}
		
		// 0번 스위치가 눌렸을 때
		
		int cnt = 1;
		swap(0, numA);
		for(int i = 1; i < N; i++) {
			if(numA[i-1] != goal[i-1]) {
				numA = swap(i, numA);
				cnt++;
			}
		}
		
		if(numA[N-1] == goal[N-1]) res = Math.min(cnt, res);
		
		// 0번 스위치가 안 눌렸을 때
		numB = numB.clone();
		cnt = 0;
		
		for(int i = 1; i < N; i++) {
			if(numB[i-1] != goal[i-1]) {
				numB = swap(i, numB);
				cnt++;
			}
		}
		
		if(numB[N-1] == goal[N-1]) res = Math.min(cnt, res);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	
	public static boolean[] swap(int idx, boolean[] arr) {
		for (int i = idx-1; i <= idx+1; i++) {
			if(i < 0 || i >= N) continue;
			arr[i] = !arr[i];
		}
		
		return arr;
	}
}
