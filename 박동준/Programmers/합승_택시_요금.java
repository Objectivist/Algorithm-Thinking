package Programmers;

import java.util.*;

public class 합승_택시_요금 {

    private HashMap<Integer, List<int[]>> map = new HashMap<>();
    private int N;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 20000001;
        this.N = n;

        for (int i = 0; i < N+1; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int bill = fares[i][2];
            map.get(x).add(new int[] {y,bill});
            map.get(y).add(new int[] {x,bill});
        }

        int[] toGether = bfs(s);

        for (int i = 1; i < n + 1; i++) {
            int[] bill = bfs(i);

            answer = Math.min(answer, toGether[i] + bill[a] + bill[b]);
        }

        return answer;
    }

    private int[] bfs(int start) {
        int[] bill = new int[N + 1];
        Queue<int[]> q = new LinkedList<>();

        Arrays.fill(bill, 20000001);
        bill[start] = 0;

        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int s = poll[0];

            for (int[] arr : map.get(s)) {
                int ns = arr[0];
                int dist = arr[1];

                if (bill[ns] > bill[s] + dist) {
                    bill[ns] = bill[s] + dist;
                    q.offer(new int[] {ns, bill[ns]});
                }
            }
        }

        return bill;
    }
}
