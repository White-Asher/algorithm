package SSWtest.SWEA.SWEA_5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5648_TRY1 {
	
	static StringTokenizer st;
	static final int MAP_SIZE = 4001;
	static int[][] map = new int[MAP_SIZE][MAP_SIZE];
	static boolean[][] collision = new boolean[MAP_SIZE][MAP_SIZE];
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0,0,-1,1};
	static Atom[] atomList;
	static int ans, N;
	
	static class Atom{
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
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dire = Integer.parseInt(st.nextToken());
				int potential = Integer.parseInt(st.nextToken());
				atomList[i] = new Atom((1000 + x) * 2 , (y + 1000) * 2, dire, potential);
				map[atomList[i].y][atomList[i].x] = 1;
			}
			simulate();
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}

	private static void simulate() {
		int atomSize = N;
		for (int time = 0; time < MAP_SIZE; time++) {
			// 원자 이동
			for (int index = 0; index < atomSize; index++) {
				
				int curY = atomList[index].y;
				int curX = atomList[index].x;
				int curDire = atomList[index].dire;
				
				map[curY][curX] -= 1;
				
				int ny = curY + dy[curDire];
				int nx = curX + dx[curDire];
				atomList[index].y = ny;
				atomList[index].x = nx;
				
			
				if(!isNotArea(ny, nx)) {
					map[ny][nx] += 1;
					if(map[ny][nx] >=2) {
						collision[ny][nx] = true;
					}
				}
				
			} // 원자 이동 end
			
			// 원자 제거
			for (int index = 0; index < atomSize; index++) {
				int curY = atomList[index].y;
				int curX = atomList[index].x;
				if(!isNotArea(curY, curX)) {
					atomList[index] = atomList[atomSize-1];
					atomSize--;
					index--;
				}
			} // 원자 제거
			
//			// 원자 충돌 여부 확인
//			for (int index = 0; index < atomSize; index++) {
//				int curY = atomList[index].y;
//				int curX = atomList[index].x;
//				if(map[curY][curX] >= 2) {
//					
//					for (int index2 = 0; index2 < atomSize; index2++) {
//						
//					}
//					ans += atomList[index].potential;
//					map[curY][curX] -= 1;
//					atomList[index] = atomList[atomSize - 1];
//					atomSize--;
//					index--;
//				}
//			}
//			
//			if(atomSize == 0) break;
		}
		
	}

	private static boolean isNotArea(int ny, int nx) {
		// TODO Auto-generated method stub
		return false;
	}
}
