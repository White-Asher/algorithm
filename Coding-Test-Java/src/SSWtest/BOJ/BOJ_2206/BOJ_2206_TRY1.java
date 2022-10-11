package SSWtest.BOJ.BOJ_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_TRY1 {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static StringTokenizer st;
	static int ans = Integer.MAX_VALUE;
	
	static class Point{
		int x, y, distance;
		boolean wallBreak;
		
		public Point(int x, int y, int distance, boolean wallBreak) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.wallBreak = wallBreak;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		
		BFS(0,0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void BFS(int i, int j) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(i, j, 1, false));
		
		visited = new boolean[N][M][2]; // 벽을 부순 경우, 부수지 않은 경우 2가지
		visited[i][j][0] = true; // 벽을 부수지 않은 경우
		visited[i][j][1] = true; // 벽을 부순 경우
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int curX = point.x;
			int curY = point.y;
			int curDist = point.distance;
			boolean curWallBreak = point.wallBreak;
			
			// 맵 끝까지 탐색
			if(curX == N - 1 && curY == M - 1) {
				ans = Math.min(ans, curDist);
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(curWallBreak == false && !visited[nx][ny][0]) {
					
					if(map[nx][ny] == 1) {
						queue.add(new Point(nx, ny, curDist+1, true));
						visited[nx][ny][1] = true;						
					} else if(map[nx][ny] == 0){
						queue.add(new Point(nx, ny, curDist+1, curWallBreak));
						visited[nx][ny][0] = true;
					}
					
				} else if(curWallBreak == true && !visited[nx][ny][1]) {
					
					if(map[nx][ny] == 0) {
						queue.add(new Point(nx, ny, curDist+1, curWallBreak));
						visited[nx][ny][1] = true;
					}
				}
				
			}
		}
		
		return;
	}
}
