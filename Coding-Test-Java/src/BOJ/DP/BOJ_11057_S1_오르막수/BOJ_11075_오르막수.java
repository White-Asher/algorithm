package BOJ.DP.BOJ_11057_S1_오르막수;

import java.util.*;
import java.io.*;

public class BOJ_11075_오르막수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 2][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int a = 2; a <= n+1; a++) {
            dp[a][9] = 1;
            for (int i = 8; i >= 0; i--) {
                dp[a][i] = (long) dp[a][i + 1] + (long) dp[a - 1][i];
                dp[a][i] %= 10007;
            }
        }
        System.out.println((long) dp[n + 1][0] % (long) 10007);
    }
}
