package _TODO_SOLVE.BOJ_2011_G5_암호코드;

import java.io.*;

// 잘못된 풀이
public class BOJ_2011_G5_암호코드_X {
    private static final int MOD = 1000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] dp = new int[input.length()+1];
        dp[0] = 0;
        if(input.length() >= 1) {
            dp[1] = 1;
        }
        if(input.length() >= 2) {
            if(Integer.parseInt(input.substring(0, 2)) > 26) {
                System.out.println(0);
                System.exit(0);
            }
            dp[2] = 2;
        }

        for (int i = 3; i <= input.length(); i++) {
            if(Integer.parseInt(input.substring(i-2, i)) >= 10 &&
                    Integer.parseInt(input.substring(i-2, i)) <= 26) {
                dp[i] = dp[i-1];
                dp[i] %= MOD;
            }

            if (Integer.parseInt(input.substring(i-1, i)) == 0) continue;

            if (Integer.parseInt(input.substring(i-2, i)) >= 10 &&
                    Integer.parseInt(input.substring(i-2, i)) <= 26) {
                dp[i] = dp[i-1] + dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[input.length()] % MOD);
    }
}
