package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class 로봇이_지나간_경로 {
    static int H;
    static int W;

    static char[][] map;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static char[] direction = {'<', '^', '>', 'v'};

    static StringBuilder sb;

    private static void dfs(int x, int y, char dir) {
        int n1x, n1y;
        for (int i = 0; i < 4; i++) {
            n1x = x + dx[i];
            n1y = y + dy[i];

            if (n1x < 0 || n1x >= H || n1y < 0 || n1y >= W)
                continue;

            if (map[n1x][n1y] == '.')
                continue;

            if (map[n1x][n1y] == '#') {
                int n2x = 0, n2y = 0;
                switch (i) {
                    case 0: // '<'
                        if (dir == '<') {
                            sb.append("A");
                        } else if (dir == '^') {
                            sb.append("LA");
                        } else if (dir == 'v') {
                            sb.append("RA");
                        }
                        n2x = x;
                        n2y = y - 2;
                        break;
                    case 1: // '^'
                        if (dir == '^') {
                            sb.append("A");

                        } else if (dir == '>') {
                            sb.append("LA");
                        } else if (dir == '<') {
                            sb.append("RA");
                        }
                        n2x = x - 2;
                        n2y = y;
                        break;
                    case 2: // '>'
                        if (dir == '>') {
                            sb.append("A");
                        } else if (dir == 'v') {
                            sb.append("LA");
                        } else if (dir == '^') {
                            sb.append("RA");
                        }
                        n2x = x;
                        n2y = y + 2;
                        break;
                    case 3: // 'v'
                        if (dir == 'v') {
                            sb.append("A");
                        } else if (dir == '<') {
                            sb.append("LA");
                        } else if (dir == '>') {
                            sb.append("RA");
                        }
                        n2x = x + 2;
                        n2y = y;
                        break;
                }
                map[n1x][n1y] = '.';
                map[n2x][n2y] = '.';
                dfs(n2x, n2y, direction[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '#') {
                    char dir = 0;
                    int cnt = 0;
                    int nx, ny;
                    for (int k = 0; k < 4; k++) {
                        nx = i + dx[k];
                        ny = j + dy[k];

                        if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                            continue;

                        if (map[nx][ny] == '.')
                            continue;

                        switch (k) {
                            case 0:
                                dir = '<';
                                break;
                            case 1:
                                dir = '^';
                                break;
                            case 2:
                                dir = '>';
                                break;
                            case 3:
                                dir = 'v';
                                break;
                        }
                        cnt++;
                    }
                    if (cnt == 1) {

                        dfs(i, j, dir);
                        System.out.println((i + 1) + " " + (j + 1));
                        System.out.println(dir);
                        System.out.println(sb.toString());

                        return;
                    }
                }
            }
        }
    }
}
