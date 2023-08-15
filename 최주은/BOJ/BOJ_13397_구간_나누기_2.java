import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, res;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
//		int left = 1;
//		int right = -10000; // 최대 10000
//		
//		st = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//			right = arr[i] > right ? arr[i] : right;
//		}
//		
//		while(left < right) {
//			int mid = right - left;
//			if(divide(mid) < M) {
//				right = mid;
//			}else {
//				left = mid+1;
//			}
//		}
//		
//		System.out.println(right);
		
		int left = 0; // 0부터 시작할 수 있음
		int right = -10000; // 최대 10000
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = arr[i] > right ? arr[i] : right;
		}
		
		while(left < right) {
			int mid = (right + left)/2;
			if(divide(mid) < M) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(right);
	}
	
	public static int divide(int k) {
		int m = 0;
		
		int high = -10000;
		int low = 10000;
		
		for(int i = 0; i < N; i++) {
			high = high < arr[i] ? arr[i] : high;
			low = low < arr[i] ? low : arr[i];
			
			if(high - low > k) {
				high = -10000;
				low = 10000;
				m++;
				i--;
			}
		}
		
		return m;
	}
}
