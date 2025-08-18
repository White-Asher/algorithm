package BOJ.DP.BOJ_11722_S2_가장긴감소하는부분수열;

import java.util.*;
import java.io.*;

public class BOJ_11722_S2_가장긴감소하는부분수열_250807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = Math.max(ans, i);
        }
        System.out.println(ans);

    }
}
