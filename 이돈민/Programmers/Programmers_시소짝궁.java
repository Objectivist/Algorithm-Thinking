import java.util.Arrays;

public class Programmers_시소짝궁 {
    public static void main(String[] args) throws Exception{
        System.out.println(solution(new int[]{100, 180, 360, 100, 270}));
    }

    public static long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        for(int i=0;i<weights.length-1;i++){
            for(int j=i+1;j<weights.length;j++){
                if(weights[i] * 2 < weights[j])
                    break;
                else if(weights[i] == weights[j]){
                    answer++;
                }
                else if(weights[i] * 2 == weights[j]){
                    answer++;
                }
                else if(weights[i] * 3 == weights[j] * 2){
                    answer++;
                }
                else if(weights[i] * 4 == weights[j] * 3){
                    answer++;
                }
            }
        }

        return answer;
    }
}
