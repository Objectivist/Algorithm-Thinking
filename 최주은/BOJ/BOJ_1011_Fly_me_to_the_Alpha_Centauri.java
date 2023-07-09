package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static int T;
	public static long GOAL;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			GOAL = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
			long cnt = 0;
			long idx = 1;
			long res = 0;
			while(cnt < GOAL) {
				boolean tri = false;
				for(int j = 1; j <= 2; j++) {
					cnt += idx;
					res++;
					if(cnt >= GOAL) {
						tri = true;
						break;
					}
				}
				
				if(!tri) idx++;
			}
			System.out.println(res);
		}
	}
}
