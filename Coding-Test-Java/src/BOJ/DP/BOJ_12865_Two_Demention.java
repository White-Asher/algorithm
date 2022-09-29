package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_Two_Demention {
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = Math.max(N,K);
		int[][] dp = new int[N+1][K+1];
		int[] W = new int[N+1]; // 무게
		int[] V = new int[K+1]; // 가치
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // 물건 1-N
			for (int j = 1; j <= K; j++) { // 배낭 용량 1-K

				// 물건 i의 무게가 배낭의 임시 용량을 초과하면 
				if(W[i] > j)
					dp[i][j] = dp[i-1][j]; // 물건 i-1까지만 담음
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i]] + V[i]);
			}	
		}
		System.out.println(dp[N][K]);
		
	}
}
