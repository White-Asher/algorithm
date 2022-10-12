package SSWtest.SWEA.SWEA_2112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_TRY3 {
	static int D, W, K;
	static int[][] map;
	static StringTokenizer st;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			
			if(K == 1) ans = 0;
			else {
				if(check()) {
					ans = 0;
				} else {
					DFS(0, 0);
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}

	}
	
	public static void DFS(int y, int count) {
		if(check()) {
			ans = Math.min(ans, count);
			return;
		}
		
		if(count > K || ans < count) return;
		
		if(y == D) return;
		
		int[] copyMap = copyMap(y);
		
		DFS(y+1, count);
		
		for (int x = 0; x < W; x++) map[y][x] = 0;
		DFS(y+1, count+1);
		
		for (int x = 0; x < W; x++) map[y][x] = 1;
		DFS(y+1, count+1);
		
		for (int x = 0; x < W; x++) map[y][x] = copyMap[x]; 

	}
	
	public static int[] copyMap(int y) {
		int[] temp = new int[W];
		for (int i = 0; i < W; i++) {
			temp[i] = map[y][i];
		}
		return temp;
	}
	
	public static boolean check() {
		for (int x = 0; x < W; x++) {
			int count = 1;
			int maxCount = 0;
			outer: for (int y = 0; y < D - 1; y++) {
				if(map[y][x] == map[y+1][x]) {
					count++;
				} else {
					count = 1;
				}
				maxCount = Math.max(count, maxCount);
				if(maxCount == K) continue outer;
			}
			if(maxCount < K) return false;
		}
		return true;
	}
	
//	public static boolean check() {
//		for (int x = 0; x < W; x++) {
//			int count = 1;
//			int maxCnt = 0;
//			outer:for (int y = 0; y < D - 1; y++) {
//				if (map[y][x] == map[y+1][x]) { // 현재 검사 하는 곳과 다음 행과 같은지 비교
//					count++; // 같다면 카운트 증가
//				} else {					
//					// 같은 셀이 아니므로 카운트 1로 초기화 
//					count = 1;
//				}
//				
//				maxCnt = Math.max(maxCnt, count);
//
//				if (count == K) { // 통과. BT5
//					continue outer;
//				}
//				// ex. D = 6, K= 3 011010에서 3번째 인덱스에서 연속된 숫자가 
//				// K보다 작고 3번째 인덱스와 4번째 인덱스 비교시 일치하지 않으면 
//				// 가능성이 없는 해
//				if (y == D - K && maxCnt < K) { // BT6
//					if(map[y][x] != map[y+1][x]) {
//						return false;
//					}
//				}
//				
//			}
//			if(maxCnt < K) return false;
//		}
//		return true;
//	}
}
