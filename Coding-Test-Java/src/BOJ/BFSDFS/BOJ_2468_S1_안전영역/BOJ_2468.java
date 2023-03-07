package BOJ.BFSDFS.BOJ_2468_S1_안전영역;

import java.io.*;
import java.util.*;

public class BOJ_2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max, min;
    static int[][] land;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        land = new int[N][N];
        int ans = 1;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, land[i][j]);
                min = Math.min(min, land[i][j]);
            }
        }

        for (int i = min; i < max; i++) {
            visited = new boolean[N][N];
            int temp = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(land[x][y] > i && !visited[x][y]){
                        BFS(x, y, i);
                        temp++;
                    }
                }
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }

    public static void BFS(int x, int y, int h) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (queue.size() != 0) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for (int d = 0; d < 4; d++) {
                int nx = qx + dx[d];
                int ny = qy + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(land[nx][ny] > h) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }

}
