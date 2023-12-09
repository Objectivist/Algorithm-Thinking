import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, X, Y, K;
	public static int[][] map;
	public static int[] dice;
	
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dice = new int[6];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			process(Integer.parseInt(st.nextToken())-1);
		}
	}
	
	public static void process(int dir) {
		int xx = X + dx[dir];
		int yy = Y + dy[dir];
		
		if(xx < 0 || xx >= N || yy < 0 || yy >= M) return;
		
		int tmp = dice[5];
        switch (dir) {
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;
            case 3:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
        }
        
        System.out.println(dice[0]);
        X = xx;
        Y = yy;
        
        // ?? X, Y 순서 왜 이렇게 해야하지..?
        if(map[X][Y] == 0) map[X][Y] = dice[5];
        else {
        	dice[5] = map[X][Y];
        	map[X][Y] = 0;
        }
	}
}
