package SSWtest.BOJ.BOJ_3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_TRY1 {
	
	static int R, C;
	static int[] dr = {-1,0,1};
	static char[][] map;
	static int ans;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			DFS(i,0);			
		}
		System.out.println(ans);
	}

	private static boolean DFS(int r, int c) {
		map[r][c] = 'x';
		
		if(c == C - 1) {
			ans++;
			return true;
		}
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + 1;
			if(nr < 0 || nr >= R || map[nr][nc] == 'x') continue;
			if(DFS(nr, nc)) return true;
		}
		
		return false;
	}
}
