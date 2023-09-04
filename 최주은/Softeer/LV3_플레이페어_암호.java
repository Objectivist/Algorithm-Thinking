import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static char[] key;
    public static String[] msg;
    public static char[][] map = new char[5][5];
    public static boolean[] visited = new boolean[26];
    public static HashMap<Character, Point> hashmap = new HashMap<>();
    public static String res = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. msg / key 입력
        msg = br.readLine().split("");
        key = br.readLine().toCharArray();
        visited[9] = true;

        // 1. 암호 맵 만들기
        int idx = 0;
        for(char c : key){
            if(visited[c - 'A']) continue;
            map[idx / 5][idx % 5] = c;
            visited[c - 'A'] = true;
            idx++;
        }

        while(idx < 25){
            for(int i = 0; i < 26; i++){
                if(visited[i]) continue;
                visited[i] = true;
                map[idx / 5][idx % 5] = (char) (i + 'A');
                idx++;
                break;
            }
        }

        // 1-2 암호 담기
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                hashmap.put(map[i][j], new Point(j, i));
            }
        }

        // 2. 메세지 나누기
        ArrayList<String> list = new ArrayList<>(Arrays.asList(msg));
        for(int i = 1; i < list.size(); i += 2){
            String prev = list.get(i-1);
            String now = list.get(i);

            if(!prev.equals(now)) continue;

            if(prev.equals("X")) list.add(i, "Q");
            else list.add(i, "X");
            i -= 2;
        }

        if(list.size() % 2 != 0) list.add("X");

        // 3. 암호화
        for(int i = 1; i < list.size(); i += 2){
            char pre = list.get(i-1).charAt(0);
            char now = list.get(i).charAt(0);

            Point pp = hashmap.get(pre);
            Point np = hashmap.get(now);

            // 1. 같은 행에 존재할 때
            if(pp.y == np.y){
                res += String.valueOf(map[pp.y][(pp.x + 1)%5]) + String.valueOf(map[np.y][(np.x + 1)%5]);
            }else if(pp.x == np.x){
                res += String.valueOf(map[(pp.y+1)%5][pp.x]) + String.valueOf(map[(np.y+1)%5][np.x]);
            }else {
                res += String.valueOf(map[pp.y][np.x]) + String.valueOf(map[np.y][pp.x]);
            }
        }

        System.out.println(res);
    }
}
