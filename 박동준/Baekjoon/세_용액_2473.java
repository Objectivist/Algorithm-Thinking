package Baekjoon;

import java.util.*;

public class 세_용액_2473 {
    private static long[] arr;
    private static int N;
    private static long SUM = Long.MAX_VALUE;
    private static long[] answer = new long[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long absSum = Math.abs(sum);

                if (SUM > absSum) {
                    SUM = absSum;
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
