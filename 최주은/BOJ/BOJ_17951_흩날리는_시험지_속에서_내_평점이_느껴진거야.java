import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, K, res;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		int left = 0; // 0부터 시작할 수 있음
		int right = N * 20;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(left < right) {
			int mid = (right + left)/2;
			if(divide(mid) < K) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(left);
	}
	
	public static int divide(int k) {
		int m = 0;
		int scores = 0;
		
		for(int i = 0; i < N; i++) {
			scores += arr[i];			
			if(scores > k) {
				scores = 0;
				m++;
			}
		}
		
		return m;
	}
}
