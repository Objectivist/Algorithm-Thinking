import java.util.*;

class Solution {
    public HashMap<String, String> inout = new HashMap<>();
    public int[] vehicle = new int[10000];
    public boolean[] visited = new boolean[10000];
    
    public int[] solution(int[] fees, String[] records) {
        for(String s : records){
            String[] record = s.split(" ");
            String time = record[0];
            String vNum = record[1];
            String io = record[2];
            // System.out.println(time + "/" + vNum + "/" + io);
            
            if("IN".equals(io)){
                // IN 이면 무조건 hashmap에 입력
                inout.put(vNum, time);
                visited[Integer.parseInt(vNum)] = true;
            }else if("OUT".equals(io)){
                // OUT 이면 hashmap 에서 꺼내서 시간 누적
                vehicle[Integer.parseInt(vNum)] += time(inout.get(vNum).split(":"), time.split(":"));
                // 정산 이후 제거
                inout.remove(vNum);
            }
        }
                                                        
        // 빠져나가지 않은 차량 시간 누적
        for(String key : inout.keySet()){
            String value = inout.get(key);
            vehicle[Integer.parseInt(key)] += time(value.split(":"), new String[]{"23", "59"}); 
        };
        
        
        
        ArrayList<Integer> ans = new ArrayList<>();
                                                        
        for(int i = 0; i < visited.length; i++){
            if(visited[i]) ans.add(calc(fees,vehicle[i]));
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public int time(String[] start, String[] end){
        return ((Integer.parseInt(end[0]) * 60) + Integer.parseInt(end[1])) - ((Integer.parseInt(start[0]) * 60) + Integer.parseInt(start[1]));
    }
    
    public int calc(int[] fees, int time){
        // 기본 요금
        int price = fees[1];
        
        // 잔류 시간
        int t = time - fees[0];
        
        // 기본 요금 이상이면 재계산
        if(t > 0) {
            price += (t/fees[2]) * fees[3];
            if(t%fees[2] > 0) price += fees[3];
        }
        
        // System.out.println(price);
        return price;
    }
}

// import java.util.*;

// class Solution {
//     public HashMap<String, String> inout = new HashMap<>();
//     public int[] vehicle = new int[10000];
//     public boolean[] visited = new boolean[10000];
    
//     public int[] solution(int[] fees, String[] records) {
//         for(String s : records){
//             String[] record = s.split(" ");
//             String time = record[0];
//             String vNum = record[1];
//             String io = record[2];
//             System.out.println(time + "/" + vNum + "/" + io);
            
//             if("IN".equals(io)){
//                 // IN 이면 무조건 hashmap에 입력
//                 inout.put(vNum, time);
//                 visited[Integer.parseInt(vNum)] = true;
//             }else if("OUT".equals(io)){
//                 // OUT 이면 hashmap 에서 꺼내서 금액
//                 vehicle[Integer.parseInt(vNum)] += calc(fees, inout.get(vNum).split(":"), time.split(":"));
//                 // 정산 이후 제거
//                 inout.remove(vNum);
//             }
//         }
                                                        
//         // 빠져나가지 않은 차량 정산
//         for(String key : inout.keySet()){
//             String value = inout.get(key);
//            vehicle[Integer.parseInt(key)] += calc(fees, value.split(":"), new String[]{"23", "59"}); 
//         };
        
//         ArrayList<Integer> ans = new ArrayList<>();
                                                        
//         for(int i = 0; i < visited.length; i++){
//             if(visited[i]) ans.add(vehicle[i]);
//         }
        
//         int[] answer = new int[ans.size()];
        
//         for(int i = 0; i < ans.size(); i++){
//             answer[i] = ans.get(i);
//         }
        
//         return answer;
//     }
    
//     public int calc(int[] fees, String[] start, String[] end){
//         // 기본 요금
//         int price = fees[1];
        
//         // 잔류 시간
//         int time = (Integer.parseInt(end[0]) * 60) + Integer.parseInt(end[1]) - (Integer.parseInt(start[0]) * 60) + Integer.parseInt(start[1]) - fees[0];
        
//         // 기본 요금 이상이면 재계산
//         if(time > 0) {
//             price += (time/fees[2]) * fees[3];
//             if(time%fees[2] > 0) price += fees[3];
//         }
        
//         System.out.println(price);
//         return price;
//     }
// }
