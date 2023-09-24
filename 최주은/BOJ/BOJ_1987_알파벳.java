import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int R, C, res;
	public static char[][] map;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0, 0, -1, 1};
	public static boolean[] visited = new boolean[30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for(int j =0; j < C; j++) {
				map[i][j] = sb.charAt(j);
			}
		}
		
		visited[map[0][0] - 'A'] = true;
		run(0, 0, 1);
		System.out.println(res);
	}
	
	public static void run(int x, int y, int c) {
		res = res < c ? c : res;
		
		for(int i = 0; i < 4; i++) {
			int yy = y + dy[i];
			int xx = x + dx[i];
			
			if(yy < 0 || yy >= R || xx < 0 || xx >= C || visited[map[yy][xx] - 'A']) continue;
			visited[map[yy][xx] - 'A'] = true;
			run(xx, yy, c+1);
			visited[map[yy][xx] - 'A'] = false;
		}
	}
}
