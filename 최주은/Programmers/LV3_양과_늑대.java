import java.util.*;

class Solution {
    public static int[] info;
    public static ArrayList<Integer> map[];
    public static int res = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        // 초기화
        this.info = info;
        map = new ArrayList[info.length];
        
        for(int i = 0; i < info.length ; i++){
            map[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map[a].add(b);
        }
        
        // 실행
        dfs(0, 0, 0, new ArrayList<Integer>());
        
        // 결과
        return res;
    }
    
    // s = sheep, w = wolf
    public static void dfs(int idx, int s, int w, ArrayList<Integer> graph){
        if(info[idx] == 0) s++;
        else w++;
        
        if(w >= s) return;
        
        res = res > s ? res : s;
        
        ArrayList<Integer> next = new ArrayList<Integer>();
        next.addAll(map[idx]);
        next.addAll(graph);
        next.remove((Object)idx);
        
        for(int i = 0; i < next.size(); i++){
            dfs(next.get(i), s, w, next);
        }
    }
}
