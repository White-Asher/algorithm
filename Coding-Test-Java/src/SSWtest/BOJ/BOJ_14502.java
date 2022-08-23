package SSWtest.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static StringTokenizer st;
	static int N, M, ans;
	static int[][] walls, map, virus;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MIN_VALUE;
		
		map = new int[N][M];
		virus = new int[10][2];
		int[][] emptyArea = new int[64][2];
		walls = new int[3][2];
		int virusIdx = 0;
		int emptyAreaIdx = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus[virusIdx][0] = i;
					virus[virusIdx][1] = j;
					virusIdx++;
				} else if(map[i][j] == 0) {
					emptyArea[emptyAreaIdx][0] = i;
					emptyArea[emptyAreaIdx][1] = j;
					emptyAreaIdx++;
				}
			}
		}
		
		virus = Arrays.copyOf(virus, virusIdx);
		emptyArea = Arrays.copyOf(emptyArea, emptyAreaIdx);
		comb(0,0,emptyArea);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt, int start, int[][] emptyArea) {
		if(cnt == 3) {
			int temp = BFS(walls);
			ans = Math.max(ans, temp);
			return;
		}
		
		for (int i = start; i < emptyArea.length; i++) {
			walls[cnt][0] = emptyArea[i][0];
			walls[cnt][1] = emptyArea[i][1];
			comb(cnt+1, i+1, emptyArea);
		}
	}
	
	public static int BFS(int[][] walls) {
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		for (int wall[] : walls) {
			tempMap[wall[0]][wall[1]] = 1;
		}
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		for (int[] v : virus) {
			queue.offer(v);
		}
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int qx = q[0];
			int qy = q[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = qx + dx[d];
				int ny = qy + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && tempMap[nx][ny] == 0) {
					tempMap[nx][ny] = 2;
					queue.offer(new int[]{nx, ny});
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tempMap[i][j] == 0) {
					cnt++;
				}
			}
			
		}
		return cnt;
	}
}
