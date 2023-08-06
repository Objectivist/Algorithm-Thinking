class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] sum = new int[board.length][board[0].length];
        
        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int y1 = skill[i][1];
            int x1 = skill[i][2];
            int y2 = skill[i][3];
            int x2 = skill[i][4];
            int d = skill[i][5];
            
            if(type != 1) d *= -1;
            
            sum[y1][x1] += -d;
            if( y2+1 < board.length) sum[y2+1][x1] += d;
            if( x2+1 < board[0].length) sum[y1][x2+1] += d;
            if( y2+1 < board.length && x2+1 < board[0].length) sum[y2+1][x2+1] += -d;
        }
        
        // x 축 누적합
        for(int i = 0; i < board.length; i++){
            for(int j = 1; j < board[i].length; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        
        // y 축 누적합
        for(int i = 0; i < board[0].length; i++){
            for(int j = 1; j < board.length; j++){
                sum[j][i] += sum[j-1][i];
            }
        }
        
        // 합계
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}
