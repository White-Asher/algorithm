package SSWtest.SWEA.SWEA_2112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_TRY2 {
	static StringTokenizer st;
	static int D, W, K;
	static int[][] cell;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
		
			cell = new int[D][W];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 통과 기준이 1이면 더 이상 탐색할 필요가 없다.
			if(K == 1) {
				ans = 0;
			} else { // 통과 기준이 2이상이다.
				if(check()) { // 체크했는데 통과한다면 종료
					ans = 0;
				} else { // 체크했는데 통과하지 못한다면 탐색
					DFS(0,0);
				}
			}
		
			System.out.printf("#%d %d\n", t, ans);
			
		} // test-case end
			
		
	} // main end
	
	
	// 탐색
	public static void DFS(int count, int y) {
		// 기저조건 걸기
		if(check()) {
			ans = Math.min(ans, count);
			return;
		}
		if(count > ans || count > K) return;
		if(y == D) return;
		
		int[] copyMap = copyMap(y);
		
		DFS(count, y+1);
		
		for (int x = 0; x < W; x++) cell[y][x] = 0;
		DFS(count+1, y+1);
		
		for (int x = 0; x < W; x++) cell[y][x] = 1;
		DFS(count+1, y+1);
		
		for (int x = 0; x < W; x++) cell[y][x] = copyMap[x];

	}
	
	// 2차원 배열 복사가 아닌 1차원 배열 복사,..
	public static int[] copyMap(int y){
		int[] temp = new int[W];
		for (int x = 0; x < W; x++) {
			temp[x] = cell[y][x];
		}
		return temp;
	}
	
	// 통과 기준을 만족하는지 검사함
	private static boolean check() {

		outer: for (int x = 0; x < W; x++) {
			int count = 1;
			int maxCount = 0;
			for (int y = 0; y < D-1; y++) {
				if(cell[y][x] == cell[y+1][x]) {
					count++;
				} else {
					count = 1;
				}
				
				maxCount = Math.max(maxCount, count);
				
				if (count == K) { // 통과. BT5
					continue outer;
				}
				
				if(y == D - K && maxCount < K) {
					if(cell[y][x] != cell[y+1][x]) {
						return false;
					}
				}
				
			}	
			if(maxCount < K) return false;
			
		} // for-loop end
		return true;
	}
	
}
