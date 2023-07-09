package Programmers;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int end = 0;

        for (int s : stations) {
            end = s - w - 1;
            int newStation = (end - start + 1) / (2 * w + 1);
            if ((end - start + 1) % (2 * w + 1) > 0) newStation++;
            answer += newStation;
            start = s + w + 1;
        }

        end = n;
        int newStation = (end - start + 1) / (2 * w + 1);
        if ((end - start + 1) % (2 * w + 1) > 0) newStation++;
        answer += newStation;

        return answer;
    }
}
