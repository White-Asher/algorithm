package BOJ.DP.BOJ_2839_설탕배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2839_Sol2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+5];
		int maxVal = 5000/3+1;
		Arrays.fill(dp,maxVal);
		dp[3] = dp[5] = 1;
		for(int i = 6; i <= N+1; i++) dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
		bw.write(String.valueOf(dp[N] >= maxVal ? -1 : dp[N]));
		bw.flush();
		bw.close();
	}
}
