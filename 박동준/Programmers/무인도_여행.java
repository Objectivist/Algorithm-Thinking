package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도_여행 {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    private int[][] map;
    private int n, m;
    private List<Integer> list = new ArrayList<>();

    public int[] solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char o = maps[i].charAt(j);

                if (o == 'X') {
                    map[i][j] = 0;
                    continue;
                }

                map[i][j] = o - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0)
                    bfs(i, j);
            }
        }

        if (list.size() == 0) return new int[]{-1};

        int[] answer = list.stream().sorted().mapToInt(i -> i).toArray();

        return answer;
    }

    private void bfs(int x, int y) {
        int cnt = map[x][y];
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        map[x][y] = 0;

        while (!q.isEmpty()) {
            Loc poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0) continue;

                q.offer(new Loc(nx, ny));
                cnt += map[nx][ny];
                map[nx][ny] = 0;
            }
        }

        list.add(cnt);
    }

    class Loc {
        int x = 0;
        int y = 0;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
