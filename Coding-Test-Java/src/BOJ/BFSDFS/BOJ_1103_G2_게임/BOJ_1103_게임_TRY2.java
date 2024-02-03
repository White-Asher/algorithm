package BOJ.BFSDFS.BOJ_1103_G2_게임;

import java.util.*;
import java.io.*;

public class BOJ_1103_게임_TRY2 {
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] dp;
    static int max;
    static boolean checkCycle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = input.charAt(j);
                if(temp == 'H') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = Integer.parseInt(String.valueOf(temp));
                }
            }
        }

        dfs(0, 0, 1);
        System.out.println(checkCycle ? "-1" : max);
    }

    private static void dfs(int y, int x, int cnt) {
        dp[y][x] = cnt;
        max = Math.max(max, cnt);
        int distance = map[y][x];

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d] * distance;
            int nx = x + dx[d] * distance;
            if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == -1) continue;
            if(visited[ny][nx]) {
                checkCycle = true;
                return;
            }

            if(dp[ny][nx] > cnt) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, cnt+1);
            visited[ny][nx] = false;
        }
    }
}
