package SSWtest.BOJ.BOJ_2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2638 {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		input();
		int time = 0;
		while(!isAllMelt()) {
			boolean[][] visited = new boolean[N][M];
			int[][] copyMap = copyMap();
			copyMap[0][0] = 3;
			outDFS(0,0, visited, copyMap);
			melt(copyMap);
			time++;
		}
		
		System.out.println(time);
	}
	
	public static void melt(int[][] copyMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyMap[i][j] == 1) {
					int meltCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(copyMap[nx][ny] == 3) {
							meltCnt++;
						}
					}
					if(meltCnt >= 2) map[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean isAllMelt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	public static void outDFS(int x, int y, boolean[][] visited, int[][] copyMap) {
		
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx >=0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false) {
				if(copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 3;
					outDFS(nx,ny,visited, copyMap);
				}
			}
		}
		return;
	}
	
	public static int[][] copyMap(){
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
