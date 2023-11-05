package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class N으로_만들기_17255 {
    private static Set<String> set = new HashSet();
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            dfs(i, i, String.valueOf(arr[i]), String.valueOf(arr[i]));
        }

        System.out.println(set.size());
    }

    private static void dfs(int left, int right, String str, String path) {
        if (str.length() == arr.length) {
            set.add(path);
        }

        if (left > 0) {
            dfs(left - 1, right, arr[left - 1] + str, path + " " + arr[left - 1] + str);
        }

        if (right < arr.length - 1) {
            dfs(left, right + 1, str + arr[right + 1], path + " " + str + arr[right + 1]);
        }
    }
}
