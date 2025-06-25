package BOJ.DP.BOJ_9465_S1_스티커;

import java.io.*;
import java.util.*;

public class BOJ_9465_S1_스티커_250625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int[][] arr = null;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[2][n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            int [][] dp = new int[3][n+1];

            dp[0][0] = arr[0][0]; // 위에꺼 뗌
            dp[1][0] = arr[1][0]; // 아래꺼 뗌
            dp[2][0] = 0;         // 둘다 안뗌

            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + arr[0][i];  // 이번에 위에꺼 뗄거라면, 이전꺼 아래꺼 떼거나 아예 안떼거나 중 큰값으로 선택
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[1][i];  // 마찬가지로 아래꺼 뗄거면, 이전거 위에꺼 떼너아 아예 안떼거나 중 큰값으로 선택
                dp[2][i] = Math.max(dp[2][i-1] ,Math.max(dp[0][i-1], dp[1][i-1])); // 이건, 셋 상태중 가장 큰 값으로 선택해야함.
            }

            int ans = Math.max(dp[0][n-1], dp[1][n-1]);
            ans = Math.max(ans, dp[2][n-1]); // 그냥 최대값 구하기

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
