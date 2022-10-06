package SSWtest.SWEA.SWEA_2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_TRY1 {
	static StringTokenizer st;
	static int N, ans, originY, originX;
	static int[][] map;
	// 우하 좌하 좌상 우상
	static int[] dy = {1,1,-1,-1};
	static int[] dx = {1,-1,-1,1};
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					check = new boolean[105];
					check[map[i][j]] = true;
					originY = i;
					originX = j;
					DFS(i, j, -1, -1, 0);
				}
			}
			if(ans == 0) ans = -1;
			System.out.printf("#%d %d\n", t , ans);
		}
	}
	
	public static void DFS(int y, int x, int prevY, int prevX, int d) {

		for (int dire = d; dire < 4; dire++) {
				int ny = y + dy[dire];
				int nx = x + dx[dire];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				
				if(nx == prevX && ny == prevY ) {
	    			continue;
	    		}
				
				if(originY == ny && originX == nx) {
					int sum = 0;
					for (int i = 0; i < check.length; i++) {
						if(check[i]) sum++;
					}
					ans = Math.max(ans, sum);
					return;
				}
				
				if(check[map[ny][nx]]) continue;
				
				check[map[ny][nx]] = true;
				DFS(ny, nx, y, x, dire);
				check[map[ny][nx]] = false;
		}

	}
	
}
