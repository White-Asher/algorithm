package _UnsolvedProblem.BOJ_11066_G3_파일합치기;

import java.util.*;
import java.io.*;

public class BOJ_11066_파일합치기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // start :: tc
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[][] dp = new long[n+1][n+1];
            long[] sum = new long[n+1];
            sum[0] = 0;

            for (int i = 1; i <= n; i++) {
                long input = Long.parseLong(st.nextToken());
                sum[i] += sum[i-1] + input;
            }

            dp[0][0] = 0;

            for (int end = 2; end <= n; end++) {
                for (int start = end - 1; start > 0; start--) {
                    dp[start][end] = Long.MAX_VALUE;
                    for (int target = start; target < end; target++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][target] + dp[target + 1][end]);
                    }
                    dp[start][end] += sum[end] - sum[start - 1];
                }
            }
            System.out.println(dp[1][n]);
        } // end :: tc
    }
}
