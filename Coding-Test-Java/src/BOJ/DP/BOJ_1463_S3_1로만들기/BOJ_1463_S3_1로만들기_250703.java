package BOJ.DP.BOJ_1463_S3_1로만들기;

import java.util.*;
import java.io.*;

public class BOJ_1463_S3_1로만들기_250703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] +1 ;
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
