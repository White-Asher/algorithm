import java.util.*;

class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int MAX_SIZE = 102;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[MAX_SIZE][MAX_SIZE];

        // 테두리 셋팅
        for(int i = 0; i < rectangle.length; i++) {
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int hx = rectangle[i][2] * 2;
            int hy = rectangle[i][3] * 2;
            
            // 좌
            for(int j = ly; j <= hy; j++) {
                if(map[j][lx] == 2) continue;
                map[j][lx] = 1;
            }
            // 우
            for(int j = ly; j <= hy; j++) {
                if(map[j][hx] == 2) continue;
                map[j][hx] = 1;
            }
            
            // 상
            for(int j = lx; j <= hx; j++) {
                if(map[hy][j] == 2) continue;
                map[hy][j] = 1;
            }
            
            // 하
            for(int j = lx; j <= hx; j++) {
                if(map[ly][j] == 2) continue;
                map[ly][j] = 1;
            }
            
            for(int j = ly + 1; j < hy; j++) {
                for(int k = lx + 1; k < hx; k++) {
                    map[j][k] = 2;
                }
            }
        } // end::for
        
        int[][] visited = new int[MAX_SIZE][MAX_SIZE];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{characterY*2, characterX*2});
        visited[characterY*2][characterX*2] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            for(int d = 0; d < 4; d++) {
                int ny = curY + dy[d];
                int nx = curX + dx[d];
                if(ny <= 0 || nx <= 0 || ny >= 102 || nx >= 102) continue;
                if(map[ny][nx] == 0 ||map[ny][nx] == 2) continue;
                if(visited[ny][nx] != 0) continue;
                if(ny == itemY*2 && nx == itemX*2) {
                    
                    return visited[curY][curX] / 2 ;
                }
                visited[ny][nx] = visited[curY][curX] + 1;
                queue.add(new int[]{ny, nx});
            }
            
        }

        
        return (visited[itemY][itemX] -1) / 2;
    }
}