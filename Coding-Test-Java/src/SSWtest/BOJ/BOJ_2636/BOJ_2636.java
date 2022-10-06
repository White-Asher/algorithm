package SSWtest.BOJ.BOJ_2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int time, leftCheese;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		time = 0;
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulate();
		System.out.println(time);
		System.out.println(leftCheese);
	}

	private static void simulate() {
		// 다 녹을 때 까지 while문
		while (true) {

			// 밖의 공기 확인 (for문돌면서로 바꾸고 바깥공기 영구 적용)
			int[][] copyMap = copyMap();
			if (isAllMelt(copyMap)) break;

			checkOutArea(0, 0, copyMap);

			// 치즈 녹이기
			int[][] melt = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copyMap[i][j] == 1) {
						meltCheese(copyMap, melt, i, j);
					}
				}
			}
			
			// 녹은 것 반영
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = map[i][j] + melt[i][j]; 
				}
			}

			
			leftCheese = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(melt[i][j] == -1) {
						leftCheese++;
					}
				}
			}
			
			time++;
		}

	}
	

	public static void meltCheese(int[][] copyMap, int[][] melt, int x, int y) {		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

			if(copyMap[nx][ny] == -9) {
				melt[x][y] = -1;
			}
		}
	}
	

	public static void checkOutArea(int x, int y, int[][] copyMap) {
		copyMap[x][y] = -9;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)	continue;
			if (copyMap[nx][ny] == 0) checkOutArea(nx, ny, copyMap);
		}
		return;
	}

	// 전부 녹았는지 확인
	public static boolean isAllMelt(int[][] copyMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] >= 1)	return false;
			}
		}
		return true;
	}

	// 맵 복사 (위의 BFS메서드에서 탐색하면 바로 녹여버리기 때문.) 
	public static int[][] copyMap() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}
