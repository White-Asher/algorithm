package _UnsolvedProblem.BOJ_1520_G3_내리막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_G3_내리막길 {
    static StringTokenizer st;
    static int M, N;
    static int[][] arr;
    static int[][] dp;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));

    }

    public static int dfs(int y, int x) {
        if(y == M-1 && x == N-1) return 1;

        // 방문한 적 있으므로 해당 지점 리턴함.
        if(dp[y][x] != -1) return dp[y][x];

        // 아직 방문하지 않았으므로 0으로 초기화
        if(dp[y][x] == -1) {
            dp[y][x] = 0;
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
                if(arr[ny][nx] < arr[y][x]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }

        return dp[y][x];

    }
}
