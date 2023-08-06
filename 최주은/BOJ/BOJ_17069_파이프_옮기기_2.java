import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static boolean[][] map;
    public static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        dp = new long[N+1][N+1][3]; // 가로, 세로, 대각선

        // map 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        dp[1][2][0] = 1; // 첫 시작 점

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if(map[i][j]) continue;

                // 가로 = 가로 + 대각선
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];

                // 세로 = 세로 + 대각선
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];

                // 대각선 = 가로 + 세로 + 대각선
                if (map[i - 1][j]|| map[i][j - 1]) continue; // 대각선으로 놔둘 땐 목표 지점의 좌, 상 부분이 비어 있어야 함.....
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}
