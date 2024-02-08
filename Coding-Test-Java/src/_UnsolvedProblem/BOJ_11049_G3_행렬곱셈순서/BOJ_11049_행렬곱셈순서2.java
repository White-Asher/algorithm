package _UnsolvedProblem.BOJ_11049_G3_행렬곱셈순서;

import java.util.*;
import java.io.*;

public class BOJ_11049_행렬곱셈순서2 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][n];

        for (int gap = 1; gap <= n; gap++) {
            for (int start = 0; gap + start < n; start++) {
                int end = gap + start;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid < end ; mid++) {
                    dp[start][end] = Math.min(
                            dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + (arr[start][0] * arr[mid][1] * arr[end][1])
                    );
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
