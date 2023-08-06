import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17951 {
    static int max = 0;
    static long score = 0L;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }

        int start = 0;
        int end = max;

        while(start <= end){
            int mid = (start + end) / 2;
            if(solve(mid) <= k){
                end = mid - 1;
            }else
                start = mid + 1;
        }
        System.out.println(end);
    }

    public static int solve(int mid){
        int group = 1;
        score = 0;
        for(int i=0;i<arr.length;i++){
            score += arr[i];
            if(score >= mid){
                group++;
                score = 0;
            }
        }
        return group;
    }


}
