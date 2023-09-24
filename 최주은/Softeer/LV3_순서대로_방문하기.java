import java.util.*;
import java.io.*;


public class Main
{
    public static int N, M, res;
    public static int[][] map;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static boolean[][] visited;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startX = 0, startY = 0;
        for(int i = 1; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            map[y][x] = -i;

            if(i == 1){
                startX = x;
                startY = y;
            }
        }

        visited[startY][startX] = true;
        run(startX, startY, 2);
        System.out.println(res);
    }

    public static void run(int x, int y, int idx){
        if(map[y][x] < 0 && map[y][x] == -idx){
            if(idx == M){
                res++;
                return;
            }
            idx++;
        }

        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx < 0 || xx >= N || yy < 0 || yy >= N || visited[yy][xx] || map[yy][xx] == 1) continue;
            visited[yy][xx] = true;
            run(xx, yy, idx);
            visited[yy][xx] = false;
        }
    }
}
