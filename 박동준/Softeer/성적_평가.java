package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 성적_평가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.valueOf(st.nextToken());
                arr[i][j] = v;
                arr[3][j] += v;
            }
        }

        for (int[] arrOne : arr) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] cloneArr = arrOne.clone();
            Arrays.sort(cloneArr);

            int rank = 1;
            int cnt = 1;
            map.put(cloneArr[n - 1], rank);
            for (int i = n - 2; i >= 0; i--) {
                if (cloneArr[i + 1] == cloneArr[i]) {
                    map.put(cloneArr[i], rank);
                    cnt++;
                } else {
                    map.put(cloneArr[i], rank+= cnt);
                    cnt = 1;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(map.get(arrOne[i]) + " ");
            }
            System.out.println();
        }
    }
}
