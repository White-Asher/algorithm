import java.util.*;
import java.io.*;

class Solution {
    static boolean[][] check;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        check = new boolean[maps.length][maps[0].length];
        
        int answer = BFS(maps);
        return answer;
    }
    
    public static int BFS(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0,1});
        check[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int qy = q[0];
            int qx = q[1];
            int qc = q[2];
            
            for(int d = 0; d < 4; d++) {
                int ny = qy + dy[d];
                int nx = qx + dx[d];
                if(ny >= maps.length || nx >= maps[0].length || ny < 0 || nx < 0) continue;
                if(maps[ny][nx] == 0) continue;
                if(check[ny][nx]) continue;
                check[ny][nx] = true;
                if(ny == maps.length -1 && nx == maps[0].length-1) {
                    return qc+1;
                }
                queue.add(new int[] {ny, nx, qc+1});
                
            }
        }
        
        return -1;
    }
}