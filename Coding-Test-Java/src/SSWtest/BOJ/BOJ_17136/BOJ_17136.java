package SSWtest.BOJ.BOJ_17136;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {
	static int[][] map;
	static int[] paper = {0,5,5,5,5,5};
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
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
	
	public static void DFS(int x, int y, int cnt) {

		if(x >= 9 && y >= 10) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(ans <= cnt) return;
		
		if(y > 9) {
			DFS(x+1, 0, cnt);
			return;
		}
			
		if(map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if(paper[i] > 0 && isGlue(x, y, i)) {
					glue(x,y,i,0);
					paper[i]--;
					DFS(x, y+1, cnt+1);
					glue(x,y,i,1);
					paper[i]++;
				}
				
			}
		}
		else DFS(x, y+1, cnt); // 우측 탐색
		
	}
	
	public static void glue(int x, int y, int size, int papaerVal) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = papaerVal;
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
	
}
