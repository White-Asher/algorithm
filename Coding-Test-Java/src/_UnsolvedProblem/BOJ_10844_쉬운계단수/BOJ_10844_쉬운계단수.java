package _UnsolvedProblem.BOJ_10844_쉬운계단수;

import java.util.Scanner;

public class BOJ_10844_쉬운계단수 {
    public static void main(String[] args) {
        int mod = 1000000000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n+1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        long ans = 0;

        for (int j = 0; j < 10; j++) {
            ans += dp[n][j];
        }

        System.out.println(ans);
    }
}
