package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순서대로_방문하기 {
    private static int n, m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static Location[] destination;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        destination = new Location[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            destination[i] = new Location(x - 1, y - 1);
        }

        dfs(destination[0], 1);
        System.out.println(answer);
    }

    private static void dfs(Location location, int i) {
        if (location.x == destination[i].x && location.y == destination[i].y) {

            if (i == m - 1) {
                answer++;
                return;
            }

            i++;
        }

        visited[location.x][location.y] = true;

        for (int j = 0; j < 4; j++) {
            int nx = location.x + dx[j];
            int ny = location.y + dy[j];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] == 0) {
                dfs(new Location(nx, ny), i);
            }
        }

        visited[location.x][location.y] = false;
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
