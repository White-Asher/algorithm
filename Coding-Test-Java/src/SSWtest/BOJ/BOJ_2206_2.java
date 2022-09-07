package SSWtest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_2 {
	static int N, M;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Location{
		int x, y, distance;
		boolean isWallBreak;
		public Location(int x, int y, int distance, boolean isWallBreak) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.isWallBreak = isWallBreak;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		BFS(0,0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void BFS(int x, int y) {
		boolean[][][] visited = new boolean[N][M][2];
		visited[x][y][0] = true; // 벽을 안깼을 때 방문체크
		visited[x][y][1] = true; // 벽을 깼을 때 방문체크
		
		Queue<Location> queue = new ArrayDeque<>();
		queue.add(new Location(x, y, 1, false));
	
		while(!queue.isEmpty()) {
			Location curLocation = queue.poll();
			int curX = curLocation.x;
			int curY = curLocation.y;
			int curDist = curLocation.distance;
			boolean curIsWallBreak = curLocation.isWallBreak;
			
			if(curX == N-1 && curY == M-1) ans = Math.min(ans, curDist);
			
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 이전까지 벽을 안깼다 && 방문하지 않음
					if (curIsWallBreak == false && !visited[nx][ny][0]) {
						if (map[nx][ny] == 1) { // 벽 일때
							queue.add(new Location(nx, ny, curDist + 1, true));
							visited[nx][ny][1] = true;
						} else { // 벽이 아니라면
							queue.add(new Location(nx, ny, curDist + 1, false));
							visited[nx][ny][0] = true;
						}
					// 이전까지 벽을 깼다 && 방문하지 않음. 
					} else if (curIsWallBreak == true && !visited[nx][ny][1]) {
						if (map[nx][ny] == 0) {
							queue.add(new Location(nx, ny, curDist + 1, true));
							visited[nx][ny][1] = true;
						}
					}
					
				}
			}
		}
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
		}
	}
}
