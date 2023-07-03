package _UnsolvedProblem.BOJ_9465_S1_스티커;

import java.io.*;
import java.util.*;

public class BOJ_9465_스티커 {
    static StringTokenizer st;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // logic
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            // search
            for (int i = 2; i <= n ; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i- 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i- 2]) + arr[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
