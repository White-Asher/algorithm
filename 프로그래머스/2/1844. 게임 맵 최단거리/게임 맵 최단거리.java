import java.util.*;

class Solution {
    static int[][] visit;
    static int N, M;
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visit = new int[N][M];
        visit[0][0] = 1;
        bfs(maps);
        int ans = visit[N-1][M-1] == 0 ? -1 : visit[N-1][M-1];
        return ans;
    }
    
    public static void bfs(int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(maps[ny][nx] == 0) continue;
                if(visit[ny][nx] != 0) continue;
                visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
                q.add(new int[]{ny, nx});
            }
        }
    }
}