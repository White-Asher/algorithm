import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 0;
        if(n >= 2) dp[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2] * dp[2];
            for (int j = i - 4; j >= 0 ; j-=2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }
        System.out.println(dp[n]);
    }
}
