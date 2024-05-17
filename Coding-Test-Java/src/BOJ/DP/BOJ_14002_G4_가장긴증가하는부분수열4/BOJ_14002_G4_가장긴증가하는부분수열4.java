package BOJ.DP.BOJ_14002_G4_가장긴증가하는부분수열4;

import java.util.*;
import java.io.*;

public class BOJ_14002_G4_가장긴증가하는부분수열4 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");

        int maxLen = result;

        Stack<Integer> stack = new Stack<>();
        for (int i = n; i > 0; i--) {
            if(maxLen == dp[i]) {
                stack.push(arr[i]);
                maxLen--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
}
