package Programmers;

import java.util.*;

public class 혼자_놀기의_달인 {
    static boolean[] open;

    public int solution(int[] cards) {
        int answer = 0;
        open = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            int cnt = 0;
            cnt = step(cards, i, cnt);

            list.add(cnt);
        }

        list.sort(Comparator.reverseOrder());
        answer = list.get(0) * list.get(1);

        return answer;
    }

    private int step(int[] cards, int c, int cnt) {
        if (!open[c]) {
            open[c] = true;
            cnt = step(cards, cards[c]-1, cnt + 1);
        }

        return cnt;
    }
}
