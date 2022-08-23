package SSWtest.BOJ.Unsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
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
		input();
		BFS(0,0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 1, false));
		
		visited = new boolean[N][M][2];
		visited[0][0][0] = true; // 벽을 부시지 않은 경우
		visited[0][0][1] = true; // 벽을 부신 경우
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int pointX = point.x;
			int pointY = point.y;
			int pointDistance = point.distance;
			boolean wallBreak = point.wallBreak;
			
			if(pointX == N-1 && pointY == M-1) {
				ans = Math.min(ans, pointDistance);
				continue;
			}
			
			/*
			# 이전에 벽을 부수지 않은 경우 wallBreak == false 
			1. 다음 탐색할 곳이 벽일 때 벽을 안 부쉈으므로(wallBreak = false)이므로 벽 부수고 이동한다 wallBreak = true로 바꿈
			2. 다음 탐색할 곳이 벽이 아닌 경우 방문처리하고 탐색을 계속 진행
			
			# 이전에 벽을 부쉈을 경우 wallBreak == true;
			1. 다음 탐색할 곳이 벽이라면 이미 벽을 부쉈으므로 해당 지점에서 탐색을 종료 -> 큐에 값을 넣지 않음
			2. 벽을 만나지 않은 경우, 방문 처리후 계속 탐색
			*/
			
			for (int d = 0; d < 4; d++) { // 4방향 탐색
				int nx = pointX + dx[d];
				int ny = pointY + dy[d];
				
				if(nx >=0 && ny >=0 && nx < N && ny < M) {
					// 탐색 이전에 벽을 부수지 않으면서 방문하지 않은 곳을 찾았을 때
					if(wallBreak == false && !visited[nx][ny][0]) {
						if(map[nx][ny] == 1) { // 탐색할 지점이 벽이면
							queue.add(new Point(nx, ny, pointDistance+1, true));
							visited[nx][ny][1] = true;
						} else { // 탐색 지점이 벽이 아니면
							queue.add(new Point(nx, ny, pointDistance+1, wallBreak));
							visited[nx][ny][0] = true;
						}
						// 탐색 이전에 벽을 부수고 방문하지 않은 곳을 찾았을 때
					} else if(wallBreak == true && !visited[nx][ny][1]) {
						// 탐색할 지점이 벽이 아니면
						if(map[nx][ny] == 0) {
							queue.add(new Point(nx, ny, pointDistance+1, wallBreak));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		return;
		
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
	}
	
}
	
	/*
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] wallList;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		inputData();
		nobreakWall();
		breakWall();
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void nobreakWall() {
		int[][] cMap = copyMap();
		int[][] visited = new int[N][M];
		move(0,0, visited, cMap);
		
		visited[N-1][M-1] = Integer.MAX_VALUE;
		ans = Math.min(ans, visited[N-1][M-1]);
	}
	
	public static void breakWall() {
		for (int i = 0; i < wallList.length; i++) {
			int[][] cMap = copyMap();
			int wallY = wallList[i][0];
			int wallX = wallList[i][1];
			cMap[wallY][wallX] = 0;
			int[][] visited = new int[N][M];
			visited[N-1][M-1] = Integer.MAX_VALUE;
			move(0,0, visited, cMap);	
			ans = Math.min(ans, visited[N-1][M-1]);
		}
	}
	
	public static void move(int y, int x, int[][] visited, int[][] cMap) {
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {y,x});
		visited[y][x] = 1;
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int qy = q[0];
			int qx = q[1];
			
			for (int d = 0; d < 4; d++) {
				int ny = qy + dy[d];
				int nx = qx + dx[d];
				if(ny >= N || ny < 0 || nx >= M || nx < 0 || cMap[ny][nx] == 1) continue;
					
				if(visited[ny][nx] == 0 || visited[ny][nx] == Integer.MAX_VALUE) {
					visited[ny][nx] = visited[qy][qx] + 1;
					queue.add(new int[] {ny,nx});
				}
				
			}
			
		}
		
	}
	
	public static int[][] copyMap() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) temp[i][j] = map[i][j];
		return temp;
	}
	
	public static void inputData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		int wallCnt = 0;
		wallList = new int[N*M][2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(String.valueOf(str.charAt(j)));
				map[i][j] = input;
				if(input == 1) {
					wallList[wallCnt][0] = i;
					wallList[wallCnt][1] = j;
					wallCnt++;
				}
			}
		}
		Arrays.copyOf(wallList, wallCnt);
	}
	
	
}*/
