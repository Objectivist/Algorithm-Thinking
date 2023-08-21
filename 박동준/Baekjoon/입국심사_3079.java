package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입국심사_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 0;
        long right = arr[N-1] * M;
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (long i : arr) {

                //없으면 틀림..
                if(sum>=M){
                    break;
                }

                sum += (mid / i);
            }

            if (sum >= M) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
