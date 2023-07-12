package BOJ.DP.BOJ_2225_G5_합분해;

import java.io.*;
import java.util.*;

public class BOJ_2225_합분해 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[K+1][N+1];
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }
        if(K >= 2) {
            for (int i = 2; i <= K; i++) {
                dp[i][0] = 1;
            }

            for (int i = 2; i <= K; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j-1]) % 1000000000;
                }
            }
        }
        System.out.println(dp[K][N] % 1000000000);
    }
}
