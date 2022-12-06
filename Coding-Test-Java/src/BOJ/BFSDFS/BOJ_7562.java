package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    static int n, startX, startY, endX, endY;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            if(startX == endX && startY == endY){
                System.out.println(0);
            } else{
                int result = BFS();
                System.out.println(result);
            }

        }
    }

    public static int BFS(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {startX, startY});
        int[][] visited = new int[n][n];
        visited[startX][startY] = 1;

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int curX = q[0];
            int curY = q[1];
            for (int d = 0; d < 8; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(visited[nx][ny] != 0 ) continue;

                if(nx == endX && ny == endY) {
                    return visited[curX][curY];
                } else{
                    visited[nx][ny] = visited[curX][curY] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }

        }

        return 0;
    }
}
