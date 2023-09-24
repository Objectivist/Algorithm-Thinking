import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Softeer_순서대로방문하기 {
    static int n, m, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        answer = 0;
        list = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            list.add(new int[]{x, y});
        }

        //출발점
        int sx = list.get(0)[0];
        int sy = list.get(0)[1];

        int ex = list.get(list.size()-1)[0];
        int ey = list.get(list.size()-1)[1];

        dfs(sx, sy, ex, ey, 1);

        System.out.println(answer);

    }

    public static void dfs(int x, int y, int ex, int ey, int count){

        for(int i=0;i<list.size();i++){
            int lx = list.get(i)[0];
            int ly = list.get(i)[1];
            if(lx == x && ly == y){
                if(count == m && (x == ex && y == ey)){
                    answer++;
                    return;
                }else {
                    count++;
                    break;
                }
            }
        }


        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                continue;
            if(map[nx][ny] == 1)
                continue;
            if(visited[nx][ny])
                continue;
            visited[x][y] = true;
            dfs(nx, ny, ex, ey, count);
            visited[x][y] = false;
        }

    }
}