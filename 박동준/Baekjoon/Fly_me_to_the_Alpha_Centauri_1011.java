package Baekjoon;

import java.util.Scanner;

public class Fly_me_to_the_Alpha_Centauri_1011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int distance = n2-n1;

            long answer = 1;
            long start = 1;
            long end = 1;
            long cnt = 1;

            while (distance > start + end) {
                start += ++cnt;
                end += cnt;
                answer ++;
            }

            if (distance <= start + end - cnt) {
                System.out.println(answer * 2 - 1);
                continue;
            }

            System.out.println(answer*2);
        }
    }
}
