package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
	static StringTokenizer st;
	static int N, M, holeY, holeX, cnt;
	static char[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		int redY = 0;
		int redX = 0;
		int blueY = 0;
		int blueX = 0;
		
		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				switch (map[i][j]) {
				case 'O':
					holeY = i;
					holeX = j;
					break;
				case 'R':
					redY = i;
					redX = j;
					break;
				case 'B':
					blueY = i;
					blueX = j;
					break;
				}
			}
		}
		
		
		
	}
	
	public static int BFS(int redY, int redX, int blueY, int blueX) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { redY, redX, blueY, blueX });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int qredY = q[0];
			int qredX = q[1];
			int qblueY = q[2];
			int qblueX = q[3];
			visited[qredY][qblueX] = true;

			for (int d = 0; d < 4; d++) {

				int nredY = qredY + dy[d];
				int nredX = qredX + dx[d];

				int nblueY = qblueY + dy[d];
				int nblueX = qblueX + dx[d];
				
				if (nredY >= 1 && nredX >= 1 && nredY < N - 1 && nredX < M - 1 && visited[nredY][nredX] == false) {
					
					
					if (visited[nredY][nredX] == false) {
						visited[nredY][nredX] = true;
						
						
						
						if(map[nblueY][nblueX] == '.') {
							
						}
						
						if(nblueY == holeY && nblueX == holeX) {
							return -1;
						}
						
						if (nredY == holeY && nredX == holeX) {
							return cnt;
						}
						queue.offer(new int[] {});
					}

					
				}
				
			}
		}

		return 0;
	}
//	public static int emptyArea(int y, int x, int d) {
//		int ny = y + dy[d];
//		int xy = x + dx[d];
//		if (ny >= 1 && ny >= 1 && nredY < N - 1 && nredX < M - 1 && visited[nredY][nredX] == false)
//		
//		
//		return 0;
//	}

}
