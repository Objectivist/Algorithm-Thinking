package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 서강그라운드_14938 {
    private static int[] item;
    private static int[] dist;
    private static boolean[] visited;
    private static Map<Integer, List<Loc>> map;
    private static int answer = Integer.MIN_VALUE;
    private static int n, m, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        visited = new boolean[n + 1];
        item = new int[n + 1];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(x).add(new Loc(y, weight));
            map.get(y).add(new Loc(x, weight));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Loc> q = new PriorityQueue<>();
        q.offer(new Loc(start, 0));
//        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            Loc poll = q.poll();

            if (!visited[poll.locNum]) {
                visited[poll.locNum] = true;
                List<Loc> locList = map.get(poll.locNum);

                for (Loc l : locList) {
                    if (!visited[l.locNum] && dist[l.locNum] > dist[poll.locNum] + l.weight) {
//                    visited[l.locNum] = true;
                        dist[l.locNum] = dist[poll.locNum] + l.weight;
                        q.offer(new Loc(l.locNum, dist[l.locNum]));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                sum += item[i];
            }
        }

        answer = Math.max(answer, sum);
    }


    static class Loc implements Comparable<Loc> {
        int locNum;
        int weight;

        public Loc(int locNum, int weight) {
            this.locNum = locNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(Loc o) {
            return weight - o.weight;
        }
    }
}
