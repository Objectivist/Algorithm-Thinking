import java.util.*;

class Solution {
    public static String res = null;
    public static int n, m, endX, endY, k;
    
    public static int[] dy = {1, 0, 0, -1};
    public static int[] dx = {0, -1, 1, 0};
    // 순서 중요 (사전 순)
    public static String[] r = {"d", "l", "r", "u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.endY = r - 1;
        this.endX = c - 1;
        this.k = k;
        x--;
        y--;
        
        int dist = getDistance(x, y, endX, endY);
        
        // 예제에 의하여 짝수의 경우에만 가능
        if(dist > k || (k - dist) % 2 == 1) return "impossible";
        
        dfs(y, x, 0, "");
        
        return res == null ? "impossible" : res;
    }
    
    public static void dfs(int x, int y, int d, String route){
        // 정답이 나온 경우
        if(res != null) return;
        
        // System.out.printf("%s(%d, %d, %d, %d) : %d\n", route, x, y, endX, endY, (d + getDistance(x, y, endX, endY)));
        
        // K 보다 큰 경우
        if(d + getDistance(x, y, endX, endY) > k) {
            return;
        }
        
        // k에 도달한 경우
        if(d >= k){
            if(x == endX && y == endY) res = route;
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if(xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
            
            dfs(xx, yy, d+1, route+r[i]);
        }
    }
    
    public static int getDistance(int x1, int y1, int x2, int y2) {
        return (int)Math.abs(x1 - x2) + (int)Math.abs(y1 - y2);
    }
}
