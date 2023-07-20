package _UnsolvedProblem.BOJ_11049_G3_행렬곱셈순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049_행렬곱셈순서 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j + i < n; j++) {
                int k = j + n;
                dp[j][k] = Integer.MAX_VALUE;

                for (int l = j; l < k; l++) {
                    dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l+1][k] +arr[j][0] + arr[l][1] + arr[k][1]);
                }
            }
        }
    }
}
