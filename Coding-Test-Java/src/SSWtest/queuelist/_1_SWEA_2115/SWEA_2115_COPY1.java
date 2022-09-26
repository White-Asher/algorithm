package SSWtest.queuelist._1_SWEA_2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_COPY1 {	
	static StringTokenizer st;
	static int N, M, C;
	static int[][] map;
	static int maxProfit;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			maxProfit = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int result = combination(0,0);
			System.out.printf("#%d %d\n", t, result);
		}
	}
	
	// 조합과 부분집합	
	public static int combination(int cnt, int start) {
		int res = 0;
		int maxNum1 = 0;
		int maxNum2 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				maxProfit = 0;
				
				checkGetHoney(i, j, 0, 0, 0);
				maxNum1 = maxProfit;
				maxProfit = 0;
				
				maxNum2 = 0;
				for (int j2 = j+M; j2 < N-M+1; j2++) {
					checkGetHoney(i, j2, 0, 0, 0);
					maxNum2 = Math.max(maxNum2, maxProfit);
				}
				
				// 해당 행 다음부터 탐색
				for (int j2 = i+1; j2 < N; j2++) {
					for (int k = 0; k < N-M+1; k++) {
						checkGetHoney(j2, k, 0, 0, 0);
						maxNum2 = Math.max(maxNum2, maxProfit);
					}
					
				}
				
				res = Math.max(res, maxNum1 + maxNum2);
			}
		}
		
		return res;
	}
	
	// 채취한 꿀들이 최대 꿀 넘으면 멈춘다. 
	public static void checkGetHoney(int i, int j, int count, int honeySum, int profit) {
		if(honeySum > C) {
			return;
		}
		
		if(count == M) {
			if(maxProfit < profit) {
				maxProfit = profit;
			}
			return;
		}
		
		int curHoney = map[i][j];
		int curProfit = map[i][j] * map[i][j];		
		
		checkGetHoney(i, j+1, count+1, honeySum + curHoney, profit + curProfit);
		checkGetHoney(i, j+1, count + 1, honeySum, profit);
	}
	
	
}
