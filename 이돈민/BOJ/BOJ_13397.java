import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//파라메트릭 서치
public class BOJ_13397 {
    static int n, m, max, answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        //최종 구해야 할 구간점수 최대값중 제일 작은 최소값
        answer = Integer.MAX_VALUE;
        arr = new int[n];
        //구간의 점수 -> 구간내의 최소값과 최대값의 차이
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        //하나의 수로 구간이 구성된 경우 최대-최소 = 0
        int start = 0;
        int end = max;

        while(start <= end){
            int mid = (start + end) / 2;
            if(solve(mid) <= m){
                //조건을 만족하는 구간점수 최대값의 최소값 구하기
                //더 작은 중간값으로 조건을 만족할 수 있는지
                answer = Math.min(answer, mid);
                //mid가 5라고 치면 end = 4, start = 0 | 0~4
                end = mid - 1;
            }else
                //6 ~ 10 이렇게 되면 중간값이 커지고 여기서 의문점 하나. 중간값이 커진다고 해서 구간의 갯수가 무조건 늘어나느냐? 모르겠다..주은씨의 설명 필요
                start = mid + 1;
        }
        System.out.println(answer);
    }

    public static int solve(int mid){
        int count = 1;
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            mx = Math.max(mx, arr[i]);
            mn = Math.min(mn, arr[i]);
            int score = mx - mn;
            //구간점수가 정해진 중간값보다 크면 구간을 나눠야 되므로 count++
            if(score > mid){
                count++;
                //구간을 나누고 난 뒤, 최대와 최소값은 나눠진 구간의 인덱스로 초기화
                mx = arr[i];
                mn = arr[i];
            }
        }
        return count;
    }
}
