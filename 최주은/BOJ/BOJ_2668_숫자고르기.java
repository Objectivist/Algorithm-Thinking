import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}
	}
	
	public static void dfs(int n, int t) {
		// 검사
		if(arr[n] == t) {
			list.add(t);
			return;
		}
		
		
		// 조합
		if(!visited[arr[n]]) {
			visited[arr[n]] = true;
			dfs(arr[n], t);
			visited[arr[n]] = false;
		}
	}
}
