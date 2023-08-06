package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구와_스위치_2138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] src = br.readLine().toCharArray();
        char[] src2 = src.clone();
        char[] des = br.readLine().toCharArray();
        int answer = 0;
        int answer2 = 0;

        //0을 누를때
        putSwitch(src, 0);
        answer++;

        for (int i = 1; i < n; i++) {
            //0을 누를때
            if (src[i-1] != des[i-1]) {
                putSwitch(src, i);
                answer++;
            }

            //0을 안누를때
            if (src2[i-1] != des[i-1]) {
                putSwitch(src2, i);
                answer2++;
            }
        }

        if (src[n-1] != des[n-1]) {
            answer = Integer.MAX_VALUE;
        }

        if (src2[n-1] != des[n-1]) {
            answer2 = Integer.MAX_VALUE;
        }

        System.out.println(Math.min(answer, answer2) == Integer.MAX_VALUE ? -1 : Math.min(answer, answer2));
    }

    private static void putSwitch(char[] src, int i) {
        if (i == 0) {
            src[0] = change(src[0]);
            src[1] = change(src[1]);

        } else if (i == src.length-1) {
            src[i - 1] = change(src[i - 1]);
            src[i] = change(src[i]);

        } else {
            src[i - 1] = change(src[i - 1]);
            src[i] = change(src[i]);
            src[i + 1] = change(src[i + 1]);
        }
    }

    private static char change(char i) {
        if (i=='0')
            return '1';
        else return '0';
    }
}
