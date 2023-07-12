/**
* 최단거리 문제
* 다익스트라 또는 플로이드 와샬 
* 알고리즘 사용하면 될 것 같음
*/

import java.util.*;

class Solution {
    public int MAX_VALUE = 100000000;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> map = new ArrayList<>();
        int[] des = new int[n+1];
        Arrays.fill(des, MAX_VALUE);
        
        int[] res = new int[sources.length];
        for(int i = 0; i <= n; i++) map.add(new ArrayList<>());
        
        for(int i = 0; i < roads.length; i++){
            int[] p = roads[i];
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }        
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        des[destination] = 0;
        
        while(!queue.isEmpty()){            
            int d = queue.poll();
            
            for(int i = 0 ; i < map.get(d).size() ; i++){
                int m = map.get(d).get(i);
                if(des[m] > des[d] + 1 ){
                    des[m] = des[d] + 1;
                    queue.add(m);
                }
            }
        }
        
        for(int i = 0; i < res.length ; i++){
            res[i] = des[sources[i]] == MAX_VALUE ? -1 : des[sources[i]];
        }
        
        return res;
    }
}


/*
import java.util.*;

class Solution {
    public int MAX_VALUE = 100000000;
    
    public int[][] map;
    public int[] des;
    public boolean[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] res = new int[sources.length];
        
        des = new int[n];
        visited = new boolean[n];
        map = new int[n][n];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], m -> MAX_VALUE);
        }
        
        for(int i = 0; i < roads.length; i++){
            int[] p = roads[i];
            map[p[0]-1][p[1]-1] = 1;
            map[p[1]-1][p[0]-1] = 1;
        }
        
        // destionation 기준에서 다익스트라 구하기
        for(int i = 0; i < n; i++){
            des[i] = map[destination-1][i];
        }
        
        des[destination-1] = 0;
        visited[destination-1] = true;
        
        while(true){
            int idx = 0, value = MAX_VALUE;
            
            // 최소 값 찾기
            for(int i = 0; i < n; i++){
                if(des[i] < value && !visited[i]){
                    value = des[i];
                    idx = i;
                }
            }
            
            // 최소 값 없으면 빠져나가기
            if(visited[idx] || value == MAX_VALUE) break;
            
            // 경로 Update
            visited[idx] = true;
            for(int i = 0 ; i < n ; i++){
                if(!visited[i]) des[i] = des[idx] + map[idx][i] < des[i] ? des[idx] + map[idx][i] : des[i];
            }
        }
        
        for(int i = 0; i < res.length ; i++){
            res[i] = des[sources[i]-1] == MAX_VALUE ? -1 : des[sources[i]-1];
        }
        
        return res;
    }
}
*/
