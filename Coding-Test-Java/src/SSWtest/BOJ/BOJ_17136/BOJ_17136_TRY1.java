package SSWtest.BOJ.BOJ_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_TRY1 {
	static int[][] map;
	static int[] paper = {0,5,5,5,5,5};
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0,0);
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
		
	}

	public static void DFS(int r, int c, int count) {
		
		if(r >= 9 && c >= 10) {
			ans = Math.min(ans, count);
			return;
		}
		
		// 이 조건을 걸어주지 않으면 매우 오래 걸릴 가능성이 있음 (가지치기)
		if(ans <= count) return;
		
		if (c > 9) {
			DFS(r+1, 0, count);
			return;
		}
		
		if (map[r][c] == 1) {
			for (int i = 5; i >= 1; i--) {
				
				if (isGlue(r, c, i)) {
					if(paper[i] > 0) {
						paperPastDetach(r, c, i, 0);
						paper[i]--;
						DFS(r, c + 1, count + 1);
						paperPastDetach(r, c, i, 1);
						paper[i]++;						
					}
				}

			}
		}
		else DFS(r, c+1, count);			
		
	}
	
	
	public static void paperPastDetach(int r, int c, int value, int operate) {
		for (int i = r; i < r + value; i++) {
			for (int j = c; j < c + value; j++) {
				map[i][j] = operate;
			}
		}
		
	}
	
	public static boolean isGlue(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i >= 10 || j >= 10) return false;
                if (map[i][j] != 1) return false;
            }
        }
        return true;
	}
	
	
//	public static boolean isGlue(int inputR, int inputC, int value) {
//		if(inputR + value >= 10 || inputC + value >= 10) return false;
//		for (int r = inputR; r < inputR + value; r++) {
//			for (int c = inputC; c < inputC + value; c++) {
//				if(map[r][c] != 1) return false;
//			}
//		}
//		return true;
//	}
	
}
