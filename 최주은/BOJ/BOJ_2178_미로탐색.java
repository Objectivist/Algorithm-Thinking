import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] map;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new Point(0, 0, 1));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int yy = p.y + dy[i];
				int xx = p.x + dx[i];
				
				if(yy < 0 || yy >= N || xx < 0 || xx >= M || visited[yy][xx] || map[yy][xx] == 0) continue;
				
				if(yy == N-1 && xx == M-1) return p.d+1;
				
				visited[yy][xx] = true;
				q.add(new Point(yy, xx, p.d+1));
			}
		}
		
		return 0;
	}
	
	public static class Point{
		int y, x, d;
		public Point(int y, int x, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
