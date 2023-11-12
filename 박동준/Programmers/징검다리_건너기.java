package Programmers;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;

        while (min <= max) {
            int cnt = 0;
            int mid = (min + max) / 2;

            for (int s : stones) {
                if (s - mid < 0) {  //0 다음 부터 못 지나감.
                    cnt++;
                } else {
                    cnt = 0;
                }

                if (cnt >= k) {
                    break;
                }
            }

            if (cnt >= k) {
                max = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                min = mid + 1;
            }
        }

        return answer;
    }
}
