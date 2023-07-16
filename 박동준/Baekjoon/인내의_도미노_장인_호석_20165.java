package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인내의_도미노_장인_호석_20165 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] cloneArr = new int[n][m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                cloneArr[i][j] = a;
            }
        }

        for (int i = 1; i <= r * 2; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if (i % 2 != 0) {
                String dir = st.nextToken();
                int cur = cloneArr[x][y];
                int dist = cur - 1;
                int j = 0;

                if (cur == -1) continue;

                switch (dir) {
                    case "E":
                        cnt++;
                        cloneArr[x][y] = -1;
                        while (dist > 0) {
                            dist--;
                            j++;
                            if (y + j >= m) break;
                            if (cloneArr[x][y + j] == -1) continue;
                            cnt++;
                            dist = Math.max(dist, cloneArr[x][y + j] - 1);
                            cloneArr[x][y + j] = -1;
                        }
                        break;
                    case "W":
                        cnt++;
                        cloneArr[x][y] = -1;
                        while (dist > 0) {
                            dist--;
                            j++;
                            if (y - j < 0) break;
                            if (cloneArr[x][y - j] == -1) continue;
                            cnt++;
                            dist = Math.max(dist, cloneArr[x][y - j] - 1);
                            cloneArr[x][y - j] = -1;
                        }
                        break;
                    case "S":
                        cnt++;
                        cloneArr[x][y] = -1;
                        while (dist > 0) {
                            dist--;
                            j++;
                            if (x + j >= n) break;
                            if (cloneArr[x + j][y] == -1) continue;
                            cnt++;
                            dist = Math.max(dist, cloneArr[x + j][y] - 1);
                            cloneArr[x + j][y] = -1;
                        }
                        break;
                    case "N":
                        cnt++;
                        cloneArr[x][y] = -1;
                        while (dist > 0) {
                            dist--;
                            j++;
                            if (x - j < 0) break;
                            if (cloneArr[x - j][y] == -1) continue;
                            cnt++;
                            dist = Math.max(dist, cloneArr[x - j][y] - 1);
                            cloneArr[x - j][y] = -1;
                        }
                        break;
                }
            } else {
                cloneArr[x][y] = arr[x][y];
            }
        }

        System.out.println(cnt);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cloneArr[i][j] == -1) {
                    System.out.print("F ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }
}
