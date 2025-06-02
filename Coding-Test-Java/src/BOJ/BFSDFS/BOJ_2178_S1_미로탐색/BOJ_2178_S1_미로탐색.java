package BOJ.BFSDFS.BOJ_2178_S1_미로탐색;

import java.util.*;
import java.io.*;

public class BOJ_2178_S1_미로탐색 {
    static int N, M;
    static int[][] arr;
    static int[][] visit;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new int[N][M];

        for(int i = 0; i < N; i++ ) {

            String[] star = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(star[j]);
            }
        }
        bfs(0, 0);
        System.out.println(visit[N-1][M-1]);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {y, x});
        visit[y][x] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(arr[ny][nx] == 0) continue;
                if(visit[ny][nx] != 0) continue;
                visit[ny][nx] = visit[cy][cx] + 1;
                q.add(new int[]{ny, nx});
            }

        }
    }
}
