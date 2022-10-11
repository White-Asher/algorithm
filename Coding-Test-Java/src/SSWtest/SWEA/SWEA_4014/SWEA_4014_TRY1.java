package SSWtest.SWEA.SWEA_4014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_TRY1 {
	static StringTokenizer st;
	static int[][] map;
	static int N, X;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			// i -> j
			for (int i = 0; i < N; i++) {
				boolean[] visited = new boolean[N];
				outer: for (int j = 1; j < N; j++) {
					if(map[i][j] - map[i][j-1] >= 2 || map[i][j-1] - map[i][j] >= 2) break outer;
					// up
					if(map[i][j] == map[i][j-1] + 1) {
						for (int j2 = 1; j2 <= X; j2++) {
							int nj = j - j2;
							if(nj < 0 || visited[nj]) break outer; 
							if(map[i][nj] != map[i][j-1]) break outer;
							visited[nj] = true;
						}
					}
					//down
					else if(map[i][j] == map[i][j-1] - 1) {
						for (int j2 = 1; j2 <= X; j2++) {
							int nj = j + j2 - 1;
							if(nj >= N || visited[nj]) break outer; 
							if(map[i][nj] != map[i][j]) break outer;
							visited[nj] = true;
						}
					}
					if (j == N - 1) count++;

				}
			} // i -> j loop end
			
			for (int j = 0; j < N; j++) {
				boolean[] visited = new boolean[N];
				outer: for (int i = 1; i < N; i++) {
					if(map[i][j] - map[i-1][j] >= 2 || map[i-1][j] - map[i][j] >= 2) break outer;
					// up
					if(map[i][j] == map[i-1][j] + 1) {
						for (int i2 = 1; i2 <= X; i2++) {
							int ni = i - i2;
							if(ni < 0 || visited[ni]) break outer; 
							if(map[ni][j] != map[i-1][j]) break outer;
							visited[ni] = true;
						}
					}
					//down
					else if(map[i][j] == map[i-1][j] - 1) {
						for (int i2 = 1; i2 <= X; i2++) {
							int ni = i + i2 - 1;
							if(ni >= N || visited[ni]) break outer; 
							if(map[ni][j] != map[i][j]) break outer;
							visited[ni] = true;
						}
					}
					if (i == N - 1) count++;
				}
			} // i -> j loop end
			
			System.out.printf("#%d %d\n", t, count);
		}
		
	}
	
	
}
