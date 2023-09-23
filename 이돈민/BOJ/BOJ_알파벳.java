import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static public class Pair{
        int x;
        int y;
        int dist;
        Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[26];

        for(int i=0;i<r;i++){
            String str = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] = str.charAt(j);
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);

    }


    public static void dfs(int x, int y, int depth){
        max = Math.max(max, depth);
        visited[map[x][y]-65] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= r || ny >= c || visited[map[nx][ny]-65]) continue;
            visited[map[nx][ny]-65] = true;
            dfs(nx, ny, depth + 1);
            visited[map[nx][ny]-65] = false;
        }
    }
}