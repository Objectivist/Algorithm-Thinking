package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, R, P;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static int[][] map;
	public static boolean[][] res;
	
	public static class Node{
		public int X, Y, D;
		public Node(int x, int y, int d) {
			X = x;
			Y = y;
			D = d;
		}
		
		public Node(int x, int y, char d) {
			X = x;
			Y = y;
			switch(d) {
				case 'N':{ D = 0; break;}
				case 'S':{ D = 1; break;}
				case 'W':{ D = 2; break;}
				case 'E':{ D = 3; break;}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		res = new boolean[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			// 공격
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if(!res[y][x]) Domino(x, y, d);
			
			// 수비
			st = new StringTokenizer(br.readLine(), " ");
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			res[y][x] = false;
		}
		
		System.out.println(P);
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.printf("%c ", res[i][j] ? 'F' : 'S');
			}
			System.out.println();
		}
	}
	
	public static void Domino(int x, int y, char d) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y, d));
		
		while(!q.isEmpty()){
			Node n = q.poll();
			int h = map[n.Y][n.X];
			for(int i = 0; i < h; i++) {
				int xx = n.X + dx[n.D]*i;
				int yy = n.Y + dy[n.D]*i;
				if(xx < 1 || xx > M || yy < 1 || yy > N) continue;
				if(!res[yy][xx]) {
					q.add(new Node(xx, yy, n.D));
					P++;
				}
				res[yy][xx] = true;
			}
		}
	}
}
