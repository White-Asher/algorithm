package BOJ.DP.BOJ_10942_G4_팰린드롬;

import java.util.*;
import java.io.*;

public class BOJ_10942_G4_팰린드롬 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[][] dp = new boolean[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1칸
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        // 2칸
        for (int i = 1; i <= N - 1; i++) {
            if(arr[i] == arr[i+1]) dp[i][i+1] = true;
        }
        // 3칸 이상
        for (int diff = 2; diff < N; diff++) {
            for (int idx = 1; idx + diff <= N; idx++) {
                if(arr[idx] == arr[idx + diff] && dp[idx + 1][idx + diff -1]) dp[idx][idx + diff] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? "1" : "0").append("\n");
        }

        System.out.println(sb);
    }
}
