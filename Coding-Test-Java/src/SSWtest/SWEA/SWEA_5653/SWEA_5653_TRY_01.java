package SSWtest.SWEA.SWEA_5653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
메모리: 100,420 kb
실행시간: 243 ms
코드길이: 2,350
*/
public class SWEA_5653_TRY_01 {
	static StringTokenizer st;
	
	static int N, M, K, result;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static final int MAP_SIZE = 1200;
	static PriorityQueue<Cell> cells;
	
	static class Cell implements Comparable<Cell>{
		
		int x, y, lifePower, lifeTime;

		public Cell(int x, int y, int lifePower, int lifeTime) {
		
			this.x = x;
			this.y = y;
			this.lifePower = lifePower;
			this.lifeTime = lifeTime;
		}

		@Override
		public int compareTo(Cell o) {
			if(this.lifeTime != o.lifeTime)
				return this.lifeTime - o.lifeTime;
			return -(this. lifePower - o.lifePower);
			
		}
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[MAP_SIZE][MAP_SIZE];
			cells = new PriorityQueue<Cell>();
			
			result = 0;
			
			for (int i = MAP_SIZE / 2; i < MAP_SIZE/2 + N ; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = MAP_SIZE / 2; j < MAP_SIZE/2 + M ; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input != 0) {
						visited[i][j] = true;
						cells.add(new Cell(i, j, input, input+1));
					}
					if(input*2 > K) result++;
				}
			}
			BFS();
			System.out.printf("#%d %d\n", t, result);
		}
		
		
	}

	private static void BFS() {
		int curLifePower = 0;
		int curLifeTime = 0;
		
		while(curLifeTime <= K) {
			Cell curCell = cells.poll();
			curLifePower = curCell.lifePower;
			curLifeTime = curCell.lifeTime;
			
			if(curLifeTime > K) break;
			
			for (int d = 0; d < 4; d++) {
				int nx = curCell.x + dx[d];
				int ny = curCell.y + dy[d];
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					if(curLifeTime + curLifePower * 2 > K) result++;
					cells.add(new Cell(nx, ny, curLifePower, curLifeTime + curLifePower + 1));
				}
				
			}
			
		}
		
	}
	
}
