package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사_상어와_파이어스톰_20058 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] arr;
    private static boolean[][] visited;
    private static int N;
    private static int Q;
    private static int dung = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] L = new int[Q];
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        //파이어스톰ㄱ
        for (int i = 0; i < Q; i++) {
            arr = divide(L[i]);
            arr = melt();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                    if (!visited[i][j]) bfs(i, j);
                }
            }
        }

        System.out.println(sum);
        System.out.println(dung);
    }

    private static int[][] melt() {
        int[][] tmpArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmpArr[i] = Arrays.copyOf(arr[i], N);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) continue;

                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (arr[nx][ny] > 0) cnt++;
                }

                if (cnt < 3) {
                    tmpArr[i][j]--;
                }
            }
        }

        return tmpArr;
    }

    private static int[][] divide(int L) {
        int[][] tmpArr = new int[N][N];
        L = (int) Math.pow(2, L);

        for (int i = 0; i < N; i += L) {
            for (int j = 0; j < N; j += L) {
                rotate(i, j, L, tmpArr);
            }
        }

        return tmpArr;
    }

    private static void rotate(int x, int y, int L, int[][] tmpArr) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                tmpArr[x + i][y + j] = arr[x + L - 1 - j][y + i];
            }
        }
    }

    private static void bfs(int x, int y) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        cnt++;
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] <= 0) {
                    continue;
                }

                cnt++;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        dung = Math.max(cnt, dung);
    }
}
