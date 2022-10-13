package SSWtest.BOJ.BOJ_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_TRY3 {
	static StringTokenizer st;
	static int[][] map;
	static int[] paper = {0,5,5,5,5,5};
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		DFS(0,0,0);
		System.out.println(ans == Integer.MAX_VALUE ?  -1 : ans);
	}
	
	public static void DFS(int x, int y, int count) {
		if(x == 9 && y == 10) {
			ans = Math.min(ans, count);
			return;
		}
		if(ans <= count) return;
		
		// 끝까지 탐색 했을 때
		if(y == 10) {
			DFS(x+1, 0, count);
			return;
		}
		
		if(map[x][y] == 1) {
			
			for (int size = 5; size >= 1 ; size--) {
				// 붙였다 떼기
				if (paper[size] > 0) {
					if (isGlue(x, y, size)) {
						paper[size]--;
						glue(x, y, size, 0);
						DFS(x, y + 1, count + 1);
						paper[size]++;
						glue(x, y, size, 1);
					}
				}
			}
		}
		else
			DFS(x, y+1, count);
	}
	
	public static void glue(int x, int y, int size, int op) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = op;  
			}
		}
	}
	
	public static boolean isGlue(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(i < 0 || j < 0 || i >= 10 || j >= 10) return false;
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
}
