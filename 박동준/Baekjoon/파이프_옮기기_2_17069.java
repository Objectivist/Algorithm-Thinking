package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프_옮기기_2_17069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        long[][][] dp = new long[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (arr[i][j] == 1) continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (arr[i - 1][j] == 1 || arr[i][j - 1] == 1) continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }

        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}
