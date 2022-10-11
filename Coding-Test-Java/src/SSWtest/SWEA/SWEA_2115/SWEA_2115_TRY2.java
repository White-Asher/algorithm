package SSWtest.SWEA.SWEA_2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_TRY2 {
	
	static int N, M, C;
	static StringTokenizer st;
	static int[][] map;
	static int ans;
	static int maxProfit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			// N 벌통 크기, 선택벌통 개수 M, 채취할 수 있는 꿀
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
			
			ans = 0;
			
			search();
			
			System.out.printf("#%d %d\n", t, ans);
			
		} // test-case end
	} // main-end case
	
	
	public static void search() {
		int get1 = 0;
		int get2 = 0;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				
				// 첫 번째 벌꿀 통 선택
				maxProfit = 0;
				getHoney(i, j, 0, 0, 0);
				get1 = maxProfit;
				maxProfit = 0;
				
				get2 = 0;
				// 첫 번째 벌꿀 통 선택이후 같은 줄 선택
				for (int j2 = j + M; j2 < N - M + 1; j2++) {
					getHoney(i, j2, 0, 0, 0);
					get2 = Math.max(maxProfit, get2);
				}
				
				// 다음 줄 벌꿀통 선택.
				for (int i3 = i+1; i3 < N; i3++) {
					for (int j3 = 0; j3 < N - M + 1; j3++) {
						getHoney(i3, j3, 0, 0, 0);
						get2 = Math.max(maxProfit, get2);
					}
				}
				
				result = Math.max(get1 + get2, result);
				
			}
		}
		ans = result;
	}
	
	public static void getHoney(int i, int j, int count, int honeySum, int profit) {
		if(honeySum > C) {
			return;
		}
		
		if(count == M) {
			maxProfit = Math.max(maxProfit, profit);
			return;
		}
		
		// 선택할 때
		getHoney(i, j+1, count + 1, honeySum + map[i][j], profit + map[i][j] * map[i][j]);
		// 선택 안했을 때
		getHoney(i, j+1, count + 1, honeySum, profit); 
		
	}
	
}
