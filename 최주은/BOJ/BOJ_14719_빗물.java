import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int H, W, res;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		st = new StringTokenizer(br.readLine(), " ");
		int j = -1;
		while(st.hasMoreTokens()){
			int cnt = Integer.parseInt(st.nextToken());
			j++;
			
			for(int i = H-1; i >= 0; i--) {
				if(cnt > 0) {
					map[i][j] = 1;
					cnt--;
				}else map[i][j] = 2;
			}
		}
		
		// 물빼기
		for(int i = 0; i < H; i++) {
			// 왼쪽
			if(map[i][0] == 0 || map[i][0] == 2) {
				int k = 0;
				while(true) {
					if(k >= W || map[i][k] == 1) break;
					map[i][k] = 0;
					k++;
				}
			}
			
			// 오른쪽
			if(map[i][W-1] == 0 || map[i][W-1] == 2) {
				int k = W-1;
				while(true) {
					if(k < 0 || map[i][k] == 1) break;
					map[i][k] = 0;
					k--;
				}
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int k = 0; k < W; k++) {
				if(map[i][k] == 2) res++;
			}
		}
		
		System.out.println(res);
	}
}
