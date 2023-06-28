package BOJ.BFSDFS.BOJ_1743_S1_음식물피하기;

import java.io.*;
import java.util.*;

public class BOJ_1743_음식물피하기 {
    static int N, M, K, ans;
    static StringTokenizer st;
    static int[][] arr;
    static int temp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        ans = -999;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            arr[r][c] = 1;
        }
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                temp = 0;
                DFS(i, j, visited);
                ans = Math.max(ans, temp);
            }
        }

        System.out.println(ans);
    }

    public static void DFS(int x, int y, boolean[][] visited) {
        if(x >= N || y >= M || x < 0 || y < 0) return;
        if(arr[x][y] != 1) return;
        if(visited[x][y]) return;
        visited[x][y] = true;
        temp += 1;
        DFS(x + 1, y, visited);
        DFS(x, y + 1, visited);
        DFS(x - 1, y, visited);
        DFS(x, y - 1, visited);
    }
}
