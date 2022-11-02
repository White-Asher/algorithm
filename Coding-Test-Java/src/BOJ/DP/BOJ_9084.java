package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {
	static int N, target;
	static StringTokenizer st;
	static int[] money, dp;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			money = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			target = Integer.parseInt(br.readLine());
			dp = new int[N+1];
			
			solution();
			
		} //test-case end
	}


	private static void solution() {
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= N; i++) {
			
		}
		
	}
}
