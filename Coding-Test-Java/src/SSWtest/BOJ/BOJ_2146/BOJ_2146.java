package SSWtest.BOJ.BOJ_2146;

// 다리만들기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
start 1: 15 / end 2:12
메모리: 293576 KB
실행시간: 344 ms
코드길이: 2859
*/
public class BOJ_2146 {
	
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		
		// 섬 데이터 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 번호 부여
		int index = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					DFS(i, j, index++);
				}
			}
		}
		
		// 섬 출발
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					BFS(i, j);
				}
			}
		}

		System.out.println(ans);
	}
	
	

	// 거리 탐색
	public static void BFS(int x, int y) {
		// 탐색하는 곳 섬 번호 
		int islandNo = map[x][y];
		// 거리측정용 방문배열
		int[][] visited = new int[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int qx = q[0];
			int qy = q[1];
			
			// 4방탐색
			for (int d = 0; d < 4; d++) {
				int nx = qx + dx[d];
				int ny = qy + dy[d];
				
				// 맵 범위 벗어나면 중지
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				// 자기섬 탐색 패스
				
				if(map[nx][ny] == islandNo) continue;

				if(map[nx][ny] > 0) {
					// 섬이 출발한 곳과 다르다
					if(map[nx][ny] != islandNo) {
						// 다른 섬에 도착했다는 뜻
						ans = Math.min(ans, visited[qx][qy]);
						return;
					}
				}
				
				if(map[nx][ny] == 0) {
					// 방문한 곳이 아니면
					if(visited[nx][ny] == 0) {
						// 거리 1 증가
						visited[nx][ny] = visited[qx][qy] + 1;
						queue.add(new int[] { nx, ny });
					}
					
				}

			}
		}
		
		
	}
	private static void DFS(int x, int y, int no) {
		map[x][y] = no;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];	
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny] == 1) {
				map[nx][ny] = no;
				DFS(nx,ny, no);
			}
		}
	}
}