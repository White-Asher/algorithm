package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	static StringTokenizer st;
	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int x,y,H,W,d;
	static String[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// 알고리즘
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new String[H][W];

			// 맵 데이터 입력
			for (int i = 0; i < H; i++) {
				String temp = br.readLine();

				for (int j = 0; j < W; j++) {
					map[i][j] = String.valueOf(temp.charAt(j));
					if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
						switch(map[i][j]) {
							case "^":
								d = 0;
								break;
							case "v":
								d = 1;
								break;
							case "<":
								d = 2;
								break;
							case ">":
								d = 3;
								break;
						}
						x = j;
						y = i;
					}
				}
			}

			// 기능입력
			int funcNum = Integer.parseInt(br.readLine());
			String[] func = br.readLine().split("");

			for(int i = 0; i < funcNum; i++) {
				String option = func[i];
				function(option);
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	public static void function(String func) {
		switch(func) {
			case "U":
				changeDirAndMove(0);
				break;
			case "D":
				changeDirAndMove(1);
				break;
			case "L":
				changeDirAndMove(2);
				break;
			case "R":
				changeDirAndMove(3);
				break;
			case "S":
				int tx = x;
				int ty = y;
				while(true) {
					if(ty+dy[d] >=0 && ty + dy[d] < H && tx + dx[d] >= 0 && tx + dx[d] < W) {
						tx+=dx[d];
						ty+=dy[d];
						if(map[ty][tx].equals("#")) {
							break;
						}
						else if(map[ty][tx].equals("*")) {
							map[ty][tx] = ".";
							break;
						}

					}
					else {
						break;
					}
				}
		}
	}
	public static void changeDirAndMove(int dire) {
		d = dire;
		direction(dire);
		if(y+dy[dire] >=0 && y + dy[dire] < H && x + dx[dire] >= 0 && x + dx[dire] < W) {
			if(map[y+dy[dire]][x+dx[dire]].equals(".")) {
				map[y][x] = ".";
				y += dy[dire];
				x += dx[dire];
				direction(dire);
			}
		}
	}

	public static void direction(int dire) {
		switch(dire) {
			case 0:
				map[y][x] = "^";
				break;
			case 1:
				map[y][x] = "v";
				break;
			case 2:
				map[y][x] = "<";
				break;
			case 3:
				map[y][x] = ">";
				break;
		}
	}
}