class Solution {
    public static int[][] users;
    public static int[] emo;
    public static int maxPlus = Integer.MIN_VALUE;
    public static int maxPrice = Integer.MIN_VALUE;
    public static double[] sales = {0.1, 0.2, 0.3, 0.4};
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emo = emoticons;
        
        combination(0, new int[emoticons.length]);
        
        int[] answer = {maxPlus, maxPrice};
        return answer;
    }
    
    public static void combination(int idx, int[] comb){
        if(idx == comb.length){
            calculation(comb);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            comb[idx] = i;
            combination(idx+1, comb);
        }
    }
    
    public static void calculation(int[] comb){
        int price = 0;
        int plus = 0;
        
        for(int i = 0; i < users.length; i++){
            int sum = 0;
            
            for(int j = 0; j < emo.length; j++){
                // 이모티콘 할인 비율이 사용자가 설정한 비율보다 높을 때
                if(sales[comb[j]] * 100 >= users[i][0]) {
                    sum += emo[j] * (1 - sales[comb[j]]);
                }
            }
            
            // 구입한 이모티콘의 가격이 사용자가 설정한 가격보다 높을 때
            if(sum >= users[i][1]) plus++;
            // 아니라면, 금액에 포함
            else price += sum;
        }
        
        if(maxPlus < plus) {
            maxPlus = plus;
            maxPrice = price;
        }
        
        if(maxPlus == plus) maxPrice = maxPrice < price ? price : maxPrice;
    }
}
