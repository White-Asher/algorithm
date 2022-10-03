package SSWtest.BOJ.BOJ_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_Refactoring {
	
	static char[][] map;
	static int[][] dist;
	static StringTokenizer st;
	static int N, M;
	static int startX, startY, endX, endY;
	static Queue<int[]> devilQueue;
	static Queue<int[]> suyeonQueue;
 	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			dist = new int[N][M];
			
			devilQueue = new ArrayDeque<>();
			suyeonQueue = new ArrayDeque<>();
			
			
			for (int i = 0; i <N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					if(map[i][j] == 'S') {
						suyeonQueue.add(new int[] {i,j});
					} else if (map[i][j] == 'D') {
						endX = i;   endY = j;
					} else if (map[i][j] == '*') {
						devilQueue.add(new int[] {i,j});
					}
				}
			}

			BFS();

			if(dist[endX][endY] == 0) {
				System.out.print("KAKTUS");
			} else {
				System.out.print(dist[endX][endY]);				
			}
		
		
	}
	
	public static void BFS() {
		
		while(true) {
			if(suyeonQueue.size() == 0) break;

			int devilQueueSize = devilQueue.size();
			for (int i = 0; i < devilQueueSize; i++) {
				int[] q = devilQueue.poll();
				int qx = q[0];
				int qy = q[1];
				
				for (int d = 0; d < 4; d++) {
					int nx = qx + dx[d];
					int ny = qy + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(map[nx][ny] == 'X' || map[nx][ny] == '*' || map[nx][ny] == 'D') continue;
					map[nx][ny] = '*';
					devilQueue.add(new int[] {nx,ny});
				}
			}
			
			int suyeonQueueSize = suyeonQueue.size();
			for (int i = 0; i < suyeonQueueSize; i++) {
				int[] q = suyeonQueue.poll();
				int qx = q[0];
				int qy = q[1];
				
				if(qx == endX && qy == endY) return;
				
				for (int d = 0; d < 4; d++) {
					int nx = qx + dx[d];
					int ny = qy + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
					if(dist[nx][ny] != 0) continue;
					dist[nx][ny] += dist[qx][qy] + 1;
					suyeonQueue.add(new int[] {nx,ny});
				}
			}

		}

		
	}
}

