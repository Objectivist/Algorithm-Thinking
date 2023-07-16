package Programmers;

import java.util.*;

public class 부대복귀 {
    private static int[] distance;
    private static boolean[] visited;
    private static Map<Integer, List<Integer>> roadMap;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        this.visited = new boolean[n + 1];
        this.distance = new int[n + 1];
        roadMap = new HashMap<>();

        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }

        for (int[] r : roads) {
            if (roadMap.get(r[0]) == null) {
                roadMap.put(r[0], new ArrayList<>());
            }
            roadMap.get(r[0]).add(r[1]);

            if (roadMap.get(r[1]) == null) {
                roadMap.put(r[1], new ArrayList<>());
            }
            roadMap.get(r[1]).add(r[0]);
        }

        bfs(destination);

        for (int i=0; i<sources.length; i++) {
            answer[i] = distance[sources[i]];
        }

        return answer;
    }

    private void bfs(int d) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(d);
        visited[d] = true;
        distance[d] = 0;

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            List<Integer> list = roadMap.get(poll);
            for (Integer i : list) {
                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    distance[i] = distance[poll] + 1;
                }
            }

//            for (int[] r : roads) {
//                if (r[0] == poll && !visited[r[1]]) {
//                    q.offer(r[1]);
//                    visited[r[1]] = true;
//                    distance[r[1]] = distance[r[0]] + 1;
//                } else if (r[1] == poll && !visited[r[0]]) {
//                    q.offer(r[0]);
//                    visited[r[0]] = true;
//                    distance[r[0]] = distance[r[1]] + 1;
//                }
//            }
        }
    }
}
