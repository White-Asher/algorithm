package SSWtest.SWEA.SWEA_2105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_TRY3 {
	static int N, ans;
	static int[][] map;
	static boolean[] visited;
	static StringTokenizer st;
	static int startX, startY;
	// 우하, 좌하, 좌상, 우상
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} //input end
			ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[101];
					visited[map[i][j]] = true;
					startX = i;
					startY = j;
					DFS(i,j,-1,-1,0,0);
				}
			}
			
			System.out.printf("#%d %d\n", t, ans == Integer.MIN_VALUE ? -1 : ans);
		}
	}
	public static void DFS(int x, int y, int prevX, int prevY, int dire, int count) {
		
		for (int d = dire; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(nx == prevX && ny == prevY) continue;
			
			if(nx == startX && ny == startY) {
				ans = Math.max(count+1, ans);
				return;
			}
			
			if(visited[map[nx][ny]]) continue;
			visited[map[nx][ny]] = true;
			DFS(nx, ny, x, y, d, count+1);				
			visited[map[nx][ny]] = false;
			
			
		}
	}
}
