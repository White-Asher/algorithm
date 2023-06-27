package BOJ.DP.BOJ_9461_파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int j = 4; j <= 100; j++) {
            dp[j] = dp[j-2] + dp[j-3];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }
        System.out.println(sb);
    }
}
