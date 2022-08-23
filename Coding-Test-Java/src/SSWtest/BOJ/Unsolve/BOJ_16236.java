package SSWtest.BOJ.Unsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int N, sharkX, sharkY;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int sharkSize = 2;
	static int eatCnt = 0;
	static int time = 0;
	static List<Fish> fishList = new LinkedList<>();
	
	static class Fish {
		int x, y, distance;

		public Fish(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		BFS(sharkX, sharkY, 0);
	}
	
	public static void BFS(int x, int y, int dist) {
		Queue<Fish> queue = new ArrayDeque<>();
		queue.add(new Fish(x, y, dist));
		
		int[][] distance = new int[N][N];
		
		while(!queue.isEmpty()) {
			Fish q = queue.poll();
			int qx = q.x;
			int qy = q.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = qx + dx[d];
				int ny = qy + dy[d];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(distance[nx][ny] == 0 && map[nx][ny] <= sharkSize) {
						distance[nx][ny] = distance[qx][qy] + 1;
						queue.add(new Fish(nx, ny, distance[nx][ny]));
						
						if(map[nx][ny] < sharkSize && map[nx][ny] > 0) {
							fishList.add(new Fish(nx, ny, distance[nx][ny]));
						}
						
					}
				}
			}
			
			if (fishList.size() == 0) {
				System.out.println(time);
				return;
			}

			Fish curFish = fishList.get(0);
			for (int i = 1; i < fishList.size(); i++) {
				if (curFish.distance > fishList.get(i).distance) {
					curFish = fishList.get(i);
				} else if (curFish.distance == fishList.get(i).distance) {
					if (curFish.x > fishList.get(i).x)
						curFish = fishList.get(i);
					else if (curFish.x == fishList.get(i).x) {
						if (curFish.y > fishList.get(i).y)
							curFish = fishList.get(i);
					}
				}
			}

			time += curFish.distance;
			eatCnt++;
			map[curFish.x][curFish.y] = 0;
			if (eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
			queue.add(new Fish(curFish.x, curFish.y, 0));
			
		}
		
		
		
	}
	
	
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}		
	}
}
