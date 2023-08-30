package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, R, MAX_VALUE = 1_000_000_000, res;
	public static int items[], map[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		items = new int[N+1];
		map = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(map[i], MAX_VALUE);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			items[i] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int i = 0; i < R; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[a][b] = l;
			map[b][a] = l;
		}
		
		for (int i = 1; i <= N; i++) {
			dijestra(i);
		}
		
		System.out.println(res);
	}
	
	public static void dijestra(int start){
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, MAX_VALUE);
		
		for(int i = 1; i <= N; i++){
			dist[i] = map[start][i];
		}
		
		visited[start] = true;
		dist[start] = 0;
		
		while(true){
			int idx = 0;
			int val = MAX_VALUE;
			
			for(int i = 1; i <= N; i++){
				if(visited[i] || dist[i] > val) continue;
				idx = i;
				val = dist[i];
			}
			
			if(idx == 0) break;
			
			for(int i = 1; i <= N; i++){
				if(visited[i] || map[idx][i] == MAX_VALUE) continue;
				dist[i] = dist[i] < dist[idx] + map[idx][i] ? dist[i] : dist[idx] + map[idx][i]; 
			}
			
			visited[idx] = true;
		}
		
		int v = 0;
		for(int i = 1; i <= N; i++){
			if(dist[i] <= M) v += items[i];
		}
		
		res = res > v ? res : v;
	}
}
