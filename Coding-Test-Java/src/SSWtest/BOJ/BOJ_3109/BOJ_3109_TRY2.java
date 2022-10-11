package SSWtest.BOJ.BOJ_3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_TRY2 {
	static StringTokenizer st;
	static char[][] map;
	static int R, C;
	static int ans = 0;
	static int[] dy = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray(); 
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j];
			}
		}
		
		for (int r = 0; r < R; r++) {
			if(DFS(r, 0)) ans++;
		}
		System.out.println(ans);
	}
	
	private static boolean DFS(int y, int x) {
		
		map[y][x] = '-';
		
		if(x == C-1) {
			return true;
		}		
		
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			if(ny < 0 || ny >= R) continue;
			if(map[ny][x+1] == 'x' || map[ny][x+1] == '-') continue;
			if(DFS(ny, x+1)) return true;
		}
		
		return false;
	}
}
