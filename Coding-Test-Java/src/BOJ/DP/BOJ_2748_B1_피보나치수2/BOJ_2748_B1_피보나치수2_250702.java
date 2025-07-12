package BOJ.DP.BOJ_2748_B1_피보나치수2;

import java.util.*;
import java.io.*;

public class BOJ_2748_B1_피보나치수2_250702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+4];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);

    }
}
