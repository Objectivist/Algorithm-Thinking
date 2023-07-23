package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 드래곤_앤_던전_16434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //방 개수
        long atk = Integer.parseInt(st.nextToken()); //용사 공격력
        long curHp = 0;
        long maxHp = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); //1 몬스터, 2 포션
            long a = Integer.parseInt(st.nextToken()); //몬스터 공격력, 용사 공격력 up 포션
            long h = Integer.parseInt(st.nextToken()); //몬스터 피통, 용사 생명력 up 포션

            if (t == 1) {
                curHp += a * ((h / atk) - (h % atk == 0 ? 1 : 0));
                maxHp = Math.max(curHp, maxHp);
            } else {
                atk += a;
                curHp = Math.max(curHp - h, 0);
            }
        }

        System.out.println(maxHp+1);
    }
}
