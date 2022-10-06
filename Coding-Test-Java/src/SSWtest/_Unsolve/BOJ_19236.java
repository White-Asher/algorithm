package SSWtest._Unsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19236 {
	static final int MAP_SIZE = 4;
	static int[][] map = new int[MAP_SIZE][MAP_SIZE];
	static int[][] direction = new int[MAP_SIZE][MAP_SIZE];
	static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,0,-1,-1,-1,0,1,1,1};
	
	static int max = Integer.MIN_VALUE;
	static int sharkX, sharkY;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		input();
		DFS(0,0,0);
	}
	
	public static void moveFish() {
		
		for (int fishSize = 1; fishSize <= 16; fishSize++) {
			for (int x = 0; x < MAP_SIZE; x++) {
				for (int y = 0; y < MAP_SIZE; y++) {
					
					if (map[x][y] == fishSize) {
						
						int dire = direction[x][y];
						int direCnt = 0;
						
						if (direCnt < 8) {
							int nx = x + dx[dire];
							int ny = y + dy[dire];

							if (nx < 0 || nx >= MAP_SIZE || ny < 0 || ny >= MAP_SIZE || map[nx][ny] == 0
									|| (nx == sharkX && ny == sharkY)) {
								dire = (dire + 1) % 9;
								if (dire == 0)
									dire = 1;
								direCnt++;
							} else
								swapFish(x, y, nx, ny);
						}
					}

				}
			}
		}

	}
	
	public static int[][] copyMap(){
		int[][] temp = new int[MAP_SIZE][MAP_SIZE];
		for (int i = 0; i < MAP_SIZE; i++) {
			for (int j = 0; j < MAP_SIZE; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
	public static int[][] copyDirection(){
		int[][] temp = new int[MAP_SIZE][MAP_SIZE];
		for (int i = 0; i < MAP_SIZE; i++) {
			for (int j = 0; j < MAP_SIZE; j++) {
				temp[i][j] = direction[i][j];
			}
		}
		return temp;
	}
	
	public static void swapFish(int x, int y, int nx, int ny) {
		int tempFish = map[x][y];
		map[x][y] = map[nx][ny];
		map[nx][ny] = tempFish;
		
		int tempDire = direction[x][y];
		direction[x][y] = map[nx][ny];
		direction[nx][ny] = tempDire;
	}
	
	public static void DFS(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		int[][] copyMap = copyMap();
		int[][] copydirection = copyDirection();
		
		
		moveFish();
		
		
//		for(int i = 1; i <= 4; i++) {
//			
//			int dire = direction[x][y];
//			int nx = x + dx[dire]*i;
//			int ny = y + dy[dire]*i;
//			
//			int eatFish = map[nx][ny];
//			
//			if(nx < 0 || nx >= MAP_SIZE || ny < 0 || ny >= MAP_SIZE || map[nx][ny] == 0) continue;
//			
//			map[x][y] = 0;
//			map[nx][ny] = -1;
//			
//			DFS(nx, ny, cnt+1);
//			
//			map[x][y] =-1;
//			map[nx][ny] = eatFish;
//			
//		}
	}

	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < MAP_SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < MAP_SIZE; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
				direction[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
