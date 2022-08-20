package BOJ.BFSDFS;

import java.util.Scanner;

public class BOJ_3109_Pro {
	static char[][] map;
	static int ans, R, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][]; //행만 크기를 잡아놓고 한줄 한줄 받아서 배열로 넣을 것임.
		
		for (int i = 0; i < R; i++) map[i] = sc.next().toCharArray();
		
		for (int i = 0; i < R; i++) DFS(i, 0);
		
		System.out.println(ans);
	}
	static int[] dr = {-1,0,1};
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
