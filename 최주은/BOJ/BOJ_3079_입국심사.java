import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static long min = Long.MAX_VALUE, res;
	public static long[] time;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		time = new long[N];
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
			if(time[i] < min) min = time[i];
		}
		
		long left = 0L;
		long right = min*M;
		
		while(left <= right) {
			long mid = (left + right)/2;
			long ppl = 0L;
			for (int i = 0; i < N; i++) {
				ppl += mid/time[i];
			}
			
			if(ppl < M) left = mid + 1;
			else {
				res = mid;
				right = mid - 1;
			}
		}
		
		System.out.println(res);
	}
}
