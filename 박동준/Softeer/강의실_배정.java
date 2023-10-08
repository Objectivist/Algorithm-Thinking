package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실_배정 {
    private static int N;
    private static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            list.add(new int[]{s, f});
        }

        Collections.sort(list, (int[] o1, int[] o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else
                        return o1[1] - o2[1];
                }
        );

        int answer = 0;
        int time = 0;

        for (int[] arr : list) {
            if (arr[0] >= time) {
                answer++;
                time = arr[1];
            }
        }

        System.out.println(answer);
    }
}
