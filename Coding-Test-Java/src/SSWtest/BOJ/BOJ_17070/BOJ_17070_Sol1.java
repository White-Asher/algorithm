package SSWtest.BOJ.BOJ_17070;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_Sol1 {
	static int[][] map;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		inputData();
		DFS(0,1,1);
		System.out.println(cnt);
		
	}
	
	public static boolean DFS(int r, int c, int state) {
		if(r >= N || c >= N || map[r][c] == 1) return false;
		if(r == N-1 && c == N-1) {
			cnt++;
			return true;
		}
		
		if(state == 1) {
			DFS(r, c+1, 1);
			if(!(r+1 >= N || c+1 >= N)) {
				if(map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0)
				DFS(r+1, c+1, 2);
			}
		}
		
		if(state == 2) {
			DFS(r, c+1, 1);	
			if(!(r+1 >= N || c+1 >= N)) {
				if(map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0)
				DFS(r+1, c+1, 2);
			}
			DFS(r+1, c, 3);
		}
		
		if(state == 3) {
			if(!(r+1 >= N || c+1 >= N)) {
				if(map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0)
				DFS(r+1, c+1, 2);
			}
			DFS(r+1, c, 3);
		}
		return false;
	}
	
	public static int[][] copyMap() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) temp[i][j] = map[i][j];
		return temp;
	}
	
	public static void inputData() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
}
