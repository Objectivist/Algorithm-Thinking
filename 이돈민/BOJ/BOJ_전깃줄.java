import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_전깃줄 {
    static int[][] arr;
    static int n, max;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        dp = new int[n];

        dp[0] = 0;

        //LIS에서 첫번째는 1
        dp[1] = 1;
        max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[1];
            }
        });

        for(int i=0;i<n;i++){
            max = Math.max(max, recursive(i));
        }

        System.out.println(n-max);

    }

    //num : 현재 전봇대와 이어진 번호
    public static int recursive(int num){
        if(dp[num] == 0){
            dp[num] = 1;

            for(int i=num+1;i<n;i++){
                //다음 번호의 전봇대에 이어진 번호가
                if(arr[num][1] < arr[i][1]){
                    dp[num] = Math.max(recursive(i) + 1, dp[num]);
                }
            }
        }
        return dp[num];
    }
}
