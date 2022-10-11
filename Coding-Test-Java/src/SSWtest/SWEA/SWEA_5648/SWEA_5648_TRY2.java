package SSWtest.SWEA.SWEA_5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5648_TRY2 {
	static StringTokenizer st;
	static int N;
	static class Atom{
		int x, y, dire, potential;

		public Atom(int x, int y, int dire, int potential) {
			this.x = x;
			this.y = y;
			this.dire = dire;
			this.potential = potential;
		}
	}
	static Atom[] atomList;
	static final int MAP_SIZE = 4001;
	static int[][] map = new int[MAP_SIZE][MAP_SIZE];
	static boolean[][] collision = new boolean[MAP_SIZE][MAP_SIZE];
	// 상 하 좌 우
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	static int atomListSize;
	static int ans;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			atomList = new Atom[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dire = Integer.parseInt(st.nextToken());
				int potential = Integer.parseInt(st.nextToken());
				atomList[i] = new Atom( (x+1000)*2, (y+1000)*2 , dire, potential );
				map[atomList[i].x][atomList[i].y] = 1;
			}
			ans = 0;
			solution();
			
			System.out.printf("#%d %d\n", t, ans);
		} // tc end
		
	}// main end

	private static void solution() {
		atomListSize = atomList.length;
		for (int time = 0; time < MAP_SIZE + 5; time++) {
			
			// 원자 리스트 돌면서 원자 이동하기
			for (int i = 0; i < atomListSize; i++) {
				int curX = atomList[i].x;
				int curY = atomList[i].y;
				int curDire = atomList[i].dire;
				
				// 원래 맵에 표시한 것 제거
				map[curX][curY] -= 1;
				
				int nx = curX + dx[curDire];
				int ny = curY + dy[curDire];
				
				// 밖을 나갔던 안 나갔던 일단 좌표 이동
				atomList[i].x = nx;
				atomList[i].y = ny;
				
				// 밖을 나가지 않았으면 이동한 좌표 맵에 표시
				if(!isArea(nx, ny)) {
					map[nx][ny] += 1;
					if(map[nx][ny] >=2 ) {
						collision[nx][ny] = true;
					}
				}

			}
			
			// 나간 애들 원자 리스트에서 제거하기
			for (int index = 0; index < atomListSize; index++) {
				int curX = atomList[index].x;
				int curY = atomList[index].y;
				
				if(isArea(curX, curY)) {
					atomList[index] = atomList[atomListSize - 1];
					atomListSize--;
					index--;
				}
			}
			
			// 겹쳐진 원자들 확인
			for (int index = 0; index < atomListSize; index++) {
				int curX = atomList[index].x;
				int curY = atomList[index].y;
				
				// 겹쳐진 원자라면..
				if(collision[curX][curY]) {
					if(map[curX][curY] == 1) collision[curX][curY] = false;
					
					ans += atomList[index].potential;
					map[curX][curY] -= 1;

					atomList[index] = atomList[atomListSize-1];
					atomListSize--;
					index--;
				}
			}
			
			if(atomListSize == 0) break;
			
		}
		
	} // sol-end (time loop)
	
	public static boolean isArea(int x, int y) {
		return (x >= MAP_SIZE || x < 0 || y >= MAP_SIZE || y < 0);
	}
	
}
