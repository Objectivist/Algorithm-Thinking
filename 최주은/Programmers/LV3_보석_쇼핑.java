// import java.util.*;

// class Solution {
//     public static String[] gems;
//     public static PriorityQueue<Pair> queue = new PriorityQueue<>();
//     public static HashMap<String, Boolean> map = new HashMap<>();
    
//     public static class Pair implements Comparable<Pair>{
//         public int a, b;
//         public Pair(int a, int b){
//             this.a = a;
//             this.b = b;
//         }
        
//         public int compareTo(Pair p){
//             return this.length() - p.length();
//         }
        
//         public int length(){
//             return b-a;
//         }
        
//         public int[] result(){
//             return new int[]{a+1, b};
//         }
//     }
    
//     public int[] solution(String[] gems) {
//         this.gems = gems;
        
//         // 원소들 HashMap에 담기
//         for(int i = 0; i < gems.length; i++){
//             map.put(gems[i],true);
//         }
        
//         // 구간 구하기
//         for(int i = 0; i < gems.length; i++){
//             int left = i;
//             int right = gems.length;
//             while(left < right){
//                 process(left, right);
//                 right--;
//             }
//         }
        
//         Pair p = queue.poll();
//         return p.result();
//     }
    
//     public static void process(int l, int r){
//         HashMap<String, Boolean> m = new HashMap<>();
//         for(int i = l; i < r; i++){
//             m.put(gems[i], true);
//         }
        
//         if(m.size() == map.size()) {
//             queue.add(new Pair(l, r));
//         }
//     }
// }

import java.util.*;

class Solution {
    public static String[] gems;
    public static HashMap<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] gems) {
        int[] res = new int[2];
        int cnt = new HashSet<>(Arrays.asList(gems)).size();
        
        // 구간 구하기
        int length = Integer.MAX_VALUE; // 구간의 크기
        int left = 0;
        for(int right = 0; right < gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            // map에 LEFT에 해당하는 값이 1 이상이면, LEFT 값을 키워서 중복 되는 구간 줄인다.
            while(map.get(gems[left]) > 1){
                map.put(gems[left], map.get(gems[left]) -1);
                left++;
            }
            
            if(map.size() == cnt && length > right-left){
                length = right - left;
                res[0] = left+1;
                res[1] = right+1;
            }
        }
        
        return res;
    }
}
