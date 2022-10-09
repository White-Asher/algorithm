package SSWtest.SWEA.SWEA_1249_LIVE_Nsswtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
메모리: 37,456 kb -> 39244 kb
실행시간: 167 ms -> 141 ms
코드길이: 1,682 -> 1,652
*/

public class SWEA_1249 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int N, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
				} 
			}
			BFS();
			System.out.printf("#%d %d\n", t, ans);
		}
	}
	
	public static void BFS() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		queue.add(new int[] {0,0,0});
		visited[0][0] = true;
		
		while(queue.size()!=0) {
			int[] q = queue.poll();
			int qy = q[0];
			int qx = q[1];
			int qcost = q[2];
			
			if(qy == N-1 && qx == N-1) {
				ans = qcost;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = qy + dy[d];
				int nx = qx + dx[d];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx]) continue;
				visited[ny][nx] = true;
				queue.add(new int[] {ny,nx, qcost + map[ny][nx]});
			}
			
		}
	}
}
