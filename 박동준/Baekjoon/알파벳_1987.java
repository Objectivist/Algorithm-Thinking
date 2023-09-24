package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
    private static int r, c;
    private static char[][] arr;
    private static boolean[] visited = new boolean[26];
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();

            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        dfs(new Location(0, 0), 0);
        System.out.println(answer);
    }

    private static void dfs(Location location, int cnt) {
        cnt++;

        visited[arr[location.x][location.y] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nx = location.x + dx[i];
            int ny = location.y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[arr[nx][ny] - 'A']) {

                dfs(new Location(nx, ny), cnt);
            }
        }

        visited[arr[location.x][location.y] - 'A'] = false;

        answer = Math.max(cnt, answer);
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
