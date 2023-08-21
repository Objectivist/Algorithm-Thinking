package Baekjoon;

import java.util.*;

public class 숫자고르기_2668 {
    private static int N;
    private static boolean[] visited;
    private static int[] arr;
    private static Set result = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int end = dfs(i);

            if (i == end) {
                result.add(i);
            }
        }

        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }

    private static int dfs(int i) {
        visited[i] = true;
        int end = arr[i];

        if (!visited[end]) {
            end = dfs(end);
        }

        visited[i] = false;
        return end;
    }
}
