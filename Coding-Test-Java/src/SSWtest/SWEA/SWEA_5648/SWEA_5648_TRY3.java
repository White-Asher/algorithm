package SSWtest.SWEA.SWEA_5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5648_TRY3 {
	static StringTokenizer st;
	
	static class Atom{
		int x, y, dire, potential;
		public Atom(int x, int y, int dire, int potential) {
			this.x = x;
			this.y = y;
			this.dire = dire;
			this.potential = potential;
		}
	}
	
	static final int MAP_SIZE = 4000;
	static int[][] visited = new int[MAP_SIZE+1][MAP_SIZE+1];
	static boolean[][] collision = new boolean[MAP_SIZE+1][MAP_SIZE+1];
	static Atom[] atomList;
	static int N;
	// 상 하 좌 우 (상, 하 반전됨)
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1}; 
	static int atomListSize, ans;
	
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
				atomList[i] = new Atom( (x+1000)*2, (y+1000)*2 , dire, potential);
				visited[atomList[i].x][atomList[i].y] = 1;
			}
			ans = 0;
			
			atomListSize = atomList.length;
			simulate();
			
			
			System.out.printf("#%d %d\n", t, ans);
		} // test-case end
	}

	private static void simulate() {
		// 시간을 흐르게 하기
		for (int time = 0; time < MAP_SIZE; time++) {
			
			// 원자들 이동시키기.
			for (int i = 0; i < atomListSize; i++) {
				Atom curAtom = atomList[i];
				int curX = curAtom.x;
				int curY = curAtom.y;
				int curDire = curAtom.dire;
				
				visited[curX][curY] -= 1;

				int nx = curX + dx[curDire];
				int ny = curY + dy[curDire];
				curAtom.x = nx;
				curAtom.y = ny;
				
				if(nx < 0 || nx >= MAP_SIZE || ny < 0 || ny >= MAP_SIZE) {
					curAtom.potential = 0;
					continue;
				}

				visited[nx][ny] += 1;
				if(visited[nx][ny] >= 2) {
					collision[nx][ny] = true;
				}
			}
			
			// 나간거 제거하기
			for (int i = 0; i < atomListSize; i++) {
				Atom curAtom = atomList[i];
				int curPotential = curAtom.potential;
				if(curPotential == 0) {
					atomList[i] = atomList[atomListSize-1];
					atomList[atomListSize-1]=null;
					atomListSize--;
					i--;
				}
			}
			
			
			// 원자 리스트 돌면서 겹쳐지는것 확인하고 제거하기..
//			int sum = 0;
			for (int i = 0; i < atomListSize; i++) {
				Atom curAtom = atomList[i];
				int curX = curAtom.x;
				int curY = curAtom.y;

				if(collision[curX][curY]) {
					if(visited[curX][curY] == 1) collision[curX][curY] = false;
					ans += curAtom.potential;
					atomList[i] = atomList[atomListSize-1];
					atomList[atomListSize-1]=null;
					atomListSize--;
					i--;
					visited[curX][curY] -= 1;
				}
			}
//			ans += sum;
			
			if(atomListSize == 0) break;
		}
		
	}
}
