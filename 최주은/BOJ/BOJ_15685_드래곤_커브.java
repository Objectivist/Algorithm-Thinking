import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static boolean[][] map = new boolean[101][101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			setDragonCurve(x, y, getDirection(d, g));
		}
		
		System.out.println(getDragonCurve());
	}
	
	public static List<Integer> getDirection(int d, int g){
		List<Integer> dir = new ArrayList<>();
		dir.add(d);
		
		for(int i = 0; i < g; i++) {
			// Dragon Curve 를 보면 끝에 점을 기준으로 90도 돌리기 때문에
			// 끝 지점 부터 방향을 추가해주어야 한다.
			for(int j = dir.size()-1; j >= 0; j--) {
				int dd = (dir.get(j) + 1) % 4;
				dir.add(dd);
			}
		}
		
		return dir;
	}
	
	public static void setDragonCurve(int x, int y, List<Integer> dir) {
		map[y][x] = true;
		for(int d : dir) {
			switch(d) {
				case 0 :
					map[y][++x] = true;
					break;
				case 1 :
					map[--y][x] = true;
					break;
				case 2 :
					map[y][--x] = true;
					break;
				case 3 :
					map[++y][x] = true;
					break;
			}
		}
	}
	
	public static int getDragonCurve() {
		int res = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) res++;
			}
		}
		
		return res;
	}
}
