package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 자동차_테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        Map<Long, Integer> map = new HashMap<>();   //자동차연비, 인덱스
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i+1);
        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());

            Integer getValue = map.get(m);

            if (getValue == null) {
                System.out.println(0);
                continue;
            }

            long left = getValue - 1;
            long right = n - getValue;

            System.out.println(left * right);
        }
    }
}
