package BOJ.DP.BOJ_9656_S5_돌게임2;

import java.util.*;
import java.io.*;

public class BOJ_9656_S5_돌게임2_250707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[4+n];
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;

        for (int i = 4; i <= n; i++) {
            // 수정 후
            if (!dp[i - 1] || !dp[i - 3]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
