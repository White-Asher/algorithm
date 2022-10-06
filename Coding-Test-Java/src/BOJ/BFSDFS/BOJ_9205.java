package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static int N, startX, startY, destX, destY;
	static StringTokenizer st;
	static int[][] store;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			store = new int[N][2];
			
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			destX = Integer.parseInt(st.nextToken());
			destY = Integer.parseInt(st.nextToken());
			
			if(BFS()) System.out.println("happy");
			else System.out.println("sad");
			
		}
	}

	private static boolean BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {startX, startY});
		boolean[] visited  = new boolean[N];
		
		while(queue.size() != 0) {
			int[] q = queue.poll();
			int qx = q[0];
			int qy = q[1];
			
			if(Math.abs(qx - destX) + Math.abs(qy - destY) <= 20*50) return true;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					int nx = store[i][0];
					int ny = store[i][1];
					int destination = Math.abs(qx - nx) + Math.abs(qy - ny);
					if(destination <= 20*50) {
						visited[i] = true;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}

		return false;
	}
}
