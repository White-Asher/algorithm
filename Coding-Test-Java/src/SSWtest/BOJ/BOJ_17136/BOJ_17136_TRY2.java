package SSWtest.BOJ.BOJ_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_TRY2 {
	static int[][] map;
	static StringTokenizer st;
	static int[] paper = {0,5,5,5,5,5};
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0,0);
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}

	private static void DFS(int r, int c, int count) {
		
		// 전체 탐색하면 DFS끝
		if(r >= 9 && c >=10) {
			ans = Math.min(ans, count);
			return;
		}
		
//		if(ans <= count) return;
		
		// 가로 끝까지 탐색하면 다음 줄 첫번째 가로 탐색
		if(c >= 10) {
			DFS(r+1, 0, count);
			return;
		}
		
		// 해당 좌표 탐색
		if(map[r][c] == 1) {
			for (int size = 5; size >= 1; size--) {
				if(isGlue(r, c, size)) {
					if(paper[size] > 0) {
						glue(r, c, size, 0);
						paper[size]--;
						DFS(r, c+1, count+1);
						glue(r, c, size, 1);
						paper[size]++;
					}
				} 
			}
		} else {
			DFS(r, c+1, count);
		}

	}

	private static void glue(int r, int c, int size, int i) {
		for (int i1 = r; i1 < r + size; i1++) {
			for (int j2 = c; j2 < c + size; j2++) {
				map[i1][j2] = i;
			}
		}
		
	}

	// 해당 지점 붙일 수 있는지 확인한다.
	private static boolean isGlue(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (i >= 10 || j >= 10) return false;
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
}
