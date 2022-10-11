package SSWtest.BOJ.BOJ_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
생각해 볼것.
1. 원숭이 이동 4방향, 말의 이동 8방향 => 총 12가지 고려

 */

public class BOJ_1600 {
	static int K, W, H;
	static int[][] map;
	static StringTokenizer st;
	static int ans;
	// 원숭이 이동방향
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// 말 이동방향
	static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2}; 
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
	static boolean[][][] visited;
	static class Point{
		int x, y, count, k;

		public Point(int x, int y, int count, int k) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.k = k;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		BFS(0,0);
		System.out.println(ans ==  Integer.MAX_VALUE ? -1 : ans);
	}

	private static void BFS(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x,y,0,K));
		visited[x][y][K] = true;
		
		while(!queue.isEmpty()) {
			Point curPoint = queue.poll();
			// 맵 전부 탐색하면 리턴
			if(curPoint.x == H - 1 && curPoint.y == W - 1) {
				ans = curPoint.count;
				return;
			}
			
			// 원숭이 4방탐색
			for (int d = 0; d < 4; d++) {
				int nx = curPoint.x + dx[d];
				int ny = curPoint.y + dy[d];
				if(nx < 0 || nx >= H || ny <0 || ny >= W) continue;
				if(visited[nx][ny][curPoint.k] || map[nx][ny] != 0) continue;
				visited[nx][ny][curPoint.k] = true;
				queue.add(new Point(nx, ny, curPoint.count + 1, curPoint.k));
			}
			
			// 이동횟수가 남아있다면..
			if(curPoint.k > 0) {
				for (int d = 0; d < 8; d++) {
					int nx = curPoint.x + hdx[d];
					int ny = curPoint.y + hdy[d];
					if(nx < 0 || nx >= H || ny <0 || ny >= W) continue;
					if(visited[nx][ny][curPoint.k-1] || map[nx][ny] != 0) continue;
					visited[nx][ny][curPoint.k-1] = true;
					queue.add(new Point(nx, ny, curPoint.count + 1, curPoint.k - 1));
				}
			}
		}
	}
	
	
}
