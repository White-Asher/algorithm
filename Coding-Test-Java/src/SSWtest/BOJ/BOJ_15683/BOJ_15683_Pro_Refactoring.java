package SSWtest.BOJ.BOJ_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_Pro_Refactoring {
	
	static int N, M, ans = Integer.MAX_VALUE;
	static List<CCTV> cctvList;
	static StringTokenizer st;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};  // 90도 시계방향으로 진행(상우하좌)
	static int[] dc = {0, 1, 0, -1};
	
	// CCTV 번호에 해당하는 기본적으로 설정된 방향 
	static int[][] dir = { {}, {1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3} };
	static int[] dCnt = {0, 4, 2, 4, 4, 1};
	
	static class CCTV {
		int r, c, d;
		CCTV(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve(0, map);
		System.out.println(ans);
	}
	
	private static void solve(int idx, int[][] map) {
		if (idx == cctvList.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) cnt++; 
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		CCTV cctv = cctvList.get(idx);
		for (int d = 0; d < dCnt[cctv.d]; d++) {  // 회전
			int[][] copyMap = mapCopy(map);
			
			for (int i = 0; i < dir[cctv.d].length; i++) {  // cctv의 종류가 가지고 있는 방향으로 체크
				int nd = (dir[cctv.d][i] + d) % 4;
				int nr = cctv.r;
				int nc = cctv.c;
				
				while (true) {
					nr += dr[nd];
					nc += dc[nd];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;  // 범위 밖에 나간 경우
					if (copyMap[nr][nc] == 6) break;  // 벽을 만난 경우
					copyMap[nr][nc] = 9;
				}
				
			}
			
			solve(idx + 1, copyMap);
		}
	}	

	static int[][] mapCopy(int[][] map) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) copy[i] = map[i].clone();
		return copy;
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cctvList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {  // CCTV
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
	}
}
