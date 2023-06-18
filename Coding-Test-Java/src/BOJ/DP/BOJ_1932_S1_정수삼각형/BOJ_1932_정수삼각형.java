package BOJ.DP.BOJ_1932_S1_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        // 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];
        if(n >= 2) {
            dp[2][1] = arr[1][1] + arr[2][1];
            dp[2][2] = arr[1][1] + arr[2][2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i][1] = dp[i-1][1] + arr[i][1];
            dp[i][i] = dp[i-1][i-1] + arr[i][i];
            for (int j = 2; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}
