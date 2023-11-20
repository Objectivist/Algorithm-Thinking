import java.util.*;

class Programmers_n진수게임 {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int num = 0;
        for(int i=0;i<m*t;i++){
            sb.append(Integer.toString(num++, n));
        }

        for(int i=p-1;i<m*t;i+=m){
            answer += sb.charAt(i);
        }

        return answer.toUpperCase();
    }
}