package BOJ.DP.BOJ_9658_S2_돌게임4;

import java.util.*;
import java.io.*;

public class BOJ_9658_S2_돌게임4_250630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[4+n];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;

        for (int i = 5; i <= n; i++) {
            // 수정 후
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
