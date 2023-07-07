class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int loc = 0;
        
        for(int i = 0; i < stations.length; i++){
            int len = stations[i] - w - loc - 1;
            answer += len / (2 * w + 1);
            if(len % (2 * w + 1) > 0) answer++;
            loc = stations[i] + w;
        }
        
        if(loc <= n){
            int len = n - loc;
            answer += len / (2 * w + 1);
            if(len % (2 * w + 1) > 0) answer++;
        }
        
        return answer;
    }
}
