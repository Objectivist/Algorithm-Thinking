import java.util.*;

public class Programmers_주차요금계산 {
    public static void main(String[] args) {
        List<Integer> list = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"});
        for(int i : list)
            System.out.print(i+" ");
    }
    public static class Car implements Comparable<Car>{
        String number;
        int cost;
        Car(String number, int cost){
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Car o){
            return Integer.parseInt(this.number)-Integer.parseInt(o.number);
        }
    }
    static Map<String, Integer> IOrecord = new HashMap<>();
    static Map<String, Integer> result = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();
    static List<Car> list = new ArrayList<>();
    public static List<Integer> solution(int[] fees, String[] records) {


        //입*출차 처리
        for(int i=0;i<records.length;i++){
            String[] tmp = records[i].split(" ");
            String timeStr = tmp[0].replace(":", "");

            int hour = Integer.parseInt(timeStr.substring(0, 2));
            int minute = Integer.parseInt(timeStr.substring(2, timeStr.length()));

            //시간 -> 분
            int minutes = hour*60+minute;
            String carNumber = tmp[1];

            String IO = tmp[2];

            if(IO.equals("IN")){
                IOrecord.put(carNumber, minutes);
            }else if(IO.equals("OUT") && IOrecord.containsKey(carNumber)){
                int prevMinutes = IOrecord.get(carNumber);
                IOrecord.remove(carNumber);
                result.put(carNumber, result.getOrDefault(carNumber, 0)+(minutes-prevMinutes));
            }
        }

        //만약 출차되지 않은 차가 있다면 23:59분으로 계산해서 result에 넣어줌
        if(IOrecord.size() > 0){
            for(Map.Entry<String, Integer> entry : IOrecord.entrySet()){
                String carNumber = entry.getKey();
                int prevMinutes = entry.getValue();

                result.put(carNumber, result.getOrDefault(carNumber, 0)+((23*60+59)-prevMinutes));
            }
        }


        for(Map.Entry<String, Integer> entry : result.entrySet()){
            String carNumber = entry.getKey();
            int minutes = entry.getValue();

            //기본 시간(분)
            int defaultTime = fees[0];

            //기본 요금(원)
            int defaultCost = fees[1];

            //단위 시간(분)
            double partTime = fees[2];

            //단위 요금(원)
            int partCost = fees[3];

            if(minutes > defaultTime){
                int totalCost = defaultCost + ((int)Math.ceil((minutes - defaultTime) / partTime)) * partCost;
                list.add(new Car(carNumber, totalCost));
            }else{
                list.add(new Car(carNumber, defaultCost));
            }

        }

        Collections.sort(list);
        for(Car c : list)
            answer.add(c.cost);
        return answer;
    }
}