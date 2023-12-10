import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_주사위굴리기 {
    static class Dice{
        int up;
        int down;
        int right;
        int left;
        int front;
        int back;
        Dice(){
            this.front = 0;
            this.back = 0;
            this.up = 0;
            this.down = 0;
            this.right = 0;
            this.left = 0;
        }
        public void rollNorth(){
            int tmp = this.down;
            this.down = this.back;
            this.back = this.up;
            this.up = this.front;
            this.front = tmp;
        }

        public void rollSouth(){
            int tmp = this.back;
            this.back = this.down;
            this.down = this.front;
            this.front = this.up;
            this.up = tmp;
        }

        public void rollWest(){
            int tmp = this.left;
            this.left = this.up;
            this.up = this.right;
            this.right = this.down;
            this.down = tmp;
        }

        public void rollEast(){
            int tmp = this.right;
            this.right = this.up;
            this.up = this.left;
            this.left = this.down;
            this.down = tmp;
        }

        public int printUp(){
            return up;
        }

        public void copyToMap(){
            map[x][y] = this.down;
        }

        public void copyToDice(){
            this.down = map[x][y];
        }

    }
    static int n, m, x, y, k;
    static int[][] map;
    static int[] commands;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        commands = new int[k];
        for(int i=0;i<k;i++){
            commands[i] = Integer.parseInt(st.nextToken());
        }

        Dice dice = new Dice();
        for(int i=0;i<k;i++){
            int curCommand = commands[i];
            int upper = getDiceUpper(curCommand, dice);

            if(upper != -1){
                System.out.println(upper);
            }
        }





    }

    public static int getDiceUpper(int dir, Dice dice){
        if(dir == 1){
            if(y+1 < m){
                dice.rollEast();
                y++;
                if(map[x][y] == 0){
                    dice.copyToMap();
                }else{
                    dice.copyToDice();
                    map[x][y] = 0;
                }
            }
            return dice.printUp();
        }
        else if(dir == 2){
            if(y-1>=0){
                dice.rollWest();
                y--;
                if(map[x][y] == 0){
                    dice.copyToMap();
                }else{
                    dice.copyToDice();
                    map[x][y] = 0;
                }
                return dice.printUp();
            }
        }
        else if(dir == 3){
            if(x-1>=0){
                dice.rollNorth();
                x--;
                if(map[x][y] == 0){
                    dice.copyToMap();
                }else{
                    dice.copyToDice();
                    map[x][y] = 0;
                }
                return dice.printUp();
            }
        }
        else if(dir == 4){
            if(x+1<n){
                dice.rollSouth();
                x++;
                if(map[x][y] == 0){
                    dice.copyToMap();
                }else{
                    dice.copyToDice();
                    map[x][y] = 0;
                }
                return dice.printUp();
            }
        }
        return -1;
    }
}
