package Programmers;

import java.awt.event.WindowFocusListener;
import java.util.*;

public class 양과_늑대 {
    private static int[] info;
    private static int answer = 0;
    private static Map<Integer, List<Integer>> map;

    public int solution(int[] info, int[][] edges) {
        map = new HashMap<>(17);
        List<Integer> canVisit = new ArrayList<>();
        this.info = info;

        for (int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];

            List<Integer> list = map.get(a);
            if (list == null) {
                List<Integer> newList = new ArrayList<>();
                newList.add(b);
                map.put(a, newList);
            } else {
                list.add(b);
            }
        }

        dfs(0, 0, 0, canVisit);

        return answer;
    }

    private void dfs(int loc, int sheep, int wolf, List<Integer> canVisit) {
        if (info[loc] == 0) sheep++;
        else wolf++;

        if (sheep <= wolf) return;

        answer = Math.max(answer, sheep);

        List<Integer> nextLocList = map.get(loc);

        List<Integer> newList = new ArrayList<>();
        newList.addAll(canVisit);

        if (nextLocList != null) {
            for (int i : nextLocList) {
                newList.add(i);
            }
        }

        newList.remove(Integer.valueOf(loc));

        for (int i : newList) {
            dfs(i, sheep, wolf, newList);
        }
    }
}
