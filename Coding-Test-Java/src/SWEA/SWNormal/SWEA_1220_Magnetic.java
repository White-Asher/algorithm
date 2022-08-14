package SWEA.SWNormal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 알고리즘
		for (int tc = 1; tc <= 10; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];

			// 맵 데이터 입력
			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 로직
			int ans = 0;
			for (int x = 0; x < size; x++) {
				boolean flag = true;
				for (int y = 0; y < size; y++) {
					if (flag) {
						if (map[y][x] == 1) {
							flag = false;
						}
					} else {
						if (map[y][x] == 2) {
							flag = true;
							ans++;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
