package _UnsolvedProblem.BOJ_12852_1로만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12852_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[N] = 0;
        while(N != 1) {
            // 3으로 나눌 수 있으면 나눔
            if (N % 3 == 0 && N > 3){
                int a = N;
                N /= 3;
                dp[N] = Math.min(dp[N], dp[a] + 1);
            } else if (N % 2 == 0 && N > 2) {
                int a = N;
                N /= 2;
                dp[N] = Math.min(dp[N], dp[a] + 1);
            } else {
                int a = N;
                N -= 1;
                dp[N] = Math.min(dp[N], dp[a] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[1]);
    }
}
