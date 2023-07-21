import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559 {
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;
    static boolean[][] visited;
    static List<int[]> imsi;
    static boolean flag;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[12][6];
        answer = 0;

        for(int i=0;i<12;i++){
            String str = br.readLine();
            for(int j=0;j<6;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        while(true){
            flag = false;
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(arr[i][j] != '@' && arr[i][j] != '.'){
                        if(bfs(i, j)){
                            flag = true;
                            for(int[] a : imsi){
                                arr[a[0]][a[1]] = '@';
                            }
                            //같은 색깔인 블럭을 찾아서 @로 바꾸고 출력하는 곳
                            //print();
                        }
                    }
                }
            }
            erase();
            //@인 부분을 빈칸(.)으로 바꿔 출력하는 곳
            //print();
            answer++;
            if(!flag)
                break;
        }

        System.out.println(answer == 0 ? 0 : answer-1);
    }



    public static void print(){
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("------------------------");
    }

    public static boolean bfs(int x, int y){
        int count = 1;
        visited = new boolean[12][6];
        q = new LinkedList<>();
        imsi = new ArrayList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        imsi.add(new int[]{x, y});
        char cc = arr[x][y];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i=0;i<4;i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6)
                    continue;
                if(!visited[nx][ny] && cc == arr[nx][ny]){
                    visited[nx][ny] = true;
                    count++;
                    imsi.add(new int[]{nx, ny});
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if(count >= 4){
            return true;
        }


        return false;
    }

    public static void erase(){

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(arr[i][j] == '@'){
                    arr[i][j] = '.';
                    minHeight = Math.min(minHeight, i);
                    maxHeight = Math.max(maxHeight, i);
                }
            }
        }

        int cycle = Math.abs(minHeight-maxHeight)+1;

        while(cycle-->0){
            for(int i=11;i>0;i--){
                for(int j=5;j>=0;j--){
                    if(arr[i][j] == '.' && arr[i-1][j] != '.'){
                        arr[i][j] = arr[i-1][j];
                        arr[i-1][j] = '.';
                    }
                }
            }
        }
    }
}