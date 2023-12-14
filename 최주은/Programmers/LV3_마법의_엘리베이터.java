class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int value = storey % 10;
            storey /= 10;
            
            if(value < 10 - value) {
                answer += value;
            }else {
                answer += 10 - value;
                if(value == 5){
                    if(storey % 10 >= 5) storey++;
                } else {
                    storey++;
                }
            }
        }
        
        return answer;
    }
}
