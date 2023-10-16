package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//다익
public class 지우는_소수를_좋아해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] levelArr = new int[N + 1];
        List<Edge>[] list = new ArrayList[N+1];
        PriorityQueue<Edge> q = new PriorityQueue<>();

        for (int i = 0; i < levelArr.length; i++) {
            levelArr[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Edge(B, C));
            list[B].add(new Edge(A, C));
        }

        q.offer(new Edge(1, 0));
        levelArr[1] = 0;

        while (!q.isEmpty()) {
            Edge poll = q.poll();
            int v = poll.vertex;
            List<Edge> edgeList = list[v];

            for (Edge edge : edgeList) {
                int nlv = Math.max(edge.level, poll.level);
                if (nlv < levelArr[edge.vertex]) {
                    levelArr[edge.vertex] = nlv;
                    //전 체육관이 지금 체육관보다 레벨이 높을 수 있음
                    q.offer(new Edge(edge.vertex, nlv));
                }
            }
        }

        int answer = levelArr[N] + 1;

        while (true) {
            if (isPrime(answer)) {
                System.out.println(answer);
                return;
            }

            answer++;
        }
    }

    private static boolean isPrime(int l) {
        for (int i = 2; i <= Math.sqrt(l); i++) {
            if (l % i == 0) return false;
        }

        return true;
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int level;

        public Edge(int vertex, int level) {
            this.vertex = vertex;
            this.level = level;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.level, o.level);
        }
    }
}