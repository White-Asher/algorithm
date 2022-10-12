package SSWtest.SWEA.SWEA_5653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5653_TRY1 {
	static int N,M,K;
	static StringTokenizer st;
	static final int MAP_SIZE = 400;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Cell implements Comparable<Cell>{
		int y, x, lifePower, lifeTime;
		public Cell(int x, int y, int power, int lifetime) {
			this.x = x;
			this.y = y;
			this.lifePower = power;
			this.lifeTime = lifetime;
		}
		@Override
		public int compareTo(Cell o) {
			if(this.lifeTime == o.lifeTime) return -(this.lifePower - o.lifePower);
			return this.lifeTime - o.lifeTime;
		}
	}
	static PriorityQueue<Cell> queue;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			K = Integer.parseInt(st.nextToken());
			
			visited = new boolean[MAP_SIZE][MAP_SIZE];
			ans = 0;
			queue = new PriorityQueue<>();
			
			for (int i = MAP_SIZE / 2; i < MAP_SIZE / 2 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = MAP_SIZE / 2; j < MAP_SIZE / 2 + M; j++) {
					int input = Integer.parseInt(st.nextToken()); 
					if(input != 0) {
						visited[i][j] = true;
						queue.add(new Cell(i, j, input, input+1));
						if(input * 2 > K) ans++;
					}
					
				}
			} // input - end 
			simul();
			System.out.printf("#%d %d\n", t, ans);
			
		}
	}
	
	public static void simul() {
		
		while(true) {
			
			Cell curCell = queue.poll();
			int curX = curCell.x;
			int curY = curCell.y;
			int curPower = curCell.lifePower;
			int curLifeTime = curCell.lifeTime;
			
			if(curLifeTime > K) return;
			
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				if(curLifeTime + curPower * 2 > K) ans++;
				queue.add(new Cell(nx, ny, curPower, curLifeTime + curPower + 1));
				
			}
		}
	}
}
