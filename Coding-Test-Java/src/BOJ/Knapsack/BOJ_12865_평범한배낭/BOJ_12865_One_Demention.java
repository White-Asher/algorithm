package BOJ.Knapsack.BOJ_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_One_Demention {
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = Math.max(N,K);
		int[] dp = new int[max+1];
		int[] W = new int[N+1]; // 무게
		int[] V = new int[K+1]; // 가치
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) { // 물건 1-N
			for (int j = K; j >= 1; j--) { // 배낭 용량 1-K
				if(W[i] <= j) {
					dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
				}
			
			}	
		}
		System.out.println(dp[K]);
		
	}
}
