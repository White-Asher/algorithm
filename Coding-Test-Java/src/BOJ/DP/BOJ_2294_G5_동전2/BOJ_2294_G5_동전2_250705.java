package BOJ.DP.BOJ_2294_G5_동전2;

import java.util.*;
import java.io.*;

public class BOJ_2294_G5_동전2_250705 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[100001];
        Arrays.fill(dp, 100001);

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            dp[coin[i]] = 1;
        }

        for (int i = 1; i <= k; i++) {
            int temp = 100001;
            for (int j = 0; j < n; j++) {
                if(i - coin[j] < 0) continue;
                int tar = dp[i - coin[j]] + 1;
                temp = Math.min(temp, tar);
            }
            temp = Math.min(temp, dp[i]);
            dp[i] = temp;
        }
        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}
