package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨_배달_15686 {
    private static int N, M;
    private static int[][] arr;
    private static List<Loc> houseList, chickenList;
    private static boolean[] open;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    houseList.add(new Loc(i, j));
                } else if (arr[i][j] == 2) {
                    chickenList.add(new Loc(i, j));
                }
            }
        }

        open = new boolean[chickenList.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int cnt, int start) {
        if (cnt == M) {
            int sum = 0;

            for (int i = 0; i < houseList.size(); i++) {
                int dis = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if (open[j]) {
                        Loc house = houseList.get(i);
                        Loc chicken = chickenList.get(j);
                        dis = Math.min(dis , Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
                    }
                }
                sum += dis;
            }

            answer = Math.min(sum, answer);
            return;
        }

        for (int i=start; i<chickenList.size(); i++) {
            open[i] = true;
            dfs(cnt + 1, i + 1);
            open[i] = false;
        }
    }

    private static class Loc {
        private int x;
        private int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
