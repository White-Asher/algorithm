package _TODO_SOLVE.BOJ_7579_G3_앱;

import java.util.*;
import java.io.*;

public class BOJ_7579_G3_앱 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] app = new int[2][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            app[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            app[1][i] = Integer.parseInt(st.nextToken());
            maxCost += app[1][i];
        }


        // 비용 배열
        int[][] dp = new int[maxCost + 1][N + 1];
        int ans = Integer.MAX_VALUE;
        for (int n = 1; n <= N; n++) {
            for (int c = 0; c <= maxCost; c++) {
                int memory = app[0][n];
                int cost = app[1][n];
                System.out.println("cost : " + cost);
                System.out.println("c-c : " + c);
                if(n == 1) {
                    if(c >= cost) dp[c][n] = memory;
                } else {
                    if(c >= cost) dp[c][n] = Math.max(dp[c][n - 1] , dp[c - cost][n - 1] + memory);
                    else dp[c][n] = dp[c - 1][n];
                }
                if(dp[c][n] >= M)
                    ans = Math.min(ans, dp[c][n]);

            }
        }
        System.out.println(ans);

    }
}
