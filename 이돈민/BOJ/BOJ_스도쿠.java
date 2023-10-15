import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_스도쿠 {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static List<Pair> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        list = new ArrayList<>();
        for(int i=0;i<9;i++){
            String str = br.readLine();
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
                if(map[i][j] == 0)
                    list.add(new Pair(i, j));
            }
        }

        //print();
        dfs(0);

    }

    public static void print(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    //행 체크
    public static boolean check(int x, int y, int num){
        for(int i=0;i<9;i++){
           if(map[i][y] == num)
               return false;
           if(map[x][i] == num)
               return false;
        }

        int sx = x / 3 * 3;
        int sy = y / 3 * 3;
        int ex = sx + 3;
        int ey = sy + 3;

        for(int i=sx;i<ex;i++){
            for(int j=sy;j<ey;j++){
                if(map[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public static void dfs(int depth){
        if(depth == list.size()){
            print();
            System.exit(0);
        }
        Pair cur = list.get(depth);
        for(int i=1;i<=9;i++){
            int x = cur.x;
            int y = cur.y;
            if(check(x, y, i)){
                map[x][y] = i;
                dfs(depth+1);
                map[x][y] = 0;
            }
        }


    }
}
