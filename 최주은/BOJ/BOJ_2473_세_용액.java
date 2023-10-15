import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {	
	public static int N;
	public static long sum = Long.MAX_VALUE;
	public static long[] res = new long[3], list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(list);
		
		for(int i = 0; i < N; i++) {
			int left = i + 1;
			int right = N - 1;
			
			while(left < right) {
				long s = list[i] + list[left] + list[right];
				long abs = Math.abs(s);
				
				if(sum > abs) {
					sum = abs;
					res[0] = list[i];
					res[1] = list[left];
					res[2] = list[right];
				}
				
				if(s > 0) right--;
				else if(s < 0) left++;
				else {
					System.out.println(res[0] + " " + res[1] + " " + res[2]);
					return;
				}
			}
		}
		
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
}
