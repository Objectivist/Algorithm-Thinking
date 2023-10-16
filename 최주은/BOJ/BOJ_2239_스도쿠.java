import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        for(int i = 0; i < 9; i++){
            sb = new StringBuilder(br.readLine());
            for(int j = 0; j < 9; j++){
                map[i][j] = sb.charAt(j) - '0';
            }
        }

        process();
    }
    public static Point find(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(map[i][j] == 0) return new Point(j,i);
            }
        }

        return null;
    }
    public static void process(){
        Point p = find();
        if(p == null){
            for (int n = 0; n < 9; n++) {
                for (int m = 0; m < 9; m++) {
                    System.out.printf("%d", map[n][m]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        for (int k = 1; k <= 9; k++) {
            if (check(p.y, p.x, k)) {
                map[p.y][p.x] = k;
                process();
                map[p.y][p.x] = 0;
            }
        }
    }


//    public static void process(){
//        boolean trigger = false;
//
//        for(int i = 0; i < 9; i++){
//            for(int j = 0; j < 9; j++){
//                // 비어있는 구간 발견
//                if(map[i][j] == 0) {
//                    trigger = true;
//                    for (int k = 1; k <= 9; k++) {
//                        if (check(i, j, k)) {
//                            map[i][j] = k;
//                            process();
//                            map[i][j] = 0;
//                        }
//                    }
//                }
//            }
//        }
//
//        if(!trigger) {
//            for (int n = 0; n < 9; n++) {
//                for (int m = 0; m < 9; m++) {
//                    System.out.printf("%d", map[n][m]);
//                }
//                System.out.println();
//            }
//            System.exit(0);
//        }
//    }

    public static boolean check(int y, int x, int k){

        // 가로 세로
        for(int i = 0; i < 9; i++){
            if(map[i][x] == k || map[y][i] == k) return false;
        }

        // 네모
        for(int i = (y/3)*3 ; i < (y/3)*3+3; i++){
            for(int j = (x/3)*3; j < (x/3)*3+3; j++){
                if(map[i][j] == k) return false;
            }
        }

        return true;
    }
}
