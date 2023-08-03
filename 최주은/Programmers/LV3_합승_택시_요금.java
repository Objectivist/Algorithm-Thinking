import java.util.*;

class Solution {
    public static int res = 10000000;
    public static int[][] map;
    public static int[][] dj;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        s--; 
        a--;
        b--;
        
        map = new int[n][n];
        dj = new int[n][n];
        
        for(int i = 0; i < n; i++) Arrays.fill(map[i], 10000000);
        
        for(int i = 0; i < fares.length; i++){
            int c = fares[i][0] - 1;
            int d = fares[i][1] - 1;
            int f = fares[i][2];
            
            map[c][d] = f;
            map[d][c] = f;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dj[j][i] = map[j][i] == 0 ? 10000000 : map[j][i];
                if(i == j) dj[j][i] = 0;
            }
        }
        
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            while(true){
                int value = Integer.MAX_VALUE;
                int idx = -1;
                
                // 최저 찾기
                for(int j = 0; j < n; j++){
                    if(!visited[j] && dj[i][j] < value) {
                        value = dj[i][j];
                        idx = j;
                    }
                }
                
                // 없으면 종료
                if(value == Integer.MAX_VALUE || idx == -1) break;
                
                for(int j = 0; j < n; j++){
                    dj[i][j] = dj[i][j] < dj[i][idx] + map[idx][j] ? dj[i][j] : dj[i][idx] + map[idx][j];
                }
                
                visited[idx] = true;
            }
        }
        
        for(int i = 0; i < n; i++){
            int fee = dj[s][i] + dj[i][a] + dj[i][b];
            res = res < fee ? res : fee;
        }
        
        return res;
    }
}
