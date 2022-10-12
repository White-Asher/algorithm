package SSWtest.BOJ.BOJ_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_TRY2 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static class Point{
		int x; 
		int y;
		boolean breakWall;
		int dist;
		public Point(int x, int y, boolean breakWall, int dist) {
		
			this.x = x;
			this.y = y;
			this.breakWall = breakWall;
			this.dist = dist;
		}	
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans;
	
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
		ans = Integer.MAX_VALUE;
		BFS();
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
	}
	
	public static void BFS() {
		boolean[][][] visited = new boolean[N][M][2];		
		visited[0][0][0] = true; // 벽 안깔때
		visited[0][0][1] = true; // 벽 깔 때
		
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0,0,false, 1));
		
		while(!queue.isEmpty()) {
			Point curPoint = queue.poll();
			int curX = curPoint.x;
			int curY = curPoint.y;
			boolean curWallBreak = curPoint.breakWall;
			int curDist = curPoint.dist;
			
			if(curX == N-1 && curY == M-1) {
				ans = Math.min(ans, curDist);
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				
				// 범위 나가면 탐색 중지
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				// 이전까지 벽을 안 깐 상태라면 
				if(curWallBreak == false) {
					// 벽을 안 만났다면?
					if(map[nx][ny] == 0 && !visited[nx][ny][0]) {
						visited[nx][ny][0] = true;
						queue.add(new Point(nx, ny, false, curDist + 1));
					}
					// 벽을 만났다면?
					else if(map[nx][ny] == 1 && !visited[nx][ny][0]) { // 벽까기
						visited[nx][ny][1] = true;
						queue.add(new Point(nx,ny, true, curDist+1));
					}
					// 이전에 이미 벽을 깐 상태라면
				} else if(curWallBreak) {
					// 벽을 안 만났다면?
					if(map[nx][ny] == 0 && !visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						queue.add(new Point(nx, ny, true, curDist + 1));
					}
				}
				
			}

		}
	}
}
