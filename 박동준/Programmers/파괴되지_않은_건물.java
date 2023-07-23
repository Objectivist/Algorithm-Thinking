package Programmers;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] degreeSumArr = new int[n+1][m+1];

        for (int[] s : skill) {
            int type = s[0];
            int x1 = s[1];
            int y1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            int degree = s[5];

            if (type == 2) {
                degreeSumArr[x1][y1] += degree;
                degreeSumArr[x1][y2 + 1] -= degree;
                degreeSumArr[x2 + 1][y1] -= degree;
                degreeSumArr[x2 + 1][y2 + 1] += degree;
            } else {
                degreeSumArr[x1][y1] -= degree;
                degreeSumArr[x1][y2 + 1] += degree;
                degreeSumArr[x2 + 1][y1] += degree;
                degreeSumArr[x2 + 1][y2 + 1] -= degree;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                degreeSumArr[i][j] += degreeSumArr[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                degreeSumArr[j][i] += degreeSumArr[j - 1][i];
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = board[i][j] + degreeSumArr[i][j];

                if (board[i][j] >= 1) answer++;
            }
        }

        return answer;
    }
}
