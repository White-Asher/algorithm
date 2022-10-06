package SSWtest.BOJ.BOJ_3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_Pro {
	static char[][] map;
	static int ans, R, C;
	static StringTokenizer st;
	static int[] dr = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][]; //행만 크기를 잡아놓고 한줄 한줄 받아서 배열로 넣을 것임.
		
		for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
		for (int i = 0; i < R; i++) DFS(i, 0);
		
		System.out.println(ans);
	}

	public static boolean DFS(int r, int c) {
		map[r][c] = 'x';
//		map[r][c] = '.'; // 실패한 경우도 다시 탐색하게 됨.
		if(c == C-1) {
			++ans;
			return true;
		}
		
		int nr, nc = c + 1;
		
		for (int d = 0; d < 3; d++) {
			nr = r + dr[d];
			if(nr < 0 || nr >= R || map[nr][nc] == 'x') continue;
			if (DFS(nr, nc)) return true;
		}
		
		return false;
	}
}
