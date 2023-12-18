package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝궁 {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();

        Arrays.sort(weights);
        for (int i : weights) {
            double d = i;
            answer += map.getOrDefault(d, 0);
            answer += map.getOrDefault(d * 2 / 3, 0);
            answer += map.getOrDefault(d * 2 / 4, 0);
            answer += map.getOrDefault(d * 3 / 4, 0);

            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        return answer;
    }
}
