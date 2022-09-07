package SSWtest.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
	static StringTokenizer st;
	static int R, C, waterX, waterY, biberX, biberY;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> waterQueue = new ArrayDeque<>();
	static Queue<int[]> moveQueue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		input();
		int[][] visited = new int[R][C];
		BFS(visited);
		System.out.println("KAKTUS");
	}

	public static void BFS(int[][] visited) {
		
		while(!waterQueue.isEmpty() || !moveQueue.isEmpty()) {
			// 문제의 코드
//			char[][] copyMap = copyMap();
			
			int waterCycle = waterQueue.size();
			for (int i = 0; i < waterCycle; i++) {
				int[] waterQ = waterQueue.poll();
				int waterqX = waterQ[0];
				int waterqY = waterQ[1];
				
				for (int d = 0; d < 4; d++) {
					int nWaterX = waterqX + dx[d];
					int nWaterY = waterqY + dy[d];
					
					if(nWaterX >= 0 && nWaterX < R && nWaterY >= 0 && nWaterY < C) {
						if(map[nWaterX][nWaterY] == '.') {
							waterQueue.add(new int[] {nWaterX, nWaterY});
							map[nWaterX][nWaterY] = '*';
						}
					}
				}
			}
			
			int moveCycle = moveQueue.size();
			for (int i = 0; i < moveCycle; i++) {
				
				int[] moveQ = moveQueue.poll();
				int moveqX = moveQ[0];
				int moveqY = moveQ[1];
				
				for (int d = 0; d < 4; d++) {
					int nMoveX = moveqX + dx[d];
					int nMoveY = moveqY + dy[d];
					
					if(nMoveX == biberX && nMoveY == biberY) {
						System.out.println(visited[moveqX][moveqY]+1);
						System.exit(0);
					}
					
					if(nMoveX >= 0 && nMoveX < R && nMoveY >= 0 && nMoveY < C) {
						if(map[nMoveX][nMoveY] == '.' && visited[nMoveX][nMoveY] == 0) {
							visited[nMoveX][nMoveY] = visited[moveqX][moveqY] + 1;
							moveQueue.add(new int[] {nMoveX, nMoveY});
						}
					}
					
				}
			}
		}
	}
	
	public static char[][] copyMap(){
		char[][] temp = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '*') {
					waterQueue.add(new int[] { i, j });
				} else if (map[i][j] == 'S') {
					moveQueue.add(new int[] { i, j });
					map[i][j] = '.';
				} else if (map[i][j] == 'D') {
					biberX = i;
					biberY = j;
				}
			}
		}
	}
}