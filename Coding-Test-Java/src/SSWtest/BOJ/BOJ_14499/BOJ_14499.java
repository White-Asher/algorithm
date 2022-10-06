package SSWtest.BOJ.BOJ_14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
	static final int DICE_NUMBER = 6;
	// 위:1 , 아래:4, 좌:2, 우:5, 앞:3, 뒤:6
	static int[] dice = new int[DICE_NUMBER+1];
	static int N, M, x, y, K;
	static StringTokenizer st;
	static int[][] map;
	static int[] dy = {0,1,-1,0,0};
	static int[] dx = {0,0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		Application();
	}
	
	public static void Application() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				moveEast();
				break;
			case 2:
				moveWest();
				break;
			case 3:
				moveNorth();
				break;
			case 4:
				moveSouth();
				break;
			}
		}
		
	}
	public static void simulate() {
		if(map[x][y] != 0) {
			dice[4] = map[x][y];
			map[x][y] = 0;
		} else {
			map[x][y] = dice[4];
		}
	}
	
	public static void moveEast() {
		if(isMove(x,y,1)) {
			swap(1,4); 
			swap(1,2);
			swap(4,5);
			simulate();
			getDiceUpside();
		}
	}
	
	public static void moveWest() {
		if(isMove(x,y,2)) {
			swap(2,5); 
			swap(1,2);
			swap(4,5);
			simulate();
			getDiceUpside();
		}
	}
	
	public static void moveNorth() {
		if(isMove(x,y,3)) {
			swap(3,6); 
			swap(1,3);
			swap(4,6);
			simulate();
			getDiceUpside();
		}
	}
	
	public static void moveSouth() {
		if(isMove(x,y,4)) {
			swap(4,1); 
			swap(1,3);
			swap(4,6);
			simulate();
			getDiceUpside();
		}
	}

	public static void swap(int x, int y) {
		int temp = dice[y];
		dice[y] = dice[x];
		dice[x] = temp;
	}
	
	public static boolean isMove(int inputX, int inputY, int direction) {
		int nx = inputX + dx[direction];
		int ny = inputY + dy[direction];
		if(nx >=0 && nx < N && ny >=0 && ny < M) {
			x = nx;
			y = ny;
			return true;
		}
		return false;
	}
	
	public static void getDiceUpside() {
		 System.out.println(dice[1]);
	}
}
