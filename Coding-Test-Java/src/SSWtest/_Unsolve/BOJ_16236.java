package SSWtest._Unsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int N;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int time = 0;
	static int sharkSize = 2;
	static int sharkEatCnt = 0;
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		while (true) BFS();
	}

	public static void BFS() {
		List<int[]> fishList = new LinkedList<>();
		int[][] visited = new int[N][N];
		
		while (!queue.isEmpty()) {
			int[] q = queue.poll();

			int qx = q[0];
			int qy = q[1];

			for (int d = 0; d < 4; d++) {
				int nx = qx + dx[d];
				int ny = qy + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == 0) {
					if (map[nx][ny] <= sharkSize) {
						visited[nx][ny] = visited[qx][qy] + 1;
						queue.add(new int[] { nx, ny, visited[nx][ny] });
						if (map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < sharkSize) {
							fishList.add(new int[] { nx, ny, visited[nx][ny] });
						}
					}
				}

			}
		}
		
		chooseFish(fishList);
	}
	
	public static void chooseFish(List<int[]>  fishList) {
		if (fishList.size() == 0) {
			System.out.println(time);
			System.exit(0);
		}

		int[] currentFish = fishList.get(0);
		for (int i = 1; i < fishList.size(); i++) {
			if (fishList.get(i)[2] < currentFish[2]) {
				currentFish = fishList.get(i);
			}

			else if (fishList.get(i)[2] == currentFish[2]) {
				if (currentFish[0] > fishList.get(i)[0]) {
					currentFish = fishList.get(i);
				} else if (currentFish[0] == fishList.get(i)[0]) {
					if (currentFish[1] > fishList.get(i)[1])
						currentFish = fishList.get(i);
				}
			}
		}
		time += currentFish[2];
		sharkEatCnt++;
		map[currentFish[0]][currentFish[1]] = 0;
		if (sharkEatCnt == sharkSize) {
			sharkSize++;
			sharkEatCnt = 0;
		}

		queue.add(new int[] { currentFish[0], currentFish[1], 0 });
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					queue.add(new int[] { i, j, 0 });
					map[i][j] = 0;
				}
			}
		}
	}
}