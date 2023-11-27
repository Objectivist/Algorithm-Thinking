import java.util.*;

class Solution {
    public boolean[] visited;
    public ArrayList<Integer> list = new ArrayList<>();
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        
        for(int i = 0; i < cards.length; i++){
            list.add(dfs(cards, i));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = list.get(0)* list.get(1);
        return answer;
    }

    public int dfs(int[] cards, int idx){
        if(visited[idx]) return 0;
        visited[idx] = true;
        return dfs(cards, cards[idx]-1) + 1;
    }
}
