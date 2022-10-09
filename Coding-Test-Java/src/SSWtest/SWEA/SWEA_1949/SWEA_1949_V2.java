package SSWtest.SWEA.SWEA_1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1949_V2 {
	static int[][] map;
	static int N, K;
	static StringTokenizer st;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static class Road {
		int y, x, high;
		boolean slope;

		public Road(int y, int x, int high, boolean slope) {
			this.y = y;
			this.x = x;
			this.high = high;
			this.slope = slope;
		}
	}

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			int maxhigh = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxhigh = Math.max(map[i][j], maxhigh);
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxhigh) {
						int[][] visited = new int[N][N];
						visited[i][j] = 1;
						DFS(i, j, false, visited, 1);
					}
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}

	}

	public static void DFS(int y, int x, boolean slope, int[][] visited, int length) {

		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			if (ans < length)
				ans = length;
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visited[ny][nx] != 0) continue;

			// 탐색 하는 곳이 값이 작은 경우
			if (map[y][x] > map[ny][nx]) {
				visited[ny][nx] = visited[y][x] + 1;
				DFS(ny, nx, slope, visited, length + 1);
				visited[ny][nx] = 0;
			}

			// 탐색 하는 곳이 값이 크거나 같은 경우
			else {
				// 경사로 파지 않은 경우
				if (map[y][x] > map[ny][nx] - K) { // 팔 수 있는 경우					
					// 이전 경로까지 경사를 파지 않은 경우에
					if (!slope) {
						// 최소 한으로 깎기 위해 계산.
						int diff = map[ny][nx] - map[y][x] + 1;

						map[ny][nx] -= diff;
						visited[ny][nx] = visited[y][x] + 1;
						DFS(ny, nx, true, visited, length + 1);
						map[ny][nx] += diff;
						visited[ny][nx] = 0;
					}
					// 이미 한번 팠다면 더이상 진행 불가 (조건문 없어도 됨.)

				}

			}

		}

	}

}
