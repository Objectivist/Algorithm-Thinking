package Programmers;

public class 미로_탈출_명령어 {
    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, -1, 1, 0};
    private char[] dir = {'d', 'l', 'r', 'u'};
    private String answer = null;
    private StringBuilder sb = new StringBuilder();

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //test case 31 대응
        if ((k - Math.abs(x-r) + Math.abs(y-c)) % 2 == 1 || k<Math.abs(x-r) + Math.abs(y-c))
            return "impossible";

        dfs(n, m, x-1, y-1, r-1, c-1, k, 0, "");

//        if (answer == null)
//            return "impossible";

        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, int cnt, String route) {
        if (answer != null) return; //메모리초과로 추가

        if(cnt + Math.abs(x-r) + Math.abs(y-c) > k) return; //시간초과로 추가

        if (cnt == k) {
            if (x == r && y == c) {
//                list.add(route);
//                list.add(sb.toString());
                answer = sb.toString();
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            sb.append(dir[i]);
//            String temp = route;
//            route += dir[i];
            dfs(n, m, nx, ny, r, c, k, cnt + 1, route);
//            route = temp;
            sb.delete(cnt, cnt + 1);
        }
    }
}
