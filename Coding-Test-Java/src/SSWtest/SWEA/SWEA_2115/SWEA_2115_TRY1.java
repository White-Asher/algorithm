package SSWtest.SWEA.SWEA_2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_TRY1 {
	static int N, M, C;
	static StringTokenizer st;
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

			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = combination();
			System.out.printf("#%d %d\n", t, res);
		}
	}
	
	public static int combination() {
		
		int get1 = 0;
		int get2 = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				
				maxProfit = 0;
				getHoneyCheck(i, j, 0, 0, 0);
				get1 = maxProfit;
				maxProfit = 0;
				
				get2 = 0;
				for (int j2 = j + M; j2 < N - M + 1; j2++) {
					getHoneyCheck(i, j2, 0, 0, 0);
					get2 = Math.max(get2, maxProfit);
				}
				
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N-M+1; j2++) {
						getHoneyCheck(i2, j2, 0, 0, 0);
						get2 = Math.max(get2, maxProfit);
					}
				}
				
				result = Math.max(get1 + get2, result);
			}
		}
		
		return result;
	}
	
	public static void getHoneyCheck(int i, int j, int count, int honeySum, int profit) {
		if(honeySum > C) return;
		if(count == M) {
			maxProfit = Math.max(maxProfit, profit); 
			return;
		}
		getHoneyCheck(i, j+1, count+1, honeySum + map[i][j], profit + map[i][j] * map[i][j]);
		getHoneyCheck(i, j+1, count+1, honeySum, profit);
	}
}
