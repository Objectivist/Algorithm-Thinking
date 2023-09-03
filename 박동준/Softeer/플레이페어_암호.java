package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 플레이페어_암호 {
    static char[][] map = new char[5][5];
    static boolean[] checkAlpha = new boolean[26];
    static List<String> list = new ArrayList<>();
    static Map<Character, Loc> locMap = new HashMap<>();
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg = br.readLine();
        String key = br.readLine();

        makeMap(key);
        makeLocMap();
        divideMsg(msg);
        encrypt();

        System.out.println(answer);
    }

    private static void encrypt() {
        for (String str : list) {
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);

            Loc loc1 = locMap.get(c1);
            Loc loc2 = locMap.get(c2);

            if (loc1.x == loc2.x) {
                answer += String.valueOf(map[loc1.x][(loc1.y + 1) % 5]) + String.valueOf(map[loc2.x][(loc2.y + 1) % 5]);
            } else if (loc1.y == loc2.y) {
                answer += String.valueOf(map[(loc1.x + 1) % 5][loc1.y]) + String.valueOf(map[(loc2.x + 1) % 5][loc2.y]);
            } else {
                answer += String.valueOf(map[loc1.x][loc2.y]) + String.valueOf(map[loc2.x][loc1.y]);
            }
        }
    }

    private static void makeLocMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                locMap.put(map[i][j], new Loc(i, j));
            }
        }
    }

    private static void divideMsg(String msg) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < msg.length(); i++) {
            q.offer(msg.charAt(i));
        }

        while (!q.isEmpty()) {
            Character p1 = q.poll();
            Character p2 = null;

            if (q.size() > 0) {
                if (p1 != 'X' && p1 == q.peek()) {
                    p2 = 'X';
                } else if (p1 == 'X' && p1 == q.peek()) {
                    p2 = 'Q';
                } else
                    p2 = q.poll();
            } else {
                p2 = 'X';
            }

            list.add(String.valueOf(p1) + String.valueOf(p2));
        }
    }

    private static void makeMap(String key) {
        checkAlpha['J' - 'A'] = true;

        int idx = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (checkAlpha[c - 'A']) continue;

            checkAlpha[c - 'A'] = true;
            map[idx / 5][idx % 5] = c;
            idx++;
        }

        for (int i = 0; i < checkAlpha.length; i++) {
            if (checkAlpha[i]) continue;
            map[idx / 5][idx % 5] = (char) (i + 'A');
            idx++;
        }
    }

    private static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
