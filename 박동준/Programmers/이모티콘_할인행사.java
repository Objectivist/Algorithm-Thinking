package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이모티콘_할인행사 {
    static int[] discount = {10, 20, 30, 40};
    static List<int[]> list = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];

        rec(0, discounts, users, emoticons);
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        return list.get(0);
    }

    private void rec(int idx, int[] discounts, int[][] users, int[] emoticons) {
        if (idx == discounts.length) {
            int consumer = 0;
            int sumsum = 0;

            for (int[] user : users) {
                int sum = 0;

                int userDiscount = user[0];
                int userMaxMoney = user[1];

                for (int i = 0; i < discounts.length; i++) {
                    if (discounts[i] >= userDiscount) {
                        sum += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }

                if (sum >= userMaxMoney) {
                    consumer++;
                } else {
                    sumsum += sum;
                }
            }

            list.add(new int[]{consumer, sumsum});
            return;
        }

        for (int i = 0; i < 4; i++) {
            discounts[idx] = discount[i];
            rec(idx + 1, discounts, users, emoticons);
        }
    }
}
