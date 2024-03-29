package SSWtest.SWEA.SWEA_2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
메모리 : 20,568 kb
실행시간 : 130 ms
코드길이 : 2,360
*/

public class SWEA_2115_1_refactor{
	static StringTokenizer st;
	static int N, M, C;
	static int[][] map;
	static int maxProfit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
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
			
			int result = combination();
			System.out.printf("#%d %d\n", t, result);
			
			
		}
	}
	public static int combination() {
		int res = 0;
		int maxNum1 = 0;
		int maxNum2 = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-M+1; j++) {
				maxProfit = 0;
				
				// 부분집합 (시작 x,y좌표, 꿀 수, 꿀의 양, 이익), 첫번째 벌통
				checkGetHoney(i, j, 0, 0, 0);
				maxNum1 = maxProfit;
				maxProfit = 0;
				
				maxNum2 = 0;
				// 첫번째 벌통 부터 M만큼 떨어진 곳에서 탐색 (같은행 탐색)
				for (int j2 = j+M; j2 < N-M+1; j2++) {
					checkGetHoney(i, j2, 0, 0, 0);
					maxNum2 = Math.max(maxNum2,maxProfit);
				}
				
				// 다음 행부터 탐색
				for (int j2 = i+1; j2 < N; j2++) {
					for (int k = 0; k < N-M+1; k++) {
						checkGetHoney(j2, k, 0, 0, 0);
						maxNum2 = Math.max(maxNum2,maxProfit);
					}
				}
				res = Math.max(res, maxNum1+maxNum2);
			}
		}
		
		
		return res;
	}
	
	public static void checkGetHoney(int i, int j, int count, int honeySum, int profit) {
		// 채취한 꿀들이 최대 꿀 넘으면 멈춤
		if(honeySum > C) {
			return;
		}
		
		// 벌통 M개 선택했을 때
		if(count == M) {
			if(maxProfit < profit)
				maxProfit = profit;
			return;
		}
		int curHoney = map[i][j];
		int curProfit = map[i][j] * map[i][j];
		
		// 꿀 선택
		checkGetHoney(i, j+1, count + 1, honeySum + curHoney, profit + curProfit);
		// 꿀 선택안함
		checkGetHoney(i, j+1, count + 1, honeySum , profit);
		
	}
}