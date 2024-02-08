package BOJ.DP.BOJ_15989_G5_123더하기4;

import java.io.*;

public class BOJ_15989_G5_123더하기4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(sol(input)).append("\n");
        }
        System.out.println(sb);
    }

    public static int sol(int input) {
        int[][] dp = new int[4][input+1];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        if(input >= 2) {
            dp[1][2] = 1;
            dp[2][2] = 2;
            dp[3][2] = 2;
        }

        for(int type = 1; type <= 3; type++) {
            for(int number = 3; number <= input; number++) {
                int diff = number - type;
                if(diff < 0) diff = 0;
                dp[type][number] = dp[type-1][number] + dp[type][diff];
            }
        }
        return dp[3][input];
    }
}
