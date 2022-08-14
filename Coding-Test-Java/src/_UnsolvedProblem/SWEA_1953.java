package _UnsolvedProblem;

import java.io.*;
import java.util.*;

// 탈주범 검거
public class SWEA_1953 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) map[n][m] = Integer.parseInt(st.nextToken());
			}
			
		
			
			
//			System.out.printf("#%d %d", tc, ans);
		}
	}
	
	public void BFS(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {y,x});
		
		while(queue.size() != 0) {
			int qy = queue.poll()[0];
			int qx = queue.poll()[1];
			
		}
	}
}
