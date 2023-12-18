package Programmers;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int r = storey % 10;

            if (r > 5) {
                answer += (10 - r);
                storey += 10;
            } else if (r < 5) {
                answer += r;
            } else {    //r==5 일 경우는 현재 자리에선 빼든 더하든 상관이 없다. 그 앞자리 수에 이득이 되는 방향으로 계산해준다.
                if (storey/10%10 > 4) {
                    storey += 10;
                }
                answer += r;
            }
            storey /= 10;
        }

        return answer;
    }
}
