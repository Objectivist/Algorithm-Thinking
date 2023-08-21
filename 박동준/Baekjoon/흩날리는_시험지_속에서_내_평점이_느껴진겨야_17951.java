package Baekjoon;

import java.util.Scanner;

public class 흩날리는_시험지_속에서_내_평점이_느껴진겨야_17951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] correct = new int[N];
        int low = 0, high = 0;

        for (int i = 0; i < N; i++) {
            correct[i] = sc.nextInt();
            high += correct[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 1, sum = 0;

            for (int i = 0; i < N; i++) {
                sum += correct[i];

                if (sum >= mid) {
                    cnt++;
                }
            }

            if (cnt > K) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(low - 1);
    }
}
