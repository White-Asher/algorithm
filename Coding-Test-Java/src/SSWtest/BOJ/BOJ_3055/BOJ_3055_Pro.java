package SSWtest.BOJ.BOJ_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_Pro {
	static int R, C;
	static char[][] map;
	static StringTokenizer st;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		// 물과 고슴도치를 구분, 좌표
		queue = new ArrayDeque<>();
		
		// 큐에 물 좌표(1), 고슴도치 좌표 넣기(2)
		int[] S = null;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if 		(map[i][j] == '*') queue.offer(new int[] {i, j, 1});
				else if (map[i][j] == 'S') S = new int[] {i, j, 2};
			}
		}
		
		queue.offer(S);
		
		solution();
	}
	
	public static void solution() {
		
		int time = 0;
		
		while(queue.size() != 0) {
			++time;
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int[] q = queue.poll();
					for (int d = 0; d < 4; d++) {
					int nr = q[0] + dr[d];
					int nc = q[1] + dc[d];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
					if(q[2] == 1) { //물일 때
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							queue.offer(new int[] {nr, nc, 1});
							map[nr][nc] = '*';
						}
					} else { //고슴도치 일 때
						if (map[nr][nc] == 'S') continue; // 자기좌표는 제외
						if (map[nr][nc] == 'D') { // 목적지 비버굴이라면 탐색 종료ㅕ
							System.out.println(time);
							return;
						}
						if (map[nr][nc] == '.') { // 빈 공간
							queue.offer(new int[] {nr, nc, 2});
							map[nr][nc] = 'S';
						}
					}
				}
			}
		}
		System.out.println("KAKTUS"); // 위에서 비버굴을 못찾으면..
	}
}
