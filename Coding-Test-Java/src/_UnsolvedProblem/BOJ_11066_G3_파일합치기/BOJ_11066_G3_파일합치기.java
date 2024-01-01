

package _UnsolvedProblem.BOJ_11066_G3_파일합치기;

import java.util.*;
import java.io.*;

public class BOJ_11066_G3_파일합치기 {
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

            for (int gap = 1; gap <= n; gap++) {
                for (int start = 1; start + gap <= n; start++) {
                    int end = gap + start;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid+1][end] + sum[end] - sum[start-1]);
                    }
                }
            }
            System.out.println(dp[1][n]);
        } // end :: tc
    }
}