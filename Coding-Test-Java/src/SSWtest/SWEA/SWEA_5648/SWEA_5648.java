package SSWtest.SWEA.SWEA_5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5648 {

	static StringTokenizer st;
	static final int MAP_SIZE = 4001;
	static int[][] map = new int[MAP_SIZE][MAP_SIZE];
	static boolean[][] collision = new boolean[MAP_SIZE][MAP_SIZE];
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Atom[] atomList;
	static int ans, N;

	static class Atom {
		int x, y, dire, potential;

		public Atom(int x, int y, int dire, int potential) {
			this.x = x;
			this.y = y;
			this.dire = dire;
			this.potential = potential;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			atomList = new Atom[N];

			ans = 0;
			// x위치 , y 위치 , 이동방향, 보유에너지 K 원자 리스트 넣고 방문배열 (map)에다가 넣기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dire = Integer.parseInt(st.nextToken());
				int potential = Integer.parseInt(st.nextToken());
				atomList[i] = new Atom((x + 1000) * 2, (y + 1000) * 2, dire, potential);
				map[atomList[i].x][atomList[i].y] = 1;
			}
			simultate();
			System.out.printf("#%d %d\n", t, ans);
		}

	}

	// 원자가 다 없을 때 까지 시뮬레이션 한다.
	public static void simultate() {

		// 원자 수
		int atomSize = N;
		// 4000번만큼 반복
		for (int time = 0; time < MAP_SIZE + 5; time++) {
			// 원자들 이동
			for (int index = 0; index < atomSize; index++) {

				int curX = atomList[index].x;
				int curY = atomList[index].y;
				int curDire = atomList[index].dire;
				
				map[curX][curY] -= 1;

				int nx = curX + dx[curDire];
				int ny = curY + dy[curDire];

				// 맵 밖을 나가면 없애버리기
				if (isNotArea(nx, ny)) {
					// 해당 원소 없애고 맨 마지막 원소를 집어넣음
					atomList[index] = atomList[atomSize - 1];
					atomSize--;
					index--;
				}
				// 맵 밖을 안 나갔다면 이동하기
				else {
					atomList[index].x = nx;
					atomList[index].y = ny;
					map[nx][ny] += 1;

					if (map[nx][ny] >= 2) {
						collision[nx][ny] = true;
					}
				}

			}
			
			// 원자 충돌 여부 확인
			for (int index = 0; index < atomSize; index++) {
				int curX = atomList[index].x;
				int curY = atomList[index].y;
				
				if(collision[curX][curY] == true) {
					if(map[curX][curY] == 1) collision[curX][curY] = false;
					
					ans += atomList[index].potential;
					map[curX][curY] -= 1;
					atomList[index] = atomList[atomSize - 1];
					atomSize--;
					index--;
				}
				
			}
			
			if(atomSize == 0) break;

		}

	}

	public static boolean isNotArea(int x, int y) {
		return (x >= 4000 || y >= 4000 || x < 0 || y < 0);
	}
}