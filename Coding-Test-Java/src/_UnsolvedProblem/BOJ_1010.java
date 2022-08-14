package _UnsolvedProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
	static int N, M;
	static int totalCnt;
	static int[][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			memo = new int[N+1][M+1];
			
			for (int i = 0; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					solution(i, j);
				}
			}
			System.out.println(memo[N][M]);
		}
	}
	
	public static void solution(int i, int j) {
		if(i == 0) memo[i][j] = 1;
		else if(i == 1) memo[i][j] = j;
		else memo[i][j] = memo[i-1][j-1] + memo[i][j-1];
	}
}
