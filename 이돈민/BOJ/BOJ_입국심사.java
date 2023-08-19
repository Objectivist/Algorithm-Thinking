import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_입국심사 {
    static int n, max;
    static long m, answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        max = Integer.MIN_VALUE;
        answer = Long.MAX_VALUE;
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = max * m;

        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;

            for(int i=0;i<arr.length;i++){
                long tmp = mid / arr[i];
                sum += tmp;
                if(sum >= m)
                    break;
            }
            //만약 m명보다 많은 사람이 입국심사대에 통과할 수 있는 경우 end를 낮춰주기
            if(sum >= m){
                answer = Math.min(answer, mid);
                end = mid - 1;
            }else
                start = mid + 1;
        }
        System.out.println(answer);
    }
}
