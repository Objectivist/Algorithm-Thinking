import java.util.*;

class Solution {
    public static int[][] map;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = maps[i].charAt(j) == 'X' ? -1 : maps[i].charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] != -1) {
                    int sum = dfs(i, j);
                    if(sum != 0) pq.add(sum);
                }
            }
        }
        
        
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll().intValue();
        }
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
    
    public static int dfs(int y, int x){
        if(y < 0 || y >= map.length || x < 0 || x >= map[0].length || map[y][x] == -1) return 0;        
        
        int sum = map[y][x];
        map[y][x] = -1;
        
        return sum + dfs(y-1, x) + dfs(y+1, x) + dfs(y, x-1) + dfs(y, x+1);
    }
}
