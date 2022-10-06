package SSWtest.BOJ.BOJ_3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
	static char[][] map;
	static int R, C;
	// 우상, 우, 우하
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	
	public static void main(String[] args) throws IOException {
		int cnt = 0;
		input(); // 입력
		
		// 로직
		for (int r = 0; r < R; r++) {
			if(DFS(r,0)) cnt++;
		}
		System.out.println(cnt);		
	}
	
	public static boolean DFS(int r, int c) {
		map[r][c] = 'P';
		if(c == C-1) return true; // 마지막 열에 도착하면 true반환
		
		for (int d = 0; d < 3; d++) { //우상, 우, 우하 탐색
			int nr = r + dr[d];
			int nc = c + dc[d];
			if((nr >= 0 && nr < R) && map[nr][nc] == '.') { // 맵 범위 안에 있고, 건물이 없다면
				if(DFS(nr, nc)) return true;
			}
		}
		return false;
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
	}
}
