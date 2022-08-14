package SWEA.SWNormal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder {
	static final int MAP_SIZE = 100;
	static int x, y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[MAP_SIZE][MAP_SIZE];

			for (int i = 0; i < MAP_SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < MAP_SIZE; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						y = i;
						x = j;
					}
				}
			}

			while (y > 0) {
				// 좌측 탐색
				if ( x - 1 >= 0 &&  map[y][x - 1] == 1) {
					while (x - 1 >= 0 && map[y][x - 1] == 1) {
						x--;
					}
				}
				// 우측 탐색
				else if ( x + 1 < MAP_SIZE && map[y][x + 1] == 1) {
					while (x + 1 < MAP_SIZE && map[y][x + 1] == 1) {
						x++;
					}
				}
				y--;
			}
			System.out.printf("#%d %d\n", T, x);
		}
	}
}
