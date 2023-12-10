package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_굴리기_14499 {
    private static int N, M, x, y, K;
    private static int[][] arr;
    private static int[] dice = new int[7];
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];

            if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;

            changeDice(dir);

            if (arr[nx][ny] == 0) {
                arr[nx][ny] = dice[6];
            } else {
                dice[6] = arr[nx][ny];
                arr[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            System.out.println(dice[1]);
        }
    }

    private static void changeDice(int dir) {
        int[] cloneDice = dice.clone();

        switch (dir) {
            case 1:
                dice[1] = cloneDice[4];
                dice[3] = cloneDice[1];
                dice[4] = cloneDice[6];
                dice[6] = cloneDice[3];
                break;
            case 2:
                dice[1] = cloneDice[3];
                dice[3] = cloneDice[6];
                dice[4] = cloneDice[1];
                dice[6] = cloneDice[4];
                break;
            case 3:
                dice[1] = cloneDice[5];
                dice[2] = cloneDice[1];
                dice[5] = cloneDice[6];
                dice[6] = cloneDice[2];
                break;
            case 4:
                dice[1] = cloneDice[2];
                dice[2] = cloneDice[6];
                dice[5] = cloneDice[1];
                dice[6] = cloneDice[5];
                break;
        }
    }
}
