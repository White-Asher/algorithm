import java.util.*;

class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int d = 0; d < 4; d++) {
            int ny = h + dy[d];
            int nx = w + dx[d];
            if(ny < 0 || nx < 0 || ny >= board.length || nx >= board[0].length) continue;
            if(board[h][w].equals(board[ny][nx])){
                answer++;
            }
        }
        
        return answer;
    }
}