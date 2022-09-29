package SSWtest.SWEA.SWEA_1953_Supplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
세로 N
가로 M
맨홀 뚜껑 세로-> R, 가로 -> C
탈출 후 소요시간 L
 */

public class SWEA_1953 {
	static StringTokenizer st;
	static int N, M, R, C, L;
	static int[][] map;
	static int[][] visited;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int ans = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new int[N][M];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			simulate();
			calc();
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}
	
	public static void calc() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] <=L && visited[i][j] > 0) ans++;
			}
		}
	}
	
	// R: 세로위치 C: 가로위치
	public static void simulate() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {R,C});
		visited[R][C] = 1;
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int qr = q[0];
			int qc = q[1];

			
			if(visited[qr][qc] == L) continue;
			
			int curVal = map[qr][qc];
			int[] curDire = tunnelDirection(curVal);
			

			for(int d = 0; d < curDire.length; d++) {
				int direction = curDire[d];

				int nr = dy[direction] + qr;
				int nc = dx[direction] + qc;

				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(map[nr][nc] == 0) continue;
				if(visited[nr][nc] > 0) continue;
				if(!connectCheck(direction, map[nr][nc])) continue;
				
				visited[nr][nc] = visited[qr][qc] + 1;
				queue.add(new int[] {nr,nc});
			}
			
		}

	}
	
	public static int[] tunnelDirection(int val) {
		if(val == 1) return new int[] {0,1,2,3};
		else if(val == 2) return new int[] {0,1};
		else if(val == 3) return new int[] {2,3};
		else if(val == 4) return new int[] {0,3};
		else if(val == 5) return new int[] {1,3};
		else if(val == 6) return new int[] {1,2};
		else return new int[] {0,2};
	}
	
	public static boolean connectCheck(int d, int next) {
		switch (next) {
		case 1: return true;
		case 2:	return (d == 0 || d == 1);
		case 3: return (d == 2 || d == 3);
		case 4: return (d == 1 || d == 2);
		case 5: return (d == 0 || d == 2);
		case 6: return (d == 0 || d == 3);
		case 7: return (d == 1 || d == 3);
		default: return false;
		} 
	}
}
