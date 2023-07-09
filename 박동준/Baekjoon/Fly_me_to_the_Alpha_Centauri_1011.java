package Baekjoon;

import java.util.Scanner;

public class Fly_me_to_the_Alpha_Centauri_1011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cnt = 0;

            while (start < end) {
                start += ++cnt;
                end -= cnt;
            }

            System.out.println(start >= end + cnt ? 2 * cnt - 1 : 2 * cnt);
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            int n1 = sc.nextInt();
//            int n2 = sc.nextInt();
//            int distance = n2-n1;
//
//            int answer = 1;
//            int start = 1;
//            int end = 1;
//            int cnt = 1;
//
//            while (distance > start + end) {
//                start += ++cnt;
//                end += ++cnt;
//                answer ++;
//            }
//
//            if (distance <= start + end - cnt) {
//                System.out.println(answer * 2 - 1);
//                continue;
//            }
//
//            System.out.println(answer*2);
//        }
//    }
}
