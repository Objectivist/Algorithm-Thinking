package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	public static int res;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static char[][] map = new char[12][6];
	public static boolean[][] tempMap, visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 12; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for(int j = 0; j < 6; j++) {
				map[i][j] = sb.charAt(j);
			}
		}
		
		while(true) {
			visited = new boolean[12][6];
			tempMap = new boolean[12][6];
			boolean tri = false;
			
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(!visited[i][j] && map[i][j] != '.') {
						if(run(j, i, map[i][j])) tri = true;
					}
				}
			}
			
			// tempMap에 맞추어 터뜨리기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(tempMap[i][j]) map[i][j] = '.';
				}
			}
			
			// 뿌요 내리기
			falling();
			
			if(!tri) break;
			res++;
		}
		
		
		System.out.println(res);
	}
	
	public static void falling() {
		for(int j = 0; j < 6; j++) {
			for(int i = 11; i >= 0; i--) {
				if(map[i][j] == '.') {
					for(int k = i; k >= 0; k--) {
						if(map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
	
	public static boolean run(int x, int y, int c) {
		boolean[][] tMap = new boolean[12][6];
		boolean res = false;
		int cnt = 0;
		
		LinkedList<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		// BFS
		while(!q.isEmpty()) {
			Point p = q.poll();
			visited[p.y][p.x] = true;
			tMap[p.y][p.x] = true;
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int yy = p.y + dy[i];
				int xx = p.x + dx[i];
				
				if(yy < 0 || yy >= 12 || xx < 0 || xx >= 6 || visited[yy][xx] || map[yy][xx] != c) continue;
				
				q.add(new Point(xx, yy));
			}
		}
		
		if(cnt >= 4) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(tMap[i][j]) tempMap[i][j] = true;
				}
			}
			
			res = true;
		}
		
		return res;
	}
}
