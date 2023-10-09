import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_세용액 {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long result = Long.MAX_VALUE;

        long a = 0;
        long b = 0;
        long c = 0;

        for(int i=0;i<n-2;i++){
            int mid = i;
            int start = i+1;
            int end = n-1;
            while(start < end){
                if(Math.abs(arr[start] + arr[mid] + arr[end]) < result){
                    result = Math.abs(arr[start] + arr[mid] + arr[end]);
                    a = arr[mid];
                    b = arr[start];
                    c  = arr[end];
                }

                if(Math.abs(arr[start+1]+arr[mid]+arr[end]) < Math.abs(arr[start]+arr[mid]+arr[end-1])){
                    start++;
                }
                else
                    end--;
            }
        }

        System.out.println(a+" "+b+" "+c);
    }

}
