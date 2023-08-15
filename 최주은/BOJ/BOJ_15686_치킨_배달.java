import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, res = Integer.MAX_VALUE;
	public static ArrayList<Point> house = new ArrayList<>();
	public static HashMap<Integer, Point> shop = new HashMap<>();
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				if(v == 1) house.add(new Point(j, i));
				else if(v == 2) shop.put(idx++, new Point(j, i));
			}
		}
		
		visited = new boolean[idx];
		process(0, 0);
		System.out.println(res);
	}
	
	public static void process(int idx, int m) {
		if(m == M) {
			int d = 0;
			for(int i = 0; i < house.size(); i++) {
				Point h = house.get(i);
				int mDis = Integer.MAX_VALUE;
				for(int j = 0; j < visited.length; j++) {
					if(visited[j]) {
						Point s = shop.get((Integer)j);
						int dis = Math.abs(s.x - h.x) + Math.abs(s.y - h.y);
						mDis = mDis > dis ? dis : mDis;
					}
				}
				d += mDis;
			}
			res = res > d ? d : res;
			return;
		}
		
		for(int i = idx; i < visited.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			process(i, m+1);
			visited[i] = false;
		}
	}
}
