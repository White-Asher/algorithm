package BOJ.DP.BOJ_5557_G5_1학년;

import java.util.*;
import java.io.*;

public class BOJ_5557_G5_1학년 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // DP 용 배열
        long[][] dp = new long[N + 1][21];
        // 첫번째 수로 만들 수 있는 값은 항상 한개임
        dp[0][arr[0]] = 1;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if(dp[i][j] != 0) {
                    int curPlus = j + arr[i + 1];
                    int curMinus = j - arr[i + 1];

                    if(curPlus >= 0 && curPlus <= 20) {
                        dp[i + 1][curPlus] += dp[i][j];
                    }

                    if (curMinus >= 0 && curMinus <=20){
                        dp[i + 1][curMinus] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[N - 2][arr[N - 1]]);

    }
}
