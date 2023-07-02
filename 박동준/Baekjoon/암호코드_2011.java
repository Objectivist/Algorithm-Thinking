package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호코드_2011 {

    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        dp = new int[str.length()];
        dp[0] = 1;

        int initPrev = str.charAt(0) - '0';

        if (initPrev == 0) {
            System.out.println(0);
            return;
        }

        if (str.length() == 1) {
            System.out.println(1);
            return;
        }

        int initCur = str.charAt(1) - '0';

        if (initPrev == 0) {
            System.out.println(0);
            return;
        }

        if ( initCur >= 1 && initCur <= 9) {
            dp[1] += dp[0];

            if (initCur + initPrev * 10 < 27) {
                dp[1] += 1;
            }
        } else {
            if (initCur + initPrev * 10 >= 27) {
                System.out.println(dp[1]);
                return;
            } else {
                dp[1] += dp[0];
            }
        }

        for (int i = 2; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            int prev = str.charAt(i-1) - '0';

            if ( cur >= 1 && cur <= 9) {
                dp[i] = (dp[i] + dp[i-1]) % 1000000;

                if (9 < cur + prev * 10 && cur + prev * 10 < 27) {
                    dp[i] = (dp[i] + dp[i-2]) % 1000000;
                }
            } else {
                if (cur + prev * 10 >= 27 || cur + prev * 10 < 1) {
                    break;
                } else {
                    dp[i] = (dp[i] + dp[i-2]) % 1000000;
                }
            }
        }

        System.out.println(dp[str.length() - 1]);
    }
}
