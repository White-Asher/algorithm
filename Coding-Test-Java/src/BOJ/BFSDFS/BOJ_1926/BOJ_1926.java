package BOJ.BFSDFS.BOJ_1926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static StringTokenizer st;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] inArr;
    static int N, M, max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        inArr = new int[N][M];
        visited = new boolean[N][M];

        int ans = 0;

        // 값 넣기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                inArr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(inArr[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
        System.out.println(max);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue =  new ArrayDeque<>();
        queue.add(new int[] {x,y});
        visited[x][y] = true;
        int tempnum=1;

        while(queue.size() != 0){
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for (int d = 0; d < 4; d++) {
                int nx = qx + dx[d];
                int ny = qy + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(inArr[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    tempnum++;
                    queue.add(new int[] {nx,ny});
                }

            }

        }
        max = Math.max(tempnum, max);
    }
}