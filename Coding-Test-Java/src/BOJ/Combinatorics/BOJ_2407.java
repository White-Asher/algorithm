package BOJ.Combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {
	static int n,m;
	static BigInteger[][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		memo = new BigInteger[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				comb(i, j);
			}
		}
		
		System.out.println(memo[n][m]);
		
	}
	
	public static void comb(int n, int m) {
		if(m == n || m == 0) memo[n][m] = new BigInteger("1");
		else memo[n][m] = memo[n-1][m-1].add(memo[n-1][m]);
	}
}
