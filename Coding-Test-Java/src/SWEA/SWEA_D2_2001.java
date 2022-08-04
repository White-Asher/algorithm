package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_D2_2001 {
	static StringTokenizer st;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					int temp = 0;
					for(int a = 0; a < M; a++) {
						for(int b = 0; b < M; b++) {
							temp += map[i+a][j+b];
						}
					}
					ans = Math.max(ans, temp);
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
