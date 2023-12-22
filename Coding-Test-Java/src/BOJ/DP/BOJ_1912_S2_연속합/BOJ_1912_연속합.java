package BOJ.DP.BOJ_1912_S2_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            int inp = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1] + inp, inp);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
