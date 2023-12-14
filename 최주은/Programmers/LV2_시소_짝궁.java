class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] cntWeight = new long[1001];
        long[] mulWeight = new long[4001];
        
        for(int i = 0; i < weights.length; i++){
            int weight = weights[i];
            int w2 = weight * 2;
            int w3 = weight * 3;
            int w4 = weight * 4;
            
            // 앞선 사람이 같은 무게를 지녔을 때 Count
            answer += mulWeight[w2];
            answer += mulWeight[w3];
            answer += mulWeight[w4];
            
            // 만약 같은 무게를 가진 사람이 존재 한다면 3배가 되므로 2를 빼준다.
            if(cntWeight[weight] > 0){
                answer -= cntWeight[weight] * 2;
            }
            
            cntWeight[weight]++;
            mulWeight[w2]++;
            mulWeight[w3]++;
            mulWeight[w4]++;
        }
        
        return answer;
    }
}

/*
예시 ) 720
100 200 300 400
180 360 540 720
360 720 1080 1440
100 200 300 400
270 540 810 1080
240 480 720 960
*/
