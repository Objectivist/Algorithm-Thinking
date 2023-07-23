package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Puyo_Puyo_11559 {
    private static char[][] arr;
    private static boolean[][] visited;
    private static List<Loc> checkList = new ArrayList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        visited = new boolean[12][6];
        boolean isBoom = false;
        int result = 0;

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();

            for (int j = 0; j < 6; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        while (true) {
            visited = new boolean[12][6];
            isBoom = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.') {
                        checkList = new ArrayList<>();
                        bfs(i, j);

                        if (checkList.size() > 3) {
                            isBoom = true;

                            for (Loc loc : checkList) {
                                arr[loc.x][loc.y] = '.';
                            }

//                            downPuyo();
//                            result++;
                        }
                    }
                }
            }

            if (!isBoom) break;

            downPuyo();
            result++;
        }

        System.out.println(result);
    }

    private static void downPuyo() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (arr[j][i] == '.') {
                    for (int k = j - 1; k > -1; k--) {
                        if (arr[k][i] != '.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));
        visited[x][y] = true;
        checkList.add(new Loc(x, y));

        while (!q.isEmpty()) {
            Loc poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx > -1 && nx < 12 && ny > -1 && ny < 6 && !visited[nx][ny] && arr[nx][ny] == arr[x][y]) {
                    checkList.add(new Loc(nx, ny));
                    q.offer(new Loc(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
